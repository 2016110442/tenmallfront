package com.cn.wanxi.service.advertisin;

import com.cn.wanxi.model.advertisin.WxTabAdvertisin;

import java.util.List;

/**
 * @author
 * @date 2019/11/20 14:29
 */
public interface WxTabAdvertisinService {

    int deleteByPrimaryKey(Integer id);

    int insert(WxTabAdvertisin record);

    int insertSelective(WxTabAdvertisin record);

    WxTabAdvertisin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WxTabAdvertisin record);

    int updateByPrimaryKey(WxTabAdvertisin record);

    List<WxTabAdvertisin> selectByPosition(String position);
}
