package com.cn.wanxi.service.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cn.wanxi.model.user.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wyy
 * @date 2019/12/3 10:29
 */
public class TokenServiceImpl {
    public String getToken(User user){
        String token="";
        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        Date date = new Date(System.currentTimeMillis()+ 60*60*1000);
        token= JWT.create().withAudience(user.getPhone()).withHeader(header).withExpiresAt(date).sign(Algorithm.HMAC256(user.getPassword()));
        return  token;
    }
}
