package com.cn.wanxi.service.cart;

import com.cn.wanxi.dao.cart.WxTabSkuDao;
import com.cn.wanxi.model.cart.WxTabSku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: tenmallfront
 * @description:
 * @author: lixuqiang
 * @create: 2019-11-23 14:08:41
 */
@Service
public class WxTabSkuServiceImpl implements  WxTabSkuService {
    @Autowired
    private WxTabSkuDao wxTabSkuDao;

    @Override
    public List<WxTabSku> selectByIds(String[] ids) {
        return wxTabSkuDao.findByIds(ids);
    }
}
