package com.cn.wanxi.dao.productdetails;

import com.cn.wanxi.model.cart.WxTabSpu;
import com.cn.wanxi.model.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author
 * @date 2019/11/20 9:38
 */
@Mapper
public interface ProductDetailsDao {

    WxTabSpu productDetails(int id);
}
