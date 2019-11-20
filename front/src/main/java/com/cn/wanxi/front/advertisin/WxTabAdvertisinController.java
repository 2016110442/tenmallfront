package com.cn.wanxi.front.advertisin;

import com.cn.wanxi.dao.advertisin.WxTabAdvertisinDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author
 * @date 2019/11/20 12:13
 */
@RestController
public class WxTabAdvertisinController {

    @Autowired
    private WxTabAdvertisinDao wxTabAdvertisinDao;

    @RequestMapping("/get")
    public String get(){
        System.out.println(wxTabAdvertisinDao.getAll());
        return "wyy";
    }
}
