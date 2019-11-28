package com.cn.wanxi.service.cart;

import com.cn.wanxi.dao.cart.CartDao;
import com.cn.wanxi.model.cart.AddCartModel;
import com.cn.wanxi.model.cart.WxTabCart;
import com.cn.wanxi.model.cart.WxTabSku;
import com.cn.wanxi.model.cart.WxTabSpu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    public Map<String, Object> updateNum(int id,String num) {
        int returnInt=cartDao.updateNum(id,num);
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
    public Map<String, Object> deleteCart(int id) {
        int returnInt=cartDao.deleteCart(id);
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
    public List<Map<String,Object>> findCartList(int page, int size) {
        List<WxTabCart> wxTabCarts=cartDao.findCartSpuidSkuid(page,size);  //查询spuid ， skuid
        List<Map<String,Object>> lists=new ArrayList<>();
        for(WxTabCart spuidskuid:wxTabCarts){

            Map<String,Object> maps=cartDao.findCartSpuTab(spuidskuid.getSpuId());
            String paraItems=((String)maps.get("para_items")).replaceAll("\"","'");
            maps.remove("para_items");
            maps.put("para_items",paraItems);
            String specItems=((String)maps.get("spec_items")).replaceAll("\"","'");
            maps.remove("spec_items");
            maps.put("para_items",specItems);
            System.out.printf(maps.toString());
            List<WxTabSku> wxTabSkulists=cartDao.findCartSkuTab(spuidskuid.getSpuId());
            List<WxTabSku> wxTabSkulists3=new ArrayList<>();
            for (WxTabSku wxTabSkulists2:wxTabSkulists) {
                wxTabSkulists2.setSpec(wxTabSkulists2.getSpec().replaceAll("\"","'"));
                wxTabSkulists3.add(wxTabSkulists2);
            }
            maps.put("skuList",wxTabSkulists3);
            maps.put("skuid",spuidskuid.getSkuId());
            maps.put("num", spuidskuid.getNum());
            lists.add(maps);
        }

        return lists;
    }


//    @Override
//    public List<Map<String,Object>> findCartList(int page, int size) {
//        List<WxTabCart> wxTabCarts=cartDao.findCartSpuidSkuid(page,size);  //查询spuid ， skuid
//        List<Map<String,Object>> lists=new ArrayList<>();
//        for(WxTabCart spuidskuid:wxTabCarts){
//            Map<String,Object> maps=new HashMap<>();
//            maps.put("spu",cartDao.findCartSpuTab(spuidskuid.getSpuId()));
//            maps.put("skuList", cartDao.findCartSkuTab(spuidskuid.getSpuId()));
//            maps.put("skuid",spuidskuid.getSkuId());
//            maps.put("num", spuidskuid.getNum());
//            lists.add(maps);
//        }
//
//        return lists;
//    }
    /**
     *  1.2.7.5.获取商品skuid接口
     * @param
     * @return
     */
    @Override
    public WxTabSku getSkuid(int spuid, String spec) {
        //   String specs=spec.replaceAll("'","\\\"");
        //  String specs2=specs.replaceAll("\"","\\\"");
        System.out.printf(spec);
        WxTabSku wxTabSkusj = cartDao.getSkuid(spuid, spec.replaceAll("\"","\\\""));
        wxTabSkusj.setSpec(wxTabSkusj.getSpec().replaceAll("\"","'"));
        return wxTabSkusj;

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
        System.out.printf(maps.toString());
        List<WxTabSku> wxTabSkulists=cartDao.findCartSkuTab(wxTabCarts.getSpuId());
        List<WxTabSku> wxTabSkulists3=new ArrayList<>();
        for (WxTabSku wxTabSkulists2:wxTabSkulists) {
            wxTabSkulists2.setSpec(wxTabSkulists2.getSpec().replaceAll("\"","'"));
            wxTabSkulists3.add(wxTabSkulists2);
        }
        maps.put("skuList",wxTabSkulists3);

        maps.put("num", wxTabCarts.getNum());
        lists.add(maps);

        return maps;
    }


}
