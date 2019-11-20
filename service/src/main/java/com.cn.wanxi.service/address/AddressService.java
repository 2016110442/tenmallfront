package com.cn.wanxi.service.address;

import java.util.List;
import com.cn.wanxi.model.address.Address;

/**
 * @author lxq
 * @date 2019/11/20 9:38
 */
public interface AddressService {

    //查询多个
    List<Address> find(Address address);

    //添加
    boolean add(Address address);

    //修改
    boolean update(Address address);

    //删除
    boolean delete(Integer id);
}
