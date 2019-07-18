package com.fy.item.mapper;

import com.fy.item.domain.ItemAllVo;
import com.fy.item.domain.ItemSpu;
import com.fy.item.domain.ItemSpuSearchVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ItemSpuMapper {
    int deleteByPrimaryKey(Integer itemId);

    int insert(ItemSpu record);

    int insertSelective(ItemAllVo itemAllVo);

    ItemSpu selectByPrimaryKey(Integer itemId);

    int updateByPrimaryKeySelective(ItemSpu record);

    int updateByPrimaryKey(ItemSpu record);

    List<ItemSpu> queryItemList(@Param("itemSpuSearchVo") ItemSpuSearchVo itemSpuSearchVo,
                                @Param("sort") String sort,
                                @Param("order") String order);

    //根据id查询item
    ItemAllVo getItemById(Integer itemId);
}