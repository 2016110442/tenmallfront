package com.cn.wanxi.service.onsale;

import com.cn.wanxi.model.cart.WxTabSpu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductOnsaleService {
    public List<WxTabSpu> getOnsaleProducts();
}
