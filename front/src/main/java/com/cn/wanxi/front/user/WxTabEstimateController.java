package com.cn.wanxi.front.user;

import com.cn.wanxi.model.order.WxTabOrder;
import com.cn.wanxi.model.order.WxTabOrderItem;
import com.cn.wanxi.model.user.User;
import com.cn.wanxi.model.user.WxTabEstimate;
import com.cn.wanxi.service.order.WxTabOrderItemService;
import com.cn.wanxi.service.order.WxTabOrderService;
import com.cn.wanxi.service.user.UserService;
import com.cn.wanxi.service.user.WxTabEstimateService;
import com.cn.wanxi.service.user.WxTabReturnCauseService;
import com.cn.wanxi.util.WebTools;
import com.github.pagehelper.PageInfo;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: tenmallfront
 * @description: 商品评价
 * @author: lixuqiang
 * @create: 2019-11-23 14:08:41
 */
@RestController
@Validated
public class WxTabEstimateController {
    @Autowired
    private WxTabEstimateService wxTabEstimateService;
    @Autowired
    private WxTabOrderItemService wxTabOrderItemService;
    @Autowired
    private WxTabReturnCauseService wxTabReturnCauseService;
    @Autowired
    private WxTabOrderService wxTabOrderService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/product/estimate", method = RequestMethod.POST)
    public Map<String, Object> estimate(@RequestBody Map<String,Object> map){
        if (StringUtils.isEmpty(map.get("spuid")) ||
                StringUtils.isEmpty(map.get("orderItemid")) ||
                StringUtils.isEmpty(map.get("star")) ||
                StringUtils.isEmpty(map.get("content"))) {
            return WebTools.returnData("spuid，orderItemid，star，content不能为空", -1);
        }
        String spuid = map.get("spuid").toString();
        String orderItemid = map.get("orderItemid").toString();
        String star = map.get("star").toString();
        String content = map.get("content").toString();
        String images = "";
        if (!StringUtils.isEmpty(map.get("images"))) {
            images = map.get("images").toString();
        }
        if(orderItemid.length()>11 || star.length()>11){
            return WebTools.returnData("spuid，star长度不能超过11",-1);
        }
        if(spuid.length()>20){
            return WebTools.returnData("spuid长度不能超过20",-1);
        }
        if(images.length()>255 || content.length()>255){
            return WebTools.returnData("images，content长度不能超过255",-1);
        }

        try {
            Integer.valueOf(orderItemid);
        } catch (Exception e) {
            return WebTools.returnData("orderItemid保存时必须是int类型", -1);
        }
        try {
            Integer test1 = Integer.valueOf(star);
            if(test1<1 || test1>5){
                return WebTools.returnData("star的值必须为1、2、3、4、5", -1);
            }
        } catch (Exception e) {
            return WebTools.returnData("star保存时必须是int类型", -1);
        }

        WxTabEstimate wxTabEstimate = new WxTabEstimate();
        wxTabEstimate.setSpuid(spuid);
        wxTabEstimate.setOrderItemid(Integer.valueOf(orderItemid));
        wxTabEstimate.setImages(images);
        wxTabEstimate.setStar(Integer.valueOf(star));
        wxTabEstimate.setContent(content);
        String phone = WebTools.getSession("username");
        if(!StringUtils.isEmpty(phone)){
            List<User> users = userService.findByPhone(phone);
            if(users.size()>0){
                wxTabEstimate.setUsername(users.get(0).getUsername());
            }
        }
        boolean flag = wxTabEstimateService.add(wxTabEstimate);
        if (flag) {
            return WebTools.returnData("评价成功", 0);
        }
        return WebTools.returnData("评价失败", -1);
    }

    @RequestMapping(value = "/product/salesReturn", method = RequestMethod.POST)
    public Map<String, Object> salesReturn(@RequestBody Map<String,Object> map){
        if (StringUtils.isEmpty(map.get("orderId")) ||
                StringUtils.isEmpty(map.get("orderItemid")) ||
                StringUtils.isEmpty(map.get("description")) ||
                StringUtils.isEmpty(map.get("returnCause")) ||
                StringUtils.isEmpty(map.get("type"))) {
            return WebTools.returnData("orderId，orderItemid，description，returnCause，type不能为空", -1);
        }
        String orderId = map.get("orderId").toString();
        String orderItemid = map.get("orderItemid").toString();
        String description = map.get("description").toString();
        String returnCause = map.get("returnCause").toString();
        String type = map.get("type").toString();
        String evidence = "";
        if (!StringUtils.isEmpty(map.get("evidence"))) {
            evidence = map.get("evidence").toString();
        }
        if(returnCause.length()>255){
            return WebTools.returnData("returnCause长度不能超过255",-1);
        }
        if(orderId.length()>11 || orderItemid.length()>11){
            return WebTools.returnData("orderId，orderItemid长度不能超过11",-1);
        }
        if(evidence.length()>50 || description.length()>50 || type.length()>50){
            return WebTools.returnData("evidence，description，type长度不能超过50",-1);
        }


        if (!type.equals("1")) {
            return WebTools.returnData("type的值必须为1", -1);
        }
        try {
            Integer test1 = Integer.valueOf(orderItemid);
            String[] orders = orderId.split(",");
            for (String order : orders) {
                Integer test2 = Integer.valueOf(order);
            }
        } catch (Exception e) {
            return WebTools.returnData("orderItemid和orderId查询时必须是int类型", -1);
        }

        WxTabOrderItem wxTabOrderItem = wxTabOrderItemService.get(orderItemid);
        if (wxTabOrderItem == null) {
            return WebTools.returnData("orderItemid没有找到对应数据", -1);
        }
        List<WxTabOrder> wxTabOrders = wxTabOrderService.selectByIds(orderId.split(","));
        if (wxTabOrders.size() <= 0) {
            return WebTools.returnData("orderId没有找到对应数据", -1);
        }

        boolean flag = wxTabReturnCauseService.addAssociated(orderId, orderItemid, evidence, description, returnCause, type);
        //退货申请操作
        if (flag) {
            return WebTools.returnData("退货申请成功", 0);
        }
        return WebTools.returnData("退货申请失败", -1);
    }

    @RequestMapping(value = "/product/refund", method = RequestMethod.POST)
    public Map<String, Object> refund(@RequestBody Map<String,Object> map){
        if (StringUtils.isEmpty(map.get("orderId")) ||
                StringUtils.isEmpty(map.get("orderItemid")) ||
                StringUtils.isEmpty(map.get("description")) ||
                StringUtils.isEmpty(map.get("returnCause")) ||
                StringUtils.isEmpty(map.get("type"))) {
            return WebTools.returnData("orderId，orderItemid，description，returnCause，type不能为空", -1);
        }
        String orderId = map.get("orderId").toString();
        String orderItemid = map.get("orderItemid").toString();
        String description = map.get("description").toString();
        String returnCause = map.get("returnCause").toString();
        String type = map.get("type").toString();
        String evidence = "";
        if (!StringUtils.isEmpty(map.get("evidence"))) {
            evidence = map.get("evidence").toString();
        }
        if(returnCause.length()>255){
            return WebTools.returnData("returnCause长度不能超过255",-1);
        }
        if(orderId.length()>11 || orderItemid.length()>11){
            return WebTools.returnData("orderId，orderItemid长度不能超过11",-1);
        }
        if(evidence.length()>50 || description.length()>50 || type.length()>50){
            return WebTools.returnData("evidence，description，type长度不能超过50",-1);
        }

        if (!type.equals("2")) {
            return WebTools.returnData("type的值必须为2", -1);
        }
        try {
            Integer.valueOf(orderItemid);
            String[] orders = orderId.split(",");
            for (String order : orders) {
                Integer.valueOf(order);
            }
        } catch (Exception e) {
            return WebTools.returnData("orderItemid和orderId查询时必须是int类型", -1);
        }
        WxTabOrderItem wxTabOrderItem = wxTabOrderItemService.get(orderItemid);
        if (wxTabOrderItem == null) {
            return WebTools.returnData("orderItemid没有找到对应数据", -1);
        }
        List<WxTabOrder> wxTabOrders = wxTabOrderService.selectByIds(orderId.split(","));
        if (wxTabOrders.size() <= 0) {
            return WebTools.returnData("orderId没有找到对应数据", -1);
        }

        boolean flag = wxTabReturnCauseService.addAssociated(orderId, orderItemid, evidence, description, returnCause, type);
        //退款操作
        if (flag) {
            return WebTools.returnData("退款申请成功", 0);
        }
        return WebTools.returnData("退款申请失败", -1);
    }

    @RequestMapping(value = "/order/uname", method = RequestMethod.POST)
    public Map<String, Object> uname(@RequestBody Map<String,Object> map,String page,String size) {
        boolean flag = false;
        if(StringUtils.isEmpty(page) || StringUtils.isEmpty(size)){
            if (StringUtils.isEmpty(map.get("page")) ||
                    StringUtils.isEmpty(map.get("size"))) {
                flag=true;
            }else{
                page=map.get("page").toString();
                size=map.get("size").toString();
            }
        }
        if(flag){
            return WebTools.returnData("page，size不能为空", -1);
        }

        String payStatus="";
        String consignStatus="";
        if (!StringUtils.isEmpty(map.get("payStatus"))) {
            payStatus=map.get("payStatus").toString();
        }
        if (!StringUtils.isEmpty(map.get("consignStatus"))) {
            consignStatus=map.get("consignStatus").toString();
        }
        try {
            Integer test1 = Integer.valueOf(page);
            Integer test2 = Integer.valueOf(size);
        } catch (Exception e) {
            return WebTools.returnData("page和size必须是int类型", -1);
        }
        if (payStatus != null) {
            if (payStatus.length() > 1) {
                return WebTools.returnData("payStatus必须是char类型", -1);
            }
        }
        if (consignStatus != null) {
            if (consignStatus.length() > 1) {
                return WebTools.returnData("consignStatus必须是char类型", -1);
            }
        }
//        PageInfo<Object> returnPage = new PageInfo<>();
        List<Object> objectList = new ArrayList<>();
        PageInfo<Map<String, Object>> pageInfo = wxTabOrderItemService.pageByPayStatusAndConsignStatus(Integer.valueOf(page), Integer.valueOf(size), payStatus, consignStatus,"");
        Map<String, Object> entityMap;
        for (Map<String, Object> wxTabOrder : pageInfo.getList()) {
            entityMap = wxTabOrder;
            if (StringUtils.isEmpty(wxTabOrder.get("orderItemId"))) {
                entityMap.put("skuList", new ArrayList<>());
                continue;
            }
            String[] orderItemId = wxTabOrder.get("orderItemId").toString().split(",");
            List<WxTabOrderItem> wxTabOrderItems = wxTabOrderItemService.findByIds(orderItemId);
            entityMap.put("sublist", wxTabOrderItems);
            objectList.add(entityMap);
        }

        Map<String, Object> returnPage = new HashMap<>();
        returnPage.put("page", pageInfo.getPageNum());
        returnPage.put("size", pageInfo.getPageSize());
        returnPage.put("total", pageInfo.getTotal());
        returnPage.put("list", objectList);
        return returnPage;
    }

    @RequestMapping(value = "/order/unameDetail", method = RequestMethod.POST)
    public Map<String, Object> unameDetail(@RequestBody Map<String,Object> map) {
        if (StringUtils.isEmpty(map.get("orderItemId"))) {
            return WebTools.returnData("orderItemId不能为空", -1);
        }
        try {
            Integer orderItemId = Integer.valueOf(map.get("orderItemId").toString());
        } catch (Exception e) {
            return WebTools.returnData("orderItemId必须是int类型", -1);
        }
        WxTabOrderItem wxTabOrderItem = wxTabOrderItemService.get(map.get("orderItemId").toString());
        if(wxTabOrderItem == null){
            return WebTools.returnData("orderItemId没有找到对应数据", -1);
        }
        try {
            return WebTools.objectToMap(wxTabOrderItem);
        } catch (IllegalAccessException e) {

        }
        return WebTools.returnData("查询订单详情出现异常！", -1);
    }
}

