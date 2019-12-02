package com.cn.wanxi.front.categorynav;

import com.cn.wanxi.model.categorynav.Category;
import com.cn.wanxi.service.categorynav.CategoryService;
import com.cn.wanxi.util.WebTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Map;

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
     * @param
     * @return
     */
    @PostMapping("/categoryByParent")
    public Object getCateByPid(@RequestBody Map<String,Object> param){
        String parentId=(String) param.get("parentId");
        if(parentId.matches("^[0-9]*$")==false||parentId==null){
            return WebTools.returnData("请输入正确参数",1);
        }
        return categoryService.getCateByPid(Integer.valueOf(parentId));
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