package com.cn.wanxi.model.user;

import java.io.Serializable;

/**
 * 退货退款原因表
 * @author lxq
 * @date 2019年11月21日15:31:48
 */
public class WxTabReturnCause implements Serializable {

    private static final long serialVersionUID = 6429781488985374512L;

    private Integer id;
    private String cause;//原因
    private Integer seq;//排序
    private char status;//是否启用

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
}
