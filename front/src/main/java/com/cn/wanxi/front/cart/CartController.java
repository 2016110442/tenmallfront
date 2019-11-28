package com.cn.wanxi.front.cart;

import com.cn.wanxi.model.cart.WxTabCart;
import com.cn.wanxi.model.cart.WxTabSku;
import com.cn.wanxi.service.cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.cn.wanxi.util.WebTools.returnData;


/**
 * @program: cart
 * @description:购物车接口类
 * @author: wangxuesong
 * @create: 2019-11-20 11:33
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

    @RequestMapping(value = "/addCart",method = RequestMethod.POST)
    public Map<String,Object> addCart(WxTabCart wxTabCart){
        if(StringUtils.isEmpty(wxTabCart.getNum()))return returnData("num不能为空",1);
        if(StringUtils.isEmpty(wxTabCart.getSpuId()))return returnData("SpuId不能为空",1);
        if(StringUtils.isEmpty(wxTabCart.getNum()))return returnData("Spec不能为空",1);
        return cartService.addCart(wxTabCart);
    }

    /**
     * 1.2.7.2.修改商品数量接口
     * id	true	Int	购物车ID
     * num	true	varchar	数量
     * @param id
     * @param num
     * @return
     */
    @RequestMapping("/updateNum")
    public Map<String,Object> updateNum(@RequestParam(required = true) Integer id,@RequestParam(required = true) String num){
        if(StringUtils.isEmpty(id))return returnData("id不能为空",1);
        if(StringUtils.isEmpty(num))return returnData("num不能为空",1);

        return cartService.updateNum(id,num);
    }

    /**
     * 1.2.7.3.移除购物车接口
     * Id	true	Varchar	购物车ID
     * @return
     */
    @RequestMapping("/deleteCart")
    public Map<String,Object> deleteCart(@RequestParam(required = true) Integer id){
        if(StringUtils.isEmpty(id))return returnData("id不能为空",1);

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
    @RequestMapping(value = "/findCartList",method = RequestMethod.POST)
    public List<Map<String,Object>> findCartList(@RequestParam(required = true) Integer page,@RequestParam(required = true) Integer size){

        return  cartService.findCartList(page,size);
    }


    /**
     * 1.2.7.5.获取商品skuid接口
     * spuid	true	Varchar	商品id
     * spec	True	Varchar	商品规格
     * @return
     */
    @RequestMapping(value ="/getSkuid",method = RequestMethod.POST)
    public WxTabSku getSkuid(@RequestParam(required = true) Integer spuid,@RequestParam(required = true) String spec){
        return cartService.getSkuid(spuid,spec);
    }
    /**
     * 1.2.7.6.查看产品详情接口
     * spuid	true	Varchar	商品id

     * @return
     */
    @RequestMapping(value ="/cardDetail",method = RequestMethod.POST)
    public  Map<String,Object> cardDetail( Integer id){
        if(StringUtils.isEmpty(id))return returnData("id不能为空",1);
        return cartService.cardDetail(id);
    }
}
