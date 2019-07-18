package com.fy.item.domain;

import lombok.Data;

import java.util.Date;

/**
 * Created by monst on 2019/7/17.
 */
@Data
public class ItemComment {
    private String key;
    private String value;
    private Date createTime;

    public ItemComment() {
    }

    public ItemComment(String key, String value, Date createTime) {
        this.key = key;
        this.value = value;
        this.createTime = createTime;
    }
}
