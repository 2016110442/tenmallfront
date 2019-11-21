package com.cn.wanxi.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 工具类
 * @author lxq
 * @date 2019/11/20 15:51:05
 */
public class WebTools {

    //返回数据
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
    private static Map<String,Object> objectToMap(Object o) throws IllegalAccessException {
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
