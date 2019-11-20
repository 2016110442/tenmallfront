package com.cn.wanxi.model.user;

import java.io.Serializable;

/**
 * 商品评价
 * @author lxq
 * @date 2019/11/20 16:13:38
 */
public class WxTabEstimate implements Serializable {

    private static final long serialVersionUID = -4724426637782784385L;

    private Integer id;
    private String username; //用户名
    private String spuid; //商品id
    private Integer orderItemid; //订单id
    private String images; //图片
    private Integer star; //星级
    private String content; //评价内容

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSpuid() {
        return spuid;
    }

    public void setSpuid(String spuid) {
        this.spuid = spuid;
    }

    public Integer getOrderItemid() {
        return orderItemid;
    }

    public void setOrderItemid(Integer orderItemid) {
        this.orderItemid = orderItemid;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
