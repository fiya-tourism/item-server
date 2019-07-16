package com.fy.item.mapper;

import com.fy.item.domain.ItemPicture;

public interface ItemPictureMapper {
    int deleteByPrimaryKey(Integer pictureId);

    int insert(ItemPicture record);

    int insertSelective(ItemPicture record);

    ItemPicture selectByPrimaryKey(Integer pictureId);

    int updateByPrimaryKeySelective(ItemPicture record);

    int updateByPrimaryKey(ItemPicture record);
}