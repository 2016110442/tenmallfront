package com.cn.wanxi.front.address;

import com.cn.wanxi.service.address.WxTabAddressService;
import com.cn.wanxi.model.address.WxTabAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cn.wanxi.util.WebTools;

import java.util.List;
import java.util.Map;

/**
 * 地址信息
 * @author lxq
 * @date 2019/11/20 9:38
 */
@RestController
@RequestMapping("/address")
public class AddressController{
    @Autowired
    private WxTabAddressService wxTabAddressService;

    //收货人地址列表接口
    @RequestMapping(value = "/listAddress.do",method = RequestMethod.POST)
    public List<WxTabAddress> list(WxTabAddress address){
        return wxTabAddressService.find(address);
    }

    //地址新增接口
    @RequestMapping(value = "/addAddress.do",method = RequestMethod.POST)
    public Map<String,Object> add(WxTabAddress address){
        boolean flag =wxTabAddressService.add(address);
        if(flag){
            return WebTools.returnData("添加成功",0);
        }
        return WebTools.returnData("添加失败",-1);
    }

    //地址修改接口
    @RequestMapping(value = "/updateAddress.do",method = RequestMethod.POST)
    public Map<String, Object> update(WxTabAddress address){
        boolean flag =wxTabAddressService.update(address);
        if(flag){
            return WebTools.returnData("修改成功",0);
        }
        return WebTools.returnData("修改失败",-1);
    }

    //地址删除接口
    @RequestMapping(value = "/deleteAddress.do",method = RequestMethod.GET)
    public Map<String, Object> delete(Integer id){
        boolean flag =wxTabAddressService.delete(id);
        if(flag){
            return WebTools.returnData("删除成功",0);
        }
        return WebTools.returnData("删除失败",-1);
    }

}
