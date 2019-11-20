package com.cn.wanxi.model.order;

import java.util.Date;

public class WxTabOrder {

    private String id;

    private Integer totalNum;

    private Integer totalMoney;

    private Integer preMoney;

    private Integer postFee;

    private Integer payMoney;

    private String payType;

    private Date createTime;

    private Date updateTime;

    private Date payTime;

    private Date consignTime;

    private Date endTime;

    private Date closeTime;

    private String shippingName;

    private String shippingCode;

    private String username;

    private String buyerMessage;

    private String buyerRate;

    private String receiverContact;

    private String receiverMobile;

    private String receiverAddress;

    private String sourceType;

    private String transactionId;

    private String orderStatus;

    private String payStatus;

    private String consignStatus;

    private String isDelete;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_tab_order.id
     *
     * @return the value of wx_tab_order.id
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_tab_order.id
     *
     * @param id the value for wx_tab_order.id
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_tab_order.total_num
     *
     * @return the value of wx_tab_order.total_num
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public Integer getTotalNum() {
        return totalNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_tab_order.total_num
     *
     * @param totalNum the value for wx_tab_order.total_num
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_tab_order.total_money
     *
     * @return the value of wx_tab_order.total_money
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public Integer getTotalMoney() {
        return totalMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_tab_order.total_money
     *
     * @param totalMoney the value for wx_tab_order.total_money
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_tab_order.pre_money
     *
     * @return the value of wx_tab_order.pre_money
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public Integer getPreMoney() {
        return preMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_tab_order.pre_money
     *
     * @param preMoney the value for wx_tab_order.pre_money
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public void setPreMoney(Integer preMoney) {
        this.preMoney = preMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_tab_order.post_fee
     *
     * @return the value of wx_tab_order.post_fee
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public Integer getPostFee() {
        return postFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_tab_order.post_fee
     *
     * @param postFee the value for wx_tab_order.post_fee
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public void setPostFee(Integer postFee) {
        this.postFee = postFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_tab_order.pay_money
     *
     * @return the value of wx_tab_order.pay_money
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public Integer getPayMoney() {
        return payMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_tab_order.pay_money
     *
     * @param payMoney the value for wx_tab_order.pay_money
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public void setPayMoney(Integer payMoney) {
        this.payMoney = payMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_tab_order.pay_type
     *
     * @return the value of wx_tab_order.pay_type
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public String getPayType() {
        return payType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_tab_order.pay_type
     *
     * @param payType the value for wx_tab_order.pay_type
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_tab_order.create_time
     *
     * @return the value of wx_tab_order.create_time
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_tab_order.create_time
     *
     * @param createTime the value for wx_tab_order.create_time
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_tab_order.update_time
     *
     * @return the value of wx_tab_order.update_time
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_tab_order.update_time
     *
     * @param updateTime the value for wx_tab_order.update_time
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_tab_order.pay_time
     *
     * @return the value of wx_tab_order.pay_time
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_tab_order.pay_time
     *
     * @param payTime the value for wx_tab_order.pay_time
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_tab_order.consign_time
     *
     * @return the value of wx_tab_order.consign_time
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public Date getConsignTime() {
        return consignTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_tab_order.consign_time
     *
     * @param consignTime the value for wx_tab_order.consign_time
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public void setConsignTime(Date consignTime) {
        this.consignTime = consignTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_tab_order.end_time
     *
     * @return the value of wx_tab_order.end_time
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_tab_order.end_time
     *
     * @param endTime the value for wx_tab_order.end_time
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_tab_order.close_time
     *
     * @return the value of wx_tab_order.close_time
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public Date getCloseTime() {
        return closeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_tab_order.close_time
     *
     * @param closeTime the value for wx_tab_order.close_time
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_tab_order.shipping_name
     *
     * @return the value of wx_tab_order.shipping_name
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public String getShippingName() {
        return shippingName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_tab_order.shipping_name
     *
     * @param shippingName the value for wx_tab_order.shipping_name
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public void setShippingName(String shippingName) {
        this.shippingName = shippingName == null ? null : shippingName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_tab_order.shipping_code
     *
     * @return the value of wx_tab_order.shipping_code
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public String getShippingCode() {
        return shippingCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_tab_order.shipping_code
     *
     * @param shippingCode the value for wx_tab_order.shipping_code
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public void setShippingCode(String shippingCode) {
        this.shippingCode = shippingCode == null ? null : shippingCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_tab_order.username
     *
     * @return the value of wx_tab_order.username
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_tab_order.username
     *
     * @param username the value for wx_tab_order.username
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_tab_order.buyer_message
     *
     * @return the value of wx_tab_order.buyer_message
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public String getBuyerMessage() {
        return buyerMessage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_tab_order.buyer_message
     *
     * @param buyerMessage the value for wx_tab_order.buyer_message
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage == null ? null : buyerMessage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_tab_order.buyer_rate
     *
     * @return the value of wx_tab_order.buyer_rate
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public String getBuyerRate() {
        return buyerRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_tab_order.buyer_rate
     *
     * @param buyerRate the value for wx_tab_order.buyer_rate
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public void setBuyerRate(String buyerRate) {
        this.buyerRate = buyerRate == null ? null : buyerRate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_tab_order.receiver_contact
     *
     * @return the value of wx_tab_order.receiver_contact
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public String getReceiverContact() {
        return receiverContact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_tab_order.receiver_contact
     *
     * @param receiverContact the value for wx_tab_order.receiver_contact
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public void setReceiverContact(String receiverContact) {
        this.receiverContact = receiverContact == null ? null : receiverContact.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_tab_order.receiver_mobile
     *
     * @return the value of wx_tab_order.receiver_mobile
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public String getReceiverMobile() {
        return receiverMobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_tab_order.receiver_mobile
     *
     * @param receiverMobile the value for wx_tab_order.receiver_mobile
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile == null ? null : receiverMobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_tab_order.receiver_address
     *
     * @return the value of wx_tab_order.receiver_address
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public String getReceiverAddress() {
        return receiverAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_tab_order.receiver_address
     *
     * @param receiverAddress the value for wx_tab_order.receiver_address
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress == null ? null : receiverAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_tab_order.source_type
     *
     * @return the value of wx_tab_order.source_type
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public String getSourceType() {
        return sourceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_tab_order.source_type
     *
     * @param sourceType the value for wx_tab_order.source_type
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_tab_order.transaction_id
     *
     * @return the value of wx_tab_order.transaction_id
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_tab_order.transaction_id
     *
     * @param transactionId the value for wx_tab_order.transaction_id
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId == null ? null : transactionId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_tab_order.order_status
     *
     * @return the value of wx_tab_order.order_status
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_tab_order.order_status
     *
     * @param orderStatus the value for wx_tab_order.order_status
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_tab_order.pay_status
     *
     * @return the value of wx_tab_order.pay_status
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public String getPayStatus() {
        return payStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_tab_order.pay_status
     *
     * @param payStatus the value for wx_tab_order.pay_status
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_tab_order.consign_status
     *
     * @return the value of wx_tab_order.consign_status
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public String getConsignStatus() {
        return consignStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_tab_order.consign_status
     *
     * @param consignStatus the value for wx_tab_order.consign_status
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public void setConsignStatus(String consignStatus) {
        this.consignStatus = consignStatus == null ? null : consignStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_tab_order.is_delete
     *
     * @return the value of wx_tab_order.is_delete
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_tab_order.is_delete
     *
     * @param isDelete the value for wx_tab_order.is_delete
     *
     * @mbggenerated Wed Nov 20 15:26:33 CST 2019
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }
}