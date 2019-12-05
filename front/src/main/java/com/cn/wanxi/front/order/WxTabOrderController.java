package com.cn.wanxi.front.order;

import com.auth0.jwt.JWT;
import com.cn.wanxi.model.order.WxOrderVO;
import com.cn.wanxi.service.order.WxTabOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @date 2019/11/20 15:50
 */
@RestController
@RequestMapping("/order")
public class WxTabOrderController {

    @Autowired
    private WxTabOrderService wxTabOrderService;

    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public Map<String,String> insert(@RequestBody(required = false) WxOrderVO wxOrderVO, HttpServletRequest request){
        String token = request.getHeader("token");
        String username = JWT.decode(token).getAudience().get(0);
        Map<String,String> result = new HashMap<>();
        if (wxOrderVO==null){
            result.put("code","1");
            result.put("payUrl","你想干哈");
        }else {
            int i = wxTabOrderService.insert(wxOrderVO,username);
            if (i==1){
                result.put("code","0");
                result.put("payUrl","http://alipay.com/pay.jpg");
            }else{
                result.put("code","1");
                result.put("message","对不起，有必填项为空了");
            }
        }
        return result;
    }







}
