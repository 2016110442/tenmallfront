package com.cn.wanxi.front.address;

import com.cn.wanxi.service.address.WxTabAddressService;
import com.cn.wanxi.model.address.WxTabAddress;
import org.springframework.beans.factory.annotation.Autowired;
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
 * 地址信息
 * @author lxq
 * @date 2019/11/20 9:38
 */
@RestController
public class WxTabAddressController {
    @Autowired
    private WxTabAddressService wxTabAddressService;

    //收货人地址列表接口
    @RequestMapping(value = "/address/listAddress.do",method = RequestMethod.POST)
    public List<WxTabAddress> list(WxTabAddress address){
        return wxTabAddressService.find(address);
    }

    //地址新增接口
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

    //地址修改接口
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

    //地址删除接口
    @RequestMapping(value = "/address/deleteAddress.do",method = RequestMethod.POST)
    public Map<String, Object> delete(@RequestParam(required = true)Integer id){
        boolean flag =wxTabAddressService.delete(id);
        if(flag){
            return WebTools.returnData("删除成功",0);
        }
        return WebTools.returnData("删除失败",-1);
    }

    //品订单详情接口
    @RequestMapping(value = "/settlement/deal.do",method = RequestMethod.POST)
    public Map<String, Object> deal(@RequestParam(required = true)String ids){
        Map<String,Object> map = new HashMap<>();
        List<Object> list = new ArrayList<>();
        //商品订单操作
        map.put("sku",list);
        map.put("totalMoney",0); //总金额
        map.put("totalNum",0); //总数量
        return map;
    }

}
