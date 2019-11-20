package com.cn.wanxi.front.user;

import com.cn.wanxi.model.user.WxTabEstimate;
import com.cn.wanxi.service.user.WxTabEstimateService;
import com.cn.wanxi.util.WebTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 商品评价
 * @author lxq
 * @date 2019年11月20日16:27:54
 */
@RestController
public class WxTabEstimateController {
    @Autowired
    private WxTabEstimateService wxTabEstimateService;

    //评价
    @RequestMapping(value = "/product/estimate.do",method = RequestMethod.GET)
    public Map<String,Object> estimate(@RequestParam(required = true) String spuid,
                                       @RequestParam(required = true) String orderItemid,
                                       @RequestParam(required = true) String images,
                                       @RequestParam(required = true) String star,
                                       @RequestParam(required = true) String content){
        WxTabEstimate wxTabEstimate = new WxTabEstimate();
        wxTabEstimate.setSpuid(spuid);
        wxTabEstimate.setOrderItemid(Integer.valueOf(orderItemid));
        wxTabEstimate.setImages(images);
        wxTabEstimate.setStar(Integer.valueOf(star));
        wxTabEstimate.setContent(content);
        boolean flag =wxTabEstimateService.add(wxTabEstimate);
        if(flag){
            return WebTools.returnData("评价成功",0);
        }
        return WebTools.returnData("评价失败",-1);
    }

    //退货申请
    @RequestMapping(value = "/product/salesReturn.do",method = RequestMethod.POST)
    public Map<String, Object> salesReturn(@RequestParam(required = true) String orderId,
                                           @RequestParam(required = true) String orderItemid,
                                           @RequestParam(required = true) String evidence,
                                           @RequestParam(required = true) String description,
                                           @RequestParam(required = true) String returnCause,
                                           @RequestParam(required = true) String type){
        //退货申请操作
        boolean flag = true;//wxTabEstimateService.update(wxTabEstimate);
        if(flag){
            return WebTools.returnData("退货申请成功",0);
        }
        return WebTools.returnData("退货申请失败",-1);
    }

    //退货申请
    @RequestMapping(value = "/product/refund.do",method = RequestMethod.POST)
    public Map<String, Object> refund(@RequestParam(required = true) String orderId,
                                      @RequestParam(required = true) String orderItemid,
                                      @RequestParam(required = true) String evidence,
                                      @RequestParam(required = true) String description,
                                      @RequestParam(required = true) String returnCause,
                                      @RequestParam(required = true) String type){
        //退款操作
        boolean flag = true;
        if(flag){
            return WebTools.returnData("退款成功",0);
        }
        return WebTools.returnData("退款失败",-1);
    }

    //订单查询接口
    @RequestMapping(value = "/order/uname.do",method = RequestMethod.POST)
    public Map<String, Object> uname(@RequestParam(required = true) Integer page,
                                     @RequestParam(required = true) Integer size,
                                     @RequestParam(required = false) char payStatus,
                                     @RequestParam(required = false) char consignStatus){
        //订单查询操作
        return null;
    }
}
