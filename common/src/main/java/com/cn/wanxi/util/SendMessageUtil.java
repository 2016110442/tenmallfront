package com.cn.wanxi.util;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * http://sms.webchinese.cn/ 在这网站注册，把UID和KEY换成自己的
 * @program: tenmallfront
 * @description: 发送短信
 * @author: niyao
 * @create: 2019-11-20 17:54
 */
@Component
public class SendMessageUtil {
    //api url
    private static final String SMS_Url = "http://gbk.api.smschinese.cn/";
    //SMS用户名
    private static final String UID = "neolyao";
    //SMS 短信秘钥
    private static final String KEY = "d41d8cd98f00b204e980";

    /**
     * @return Integer(1：成功码，其他失败，具体参见注释)
     */
    public static Integer send(String phone,String code){

        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod(SMS_Url);
        // 在头文件中设置转码
        post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");
        //设置参数
        NameValuePair[] data = {
                new NameValuePair("Uid", UID),
                new NameValuePair("Key", KEY),//秘钥
                new NameValuePair("smsMob", phone),
                new NameValuePair("smsText", code)
        };

        post.setRequestBody(data);

        try {
            client.executeMethod(post);
        } catch (Exception e) {  e.printStackTrace();  }


        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
        System.out.println("statusCode:" + statusCode);
        for (Header h : headers) {
            System.out.println(h.toString());
        }

        String result ="";
        try {
            result = new String(post.getResponseBodyAsString().getBytes("gbk"));
        } catch (Exception e) {  e.printStackTrace();  }

        post.releaseConnection();

        return Integer.parseInt(result);
    }

    /**
     * 根据返回码,获得相应信息
     * @param code
     * @return
     */
    public static String getMessage(Integer code){
        String message;
        if(code > 0 ) {
            message = "SMS-f发送成功！";
        }else if(code == -1){
            message = "SMS-没有该用户账户";
        }else if(code == -2){
            message = "SMS-接口密钥不正确";
        }else if(code == -21){
            message = "SMS-MD5接口密钥加密不正确";
        }else if(code == -3){
            message = "SMS-短信数量不足";
        }else if(code == -11){
            message = "SMS-该用户被禁用";
        }else if(code == -14){
            message = "SMS-短信内容出现非法字符";
        }else if(code == -4){
            message = "SMS-手机号格式不正确";
        }else if(code == -41){
            message = "SMS-手机号码为空";
        }else if(code == -42){
            message = "SMS-短信内容为空";
        }else if(code == -51){
            message = "SMS-短信签名格式不正确接口签名格式为：【签名内容】";
        }else if(code == -6){
            message = "SMS-IP限制";
        }else{
            message = "其他错误";
        }
        return message;
    }

    /**
     * 随机生成验证码
     * @param code 验证码的位数
     * @return
     */
    public static String getRandomCode(Integer code){
        Random random = new Random();
        StringBuffer result= new StringBuffer();
        for (int i=0;i<code;i++){
            result.append(random.nextInt(10));
        }
        return result.toString();
    }

}