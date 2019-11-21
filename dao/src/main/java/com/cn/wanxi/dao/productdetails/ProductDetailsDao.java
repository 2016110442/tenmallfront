package com.cn.wanxi.dao.productdetails;

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
    @Select("select id,username from user where id=#{id}")
    List productDetails(int id);
}
