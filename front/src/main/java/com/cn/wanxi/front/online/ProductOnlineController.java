package com.cn.wanxi.front.online;

import com.cn.wanxi.model.cart.WxTabSpu;
import com.cn.wanxi.service.online.ProductOnlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: tenmallfront
 * @description:
 * @author: niyao
 * @create: 2019-11-21 13:42
 */
@RestController
@RequestMapping("/product")
public class ProductOnlineController {
    @Autowired(required = false)
    private ProductOnlineService productOnlineService;
    @RequestMapping(value = "/online",method = RequestMethod.POST)
    public List<WxTabSpu> getOnlineProducts(){
        return productOnlineService.getOnlineProducts();
    }
}