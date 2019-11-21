package com.cn.wanxi.front.onsale;

import com.cn.wanxi.model.cart.WxTabSpu;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping("/onSale")
    public List<WxTabSpu> getOnsaleProducts(){
        return null;
    }
}