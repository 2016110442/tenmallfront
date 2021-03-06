package com.cn.wanxi.front.cart;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.cn.wanxi.model.cart.WxTabSpu;
import org.springframework.util.StringUtils;
import com.cn.wanxi.model.cart.WxTabCart;
import com.cn.wanxi.model.cart.WxTabSku;
import com.cn.wanxi.service.cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    @PostMapping(value = "/addCart")
    public Map<String,Object> addCart(@RequestBody String caerString, HttpServletRequest request){
        JSONObject object= JSON.parseObject(caerString);
        String token= request.getHeader("token");
        if(StringUtils.isEmpty(object.getString("spuId")))return returnData("spuId不能为空",1);
        if(StringUtils.isEmpty(object.getString("skuId")))return returnData("skuId不能为空",1);
        if(StringUtils.isEmpty(object.getString("num")))return returnData("num不能为空",1);
        //if(StringUtils.isEmpty(object.getString("spec")))return returnData("Spec不能为空",1);
        WxTabCart wxTabCart=new WxTabCart();

        wxTabCart.setNum(Integer.valueOf(object.getString("num")));
        wxTabCart.setSkuId(Integer.valueOf(object.getString("skuId")));
        wxTabCart.setSpuId(Integer.valueOf(object.getString("spuId")));
        //wxTabCart.setSpec(object.getString("spec"));
        wxTabCart.setUsername(JWT.decode(token).getAudience().get(0));
        return cartService.addCart(wxTabCart);
    }

    /**
     * 1.2.7.2.修改商品数量接口
     * id	true	Int	购物车ID
     * num	true	varchar	数量

     * @return
     */
    @PostMapping(value = "/updateNum", produces = "application/json;charset=UTF-8")
    public Map<String,Object> updateNum(@RequestBody Map<String, String> param, HttpServletRequest request){
        if(StringUtils.isEmpty(param.get("cartId")))return returnData("cartId不能为空",1);
        if(StringUtils.isEmpty(param.get("num")))return returnData("num不能为空",1);
        String token= request.getHeader("token");
        return cartService.updateNum(Integer.parseInt(param.get("cartId")),param.get("num"),JWT.decode(token).getAudience().get(0));
    }

    /**
     * 1.2.7.3.移除购物车接口
     * Id	true	Varchar	购物车ID
     * @return
     */
    @PostMapping(value = "/deleteCart", produces = "application/json;charset=UTF-8")
    public Object deleteCart(@RequestBody Map<String, String> param, HttpServletRequest request){
        if(StringUtils.isEmpty(param.get("cartId")))return returnData("id不能为空",1);
        String token= request.getHeader("token");
        return cartService.deleteCart(Integer.parseInt(param.get("cartId")),JWT.decode(token).getAudience().get(0));
    }

    /**
     * 1.2.7.4.购物车列表接口
     * page	true	int	页码（GET）
     * size	true	int	每页记录数（GET）

     * @return
     */
    @PostMapping(value = "/findCartList", produces = "application/json;charset=UTF-8")
    public Object findCartList(@RequestBody Map<String, String> param, HttpServletRequest request){
        if(StringUtils.isEmpty(param.get("page"))) return returnData("page不能为空",1);
        if(StringUtils.isEmpty(param.get("size")))return returnData("size不能为空",1);
        String token= request.getHeader("token");

        return cartService.findCartList(Integer.parseInt(param.get("page")),Integer.parseInt(param.get("size")),JWT.decode(token).getAudience().get(0));
    }


    /**
     * 1.2.7.5.获取商品skuid接口
     * spuid	true	Varchar	商品id
     * spec	True	Varchar	商品规格
     * @return
     */
    @PostMapping(value = "/getSkuid", produces = "application/json;charset=UTF-8")
    public Object getSkuid(@RequestBody String param){
        JSONObject object=JSON.parseObject(param);
        System.out.println(object.get("spec").toString());
      return cartService.getSkuid((int) object.get("spuid"),object.get("spec").toString());

    }
    /**
     * 1.2.7.6.查看产品详情接口
     * spuid	true	Varchar	商品id

     * @return
     */
    @PostMapping(value = "/cardDetail", produces = "application/json;charset=UTF-8")
    public  Map<String,Object> cardDetail(@RequestBody Map<String, String> param){
        if(StringUtils.isEmpty(param.get("id")))return returnData("id不能为空",1);
        return cartService.cardDetail(Integer.parseInt(param.get("id")));
    }
}
