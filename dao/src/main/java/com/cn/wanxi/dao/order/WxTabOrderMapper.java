package com.cn.wanxi.dao.order;

import com.cn.wanxi.model.order.WxTabOrder;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WxTabOrderMapper {

    int deleteByPrimaryKey(String id);

    int insert(WxTabOrder record);

    int insertSelective(WxTabOrder record);

    WxTabOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WxTabOrder record);

    int updateByPrimaryKey(WxTabOrder record);

    @Select({
            "<script>",
            "select * from wx_tab_order where id in ",
            "<foreach collection='ids' item='item' open='(' separator=',' close=')'>",
            "#{item}",
            "</foreach>",
            "</script>"
    })
    List<WxTabOrder> selectByIds(@Param("ids") String[] ids);
}