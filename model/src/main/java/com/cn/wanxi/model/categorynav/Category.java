package com.cn.wanxi.model.categorynav;

import java.util.List;

/**
 * @program: tenmallfront
 * @description: 商品分类
 * @author: niyao
 * @create: 2019-11-21 09:13
 */
public class Category {
    private Integer id;//主键分类ID
    private String  name; //分类名称
    private String  goodsNum;//商品数量
    private String  isShow; //是否显示
    private String  isMenu;//是否导航
    private Integer seq;//排序
    private Integer parentId;//上级ID
    private Integer templateId;//模板ID
    private List<Category> menus; //子分类

    public List<Category> getMenus() {
        return menus;
    }
    public void setMenus(List<Category> menus) {
        this.menus = menus;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public String getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(String isMenu) {
        this.isMenu = isMenu;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }
}