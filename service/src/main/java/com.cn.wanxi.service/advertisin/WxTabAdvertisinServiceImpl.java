package com.cn.wanxi.service.advertisin;

import com.cn.wanxi.dao.advertisin.WxTabAdvertisinDao;
import com.cn.wanxi.model.advertisin.WxTabAdvertisin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @date 2019/11/20 14:29
 */
@Service
public class WxTabAdvertisinServiceImpl implements WxTabAdvertisinService {

    @Autowired
    private WxTabAdvertisinDao wxTabAdvertisinDao;

    @Override
    public List<WxTabAdvertisin> getAll() {
        return wxTabAdvertisinDao.getAll();
    }
}
