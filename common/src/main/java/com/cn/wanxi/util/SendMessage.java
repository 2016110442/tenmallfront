package com.cn.wanxi.util;

import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: tenmallfront
 * @description:
 * @author: niyao
 * @create: 2019-12-03 17:43
 */
public class SendMessage {
    //发送短信
    public static boolean sendSMS(String phone,String code){
        String smsUrl="https://api.submail.cn/message/send.json";//【主】发送短信地址
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("appid","43996");  //appid
        param.put("to",phone); //发送的短信手机号
        param.put("content","【万息商城】您的短信验证码："+code);//发送的短信内容
        param.put("signature","d021be186ff1ef1c88178d6dace1760a"); //应用密匙 或 数字签名
        JSONObject jsonParam = JSONObject.fromObject(param);
        String message = HttpClient.sendPost(smsUrl,jsonParam.toString());
        JSONObject jsonMessage = JSONObject.fromObject(message);
        System.out.println(jsonMessage.toString());
        if(jsonMessage.get("status").equals("success")){
            return true;
        }else{
            smsUrl="https://api.submail.cn/message/send.json";//【备】发送短信地址
            message = HttpClient.sendPost(smsUrl,jsonParam.toString());
            jsonMessage = JSONObject.fromObject(message);
            System.out.println(jsonMessage.toString());
            if(jsonMessage.get("status").equals("success")){
                return true;
            }else{
                return false;
            }
        }
    }
}