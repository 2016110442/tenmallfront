package com.cn.wanxi.service.user;

import com.cn.wanxi.dao.user.UserDao;
import com.cn.wanxi.model.user.User;
import com.cn.wanxi.util.RedisUtil;
import com.cn.wanxi.util.SendMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: tenmallfront
 * @description:
 * @author: niyao
 * @create: 2019-11-20 12:47
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 根据电话号码查询
     * @param phone
     * @return
     */
    @Override
    public User findUserByPhone(String phone) {
        return userDao.findUserByPhone(phone);
    }

    /**
     * 用户注册
     * @param phone
     * @param code
     * @param password
     * @return
     */
    @Override
    public Map<String,String > register(String phone,
                                        String code,
                                        String password){
        Map<String,String> msg=new HashMap<>();
        User user=userDao.findUserByPhone(phone);
        if(user!=null){
            msg.put("code","0");
            msg.put("message","注册成功");
        }
        if(RedisUtil.isCodeExist(phone,code)){
            msg.put("code","0");
            msg.put("message","注册成功");
        }else {
            msg.put("code","1");
            msg.put("message","验证码错误，注册失败");
        }
        return msg;
    }

    /**
     * 手机获取验证码
     * @param phone
     * @return
     */
    @Override
    public Map<String, String> getSSM(String phone) {

        Map<String,String> map=new HashMap<>();

        String  code= SendMessageUtil.getRandomCode(6);
        Integer result=SendMessageUtil.send(phone,code);
        if(result>0){
            RedisUtil.setCode(phone,code); //发送成功,存储验证码
        }
        String  msg=SendMessageUtil.getMessage(result);
        map.put("code",String.valueOf(result));
        map.put("message",msg);
        return map;
    }

    @Override
    public String update(User user) {
        return null;
    }

    @Override
    public String uname(String phone) {
        return null;
    }

}