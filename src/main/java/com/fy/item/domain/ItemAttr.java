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
}