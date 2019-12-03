package com.cn.wanxi.front.productdetails;

import com.cn.wanxi.model.productdetails.ProductSearch;
import com.cn.wanxi.service.productdetails.ProductDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/productDetails", produces = "application/json;charset=UTF-8")
    public Object productDetails(@RequestBody Map<String, String> param){
        if(StringUtils.isEmpty(Integer.parseInt(param.get("id"))))return returnData("id不能为空",1);
        return productDetailsServiceImpl.productDetails(Integer.parseInt(param.get("id")));
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
