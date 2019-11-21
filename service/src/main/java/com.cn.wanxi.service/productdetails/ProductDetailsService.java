package com.cn.wanxi.service.productdetails;

import com.cn.wanxi.dao.productdetails.ProductDetailsDao;
import com.cn.wanxi.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @date 2019/11/20 9:38
 */

@Service
public class ProductDetailsService implements ProductDetailsServiceImpl {
    @Autowired
     ProductDetailsDao productDetailsDao;
    public List productDetails(int id) {
        return productDetailsDao.productDetails(id);
    }
}
