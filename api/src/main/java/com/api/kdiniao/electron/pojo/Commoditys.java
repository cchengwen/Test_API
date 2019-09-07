package com.api.kdiniao.electron.pojo;

/**
 *  商品信息
 */
public class Commoditys {
    private String GoodsName;  //  商品名称
    private String GoodsCode; //  商品编码
    private Integer Goodsquantity;  //  商品数量
    private Double GoodsPrice;  //  商品价格
    private Double GoodsWeight;  //  商品重量kg
    private String GoodsDesc;  //  商品描述
    private Double GoodsVol;  //  商品体积m3

    public String getGoodsName() {
        return GoodsName;
    }

    public void setGoodsName(String goodsName) {
        GoodsName = goodsName;
    }

    public String getGoodsCode() {
        return GoodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        GoodsCode = goodsCode;
    }

    public Integer getGoodsquantity() {
        return Goodsquantity;
    }

    public void setGoodsquantity(Integer goodsquantity) {
        Goodsquantity = goodsquantity;
    }

    public Double getGoodsPrice() {
        return GoodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        GoodsPrice = goodsPrice;
    }

    public Double getGoodsWeight() {
        return GoodsWeight;
    }

    public void setGoodsWeight(Double goodsWeight) {
        GoodsWeight = goodsWeight;
    }

    public String getGoodsDesc() {
        return GoodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        GoodsDesc = goodsDesc;
    }

    public Double getGoodsVol() {
        return GoodsVol;
    }

    public void setGoodsVol(Double goodsVol) {
        GoodsVol = goodsVol;
    }

    @Override
    public String toString() {
        return "Commoditys{" +
                "GoodsName='" + GoodsName + '\'' +
                ", GoodsCode='" + GoodsCode + '\'' +
                ", Goodsquantity='" + Goodsquantity + '\'' +
                ", GoodsPrice=" + GoodsPrice +
                ", GoodsWeight=" + GoodsWeight +
                ", GoodsDesc='" + GoodsDesc + '\'' +
                ", GoodsVol=" + GoodsVol +
                '}';
    }
}
