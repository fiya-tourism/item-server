package com.fy.item.domain;

import lombok.Data;

import java.util.Date;

@Data
public class ItemPicture {
    //图片主键
    private Integer pictureId;
    //商品主键
    private Integer itemId;
    //图片路径
    private String pictureUrl;
    //图片次序
    private Integer pictureSequence;
    //创建时间
    private Date pictureCreate;
    //修改时间
    private Date pictureUpdate;
    //状态码
    private Integer pictureYn;

    public ItemPicture() {
    }

    public ItemPicture(Integer itemId, String pictureUrl, Integer pictureSequence, Date pictureCreate, Integer pictureYn) {
        this.itemId = itemId;
        this.pictureUrl = pictureUrl;
        this.pictureSequence = pictureSequence;
        this.pictureCreate = pictureCreate;
        this.pictureYn = pictureYn;
    }
}