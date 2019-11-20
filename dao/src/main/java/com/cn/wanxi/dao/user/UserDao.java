package com.cn.wanxi.dao.user;

import com.cn.wanxi.model.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Select("select id,username from user where id=#{id}")
    public User getUserByID(@Param("id") Integer id);
}
