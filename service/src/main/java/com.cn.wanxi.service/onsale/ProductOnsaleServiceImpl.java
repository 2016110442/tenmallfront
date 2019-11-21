package com.cn.wanxi.service.onsale;

import com.cn.wanxi.dao.onsale.ProductOnsaleDao;
import com.cn.wanxi.model.cart.WxTabSpu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: tenmallfront
 * @description:
 * @author: niyao
 * @create: 2019-11-21 15:04
 */
@Service
public class ProductOnsaleServiceImpl  implements ProductOnsaleService{
    @Autowired
    private ProductOnsaleDao productOnsaleDao;
    @Override
    public List<WxTabSpu> getOnsaleProducts() {
        return productOnsaleDao.getOnsaleProducts();
    }
}