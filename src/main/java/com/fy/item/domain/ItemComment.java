package com.fy.item.domain;

import lombok.Data;

import java.util.Date;

/**
 * Created by monst on 2019/7/17.
 */
@Data
public class ItemComment {
    private String _id;
    private String value;
    private Date createTime;

    public ItemComment() {
    }

    public ItemComment(String _id, String value, Date createTime) {
        this._id = _id;
        this.value = value;
        this.createTime = createTime;
    }
}
