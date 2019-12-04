package com.cn.wanxi.service.user;

import com.cn.wanxi.model.user.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public String findPassByPhone(String phone);
    public Map<String,String > register(String phone,
                                        String code,
                                        String password);
    public Object  getSSM(String phone);
    public Map<String, Object> update(User user);
    public Map<String,Object> uname(String phone);
    public void addUser(String phone,String password);
    public boolean userLogin(String phone,String password);

    List<User> findByPhone(String phone);
    User findMessage(String phone);

    Map<String, Object> updatePw(String phone, String oldPassword, String newPassword);

}
