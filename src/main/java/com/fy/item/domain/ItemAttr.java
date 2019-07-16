package com.fy.item.domain;
import lombok.Data;
@Data
public class ItemAttr {
    //商品规格主键
    private Integer sttrId;
    //商品详情主键
    private Integer iskuId;
    //商品规格属性名
    private String attrAttrKey;
    //商品规格属性值
    private String attrAttrValue;

    public ItemAttr() {
    }

    public ItemAttr(Integer iskuId, String attrAttrKey, String attrAttrValue) {
        this.iskuId = iskuId;
        this.attrAttrKey = attrAttrKey;
        this.attrAttrValue = attrAttrValue;
    }

    public ItemAttr(Integer sttrId, Integer iskuId, String attrAttrKey, String attrAttrValue) {
        this.sttrId = sttrId;
        this.iskuId = iskuId;
        this.attrAttrKey = attrAttrKey;
        this.attrAttrValue = attrAttrValue;
    }
}