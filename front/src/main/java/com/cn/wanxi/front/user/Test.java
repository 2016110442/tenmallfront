package com.cn.wanxi.front.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @date 2019/11/20 9:38
 */
@RestController
public class Test {

    @Autowired
    private UserVOpository userVOpository;

    @RequestMapping("/get")
    public String get(){
        System.out.println(userVOpository.findAllById(1));
        return "wyy";
    }

}
