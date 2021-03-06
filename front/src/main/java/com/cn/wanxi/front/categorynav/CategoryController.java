package com.cn.wanxi.front.categorynav;

import com.cn.wanxi.service.categorynav.CategoryService;
import com.cn.wanxi.util.WebTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public Object getCategorys(){
       return WebTools.returnData(categoryService.getCategorys(),0);
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
        return WebTools.returnData(categoryService.getCateByPid(Integer.valueOf(parentId)),0);
    }
    /**
     * 查询所有分类及其子分类
     * @return
     */
    @PostMapping("/categoryBySub")
    public Object getCategoryBySub(){
        return WebTools.returnData(categoryService.getCategoryBySub(),1);
    }
}