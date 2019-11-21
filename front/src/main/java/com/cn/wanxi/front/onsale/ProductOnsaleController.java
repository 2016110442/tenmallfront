package com.cn.wanxi.front.onsale;

import com.cn.wanxi.model.cart.WxTabSpu;
import com.cn.wanxi.service.onsale.ProductOnsaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: tenmallfront
 * @description:
 * @author: niyao
 * @create: 2019-11-21 13:45
 */
@RestController
@RequestMapping("/product")
public class ProductOnsaleController {
    @Autowired(required = false)
    private ProductOnsaleService productOnsaleService;
    @RequestMapping(value = "/onSale",method = RequestMethod.POST)
    public List<WxTabSpu> getOnsaleProducts(){
        return productOnsaleService.getOnsaleProducts();
    }
}