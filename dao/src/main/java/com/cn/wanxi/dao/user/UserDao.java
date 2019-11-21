package com.cn.wanxi.dao.user;

import com.cn.wanxi.model.user.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Select("select username,phone,email,nickName,name,status,headPic,qq," +
            "sex,userLevel,points,experienceValue,birthday from user where phone=#{phone}")
    public User findUserByPhone(@Param("phone") String phone);
    @Insert("insert into user(phone) valus(#{phone})")
    public void addUser(@Param("phone") String phone);
}
