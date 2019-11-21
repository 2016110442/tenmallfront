package com.cn.wanxi.front.cart;

import com.cn.wanxi.model.cart.AddCartModel;
import com.cn.wanxi.service.cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * wxs
 * 购物车接口类
 *
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    /**
     * 1.2.7.1.添加购物车接口
     *
     * 参数	    必选	类型	说明
     * skuId	false	Varchar	商品对应库存ID
     * num	    true	varchar	添加数量
     * spuId	true	varchar	商品id
     * Spec	    True	Varchar	规格参数，json格式，以逗号分开
     */

    @RequestMapping(value = "/addCart.do",method = RequestMethod.POST)
    public Map<String,Object> addCart(AddCartModel addCartModel){

        return cartService.addCart(addCartModel);
    }

    /**
     * 1.2.7.2.修改商品数量接口
     * id	true	Int	购物车ID
     * num	true	varchar	数量
     * @param id
     * @param num
     * @return
     */
    @RequestMapping("/updateNum.do")
    public Map<String,Object> updateNum(int id,String num){

        return cartService.updateNum(id,num);
    }

    /**
     * 1.2.7.3.移除购物车接口
     * Id	true	Varchar	购物车ID
     * @return
     */
    @RequestMapping("/deleteCart.do")
    public Map<String,Object> deleteCart(int id){

        return cartService.deleteCart(id);
    }

    /**
     * 1.2.7.4.购物车列表接口
     * page	true	int	页码（GET）
     * size	true	int	每页记录数（GET）
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/findCartList.do",method = RequestMethod.GET)
    public List findCartList(int page, int size){

        return  cartService.findCartList(page,size);
    }


    /**
     * 1.2.7.5.获取商品skuid接口
     * spuid	true	Varchar	商品id
     * spec	True	Varchar	商品规格
     * @return
     */
    @RequestMapping("/getSkuid.do")
    public List getSkuid(int spuid,String spec){

        return cartService.getSkuid(spuid,spec);
    }
    /**
     * 1.2.7.6.查看产品详情接口
     * spuid	true	Varchar	商品id

     * @return
     */
    @RequestMapping("/cardDetail.do")
    public List cardDetail(int id){

        return cartService.cardDetail(id);
    }
}
