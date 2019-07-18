package com.fy.item.domain;


import lombok.Data;

/**
 * @author monst
 * 查询条件的
 */
@Data
public class ItemSpuSearchVo {
    //商品类型  1.农产品 2.水果 3.工艺品
    private Integer itemType;
    //是否上架 0.已上架   1.未上架
    private Integer itemIsActive;
    //商品产地
    private String itemAddress;
    //开始的时间
    private String timeB;
    //结束的时间
    private String timeE;

}