package com.cn.wanxi.model.address;


import java.io.Serializable;

/**
 * 地址信息表
 * @author lxq
 * @date 2019/11/20 9:38
 */
public class WxTabAddress implements Serializable {
    private static final long serialVersionUID = -7119625474056842840L;

    private Integer id;
    private String receiverAddress; //收件人地址
    private String receiverName;//收件人姓名
    private String receiverPhone;//收件人电话
    private String username;//添加人账号
    private String isDefault;//是否默认(0是，1否)

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }
}
