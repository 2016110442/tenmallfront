package com.cn.wanxi.service.cart;

import com.cn.wanxi.dao.cart.WxTabSpuDao;
import com.cn.wanxi.model.cart.WxTabSpu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: tenmallfront
 * @description:
 * @author: lixuqiang
 * @create: 2019-11-23 14:08:41
 */
@Service
public class WxTabSpuServiceImpl implements  WxTabSpuService {
    @Autowired
    private WxTabSpuDao wxTabSpuDao;

    @Override
    public List<WxTabSpu> findByIds(String[] ids) {
        return wxTabSpuDao.findByIds(ids);
    }
}
