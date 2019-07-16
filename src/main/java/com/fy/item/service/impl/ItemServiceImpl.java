package com.fy.item.service.impl;

import com.fy.item.commons.ResultVo;
import com.fy.item.domain.ItemAllVo;
import com.fy.item.domain.ItemSku;
import com.fy.item.domain.ItemSpu;
import com.fy.item.mapper.ItemAttrMapper;
import com.fy.item.mapper.ItemSkuMapper;
import com.fy.item.mapper.ItemSpuMapper;
import com.fy.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 飞亚-商品服务
 * @author monst
 * @date 2019/7/12
 */
@Service
public class ItemServiceImpl implements ItemService {

    //注入商品主表
    @Autowired
    private ItemSpuMapper itemSpuMapper;

    //注入商品详情表表
    @Autowired
    private ItemSkuMapper itemSkuMapper;

    //注入属性表
    @Autowired
    private ItemAttrMapper itemAttrMapper;

    /**
     * 查询商品列表
     * @return
     */
    @Override
    public ResultVo queryItemList() {
        ResultVo resultVo = new ResultVo(500,"查询出现问题");
        List<ItemSpu> itemSpuList = itemSpuMapper.queryItemList();
        resultVo.setList(itemSpuList);
        resultVo.setCode(200);
        resultVo.setMsg("查询成功");
        return resultVo;
    }

    /**
     * 发布商品(新增)
     * @param itemAllVo
     * @return
     */
    @Override
    public ResultVo insertItem(ItemAllVo itemAllVo) {
        ResultVo resultVo = new ResultVo(500,"发布商品出现问题");
        //员工id-缓存中获取
        itemAllVo.setStaffId(1);
        //是否上架 1.未上架  需手动点击后才让上架
        itemAllVo.setItemIsActive(1);
        // 发布时间
        itemAllVo.setItemRelease(new Date());
        // 创建时间
        itemAllVo.setItemCreate(new Date());
        // 状态码-0.显示
        itemAllVo.setItemYn(0);
        //新增商品表
        itemSpuMapper.insertSelective(itemAllVo);
        //获取刚新增完的商品id
        int itemId = itemAllVo.getItemId();
        //创建sku实体
        ItemSku itemSku = new ItemSku(itemId, itemAllVo.getIskuSalePrice(), itemAllVo.getIskuKeepCount());
        //新增商品详情表
        itemSkuMapper.insertSelective(itemSku);
        //获取刚新增完的商品详情id
        int itemSkuId = itemSku.getIskuId();

        resultVo.setCode(200);
        resultVo.setMsg("新增成功");

        return resultVo;
    }
}
