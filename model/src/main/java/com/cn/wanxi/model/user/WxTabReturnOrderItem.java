package com.cn.wanxi.model.user;

import java.io.Serializable;

/**
 * @program: tenmallfront
 * @description: 退货退款申请明细表
 * @author: lixuqiang
 * @create: 2019-11-23 14:08:41
 */
public class WxTabReturnOrderItem implements Serializable {
    private static final long serialVersionUID = 4439990218263562892L;
    private String id;//分布式id
    private Integer categoryId;//分类ID
    private String spuId;//SPU_ID
    private String skuId;//SKU_ID
    private String orderId;//订单ID
    private String orderItemId;//订单明细ID
    private String returnOrderId;//退货订单ID
    private String title;//	标题
    private Integer price;//单价
    private Integer num;//数量
    private Integer money;//总金额
    private Integer payMoney;//支付金额
    private String image;//图片地址
    private Integer weight;//重量

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getSpuId() {
        return spuId;
    }

    public void setSpuId(String spuId) {
        this.spuId = spuId;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getReturnOrderId() {
        return returnOrderId;
    }

    public void setReturnOrderId(String returnOrderId) {
        this.returnOrderId = returnOrderId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Integer payMoney) {
        this.payMoney = payMoney;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
