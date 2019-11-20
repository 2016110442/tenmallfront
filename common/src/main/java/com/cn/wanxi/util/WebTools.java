package com.cn.wanxi.util;

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
}
