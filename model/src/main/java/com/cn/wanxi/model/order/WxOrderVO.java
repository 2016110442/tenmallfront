package com.cn.wanxi.model.order;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author
 * @date 2019/11/21 10:02
 */
public class WxOrderVO {

    private String id;

    private Integer totalNum;

    private Integer totalMoney;

    private Integer preMoney;

    private Integer postFee;

    private Integer payMoney;

    private String payType;

    private String username;

    private String receiverContact;

    private String receiverMobile;

    private String receiverAddress;

    private String sourceType;

    private List<WxTabOrderItem> orderItem;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getPreMoney() {
        return preMoney;
    }

    public void setPreMoney(Integer preMoney) {
        this.preMoney = preMoney;
    }

    public Integer getPostFee() {
        return postFee;
    }

    public void setPostFee(Integer postFee) {
        this.postFee = postFee;
    }

    public Integer getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Integer payMoney) {
        this.payMoney = payMoney;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReceiverContact() {
        return receiverContact;
    }

    public void setReceiverContact(String receiverContact) {
        this.receiverContact = receiverContact;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public List<WxTabOrderItem> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(List<WxTabOrderItem> orderItem) {
        this.orderItem = orderItem;
    }
}
