package com.cn.wanxi.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: tenmallfront
 * @description: 工具类
 * @author: lixuqiang
 * @create: 2019-11-23 14:08:41
 */
public class WebTools {

    /**
     * 返回数据
     * @param message 消息
     * @param code code
     * @return map集合
     */
    public static Map<String,Object> returnData(String message,Integer code){
        Map<String,Object> map = new HashMap<>();
        map.put("code",code);
        map.put("message",message);
        return map;
    }

    /**
     * 对象转化为map
     * @param o 对象
     * @return 转化成功的map
     * @throws IllegalAccessException 非法访问异常
     */
    public static Map<String,Object> objectToMap(Object o) throws IllegalAccessException {
        if(null == o){
            return null;
        }
        Map<String,Object> map = new HashMap<>();
        Field[] declaredFields = o.getClass().getDeclaredFields();
        for (Field field :declaredFields) {
            // （此处如果不设置 无法获取对象的私有属性）
            field.setAccessible(true);
            map.put(field.getName(),field.get(o));
        }
        return map;
    }
}
