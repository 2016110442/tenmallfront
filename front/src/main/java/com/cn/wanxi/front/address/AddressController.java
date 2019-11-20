package com.cn.wanxi.front.address;

import com.cn.wanxi.service.address.AddressService;
import com.cn.wanxi.model.address.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 地址信息
 * @author lxq
 * @date 2019/11/20 9:38
 */
@RestController
@RequestMapping("/address")
public class AddressController{
    @Autowired
    private AddressService addressService;

    //收货人地址列表接口
    @RequestMapping(value = "/listAddress.do",method = RequestMethod.POST)
    public List<Address> list(Address address){
        return addressService.find(address);
    }

    //地址新增接口
    @RequestMapping(value = "/addAddress.do",method = RequestMethod.POST)
    public String add(Address address){
        boolean flag =addressService.add(address);
        if(flag){
            return "添加成功";
        }
        return "添加失败";
    }

    //地址修改接口
    @RequestMapping(value = "/updateAddress.do",method = RequestMethod.POST)
    public String update(Address address){
        boolean flag =addressService.update(address);
        if(flag){
            return "修改成功";
        }
        return "修改失败";
    }

    //地址删除接口
    @RequestMapping(value = "/deleteAddress.do",method = RequestMethod.POST)
    public String delete(Integer id){
        boolean flag =addressService.delete(id);
        if(flag){
            return "删除成功";
        }
        return "删除失败";
    }

}
