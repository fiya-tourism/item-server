package com.fy.item.mapper;

import com.fy.item.domain.ItemAttr;

import java.util.List;

public interface ItemAttrMapper {
    int deleteByPrimaryKey(Integer sttrId);

    int insert(ItemAttr record);

    int insertSelective(ItemAttr record);

    ItemAttr selectByPrimaryKey(Integer sttrId);

    int updateByPrimaryKeySelective(ItemAttr record);

    int updateByPrimaryKey(ItemAttr record);

    List<ItemAttr> queryAttrList(Integer iskuId);
}