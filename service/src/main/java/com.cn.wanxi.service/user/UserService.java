package com.cn.wanxi.service.user;

import com.cn.wanxi.model.user.User;

import java.util.Map;

public interface UserService {
    public User findUserByPhone(String phone);
    public Map<String,String > register(String phone,
                                        String code,
                                        String password);
    public Map<String,String>  getSSM(String phone);
    public Map<String, Object> update(User user);
    public Map<String,Object> uname(String phone);
}
