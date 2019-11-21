package com.cn.wanxi.front.user;

import com.cn.wanxi.model.user.User;
import com.cn.wanxi.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @program: tenmallfront
 * @description:
 * @author: niyao
 * @create: 2019-11-20 11:33
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired(required = false)
    private UserService userService;

    /**
     *
     * @param phone 电话号码
     * @param code  验证码
     * @param password 密码
     * @return msg
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Map<String ,String> register(String phone,     /*手机号*/
                                        String code,      /*验证码*/
                                        String password){ /*密码*/
        return userService.register(phone,code,password);
    }

    /**
     * 手机获取验证码
     * @param phone
     * @return
     */
    @RequestMapping(value = "/ssm",method = RequestMethod.POST)
    public Map<String,String>  getSSM(String phone){
        return userService.getSSM(phone);
    }

    /**
     * 根据手机号查询用户
     * @param phone
     * @return
     */
    @RequestMapping(value = "/findOne",method = RequestMethod.POST)
    public User findByPhone(String phone){
        return userService.findUserByPhone(phone);
    }


    /**
     * 1.2.12.5.个人信息维护接口
     * @param user
     * @return
     */
    @RequestMapping(value ="/update",method = RequestMethod.POST)
    public Map<String, Object> update(User user){
        return userService.update(user);
    }

    /**
     * 1.2.12.6.首页显示登陆名接口
     * @param
     * @return
     */
    @RequestMapping(value ="/uname",method = RequestMethod.POST)
    public Map<String,Object> uname(String phone){
        return userService.uname(phone);
    }
}