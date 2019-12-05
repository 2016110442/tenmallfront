package com.cn.wanxi.front.online;

import com.cn.wanxi.model.cart.WxTabSpu;
import com.cn.wanxi.service.online.ProductOnlineService;
import com.cn.wanxi.util.WebTools;
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

    /**
     * 查询新上线的商品
     * @return
     */
    @RequestMapping(value = "/online",method = RequestMethod.POST)
    public Object getOnlineProducts(){
        return WebTools.returnData(productOnlineService.getOnlineProducts(),0);
    }
}