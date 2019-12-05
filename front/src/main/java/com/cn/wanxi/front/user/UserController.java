package com.cn.wanxi.front.user;

import com.auth0.jwt.JWT;
import com.cn.wanxi.model.user.User;
import com.cn.wanxi.service.token.TokenServiceImpl;
import com.cn.wanxi.service.user.UserService;
import com.cn.wanxi.util.CacheFileUpload;
import com.cn.wanxi.util.WebTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.text.SimpleDateFormat;
import java.util.Date;
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
            User u = new User();
            u.setPhone(phone);
            u.setPassword(password);
            TokenServiceImpl tokenService = new TokenServiceImpl();
            String token = tokenService.getToken(u);
            map.put("token", token);

            response.setHeader("token",token);
            session.setAttribute("username",phone);
            Cookie cookie=new Cookie("username",phone);
            cookie.setMaxAge(1800);
            response.addCookie(cookie);
            return WebTools.returnData("登录成功",0);
        }

        return WebTools.returnData("登录失败",1);
    }
    /**
     *
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

        String phone=(String) param.get("phone");

        if(phone.matches("^\\d{11}$")==false||phone==null){
            return WebTools.returnData("手机号不对",1);
        }
        return userService.getSSM(phone);
    }

    /**
     * 1.2.12.4.个人信息
     * @param
     * @return
     */
    @PostMapping(value = "/findOne", produces = "application/json;charset=UTF-8")
    public Object findMessage(@RequestBody Map<String, String> param){
        if(StringUtils.isEmpty(param.get("phone")))return returnData("phone不能为空",1);
        return userService.findMessage(param.get("phone"));
    }

    /**
     * 1.2.12.5.个人信息维护接口
     * @param
     * @return
     */

    @Autowired
    private Environment environment;

    @PostMapping(value = "/imageUpload", produces = "application/json;charset=UTF-8")
    public Map<String,Object> imageUpload(@RequestBody MultipartFile filecontent) {
          Map<String,Object> returnInfo= CacheFileUpload.cacheFile(filecontent,environment.getProperty("configs.imageurl"));
       return returnInfo;
    }
    /**
     * 1.2.12.5.个人信息维护接口
     * @param
     * @return
     */
    @PostMapping(value = "/update", produces = "application/json;charset=UTF-8")
    public Map<String, Object> update(@RequestBody Map<String, String> param, HttpServletRequest request){
        if(StringUtils.isEmpty(param.get("username")))return returnData("username不能为空",1);
        if(StringUtils.isEmpty(param.get("nickName")))return returnData("nickName不能为空",1);
        if(StringUtils.isEmpty(param.get("name")))return returnData("name不能为空",1);
        if(StringUtils.isEmpty(param.get("headPic")))return returnData("headPic不能为空",1);
        if(StringUtils.isEmpty(param.get("sex")))return returnData("sex不能为空",1);
        String token=request.getHeader("token");
        User user =new User();
        user.setUsername(param.get("username"));
        user.setPhone(JWT.decode(token).getAudience().get(0));
        user.setEmail(param.get("email"));
        user.setNickName(param.get("nickName"));
        user.setName(param.get("name"));
        user.setHeadPic(param.get("headPic"));
        user.setQq(param.get("qq"));
        user.setSex(param.get("sex"));
        user.setBirthday(param.get("birthday"));

        return userService.update(user);
    }

    /**
     * 1.2.12.6.首页显示登陆名接口
     * @param
     * @return
     */
    @PostMapping(value = "/uname", produces = "application/json;charset=UTF-8")
    public Map<String,Object> uname(@RequestBody Map<String, String> param){
        if(StringUtils.isEmpty(param.get("phone")))return returnData("phone不能为空",1);
        return userService.uname(param.get("phone"));
    }

    /**
     * 退出登陸
     * @param
     * @return
     */
    @PostMapping(value = "/outLogin", produces = "application/json;charset=UTF-8")
    public Map<String,Object> outLogin(HttpServletResponse response){
        response.setHeader("token","");
        return returnData("退出成功",0);
    }
    /**
     * 修改密码
     * @param
     * @return
     */
    @PostMapping(value = "/updatePassword", produces = "application/json;charset=UTF-8")
    public Object updatePassword(@RequestBody Map<String, String> param){
        String regular="^[1](([3][0-9])|([4][5,7,9])|([5][0-9])|([6][6])|([7][3,5,6,7,8])|([8][0-9])|([9][8,9]))[0-9]{8}$";
        if(StringUtils.isEmpty(param.get("phone"))&& !param.get("phone").matches("^\\d{11}$")){
            return returnData("手机号格式不对",1);
        }
        if(StringUtils.isEmpty(param.get("password"))&&param.get("password").length()<5){
            return returnData("密码有误",1);
        }
        if(StringUtils.isEmpty(param.get("newPassword"))&& StringUtils.isEmpty(param.get("confirmNewPassword"))&&param.get("newPassword").equals(param.get("confirmNewPassword"))){
            return returnData("新密码有误",1);
        }
        return userService.updatePw(param.get("phone"),param.get("password"),param.get("newPassword"));
    }
}