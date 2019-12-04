package com.cn.wanxi.service.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101100662637";
    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCjZjdBPIRnly1sjemz01jNMJvpWkDtIXjlnYClLA4XB4idI79C/Ke9hV6fmyH3js+5soTdZGvqb0qiwQKY1mh0E/woiL9r4Gyl3WMm837H5IzReLQPnLoCbczJu8HJdRiupE6GQuzRjHTfB5xeWVazIZ3lRfq6H0AhSI6G3JOEYMIGX7OBxbfQGJTT2kRK7soCB/Hm7SdCMZgZtSyND2CnOEepwoQprySA8wnmrF4DpkCvfU7a6LIFi8X0nuT72M8s168mEfykJ6yJx5Tlq12m4aaUSpc6/qbyqXaNj6IwdDKauEsjjV3h/SaNYmw6w3GNPQLHfiYjxOuNF7kAlmslAgMBAAECggEBAIUi6QyvmZaqWGml6/EI2Mc/vxnQ3ywX5OD6h3KNxeE/0zFuig2zvZ0viVz00yVZ6Kl+6sFVbJS1H5QjPdF4id1i10fTvFzSnNQ84eg/6GJJN/AJsHU0F1+ZRY5t/MUAMx9BY3YEG9/V2PhMxD0gAAOu9W91qIh0pBU6gF8kZNIrkCk4XHCI3hDw22wjLMpRyvzDlrl6ikVOXNDLkuNuS++gO+SgcE45fafRKzlAAZIHsAmh1JeWQOnqm6LuMFlwfleFEpzuwNiQtCLkoYEywwkJJxYxFCfrDzSAyW1zppmsM2NczKGSuC0ZbJdLMTdijFfPUsxYedXoi5P5BxiugrUCgYEA6lfDt/QJ4Vn2vQTqrmno3BFjEJPGzkRUnlllNPSMDjAcTd5ZRteroVWzfPNaPih6LjpMkx+SMZhmU1xMLEHUYIEvRwsImy4bhZuLlm44EYjrqsM/NVsTDKmGxA2T327WOrE963MKGQGHK6Dr+77/AU0DNLeBCoWohC0eRzB36TcCgYEAsoAFxo4u03nEON1oCZnxba0Sw2oC9q4J1pJF1X7NJQlqK3eFuy5xR1KffWfvpRufbWZ35BsNg5DP1jfz+XkClm7GjlzLpyk1t+RDhNJudX7wlIMAJK7O/ayZRR8YJ+yyoXPb1nsMHOs69iZt2wKlRfrHtRFPgM9A3/3tanXQjIMCgYEApWjrkkWkT7eDrOnyiMfjAKsZJNNaSa/7loX9JQLUdRNKd0BR/eovkEKA3dqbwTIrA8RM1rA7LdynpYGJltekg7XL3DaSjY5fCNDBF56W3vGpfzAvxoaRjKeAo5P944FFn8oJrc7Wus3UTlxZFao8LvvgHm7Em9u6FgoOzCsPCMMCgYB9nAV0cf2Vp2xjr7pUd1YjndVEWkd3m4Ukz44A7NgjpfpmWBdtXwMr84J0Vz2WbFfGPoNDq53Y5YC7+GfhODyP66gh6j8NhLxeiWzR/NrqJ8fYWk8xgSn77Qd2UqlG/xO89bDPv4sIlqfJK8XGhpgTJKSAUIwn0rCObzww3HNDTQKBgQCeVs4dYo1NaFdLSsux7KE45+5Vbm4XHqchfwhJLKReNP1PCiKe7gh8o+Qwsh+XV9ItnfmsJoz9IE+5eKmd4b7ildpuxsQLOIe9wEB1dOFmanoijYNlGPYLEs9dRjFGUnvuXKwor2IQ9yRRfpNBbNXwWyU3lQuUFdpzjALV6sTSCg==";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAk/57diDaAJXobcflvBP4SVsg89fG4+FVm6sELt866hQXlMoG8KAeyIgr06A1mIOVVw2Cg7Q6kCZJD0CZh3uRVPKZQlw98eaSE2rG7V4qqVbh9oxSKlgv/53+BirHEbVZ+GLnSDYsRxmQ376fuUyQ1GU7AfMvWgtBWjCklUqgDK3ypMMBEJC238/2AMjnTgwXCK3uIll9ZZfkF3gDA0I9GR3mHxmfQRme/vRKrvxwnxR8ST6uukcw8DNJNhQlRlUM8qxGV0X8XrBIvCvsCz0Um5p6C4MaV2aTnxU4n0RbeXsxfhmbsxC/tukpL460zqgaBnBMuhtTZN0qA5XFJKkEkQIDAQAB";
    // 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://18385295580.wicp.vip/alipay/notify";
    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://18385295580.wicp.vip/alipay/return";
    // 签名方式
    public static String sign_type = "RSA2";
    // 字符编码格式
    public static String charset = "utf-8";
    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
    // 支付宝网关
    public static String log_path = "C:\\";
}
