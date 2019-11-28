package com.cn.wanxi.front.user;

import com.cn.wanxi.model.user.User;
import com.cn.wanxi.service.user.UserService;
import com.cn.wanxi.util.WebTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.StringUtils;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;

import static com.cn.wanxi.util.WebTools.returnData;

/**
 * @program: tenmallfront
 * @description:
 * @author: niyao
 * @create: 2019-11-20 11:33
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired(required = false)
    private UserService userService;
    @RequestMapping("/login")
    public Object userLogin(@RequestBody Map<String,Object> param,HttpSession session,HttpServletResponse response){

        Map<String,String> map=new HashMap<>();
        String phone=(String) param.get("phone");
        String password=(String) param.get("password");
        if(phone.matches("^\\d{11}$")==false||phone==null){
            return WebTools.returnData("手机号不对",1);
        }
        if(password==null){
            return WebTools.returnData("密码不能为空",1);
        }

        if (userService.userLogin(phone,password)){
            map.put("code","0");
            map.put("message","登录成功");
            session.setAttribute("username",phone);
            Cookie cookie=new Cookie("username",phone);
            cookie.setMaxAge(1800);
            response.addCookie(cookie);
            return map;
        }
        map.put("code","1");
        map.put("message","登录失败");
        return map;
    }
    /**
     *
     * @param phone 电话号码
     * @param code  验证码
     * @param password 密码
     * @return msg
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Object register(@RequestBody Map<String,Object> param){

        String phone=(String) param.get("phone");
        String code=(String) param.get("code");
        String password=(String) param.get("password");
        if(phone.matches("^\\d{11}$")==false||phone==null){
            return WebTools.returnData("手机号不对",1);
        }
        if(code.matches("^\\d{6}$")==false||code==null){
            return WebTools.returnData("验证码不对",1);
        }
        if(password==null){
            return WebTools.returnData("密码不能为空",1);
        }
        return userService.register(phone,code,password);
    }

    /**
     * 手机获取验证码
     * @param
     * @return
     */
    @RequestMapping(value = "/ssm",method = RequestMethod.POST)
    public Object  getSSM(@RequestBody Map<String,Object> param){
        Map<String,String> map=new HashMap<>();
        String phone=(String) param.get("phone");
        if(phone.matches("^\\d{11}$")==false||phone==null){
            return WebTools.returnData("手机号不对",1);
        }
        return userService.getSSM(phone);
    }

    /**
     * 1.2.12.4.个人信息
     * @param phone
     * @return
     */
    @RequestMapping(value = "/findOne",method = RequestMethod.POST)
    public User findMessage(@RequestParam(required = true)String phone){
        return userService.findMessage(phone);
    }

    /**
     * 1.2.12.5.个人信息维护接口
     * @param user
     * @return
     */
    @RequestMapping(value ="/update",method = RequestMethod.POST)
    public Map<String, Object> update( User user){
        return userService.update(user);
    }

    /**
     * 1.2.12.6.首页显示登陆名接口
     * @param
     * @return
     */
    @RequestMapping(value ="/uname",method = RequestMethod.POST)
    public Map<String,Object> uname(@RequestParam(required = false)String phone){
        if(StringUtils.isEmpty(phone))return returnData("phone不能为空",1);
        return userService.uname(phone);
    }
}