package com.cn.wanxi.service.alipay;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface AlipayService {
    /**
     * 支付宝支付调用接口
     * @param response
     * @param request
     * @throws IOException
     */
    Object  aliPay(Integer id,HttpServletResponse response, HttpServletRequest request);
    void aliPayReturn(HttpServletRequest request);
    String aliPayNotify(HttpServletRequest request) throws IOException;
}
