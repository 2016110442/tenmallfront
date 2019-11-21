package com.cn.wanxi.front.categorynav;

import com.cn.wanxi.model.categorynav.Category;
import com.cn.wanxi.service.categorynav.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: tenmallfront
 * @description:
 * @author: niyao
 * @create: 2019-11-21 09:41
 */
@RestController
@RequestMapping("/index")
public class CategoryController {

    @Autowired(required = false)
    private CategoryService categoryService;
    @GetMapping("/categoryNav")
    public List<Category> getCategorys(){
       return categoryService.getCategorys();
    }
    @PostMapping("/categoryByParent")
    public List<Category> getCateByPid(Integer pid){
        return null;
    }
    @PostMapping("/categoryBySub")
    public List<Category> getCategoryBySub(){
        return null;
    }
}