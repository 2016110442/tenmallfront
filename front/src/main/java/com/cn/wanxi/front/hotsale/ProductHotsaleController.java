package com.cn.wanxi.front.hotsale;

import com.cn.wanxi.model.cart.WxTabSpu;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: tenmallfront
 * @description:
 * @author: niyao
 * @create: 2019-11-21 13:44
 */
@RestController
public class ProductHotsaleController {
    @RequestMapping("/hotSale")
    public List<WxTabSpu> getHotsaleProducts(){
        return null;
    }
}