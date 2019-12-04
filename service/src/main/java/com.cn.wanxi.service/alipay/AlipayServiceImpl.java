package com.cn.wanxi.service.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.cn.wanxi.dao.order.WxTabOrderMapper;
import com.cn.wanxi.service.config.AlipayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class AlipayServiceImpl implements AlipayService{

    @Autowired
    private WxTabOrderMapper orderMapper;
    @Override
    public Object aliPay(Integer id,HttpServletResponse response, HttpServletRequest request){

        response.setContentType("text/html;charset=utf-8");
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl,AlipayConfig.app_id, AlipayConfig.merchant_private_key,"json",AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePrecreateRequest aliPayRequest = new AlipayTradePrecreateRequest();
        aliPayRequest.setNotifyUrl(AlipayConfig.notify_url);
        aliPayRequest.setReturnUrl(AlipayConfig.return_url);
        AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();
        Map<String,Object> order =orderMapper.findOrderById(id);
        String out_trade_no=order.get("id").toString();
        String total_Amount=order.get("total_money").toString();
        System.out.println(out_trade_no+":"+total_Amount);
        SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.setOutTradeNo(out_trade_no+"-"+sdfTime.format(new Date()));
        model.setTotalAmount(total_Amount);
        model.setSubject("万息商城");
        model.setStoreId("WX_001");
        model.setTimeoutExpress("9m");
        aliPayRequest.setBizModel(model);
        AlipayTradePrecreateResponse alipayResponse = null;
        Map<String,Object> map=new HashMap<>();
        try {
            alipayResponse = alipayClient.execute(aliPayRequest);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if(alipayResponse.isSuccess()){
            String qrcode=alipayResponse.getQrCode();
            map.put("out_trade_no",out_trade_no);
            map.put("total_Amount",total_Amount);
            map.put("qrcode",qrcode);
            return map;
        } else {
            return null;
        }

    }
    @Override
    public String aliPayNotify(HttpServletRequest request) throws IOException {

        WxWebSocket wxWebSocket = WxWebSocket.getSocket();
        System.out.println("-------阿里服务器消费回调-------");
        Map<String, String> params = new HashMap<String, String>();

        Map requestParams = request.getParameterMap();

        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
            params.put(name, valueStr);
        }
        try {
            // 调用SDK验证签名
            boolean flag = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key,
                    AlipayConfig.charset, "RSA2");
            // 商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
            // 支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
            // 交易状态
            String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            if (flag && trade_status.equals("TRADE_SUCCESS")){
                // 修改订单状态
                // 已缴费----开始处理业务
                System.out.println("订单支付成功");
                wxWebSocket.sendMessage("success");
                out_trade_no=out_trade_no.split("-")[0];
                orderMapper.updateOrderPayStatus(Integer.valueOf(out_trade_no),"0");
                return "success";
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            wxWebSocket.sendMessage("fail");
            e.printStackTrace();
        }
        return "fail";
    }

    @Override
    public void aliPayReturn(HttpServletRequest request){
        System.out.println("同步通知");
        try {
            request.setCharacterEncoding("utf-8");//乱码解决，这段代码在出现乱码时使用
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //获取支付宝GET过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for(String str :requestParams.keySet()){
            String name = str;
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]:
                        valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }

        boolean signVerified = false; //调用SDK验证签名
        try {
            signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        if(signVerified) {
            System.out.println("验签成功-跳转到成功后页面");
            //跳转至支付成功后的页面
        }else {
            System.out.println("验签失败-跳转到付款页面");
        }
    }

}
