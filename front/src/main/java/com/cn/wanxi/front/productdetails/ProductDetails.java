package com.cn.wanxi.front.productdetails;

import com.cn.wanxi.model.cart.WxTabSpu;
import com.cn.wanxi.model.user.User;
import com.cn.wanxi.service.productdetails.ProductDetailsService;
import com.cn.wanxi.service.productdetails.ProductDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author wxs
 * @date 2019/11/20 9:38
 * 1.2.6.1.商品详情接口
 * /product/productDetails.do
 */

@RestController
@RequestMapping("/product")
public class ProductDetails {
    @Autowired
    private ProductDetailsServiceImpl productDetailsServiceImpl;
    @RequestMapping(value = "/productDetails",method = RequestMethod.POST)
    public Map<String,Object> productDetails(int id){
        return productDetailsServiceImpl.productDetails(id);
    }

}
