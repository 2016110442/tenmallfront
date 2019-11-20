package com.cn.wanxi.service.user;

import com.cn.wanxi.model.user.WxTabEstimate;

import java.util.List;

/**
 * @author lxq
 * @date 2019/11/20 9:38
 */
public interface WxTabEstimateService {

    //查询多个
    List<WxTabEstimate> find(WxTabEstimate wxTabEstimate);

    //添加
    boolean add(WxTabEstimate wxTabEstimate);

    //修改
    boolean update(WxTabEstimate wxTabEstimate);
}
