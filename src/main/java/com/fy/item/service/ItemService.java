package com.fy.item.service;

import com.fy.item.commons.ResultVo;
import com.fy.item.domain.ItemAllVo;

/**
 * Created by monst on 2019/7/12.
 */
public interface ItemService {

    ResultVo queryItemList();

    ResultVo insertItem(ItemAllVo itemAllVo);
}
