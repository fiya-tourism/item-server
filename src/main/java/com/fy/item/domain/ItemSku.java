package com.fy.item.domain;

import lombok.Data;

import java.util.List;

@Data
public class ItemSku {
    //商品详情主键
    private Integer iskuId;
    //商品主键
    private Integer itemId;
    //商品销售价格
    private Double iskuSalePrice;
    //商品库存   --预留
    private Integer iskuKeepCount;
    //商品规格集合
    private List<ItemAttr> itemAttrList;

    public ItemSku() {
    }

    //新增用
    public ItemSku(Integer itemId,Double iskuSalePrice, Integer iskuKeepCount) {
        this.itemId = itemId;
        this.iskuSalePrice = iskuSalePrice;
        this.iskuKeepCount = iskuKeepCount;
    }

    //修改用
    public ItemSku(Integer iskuId, Integer itemId, Double iskuSalePrice, Integer iskuKeepCount) {
        this.iskuId = iskuId;
        this.itemId = itemId;
        this.iskuSalePrice = iskuSalePrice;
        this.iskuKeepCount = iskuKeepCount;
    }
}