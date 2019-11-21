package com.cn.wanxi.dao.categorynav;

import com.cn.wanxi.model.categorynav.Category;

import java.util.List;

public interface CategoryDao {
    public List<Category> getCategorys();
    public List<Category> getCateByPid();
    public List<Category> getCategoryBySub();
}
