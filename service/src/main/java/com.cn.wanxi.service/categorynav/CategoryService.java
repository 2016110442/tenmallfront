package com.cn.wanxi.service.categorynav;

import com.cn.wanxi.model.categorynav.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> getCategorys();
    public List<Category> getCateByPid(Integer pid);
    public List<Category> getCategoryBySub();
}
