package com.cn.wanxi.front.alipay;


import com.cn.wanxi.service.alipay.AlipayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/alipay")
public class AliPayController {
    @Autowired(required = false)
   private AlipayServiceImpl alipayService;

    @RequestMapping("/pay/{id}")
    public Object payMent(@PathVariable("id") Integer id, HttpServletResponse response, HttpServletRequest request) {
            return alipayService.aliPay(id,response,request);
    }
    @RequestMapping("/notify")
    public String payNotify(HttpServletRequest request) throws IOException {
        return alipayService.aliPayNotify(request);
    }
    @RequestMapping("/return")
    public void payReturn(HttpServletRequest request){
         alipayService.aliPayReturn(request);
    }
}
