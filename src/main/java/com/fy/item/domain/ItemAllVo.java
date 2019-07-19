package com.fy.item.domain;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author monst
 * 接收页面传来的全部数据
 */
@Data
public class ItemAllVo implements Serializable {
    //商品主键
    private Integer itemId;
    //员工主键
    private Integer staffId;
    //类目主键 --预留
    private Integer itemCategoryId;
    //品牌主键 --预留
    private Integer itemBrandId;
    //商品名称
    private String itemName;
    //商品标题 (提供seo优化用)
    private String itemTitle;
    //商品类型   1.农产品 2.水果 3.工艺品 4.副产品
    private Integer itemType;
    //商品介绍 (存放mongodb唯一标识)
    private String itemIntroduceId;
    //商品介绍 (真正内容)
    private String itemIntroduceValue;
    //是否上架 0.已上架   1.未上架
    private Integer itemIsActive;
    //商品产地
    private String itemAddress;
    //商品发布时间
    private Date itemRelease;
    //创建时间
    private Date itemCreate;
    //修改时间
    private Date itemUpdate;
    //状态码   0.显示   1.隐藏
    private Integer itemYn;
//商品详情 (sku)
    //商品销售价格
    private Double iskuSalePrice;
    //商品库存
    private Integer iskuKeepCount;
//商品规格 (Attr)
    //商品规格属性名
    private String attrAttrKey;
    private String attrAttrKey2;
    //商品规格属性值
    private String attrAttrValue;
    private String attrAttrValue2;
//商品图片
    private String pictureUrl;



}