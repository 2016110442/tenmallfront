package com.cn.wanxi.service.user;

import com.cn.wanxi.model.user.User;

import java.util.Map;

public interface UserService {
    public User findUserByPhone(String phone);
    public Map<String,String > register(String phone,  //手机号
                                        String code,  //验证码
                                        String password); //密码
    public Map<String,String>  getSSM(String phone);
    public String update(User user);
    public String uname(String phone);
}
