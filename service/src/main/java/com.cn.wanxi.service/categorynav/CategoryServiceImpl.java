package com.cn.wanxi.service.categorynav;

import com.cn.wanxi.dao.categorynav.CategoryDao;
import com.cn.wanxi.model.categorynav.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @program: tenmallfront
 * @description: 分类业务
 * @author: niyao
 * @create: 2019-11-21 09:39
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryDao categoryDao;
    @Override
    public List<Category> getCategorys() {
        return categoryDao.getCategorys();
    }

    @Override
    public List<Category> getCateByPid(Integer pid) {
        return categoryDao.getCateByPid(pid);
    }

    /**
     * 查询所有分类及其子类
     * @return
     */
    @Override
    public List<Category> getCategoryBySub() {
        List<Category> categories=categoryDao.getCategorys();
        ListIterator<Category> iterator=categories.listIterator();
        while (iterator.hasNext()){
            Category category=iterator.next();
            System.out.println(category.getParentId());
            List<Category> sublist=categoryDao.getCateByPid(category.getId());
            category.setMenus(sublist);
            iterator.set(category);
        }
        return categories;
    }
/*    public void setSubList(List<Category> list){
        if (list==null) return;
        ListIterator<Category> iterator=list.listIterator();
        while (iterator.hasNext()){
            Category category=iterator.next();
            System.out.println(category.getParentId());
            List<Category> sublist=categoryDao.getCateByPid(category.getId());
            setSubList(sublist);
            category.setMenus(sublist);
            iterator.set(category);
        }
    }*/
}