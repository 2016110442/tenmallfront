package com.cn.wanxi.dao.advertisin;

import com.cn.wanxi.model.advertisin.WxTabAdvertisin;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface WxTabAdvertisinMapper {

    @Delete("delete * from wx_tab_advertisin where id=#{id}")
    int deleteByPrimaryKey(Integer id);

    @Insert("insert into wx_tab_advertisin(name,position,start_time,end_time,status,image,url,remarks) value(#{name},#{position},#{startTime},#{endTime},'0',#{image},#{url},#{remarks})")
    int insert(WxTabAdvertisin record);

    int insertSelective(WxTabAdvertisin record);

    @Select("select * from wx_tab_advertisin where id=#{id}")
    WxTabAdvertisin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WxTabAdvertisin record);

    @Update("update wx_tab_advertisin set name=#{name},position=#{position},start_time=#{startTime},end_time=#{endTime},image=#{image},url=#{url},remarks=#{remarks} where id=#{id}")
    int updateByPrimaryKey(WxTabAdvertisin record);

    @Select("select * from wx_tab_advertisin where position=#{position}")
    List<WxTabAdvertisin> selectByPosition(@Param("position") String position);
}