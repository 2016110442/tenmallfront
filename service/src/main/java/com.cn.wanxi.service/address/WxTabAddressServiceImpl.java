package com.cn.wanxi.service.address;

import com.cn.wanxi.dao.address.WxTabAddressDao;
import com.cn.wanxi.model.address.WxTabAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lxq
 * @date 2019/11/20 9:38
 */
@Service
public class WxTabAddressServiceImpl implements WxTabAddressService {
    @Autowired
    private WxTabAddressDao wxTabAddressDao;

    @Override
    public List<WxTabAddress> find(WxTabAddress address) {
        return wxTabAddressDao.find(address);
    }

    @Override
    public boolean add(WxTabAddress address) {
        Integer num = wxTabAddressDao.insert(address);
        if(num == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean update(WxTabAddress address) {
        Integer num = wxTabAddressDao.update(address);
        if(num == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        Integer num = wxTabAddressDao.delete(id);
        if(num == 1){
            return true;
        }
        return false;
    }
}
