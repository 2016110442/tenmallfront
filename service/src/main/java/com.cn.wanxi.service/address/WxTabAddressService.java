package com.cn.wanxi.service.address;

import java.util.List;
import com.cn.wanxi.model.address.WxTabAddress;

/**
 * @program: tenmallfront
 * @description:
 * @author: lixuqiang
 * @create: 2019-11-23 14:08:41
 */
public interface WxTabAddressService {

    //查询多个
    List<WxTabAddress> find(WxTabAddress address);

    //添加
    boolean add(WxTabAddress address);

    //修改
    boolean update(WxTabAddress address);

    //删除
    boolean delete(Integer id);
}
