package com.cn.wanxi.front.categorynav;

import com.cn.wanxi.model.categorynav.Category;
import com.cn.wanxi.service.categorynav.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * @program: tenmallfront
 * @description:
 * @author: niyao
 * @create: 2019-11-21 09:41
 */
@RestController
@RequestMapping("/index")
@Validated
public class CategoryController {

    @Autowired(required = false)
    private CategoryService categoryService;
    /**
     * 获取所有分类
     * @return
     */
    @PostMapping("/categoryNav")
    public List<Category> getCategorys(){
       return categoryService.getCategorys();
    }

    /**
     * 根据父分类ID 查询所有子分类
     * @param parentId
     * @return
     */
    @PostMapping("/categoryByParent")
    public Object getCateByPid(@RequestParam(required = false)
                               @NotNull(message ="参数不能为空")
                               Integer  parentId){
        return categoryService.getCateByPid(parentId);
    }
    /**
     * 查询所有分类及其子分类
     * @return
     */
    @PostMapping("/categoryBySub")
    public List<Category> getCategoryBySub(){
        return categoryService.getCategoryBySub();
    }
}