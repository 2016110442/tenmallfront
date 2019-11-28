package com.cn.wanxi.service.address;

import com.cn.wanxi.dao.address.WxTabAddressDao;
import com.cn.wanxi.model.address.WxTabAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: tenmallfront
 * @description:
 * @author: lixuqiang
 * @create: 2019-11-23 14:08:41
 */
@Service
public class WxTabAddressServiceImpl implements WxTabAddressService {
    @Autowired
    private WxTabAddressDao wxTabAddressDao;

    @Override
    public WxTabAddress get(String id) {
        return wxTabAddressDao.get(id);
    }

    @Override
    public List<WxTabAddress> find(WxTabAddress address) {
        List<WxTabAddress> wxTabAddresses = wxTabAddressDao.find(address);
        List<WxTabAddress> updateWxTabAddresses = new ArrayList<>();
        for (WxTabAddress wxTabAddress:wxTabAddresses) {
            wxTabAddress.setReceiverAddress(wxTabAddress.getReceiverAddress().replaceAll("\"","'"));
            wxTabAddress.setReceiverName(wxTabAddress.getReceiverName().replaceAll("\"","'"));
            updateWxTabAddresses.add(wxTabAddress);
        }
        return updateWxTabAddresses;
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
