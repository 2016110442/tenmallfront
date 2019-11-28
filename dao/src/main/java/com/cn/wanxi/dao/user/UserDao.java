package com.cn.wanxi.dao.user;

import com.cn.wanxi.model.user.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select password from wx_tab_user where phone=#{phone}")
    public String findPassByPhone(@Param("phone") String phone);
    @Insert("insert into wx_tab_user(phone,password) values(#{phone},#{password})")
    public void addUser(@Param("phone") String phone,@Param("password") String password);

    @Update("update wx_tab_user set username=#{user.username},phone=#{user.phone},email=#{user.email}" +
            ",nick_name=#{user.nickName},name=#{user.name},head_pic=#{user.headPic},qq=#{user.qq},sex=#{user.sex},birthday=#{user.birthday} where id=1")
    int updateUserInfo(@Param("user") User user);

    @Select("select username from wx_tab_user where phone=#{phone}")
    String findUserName(String phone);
    @Select("select count(*) from wx_tab_user where username=#{username}")
    String findRepetition(String username);

    @Select("select * from wx_tab_user where phone=#{phone}")
    List<User> findByPhone(String phone);
}
