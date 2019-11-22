package com.cn.wanxi.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @program: tenmallfront
 * @description: redis 缓存工具类
 * @author: niyao
 * @create: 2019-11-20 19:25
 */
@Component
public class RedisUtil {
    /**
     * 检查验证码是否存在
     */
    @Autowired
    public   RedisTemplate redisTemplate;

    public    boolean isCodeExist(String phone,String code){
        ValueOperations<String,String> ops=redisTemplate.opsForValue();
        return  ops.get(phone)!=null&&ops.get(phone).equals(code);
    }

    /**
     * 设置验证码
     * @param phone
     * @param code
     */
    public  void setCode(String phone,String code){
        ValueOperations<String,String> ops=redisTemplate.opsForValue();
        ops.set(phone,code);
        redisTemplate.expire(phone,1, TimeUnit.MINUTES);//过期时间1分钟
    }
}