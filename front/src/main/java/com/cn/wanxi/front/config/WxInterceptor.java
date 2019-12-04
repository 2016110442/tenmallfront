package com.cn.wanxi.front.config;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: tenmallfront
 * @description:
 * @author: niyao
 * @create: 2019-11-22 18:46
 */
public class WxInterceptor  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
  /*      Map<String,String> msg=new HashMap<>();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        if(request.getSession().getAttribute("username")!=null)
        {
            return true;
        }
        PrintWriter pw = response.getWriter();
        msg.put("code","1");
        msg.put("message","请登录");
        pw.write(JSON.toJSONString(msg));
        pw.flush();
        pw.close();
        return false;*/
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        Map<String,String> msg=new HashMap<>();
//        ServletOutputStream out = response.getOutputStream();
//        PrintWriter pw = response.getWriter();

        String token = request.getHeader("token");

        try {
            if(token==null){
                msg.put("code","1");
                msg.put("message","请登录");
//                pw.write(JSON.toJSONString(msg));
//                pw.flush();
                sendMsg(JSON.toJSONString(msg),response);
                return false;
            }
//            JWT.decode(token).getClaim("");
            JWT.decode(token).getAudience().get(0);
            if (JWT.decode(token).getExpiresAt().before(new Date())){
                msg.put("code","1");
                msg.put("message","token已过期");
//                pw.write(JSON.toJSONString(msg));
                sendMsg(JSON.toJSONString(msg),response);
                return false;
            }
        } catch (JWTVerificationException e) {
            msg.put("code","1");
            msg.put("message","401");
//            pw.write(JSON.toJSONString(msg));
            sendMsg(JSON.toJSONString(msg),response);
            return false;
        }
        return true;
    }

    private void sendMsg(String msg,HttpServletResponse response) {
        if (response != null) {
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = null;
            try {
                out = response.getWriter();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (out != null) {
                out.write(msg);
                out.flush();
                out.close();
            }
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}