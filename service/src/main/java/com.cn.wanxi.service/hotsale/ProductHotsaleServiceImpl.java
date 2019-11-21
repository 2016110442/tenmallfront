package com.cn.wanxi.service.hotsale;

import com.cn.wanxi.dao.hotsale.ProductHotsaleDao;
import com.cn.wanxi.model.cart.WxTabSpu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: tenmallfront
 * @description:
 * @author: niyao
 * @create: 2019-11-21 15:29
 */
@Service
public class ProductHotsaleServiceImpl implements ProductHotsaleService{
    @Autowired
    private ProductHotsaleDao productHotsaleDao;
    @Override
    public List<WxTabSpu> getHotsaleProducts() {
        return productHotsaleDao.getHotsaleProducts();
    }
}