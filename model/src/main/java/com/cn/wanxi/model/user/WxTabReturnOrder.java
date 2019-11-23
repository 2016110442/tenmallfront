package com.cn.wanxi.model.user;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: tenmallfront
 * @description: 退货退款申请表
 * @author: lixuqiang
 * @create: 2019-11-23 14:08:41
 */
public class WxTabReturnOrder implements Serializable {
    private static final long serialVersionUID = 1232622307225483072L;

    private String id;//	服务单号
    private String orderId;//	订单号
    private Date applyTime;//	申请时间
    private Integer userId;//	用户ID
    private String userAccount;//	用户账号
    private String linkman;//	联系人
    private String linkmanMobile;//	联系人手机
    private char type;//类型 1.退货 2.退款
    private Integer returnMoney;//	退款金额
    private char isReturnFreight;//是否退运费
    private char status;//申请状态 0：申请 1同意 2驳回
    private Date disposeTime;//处理时间
    private Integer returnCause;//	退货退款原因
    private String evidence;//凭证图片 逗号分割
    private String description;//问题描述
    private String remark;//处理备注
    private Integer adminId;//	管理员id

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getReturnCause() {
        return returnCause;
    }

    public void setReturnCause(Integer returnCause) {
        this.returnCause = returnCause;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getLinkmanMobile() {
        return linkmanMobile;
    }

    public void setLinkmanMobile(String linkmanMobile) {
        this.linkmanMobile = linkmanMobile;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public Integer getReturnMoney() {
        return returnMoney;
    }

    public void setReturnMoney(Integer returnMoney) {
        this.returnMoney = returnMoney;
    }

    public char getIsReturnFreight() {
        return isReturnFreight;
    }

    public void setIsReturnFreight(char isReturnFreight) {
        this.isReturnFreight = isReturnFreight;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Date getDisposeTime() {
        return disposeTime;
    }

    public void setDisposeTime(Date disposeTime) {
        this.disposeTime = disposeTime;
    }


    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }
}
