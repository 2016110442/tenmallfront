package com.cn.wanxi.service.cart;

import com.cn.wanxi.dao.cart.CartDao;
import com.cn.wanxi.model.cart.AddCartModel;
import com.cn.wanxi.model.cart.WxTabSku;
import com.cn.wanxi.model.cart.WxTabSpu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.cn.wanxi.util.WebTools.returnData;

/**
 * @author wxs
 * @date 2019/11/20 9:38
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
    public Map<String, Object> addCart(AddCartModel addCartModel) {
        int returnInt=cartDao.addCart(addCartModel);
        Map<String, Object> maps= new HashMap<>();
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
    public List<WxTabSpu> findCartList(int page, int size) {
        return cartDao.findCartList(page, size);
    }
    /**
     *  1.2.7.5.获取商品skuid接口
     * @param
     * @return
     */
    @Override
    public WxTabSku getSkuid(int spuid, String spec) {
        return cartDao.getSkuid(spuid, spec);
    }
    /**
     *  1.2.7.6.查看产品详情接口
     * @param
     * @return
     */
    @Override
    public List cardDetail(int id) {
        return cartDao.cardDetail(id);
    }


}
