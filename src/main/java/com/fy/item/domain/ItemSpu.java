package com.fy.item.domain;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author monst
 * 飞亚-商品spu
 */
@Data
public class ItemSpu {
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
    private Date itemRelease;
    //创建时间
    private Date itemCreate;
    //修改时间
    private Date itemUpdate;
    //状态码   0.显示   1.隐藏
    private Integer itemYn;
    //商品详情集合 (sku)
    private List<ItemSku> itemSkuList;

    public ItemSpu() {
    }

    //新增所需参数
    public ItemSpu(Integer staffId, Integer itemIsActive, Date itemRelease, Date itemCreate, Integer itemYn) {
        this.staffId = staffId;
        this.itemIsActive = itemIsActive;
        this.itemRelease = itemRelease;
        this.itemCreate = itemCreate;
        this.itemYn = itemYn;
    }
}