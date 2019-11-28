package com.cn.wanxi.front.hotsale;

import com.cn.wanxi.model.cart.WxTabSpu;
import com.cn.wanxi.service.hotsale.ProductHotsaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: tenmallfront
 * @description:
 * @author: niyao
 * @create: 2019-11-21 13:44
 */
@RestController
@RequestMapping("/product")
public class ProductHotsaleController {
    @Autowired(required = false)
    private ProductHotsaleService productHotsaleService;
    /**
     * 查询热卖商品
     * @return
     */
    @RequestMapping(value = "/hotSale",method = RequestMethod.POST)
    public List<WxTabSpu> getHotsaleProducts(){
        return productHotsaleService.getHotsaleProducts();
    }
}