package com.fy.item.controller;

import com.fy.item.commons.ResultVo;
import com.fy.item.domain.ItemAllVo;
import com.fy.item.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 飞亚-商品模块
 * @author monst
 * @date 2019/7/12
 */
@Api(description = "飞亚-商品模块")
@Slf4j
@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * 商品列表展示
     * @return
     */
    @ApiOperation(notes = "查询商品列表",value = "查询商品列表")
    @RequestMapping("queryList")
    public ResultVo queryItemList(){
//        log.info("入参条件",);
        ResultVo resultVo = itemService.queryItemList();
        return resultVo;
    }

    /**
     * 发布商品(新增)
     * @param itemAllVo
     * @return
     */
    @ApiOperation(notes="飞亚-发布商品",value = "飞亚-发布商品")
    @RequestMapping("insert")
    public ResultVo insert(ItemAllVo itemAllVo){
        ResultVo resultVo = itemService.insertItem(itemAllVo);
        return resultVo;
    }

}
