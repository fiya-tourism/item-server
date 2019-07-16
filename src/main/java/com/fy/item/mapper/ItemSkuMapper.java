package com.fy.item.mapper;

import com.fy.item.domain.ItemSku;

public interface ItemSkuMapper {
    int deleteByPrimaryKey(Integer iskuId);

    int insert(ItemSku record);

    int insertSelective(ItemSku record);

    ItemSku selectByPrimaryKey(Integer iskuId);

    int updateByPrimaryKeySelective(ItemSku record);

    int updateByPrimaryKey(ItemSku record);
}