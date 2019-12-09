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



//    @Select("select * from wx_tab_user where phone=#{phone}")
    List<User> findByPhone(@Param("phone") String phone);

    /**
     * wxs
     * @param user
     * @return
     */
    int updateUserInfo(@Param("user") User user);

    String findUserName(@Param("phone")String phone);


    User findMessages(@Param("phone")String phone);

    int updatePassword(@Param("phone")String phone, @Param("password")String newPassword);

    int passwordValidation(@Param("phone") String phone,@Param("password") String password);
}
