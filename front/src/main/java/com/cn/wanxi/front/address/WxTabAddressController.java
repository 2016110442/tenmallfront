package com.cn.wanxi.front.address;

import com.cn.wanxi.model.cart.WxTabSku;
import com.cn.wanxi.model.cart.WxTabSpu;
import com.cn.wanxi.model.order.WxTabOrderItem;
import com.cn.wanxi.service.address.WxTabAddressService;
import com.cn.wanxi.model.address.WxTabAddress;
import com.cn.wanxi.service.cart.WxTabSkuService;
import com.cn.wanxi.service.cart.WxTabSpuService;
import com.cn.wanxi.service.order.WxTabOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cn.wanxi.util.WebTools;

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
public class WxTabAddressController {
    @Autowired
    private WxTabAddressService wxTabAddressService;
    @Autowired
    private WxTabOrderItemService wxTabOrderItemService;
    @Autowired
    private WxTabSpuService wxTabSpuService;
    @Autowired
    private WxTabSkuService wxTabSkuService;

    @RequestMapping(value = "/address/listAddress.do",method = RequestMethod.POST)
    public List<WxTabAddress> list(WxTabAddress address){
        return wxTabAddressService.find(address);
    }

    @RequestMapping(value = "/address/addAddress.do",method = RequestMethod.POST)
    public Map<String,Object> add(@RequestParam(required = true)String receiverAddress,
                                  @RequestParam(required = true)String receiverName,
                                  @RequestParam(required = true)String receiverPhone,
                                  @RequestParam(required = true)char isDefault){
        WxTabAddress address = new WxTabAddress();
        address.setReceiverAddress(receiverAddress);
        address.setReceiverName(receiverName);
        address.setReceiverPhone(receiverPhone);
        address.setIsDefault(String.valueOf(isDefault));
        boolean flag =wxTabAddressService.add(address);
        if(flag){
            return WebTools.returnData("添加成功",0);
        }
        return WebTools.returnData("添加失败",-1);
    }

    @RequestMapping(value = "/address/updateAddress.do",method = RequestMethod.POST)
    public Map<String, Object> update(@RequestParam(required = true)Integer id,
                                      @RequestParam(required = true)String receiverAddress,
                                      @RequestParam(required = true)String receiverName,
                                      @RequestParam(required = true)String receiverPhone,
                                      @RequestParam(required = true)char isDefault){
        WxTabAddress address = new WxTabAddress();
        address.setId(id);
        address.setReceiverAddress(receiverAddress);
        address.setReceiverName(receiverName);
        address.setReceiverPhone(receiverPhone);
        address.setIsDefault(String.valueOf(isDefault));
        boolean flag =wxTabAddressService.update(address);
        if(flag){
            return WebTools.returnData("修改成功",0);
        }
        return WebTools.returnData("修改失败",-1);
    }

    @RequestMapping(value = "/address/deleteAddress.do",method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestParam(required = true)Integer id){
        boolean flag =wxTabAddressService.delete(id);
        if(flag){
            return WebTools.returnData("删除成功",0);
        }
        return WebTools.returnData("删除失败",-1);
    }

    @RequestMapping(value = "/settlement/deal.do",method = RequestMethod.POST)
    public Map<String, Object> deal(@RequestParam(required = true)String ids){
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
                WxTabSpu wxTabSpu = wxTabSpuService.findByIds(wxTabOrderItem.getSpuId().split(",")).get(0);
                entityMap = WebTools.objectToMap(wxTabSpu);
                entityMap.put("skuid",wxTabOrderItem.getSkuId());
                entityMap.put("skuList",wxTabSkus);
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
        return map;
    }

}
