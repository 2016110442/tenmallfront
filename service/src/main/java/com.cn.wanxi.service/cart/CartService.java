package com.cn.wanxi.service.cart;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cn.wanxi.dao.cart.CartDao;
import com.cn.wanxi.model.cart.WxTabCart;
import com.cn.wanxi.model.cart.WxTabSku;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static com.cn.wanxi.util.WebTools.returnData;

/**
 * @program: cart
 * @description:购物车接口类
 * @author: wangxuesong
 * @create: 2019-11-20 11:33
 */

@Service
public class CartService implements CartServiceImpl {


    @Autowired
    private CartDao cartDao;

    /**
     *  1.2.7.1.接口添加购物车接口
     * @param
     * @return
     */
    @Override
    public Map<String,Object> addCart(WxTabCart wxTabCart) {

        int returnInt=cartDao.addCart(wxTabCart);
        if(returnInt>0){
            return returnData("添加成功",0);
        }
        return returnData("添加失败",1);
    }
    /**
     *  1.2.7.2.修改商品数量接口
     * @param
     * @return
     */
    @Override
    public Map<String, Object> updateNum(int id,String num,String uaername) {
        int returnInt=cartDao.updateNum(id,num,uaername);
        Map<String, Object> maps= new HashMap<>();
        if(returnInt>0){
            return returnData("修改数量成功",0);
        }
        return returnData("修改数量失败",1);
    }
    /**
     *  1.2.7.3.移除购物车接口
     * @param
     * @return
     */
    @Override
    public Map<String, Object> deleteCart(int id,String uaername) {
        int returnInt=cartDao.deleteCart(id,uaername);
        Map<String, Object> maps= new HashMap<>();
        if(returnInt>0){
            return returnData("删除成功",0);
        }
        return returnData("删除失败",1);
    }
    /**
     *  11.2.7.4.购物车列表接口
     * @param
     * @return
     */
    @Override
    public Object findCartList(int page, int size,String username) {
        PageHelper.startPage(page,size);
        List<WxTabCart> wxTabCarts=cartDao.findCartSpuidSkuid(username);  //查询spuid ， skuid
        PageInfo<WxTabCart> pageInfo = new PageInfo<WxTabCart>(wxTabCarts);
        long total=pageInfo.getTotal();
        List<Map<String,Object>> lists=new ArrayList<>();
        System.out.println(wxTabCarts);
        for(WxTabCart spuidskuid:pageInfo.getList()){//
            Map<String,Object> maps=cartDao.findCartSpuTab(spuidskuid.getSpuId());
            if(maps!=null){


            String paraItems=((String)maps.get("para_items")).replaceAll("\"","'");

            maps.remove("para_items");
            maps.put("para_items",paraItems);
            String specItems=((String)maps.get("spec_items")).replaceAll("\"","'");
            maps.remove("spec_items");
            maps.put("spec_items",specItems);
            WxTabSku wxTabSkulists=cartDao.findCartSkuTab(spuidskuid.getSkuId());

            wxTabSkulists.setSpec(wxTabSkulists.getSpec().replaceAll("\"","'"));
            maps.put("skuList",wxTabSkulists);
            maps.put("skuid",spuidskuid.getSkuId());
            maps.put("cartNum", spuidskuid.getNum());
            maps.put("cartId", spuidskuid.getId());
            maps.put("subtotal",spuidskuid.getNum()*wxTabSkulists.getPrice());
            lists.add(maps);
            }
        }

        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("data",lists);
        map.put("total",total);
        return map;
    }
    /**
     *  1.2.7.5.获取商品skuid接口
     * @param
     * @return
     */
    @Override
    public Object getSkuid(int spuid, String spec) {
        WxTabSku wxTabSkusj = cartDao.getSkuid(spuid, spec);
        if(wxTabSkusj==null){
           return returnData("没有这个数据",1);
        }
        wxTabSkusj.setSpec(wxTabSkusj.getSpec().replaceAll("\"","'"));
        return returnData(wxTabSkusj,0);

    }
    /**
     *  1.2.7.6.查看产品详情接口
     * @param
     * @return
     */
    @Override
    public  Map<String,Object> cardDetail(int id){
        WxTabCart wxTabCarts=cartDao.findCartTab(id);  //查询spuid ， skuid
        List<Map<String,Object>> lists=new ArrayList<>();
        if(wxTabCarts==null){return returnData("未找到",1);}
        Map<String,Object> maps=cartDao.findCartSpuTab(wxTabCarts.getSpuId());
        String paraItems=((String)maps.get("para_items")).replaceAll("\"","'");
        maps.remove("para_items");
        maps.put("para_items",paraItems);
        String specItems=((String)maps.get("spec_items")).replaceAll("\"","'");
        maps.remove("spec_items");
        maps.put("para_items",specItems);
        List<WxTabSku> wxTabSkulists=cartDao.findCartSkuTabList(wxTabCarts.getSkuId());
        List<WxTabSku> wxTabSkulists3=new ArrayList<>();
        for (WxTabSku wxTabSkulists2:wxTabSkulists) {
            wxTabSkulists2.setSpec(wxTabSkulists2.getSpec().replaceAll("\"","'"));
            wxTabSkulists3.add(wxTabSkulists2);
        }
        maps.put("skuList",wxTabSkulists3);

        maps.put("num", wxTabCarts.getNum());
        lists.add(maps);

        return returnData(maps,0);
    }


}
