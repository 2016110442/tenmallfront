package com.cn.wanxi.service.productdetails;

import com.cn.wanxi.dao.productdetails.ProductDetailsDao;
import com.cn.wanxi.model.cart.WxTabSku;
import com.cn.wanxi.model.cart.WxTabSpu;
import com.cn.wanxi.model.productdetails.ProductSearch;
import com.cn.wanxi.model.user.User;
import com.cn.wanxi.util.WebTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: product
 * @description:商品详情
 * @author: wangxuesong
 * @create: 2019-11-20 11:33
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
        return WebTools.returnData(maps,0);
    }

    @Override
    public List<ProductSearch> search(String conditionpara,String categoryId3) {

        Integer cateid = null;
        if (categoryId3!=null){
            cateid = Integer.valueOf(categoryId3);
        }
        List<ProductSearch> list = productDetailsDao.search(conditionpara,cateid);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getParaItems()!=null&&list.get(i).getParaItems().indexOf("\"")>0){
                list.get(i).setParaItems(list.get(i).getParaItems().replace("\"","\'"));
            }
            if (list.get(i).getSpecItems()!=null&&list.get(i).getSpecItems().indexOf("\"")>0){
                list.get(i).setSpecItems(list.get(i).getSpecItems().replace("\"","\'"));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setWxTabSku(productDetailsDao.productDetailsWxTabSkuList(list.get(i).getId()));
            for (int j = 0; j < list.get(i).getWxTabSku().size(); j++) {
                if (list.get(i).getWxTabSku().get(j).getSpec()!=null&&list.get(i).getWxTabSku().get(j).getSpec().indexOf("\"")>0){
                    list.get(i).getWxTabSku().get(j).setSpec(list.get(i).getWxTabSku().get(j).getSpec().replace("\"","\'"));
                }
            }
        }
        return list;
    }

    @Override
    public List<ProductSearch> searchTwo(Integer categoryId3) {
        Integer cateid = null;
        if (categoryId3!=null){
            cateid = Integer.valueOf(categoryId3);
        }
        List<ProductSearch> list = productDetailsDao.searchTwo(cateid);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getParaItems()!=null&&list.get(i).getParaItems().indexOf("\"")>0){
                list.get(i).setParaItems(list.get(i).getParaItems().replace("\"","\'"));
            }
            if (list.get(i).getSpecItems()!=null&&list.get(i).getSpecItems().indexOf("\"")>0){
                list.get(i).setSpecItems(list.get(i).getSpecItems().replace("\"","\'"));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setWxTabSku(productDetailsDao.productDetailsWxTabSkuList(list.get(i).getId()));
            for (int j = 0; j < list.get(i).getWxTabSku().size(); j++) {
                if (list.get(i).getWxTabSku().get(j).getSpec()!=null&&list.get(i).getWxTabSku().get(j).getSpec().indexOf("\"")>0){
                    list.get(i).getWxTabSku().get(j).setSpec(list.get(i).getWxTabSku().get(j).getSpec().replace("\"","\'"));
                }
            }
        }
        return list;
    }
}
