package com.cn.wanxi.front.productdetails;

import com.cn.wanxi.model.user.User;
import com.cn.wanxi.service.productdetails.ProductDetailsService;
import com.cn.wanxi.service.productdetails.ProductDetailsServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wxs
 * @date 2019/11/20 9:38
 * 1.2.6.1.商品详情接口
 * /product/productDetails.do
 */

@RestController
@RequestMapping("/product")
public class ProductDetails {

    ProductDetailsServiceImpl ProductDetailsServiceImpl =new ProductDetailsService();
    @RequestMapping(value = "/productDetails.do",method = RequestMethod.POST)
    public List productDetails(int id){
        return ProductDetailsServiceImpl.productDetails(id);
    }

}
