package com.cn.wanxi.front.productdetails;

import org.springframework.util.StringUtils;
import com.cn.wanxi.model.productdetails.ProductSearch;
import com.cn.wanxi.model.user.User;
import com.cn.wanxi.service.productdetails.ProductDetailsService;
import com.cn.wanxi.service.productdetails.ProductDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static com.cn.wanxi.util.WebTools.returnData;

/**
 * @program: product
 * @description:商品详情
 * @author: wangxuesong
 * @create: 2019-11-20 11:33
 */

@RestController
@RequestMapping("/product")
public class ProductDetails {
    @Autowired
    private ProductDetailsServiceImpl productDetailsServiceImpl;
    @RequestMapping(value = "/productDetails",method = RequestMethod.POST)
    public Map<String,Object> productDetails(@RequestParam(required = false) Integer id){
        if(StringUtils.isEmpty(id))return returnData("id不能为空",1);
        return productDetailsServiceImpl.productDetails(id);
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public List<ProductSearch> productDetails(@RequestParam(required = false) String conditionpara){
        if (conditionpara==null){
            return productDetailsServiceImpl.search("");
        }else{
            return productDetailsServiceImpl.search(conditionpara);
        }

    }

}
