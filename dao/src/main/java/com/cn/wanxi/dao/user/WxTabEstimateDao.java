package com.cn.wanxi.dao.user;

import com.cn.wanxi.model.user.WxTabEstimate;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @program: tenmallfront
 * @description: 商品评价dao层
 * @author: lixuqiang
 * @create: 2019-11-23 14:08:41
 */
public interface WxTabEstimateDao {

//    @Select("select * from wx_tab_estimate")
    List<WxTabEstimate> find(@Param("wxTabEstimate") WxTabEstimate wxTabEstimate);

//    @Insert("insert into wx_tab_estimate(username,spuid,order_itemid,images,star,content) value(#{wxTabEstimate.username},#{wxTabEstimate.spuid},#{wxTabEstimate.orderItemid},#{wxTabEstimate.images},#{wxTabEstimate.star},#{wxTabEstimate.content})")
    Integer insert(@Param("wxTabEstimate") WxTabEstimate wxTabEstimate);

//    @Update("update wx_tab_estimate set username=#{wxTabEstimate.username},spuid=#{wxTabEstimate.spuid},order_itemid=#{wxTabEstimate.orderItemid},images=#{wxTabEstimate.images},star=#{wxTabEstimate.star},content=#{wxTabEstimate.content} where id=#{wxTabEstimate.id}")
    Integer update(@Param("wxTabEstimate") WxTabEstimate wxTabEstimate);
}
