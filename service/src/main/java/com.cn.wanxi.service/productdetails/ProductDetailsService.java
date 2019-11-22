package com.cn.wanxi.service.productdetails;

import com.cn.wanxi.dao.productdetails.ProductDetailsDao;
import com.cn.wanxi.model.cart.WxTabSku;
import com.cn.wanxi.model.cart.WxTabSpu;
import com.cn.wanxi.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @date 2019/11/20 9:38
 */

@Service
public class ProductDetailsService implements ProductDetailsServiceImpl {
    @Autowired
     ProductDetailsDao productDetailsDao;
    public Map<String,Object> productDetails(int id) {
        WxTabSpu WxTabSpuList= productDetailsDao.productDetailsWxTabSpuList(id);   //wx_tab_spu表
        List<WxTabSku>  WxTabSkuList= productDetailsDao.productDetailsWxTabSkuList(id);  //wx_tab_sku表
        Map<String,Object> maps=new HashMap<>();
        maps.put("spu",WxTabSpuList);
        maps.put("skuList",WxTabSkuList);


        return maps;
    }

    @Override
    public List<WxTabSpu> search(String conditionpara) {
        return productDetailsDao.search(conditionpara);
    }

}
