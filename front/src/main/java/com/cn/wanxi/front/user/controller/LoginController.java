package com.cn.wanxi.front.user.controller;

import com.cn.wanxi.model.user.User;
import com.cn.wanxi.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: tenmallfront
 * @description:
 * @author: niyao
 * @create: 2019-11-20 11:33
 */
@RestController
public class LoginController {
    @Autowired(required = false)
    private UserService userService;
    @RequestMapping("/hello/{id}")
    public User hello(@PathVariable("id") Integer id){
        return userService.getUserByID(id);
    }
}