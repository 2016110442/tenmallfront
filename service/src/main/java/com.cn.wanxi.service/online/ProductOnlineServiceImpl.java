package com.cn.wanxi.service.online;

import com.cn.wanxi.dao.online.ProductOnlineDao;
import com.cn.wanxi.model.cart.WxTabSpu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: tenmallfront
 * @description:
 * @author: niyao
 * @create: 2019-11-21 13:40
 */
@Service
public class ProductOnlineServiceImpl implements ProductOnlineService {
    @Autowired
    private ProductOnlineDao productOnlineDao;
    @Override
    public List<WxTabSpu> getOnlineProducts() {
        return productOnlineDao.getOnlineProducts();
    }
}