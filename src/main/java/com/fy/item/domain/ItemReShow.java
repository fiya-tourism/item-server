package com.fy.item.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 商品详情
 * Created by monst on 2019/7/18.
 */
@Data
public class ItemReShow {
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
    //商品类型  1.农产品 2.水果 3.工艺品
    private Integer itemType;
    //商品介绍 (存放mongodb唯一标识)
    private String itemIntroduceId;
    //是否上架 0.已上架   1.未上架
    private Integer itemIsActive;
    //商品产地
    private String itemAddress;
    //商品发布时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date itemRelease;
    //创建时间
    private Date itemCreate;
    //修改时间
    private Date itemUpdate;
    //状态码   0.显示   1.隐藏
    private Integer itemYn;
    //商品详情主键
    private Integer iskuId;
    //商品销售价格
    private Double iskuSalePrice;
    //商品库存   --预留
    private Integer iskuKeepCount;
    //商品规格集合
    private List<ItemAttr> itemAttrList;
    //图片集合
    private List<ItemPicture> itemPictureList;
    //商品介绍 (真正内容)
    private String itemIntroduceValue;
}
