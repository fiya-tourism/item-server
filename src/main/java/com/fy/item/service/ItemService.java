package com.fy.item.service;

import com.fy.item.commons.DataGrid;
import com.fy.item.commons.PageUtil;
import com.fy.item.commons.ResultVo;
import com.fy.item.domain.ItemAllVo;
import com.fy.item.domain.ItemReShow;
import com.fy.item.domain.ItemSpu;
import com.fy.item.domain.ItemSpuSearchVo;

/**
 * Created by monst on 2019/7/12.
 */
public interface ItemService {

    DataGrid queryItemList(PageUtil pageUtil,ItemSpuSearchVo itemSpuSearchVo);

    ResultVo insertItem(ItemAllVo itemAllVo);

    ItemReShow getItemById(Integer itemId);

}
