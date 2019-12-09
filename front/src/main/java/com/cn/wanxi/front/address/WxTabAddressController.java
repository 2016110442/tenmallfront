package com.cn.wanxi.front.address;

import com.auth0.jwt.JWT;
import com.cn.wanxi.model.cart.WxTabSku;
import com.cn.wanxi.model.cart.WxTabSpu;
import com.cn.wanxi.model.order.WxTabOrderItem;
import com.cn.wanxi.model.user.User;
import com.cn.wanxi.service.address.WxTabAddressService;
import com.cn.wanxi.model.address.WxTabAddress;
import com.cn.wanxi.service.cart.WxTabSkuService;
import com.cn.wanxi.service.cart.WxTabSpuService;
import com.cn.wanxi.service.order.WxTabOrderItemService;
import com.cn.wanxi.service.user.UserService;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cn.wanxi.util.WebTools;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: tenmallfront
 * @description: 地址信息
 * @author: lixuqiang
 * @create: 2019-11-23 14:08:41
 */
@RestController
@Validated
public class WxTabAddressController {
    @Autowired
    private WxTabAddressService wxTabAddressService;
    @Autowired
    private WxTabOrderItemService wxTabOrderItemService;
    @Autowired
    private WxTabSpuService wxTabSpuService;
    @Autowired
    private WxTabSkuService wxTabSkuService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/address/listAddress",method = RequestMethod.POST)
    public Map<String, Object> list(HttpServletRequest request){
        return WebTools.returnData(wxTabAddressService.find(new WxTabAddress(),request),0);
    }

    @RequestMapping(value = "/address/addAddress",method = RequestMethod.POST)
    public Map<String,Object> add(@RequestBody Map<String,Object> map, HttpServletRequest request){
        if (StringUtils.isEmpty(map.get("receiverAddress")) ||
                StringUtils.isEmpty(map.get("receiverName")) ||
                StringUtils.isEmpty(map.get("receiverPhone")) ||
                StringUtils.isEmpty(map.get("isDefault"))) {
            return WebTools.returnData("receiverAddress，receiverName，receiverPhone，isDefault不能为空",-1);
        }
        String receiverAddress = map.get("receiverAddress").toString();
        String receiverName = map.get("receiverName").toString();
        String receiverPhone = map.get("receiverPhone").toString();
        String isDefault = map.get("isDefault").toString();
        if(receiverAddress.length()>255 ||
                receiverName.length()>255 ||
                receiverPhone.length()>255 ||
                isDefault.length()>255){
            return WebTools.returnData("receiverAddress，receiverName，receiverPhone，isDefault长度不能超过255",-1);
        }
        if(receiverPhone.length()!=11){
            return WebTools.returnData("请输入正确收件人手机号",-1);
        }

        if(isDefault.length()>1){
            return WebTools.returnData("isDefault必须是char类型",-1);
        }
        if(!(isDefault.equals("0") || isDefault.equals("1"))){
            return WebTools.returnData("isDefault只能是0(是)和1(否)",-1);
        }
        WxTabAddress address = new WxTabAddress();
        address.setReceiverAddress(receiverAddress);
        address.setReceiverName(receiverName);
        address.setReceiverPhone(receiverPhone);
        address.setIsDefault(String.valueOf(isDefault));
//        String phone = WebTools.getSession("username");
        String phone = JWT.decode(request.getHeader("token")).getAudience().get(0);
        address.setUsername(phone);
//        if(!StringUtils.isEmpty(phone)){
//            List<User> users = userService.findByPhone(phone);
//            if(users.size()>0){
//                address.setUsername(users.get(0).getUsername());
//            }
//        }

        boolean flag =wxTabAddressService.add(address,request);
        if(flag){
            return WebTools.returnData("添加成功",0);
        }
        return WebTools.returnData("添加失败",-1);
    }

    @RequestMapping(value = "/address/updateAddress",method = RequestMethod.POST)
    public Map<String, Object> update(@RequestBody Map<String,Object> map, HttpServletRequest request){
        if (StringUtils.isEmpty(map.get("receiverAddress")) ||
                StringUtils.isEmpty(map.get("receiverName")) ||
                StringUtils.isEmpty(map.get("receiverPhone")) ||
                StringUtils.isEmpty(map.get("isDefault")) ||
                StringUtils.isEmpty(map.get("id"))) {
            return WebTools.returnData("receiverAddress，receiverName，receiverPhone，isDefault, id不能为空",-1);
        }
        String receiverAddress = map.get("receiverAddress").toString();
        String receiverName = map.get("receiverName").toString();
        String receiverPhone = map.get("receiverPhone").toString();
        String isDefault = map.get("isDefault").toString();
        String id = map.get("id").toString();
        if(id.length()>11){
            return WebTools.returnData("id长度不能超过11",-1);
        }
        if(receiverAddress.length()>255 ||
                receiverName.length()>255 ||
                receiverPhone.length()>255 ||
                isDefault.length()>255){
            return WebTools.returnData("receiverAddress，receiverName，receiverPhone，isDefault长度不能超过255",-1);
        }
        if(receiverPhone.length()!=11){
            return WebTools.returnData("请输入正确收件人手机号",-1);
        }

        if(isDefault.length()>1){
            return WebTools.returnData("isDefault必须是char类型",-1);
        }
        if(!(isDefault.equals("0") || isDefault.equals("1"))){
            return WebTools.returnData("isDefault只能是0(是)和1(否)",-1);
        }
        try{
            Integer num = Integer.valueOf(id);
        }catch (Exception e){
            return WebTools.returnData("id必须是int类型",-1);
        }
        WxTabAddress findAddress = wxTabAddressService.get(id);
        if(findAddress == null){
            return WebTools.returnData("没有查找到对应id数据",-1);
        }
        WxTabAddress address = new WxTabAddress();
        address.setId(Integer.valueOf(id));
        address.setReceiverAddress(receiverAddress);
        address.setReceiverName(receiverName);
        address.setReceiverPhone(receiverPhone);
        address.setIsDefault(String.valueOf(isDefault));
        boolean flag =wxTabAddressService.update(address, request);
        if(flag){
            return WebTools.returnData("修改成功",0);
        }
        return WebTools.returnData("修改失败",-1);
    }

    @RequestMapping(value = "/address/deleteAddress",method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestBody Map<String,Object> map){
        if (StringUtils.isEmpty(map.get("id"))) {
            return WebTools.returnData("id不能为空",-1);
        }
        String id = map.get("id").toString();
        try{
            Integer num = Integer.valueOf(id);
        }catch (Exception e){
            return WebTools.returnData("id必须是int类型",-1);
        }
        WxTabAddress findAddress = wxTabAddressService.get(id);
        if(findAddress == null){
            return WebTools.returnData("没有查找到对应id数据",-1);
        }
        boolean flag =wxTabAddressService.delete(Integer.valueOf(id));
        if(flag){
            return WebTools.returnData("删除成功",0);
        }
        return WebTools.returnData("删除失败",-1);
    }

    @RequestMapping(value = "/settlement/deal",method = RequestMethod.POST)
    public Map<String, Object> deal(@RequestBody Map<String,Object> map2){
//            String ids){
        if (StringUtils.isEmpty(map2.get("ids"))) {
            return WebTools.returnData("ids不能为空",-1);
        }
        String ids = map2.get("ids").toString();
        Map<String,Object> map = new HashMap<>();
        List<Object> objectList = new ArrayList<>();
        Integer totalMoney = 0;
        Integer totalNum = 0;
        String[] skuIds = ids.split(",");
        //商品订单操作
        List<WxTabOrderItem> list = wxTabOrderItemService.findBySkuIds(skuIds);
        Map<String,Object> entityMap ;
        for (WxTabOrderItem wxTabOrderItem:list) {
            try {
                entityMap = WebTools.objectToMap(wxTabOrderItem);
                String[] skuIds2 =wxTabOrderItem.getSkuId().split(",");
                if(skuIds2.length<=0){
                    entityMap.put("skuList",new ArrayList<>());
                    continue;
                }
                //sku
                List<WxTabSku> wxTabSkus =wxTabSkuService.selectByIds(skuIds2);
                if(StringUtils.isEmpty(wxTabOrderItem.getSpuId())){
                    objectList.add(new HashMap<>());
                    continue;
                }
                List<WxTabSpu> wxTabSpus =wxTabSpuService.findByIds(wxTabOrderItem.getSpuId().split(","));
                if(wxTabSpus.size()>0){
                    WxTabSpu wxTabSpu = wxTabSpus.get(0);
                    //更新双引号变为单引号
                    if(StringUtils.isEmpty(wxTabSpu.getParaItems())){
                        wxTabSpu.setParaItems("");
                    }
                    wxTabSpu.setParaItems(wxTabSpu.getParaItems().replaceAll("\"","'"));
                    if(StringUtils.isEmpty(wxTabSpu.getSpecItems())){
                        wxTabSpu.setSpecItems("");
                    }
                    wxTabSpu.setSpecItems(wxTabSpu.getSpecItems().replaceAll("\"","'"));
                    entityMap = WebTools.objectToMap(wxTabSpu);
                }else{
                    entityMap = new HashMap<>();
                }
                entityMap.put("skuid",wxTabOrderItem.getSkuId());
                //更新双引号变为单引号
                List<WxTabSku> updateWxTabSkus = new ArrayList<>();
                for (WxTabSku wxtabsku : wxTabSkus) {
                    wxtabsku.setSpec(wxtabsku.getSpec().replaceAll("\"","'"));
                    updateWxTabSkus.add(wxtabsku);
                }
                entityMap.put("skuList",updateWxTabSkus);
                objectList.add(entityMap);
                totalMoney = totalMoney+(wxTabOrderItem.getPrice()*wxTabOrderItem.getNum());
                totalNum = totalNum+wxTabOrderItem.getNum();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        map.put("spu",objectList);
        map.put("totalMoney",totalMoney); //总金额
        map.put("totalNum",totalNum); //总数量
        return WebTools.returnData(map,0);
    }

}
