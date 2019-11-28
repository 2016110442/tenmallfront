package com.cn.wanxi.front.user;

import com.cn.wanxi.model.user.User;
import com.cn.wanxi.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;

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
    public Map<String ,String> userLogin(@RequestParam(required = false)
                                         @Pattern(regexp= "^\\d{11}$",message = "请输入正确手机号")
                                         @NotNull(message = "手机号不能为空") String phone,
                                         @RequestParam(required = false)
                                         @NotNull(message = "密码不能为空") String password,
                                         HttpSession session,
                                         HttpServletResponse response){
        System.out.println(phone+"-"+password);
        Map<String,String> map=new HashMap<>();
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
    public Map<String ,String> register(@RequestParam(required = false)
                                        @NotNull(message = "手机号不能为空")
                                        @Pattern(regexp= "^\\d{11}$",message = "请输入正确手机号")
                                                    String phone,     /*手机号*/
                                        @RequestParam(required = false)
                                        @NotNull(message = "验证码不能为空")
                                                String code,      /*验证码*/
                                        @RequestParam(required = false)
                                        @NotNull(message = "密码不能为空")
                                                    String password){ /*密码*/
        return userService.register(phone,code,password);
    }

    /**
     * 手机获取验证码
     * @param phone
     * @return
     */
    @RequestMapping(value = "/ssm",method = RequestMethod.POST)
    public Map<String,String>  getSSM(@RequestParam(required = false)
                                      @Pattern(regexp= "^\\d{11}$",message = "请输入正确手机号")
                                      @NotNull(message = "手机号不能为空")
                                                  String phone){
        return userService.getSSM(phone);
    }

    /**
     * 根据手机号查询用户
     * @param phone
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String findByPhone(@RequestParam(required = true)String phone){
        return userService.findPassByPhone(phone);
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
    public Map<String, Object> update(User user){
        return userService.update(user);
    }

    /**
     * 1.2.12.6.首页显示登陆名接口
     * @param
     * @return
     */
    @RequestMapping(value ="/uname",method = RequestMethod.POST)
    public Map<String,Object> uname(@RequestParam(required = true)String phone){
        return userService.uname(phone);
    }
}