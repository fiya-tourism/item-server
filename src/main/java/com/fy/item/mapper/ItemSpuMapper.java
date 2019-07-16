package com.fy.item.mapper;

import com.fy.item.domain.ItemAllVo;
import com.fy.item.domain.ItemSpu;

import java.util.List;

public interface ItemSpuMapper {
    int deleteByPrimaryKey(Integer itemId);

    int insert(ItemSpu record);

    int insertSelective(ItemAllVo itemAllVo);

    ItemSpu selectByPrimaryKey(Integer itemId);

    int updateByPrimaryKeySelective(ItemSpu record);

    int updateByPrimaryKey(ItemSpu record);

    List<ItemSpu> queryItemList();

}