package com.fy.item.service;

import com.fy.item.commons.DataGrid;
import com.fy.item.commons.PageUtil;
import com.fy.item.commons.ResultVo;
import com.fy.item.domain.ItemAllVo;

/**
 * Created by monst on 2019/7/12.
 */
public interface ItemService {

    DataGrid queryItemList(PageUtil pageUtil);

    ResultVo insertItem(ItemAllVo itemAllVo);
}
