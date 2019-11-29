package com.cn.wanxi.dao.cart;

import com.cn.wanxi.model.cart.WxTabSpu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: tenmallfront
 * @description:
 * @author: lixuqiang
 * @create: 2019-11-23 14:08:41
 */
public interface WxTabSpuDao {

//    @Select({
//            "<script>",
//                "select * from wx_tab_spu where id in ",
//                "<foreach collection='ids' item='item' open='(' separator=',' close=')'>",
//                    "#{item}",
//                "</foreach>",
//            "</script>"
//    })
    List<WxTabSpu> findByIds(@Param("ids") String[] ids);
}
