package com.cn.wanxi.service.address;

import com.cn.wanxi.dao.address.AddressDao;
import com.cn.wanxi.model.address.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lxq
 * @date 2019/11/20 9:38
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;

    @Override
    public List<Address> find(Address address) {
        return addressDao.find(address);
    }

    @Override
    public boolean add(Address address) {
        Integer num = addressDao.insert(address);
        if(num == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Address address) {
        Integer num = addressDao.update(address);
        if(num == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        Integer num = addressDao.delete(id);
        if(num == 1){
            return true;
        }
        return false;
    }
}
