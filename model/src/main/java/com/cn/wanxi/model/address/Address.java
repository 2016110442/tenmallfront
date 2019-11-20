package com.cn.wanxi.model.address;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 地址信息表
 * @author lxq
 * @date 2019/11/20 9:38
 */
@Data
@Entity
@Table(name = "wx_tab_address")
public class Address implements Serializable {
    private static final long serialVersionUID = 2661199599636376008L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "receiver_address",length = 255,nullable = true)
    private String receiverAddress; //收件人地址

    @Column(name = "receiver_name",length = 255,nullable = true)
    private String receiverName;//收件人姓名

    @Column(name = "receiver_phone",length = 255,nullable = true)
    private String receiverPhone;//收件人电话

    @Column(name = "username",length = 255,nullable = true)
    private String username;//添加人账号

    @Column(name = "is_default",length = 255,nullable = true)
    private String isDefault;//是否默认(0是，1否)
}
