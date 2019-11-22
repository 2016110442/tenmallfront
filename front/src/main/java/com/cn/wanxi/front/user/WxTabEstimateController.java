package com.cn.wanxi.front.user;

import com.cn.wanxi.model.order.WxTabOrder;
import com.cn.wanxi.model.order.WxTabOrderItem;
import com.cn.wanxi.model.user.WxTabEstimate;
import com.cn.wanxi.service.order.WxTabOrderItemService;
import com.cn.wanxi.service.order.WxTabOrderService;
import com.cn.wanxi.service.user.WxTabEstimateService;
import com.cn.wanxi.service.user.WxTabReturnCauseService;
import com.cn.wanxi.util.WebTools;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    @Autowired
    private WxTabOrderItemService wxTabOrderItemService;
    @Autowired
    private WxTabOrderService wxTabOrderService;
    @Autowired
    private WxTabReturnCauseService wxTabReturnCauseService;

    //评价
    @RequestMapping(value = "/product/estimate.do",method = RequestMethod.POST)
    public Map<String,Object> estimate(@RequestParam(required = true) String spuid,
                                       @RequestParam(required = true) String orderItemid,
                                       @RequestParam(required = false) String images,
                                       @RequestParam(required = true) String Star,
                                       @RequestParam(required = true) String Content){
        WxTabEstimate wxTabEstimate = new WxTabEstimate();
        wxTabEstimate.setSpuid(spuid);
        wxTabEstimate.setOrderItemid(Integer.valueOf(orderItemid));
        wxTabEstimate.setImages(images);
        wxTabEstimate.setStar(Integer.valueOf(Star));
        wxTabEstimate.setContent(Content);
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
                                           @RequestParam(required = false) String evidence,
                                           @RequestParam(required = true) String description,
                                           @RequestParam(required = true) String returnCause,
                                           @RequestParam(required = true) String type){
        boolean flag = wxTabReturnCauseService.addAssociated(orderId,orderItemid,evidence,description,returnCause,type);
        //退货申请操作
        if(flag){
            return WebTools.returnData("退货申请成功",0);
        }
        return WebTools.returnData("退货申请失败",-1);
    }

    //退款申请
    @RequestMapping(value = "/product/refund.do",method = RequestMethod.POST)
    public Map<String, Object> refund(@RequestParam(required = true) String orderId,
                                      @RequestParam(required = true) String orderItemid,
                                      @RequestParam(required = false) String evidence,
                                      @RequestParam(required = true) String description,
                                      @RequestParam(required = true) String returnCause,
                                      @RequestParam(required = true) String type){
        boolean flag = wxTabReturnCauseService.addAssociated(orderId,orderItemid,evidence,description,returnCause,type);
        //退款操作
        if(flag){
            return WebTools.returnData("退款申请成功",0);
        }
        return WebTools.returnData("退款申请失败",-1);
    }

    //订单查询接口
    @RequestMapping(value = "/order/uname.do",method = RequestMethod.POST)
    public PageInfo<Object> uname(@RequestParam(required = true) Integer page,
                                  @RequestParam(required = true) Integer size,
                                  @RequestParam(required = false) String payStatus,
                                  @RequestParam(required = false) String consignStatus){
        PageInfo<Object> returnPage = new PageInfo<>();
        List<Object> objectList = new ArrayList<>();
        PageInfo<Map<String,Object>> pageInfo = wxTabOrderItemService.pageByPayStatusAndConsignStatus(page,size,payStatus,consignStatus);
        Map<String,Object> entityMap ;
        for (Map<String,Object> wxTabOrder:pageInfo.getList()) {
            entityMap = wxTabOrder;
            if(StringUtils.isEmpty(wxTabOrder.get("order_item_id"))){
                entityMap.put("skuList",new ArrayList<>());
                continue;
            }
            String[] orderItemId =wxTabOrder.get("order_item_id").toString().split(",");
            List<WxTabOrderItem> wxTabOrderItems =wxTabOrderItemService.findByIds(orderItemId);
            entityMap.put("sublist",wxTabOrderItems);
            objectList.add(entityMap);
        }
        returnPage.setList(objectList);
        returnPage.setPageNum(pageInfo.getPageNum());
        returnPage.setPageSize(pageInfo.getPageSize());
        returnPage.setTotal(pageInfo.getTotal());
        returnPage.setSize(pageInfo.getSize());
        return returnPage;
    }
}
