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
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: tenmallfront
 * @description: 商品评价
 * @author: lixuqiang
 * @create: 2019-11-23 14:08:41
 */
@RestController
public class WxTabEstimateController {
    @Autowired
    private WxTabEstimateService wxTabEstimateService;
    @Autowired
    private WxTabOrderItemService wxTabOrderItemService;
    @Autowired
    private WxTabReturnCauseService wxTabReturnCauseService;
    @Autowired
    private WxTabOrderService wxTabOrderService;

    @RequestMapping(value = "/product/estimate",method = RequestMethod.POST)
    public Map<String,Object> estimate(String spuid, String orderItemid, String images, String Star, String Content){
        if(StringUtils.isEmpty(spuid) ||
           StringUtils.isEmpty(orderItemid) ||
           StringUtils.isEmpty(Star) ||
           StringUtils.isEmpty(Content)){
            return WebTools.returnData("spuid，orderItemid，Star，Content不能为空",-1);
        }
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

    @RequestMapping(value = "/product/salesReturn",method = RequestMethod.POST)
    public Map<String, Object> salesReturn(String orderId, String orderItemid, String evidence, String description, String returnCause, String type){
        if(StringUtils.isEmpty(orderId) ||
                StringUtils.isEmpty(orderItemid) ||
                StringUtils.isEmpty(description) ||
                StringUtils.isEmpty(returnCause) ||
                StringUtils.isEmpty(type)){
            return WebTools.returnData("orderId，orderItemid，description，returnCause，type不能为空",-1);
        }
        if(!type.equals("1")){
            return WebTools.returnData("type的值必须为1",-1);
        }
        try{
            Integer test1 = Integer.valueOf(orderItemid);
            String[] orders = orderId.split(",");
            for (String order:orders){
                Integer test2 = Integer.valueOf(order);
            }
        }catch (Exception e){
            return WebTools.returnData("orderItemid和orderId查询时必须是int类型",-1);
        }

        WxTabOrderItem wxTabOrderItem = wxTabOrderItemService.get(orderItemid);
        if(wxTabOrderItem == null){
            return WebTools.returnData("orderItemid没有找到对应数据",-1);
        }
        List<WxTabOrder> wxTabOrders = wxTabOrderService.selectByIds(orderId.split(","));
        if(wxTabOrders.size()<=0){
            return WebTools.returnData("orderId没有找到对应数据",-1);
        }

        boolean flag = wxTabReturnCauseService.addAssociated(orderId,orderItemid,evidence,description,returnCause,type);
        //退货申请操作
        if(flag){
            return WebTools.returnData("退货申请成功",0);
        }
        return WebTools.returnData("退货申请失败",-1);
    }

    @RequestMapping(value = "/product/refund",method = RequestMethod.POST)
    public Map<String, Object> refund(String orderId, String orderItemid, String evidence, String description, String returnCause, String type){
        if(StringUtils.isEmpty(orderId) ||
           StringUtils.isEmpty(orderItemid) ||
           StringUtils.isEmpty(description) ||
           StringUtils.isEmpty(returnCause) ||
           StringUtils.isEmpty(type)){
            return WebTools.returnData("orderId，orderItemid，description，returnCause，type不能为空",-1);
        }
        if(!type.equals("2")){
            return WebTools.returnData("type的值必须为2",-1);
        }
        try{
            Integer test1 = Integer.valueOf(orderItemid);
            String[] orders = orderId.split(",");
            for (String order:orders){
                Integer test2 = Integer.valueOf(order);
            }
        }catch (Exception e){
            return WebTools.returnData("orderItemid和orderId查询时必须是int类型",-1);
        }
        WxTabOrderItem wxTabOrderItem = wxTabOrderItemService.get(orderItemid);
        if(wxTabOrderItem == null){
            return WebTools.returnData("orderItemid没有找到对应数据",-1);
        }
        List<WxTabOrder> wxTabOrders = wxTabOrderService.selectByIds(orderId.split(","));
        if(wxTabOrders.size()<=0){
            return WebTools.returnData("orderId没有找到对应数据",-1);
        }

        boolean flag = wxTabReturnCauseService.addAssociated(orderId,orderItemid,evidence,description,returnCause,type);
        //退款操作
        if(flag){
            return WebTools.returnData("退款申请成功",0);
        }
        return WebTools.returnData("退款申请失败",-1);
    }

    @RequestMapping(value = "/order/uname",method = RequestMethod.POST)
    public Map<String,Object> uname(String page,String size,String payStatus,String consignStatus){
        if(StringUtils.isEmpty(page) ||
           StringUtils.isEmpty(size)){
            return WebTools.returnData("page，size不能为空",-1);
        }
        try{
            Integer test1 = Integer.valueOf(page);
            Integer test2 = Integer.valueOf(size);
        }catch (Exception e){
            return WebTools.returnData("page和size必须是int类型",-1);
        }
        if(payStatus != null){
            if(payStatus.length()>1){
                return WebTools.returnData("payStatus必须是char类型",-1);
            }
        }
        if(consignStatus != null){
            if(consignStatus.length()>1){
                return WebTools.returnData("consignStatus必须是char类型",-1);
            }
        }

        PageInfo<Object> returnPage = new PageInfo<>();
        List<Object> objectList = new ArrayList<>();
        PageInfo<Map<String,Object>> pageInfo = wxTabOrderItemService.pageByPayStatusAndConsignStatus(Integer.valueOf(page),Integer.valueOf(size),payStatus,consignStatus);
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
//        returnPage.setList(objectList);
        returnPage.setPageNum(pageInfo.getPageNum());
        returnPage.setPageSize(pageInfo.getPageSize());
        returnPage.setTotal(pageInfo.getTotal());
        returnPage.setSize(pageInfo.getSize());
        try {
            Map<String,Object> map =WebTools.objectToMap(returnPage);
            map.put("sublist",objectList);
            return map;
        } catch (IllegalAccessException e) {}
        return WebTools.returnData("查询异常！",-1);
    }
}
