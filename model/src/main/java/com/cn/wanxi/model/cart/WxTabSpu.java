package com.cn.wanxi.model.cart;

public class WxTabSpu {
    private Integer id;
    private String sn;
    private String name;
    private String caption;
    private Integer brandId;
    private Integer category1Id;
    private Integer category2Id;
    private Integer category3Id;
    private Integer templateId;
    private Integer freightId;
    private String image;
    private String images;
    private String saleService;
    private String introduction;
    private String specItems;
    private String paraItems;
    private Integer saleNum;
    private Integer commentNum;
    private String isMarketable;
    private String isEnablePec;
    private String isDelete;
    private String status;
    private WxTabCart wxTabCart;
    private WxTabSku wxTabSku;

    public WxTabCart getWxTabCart() {
        return wxTabCart;
    }

    public void setWxTabCart(WxTabCart wxTabCart) {
        this.wxTabCart = wxTabCart;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public WxTabSku getWxTabSku() {
        return wxTabSku;
    }

    public void setWxTabSku(WxTabSku wxTabSku) {
        this.wxTabSku = wxTabSku;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getCategory1Id() {
        return category1Id;
    }

    public void setCategory1Id(Integer category1Id) {
        this.category1Id = category1Id;
    }

    public Integer getCategory2Id() {
        return category2Id;
    }

    public void setCategory2Id(Integer category2Id) {
        this.category2Id = category2Id;
    }

    public Integer getCategory3Id() {
        return category3Id;
    }

    public void setCategory3Id(Integer category3Id) {
        this.category3Id = category3Id;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public Integer getFreightId() {
        return freightId;
    }

    public void setFreightId(Integer freightId) {
        this.freightId = freightId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getSaleService() {
        return saleService;
    }

    public void setSaleService(String saleService) {
        this.saleService = saleService;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getSpecItems() {
        return specItems;
    }

    public void setSpecItems(String specItems) {
        this.specItems = specItems;
    }

    public String getParaItems() {
        return paraItems;
    }

    public void setParaItems(String paraItems) {
        this.paraItems = paraItems;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public String getIsMarketable() {
        return isMarketable;
    }

    public void setIsMarketable(String isMarketable) {
        this.isMarketable = isMarketable;
    }

    public String getIsEnablePec() {
        return isEnablePec;
    }

    public void setIsEnablePec(String isEnablePec) {
        this.isEnablePec = isEnablePec;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
