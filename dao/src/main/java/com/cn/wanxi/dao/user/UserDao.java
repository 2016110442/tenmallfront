package com.cn.wanxi.dao.user;

import com.cn.wanxi.model.user.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao {
    @Select("select username,phone,email,nick_name,name,status,head_pic,qq," +
            "sex,user_level,status,points,experience_value,birthday from wx_tab_user where phone=#{phone}")
    public User findUserByPhone(@Param("phone") String phone);
    @Insert("insert into user(phone) valus(#{phone})")
    public void addUser(@Param("phone") String phone);

    @Update("update wx_tab_user set username=#{user.username},phone=#{user.phone},email=#{user.email}" +
            ",nick_name=#{user.nickName},name=#{user.name},head_pic=#{user.headPic},qq=#{user.qq},sex=#{user.sex},birthday=#{user.birthday} where id=1")
    int updateUserInfo(@Param("user") User user);

    @Select("select username from wx_tab_user where phone=#{phone}")
    String findUserName(String phone);
    @Select("select count(*) from wx_tab_user where username=#{username}")
    String findRepetition(String username);
}
