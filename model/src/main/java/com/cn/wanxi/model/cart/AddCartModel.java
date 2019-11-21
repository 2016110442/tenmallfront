package com.cn.wanxi.model.cart;

/**
 * @author
 * @date 2019/11/20 9:38
 */
public class AddCartModel {
    private String skuId;
    private Integer num;
    private Integer spuId;
    private String spec;

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getSpuId() {
        return spuId;
    }

    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    @Override
    public String toString() {
        return "AddCart{" +
                "skuId='" + skuId + '\'' +
                ", num='" + num + '\'' +
                ", spuId='" + spuId + '\'' +
                ", Spec='" + spec + '\'' +
                '}';
    }


}
