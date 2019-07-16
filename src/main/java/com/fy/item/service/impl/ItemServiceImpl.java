package com.fy.item.service.impl;

import com.fy.item.commons.DataGrid;
import com.fy.item.commons.PageUtil;
import com.fy.item.commons.ResultVo;
import com.fy.item.domain.ItemAllVo;
import com.fy.item.domain.ItemAttr;
import com.fy.item.domain.ItemPicture;
import com.fy.item.domain.ItemSku;
import com.fy.item.domain.ItemSpu;
import com.fy.item.mapper.ItemAttrMapper;
import com.fy.item.mapper.ItemPictureMapper;
import com.fy.item.mapper.ItemSkuMapper;
import com.fy.item.mapper.ItemSpuMapper;
import com.fy.item.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    //注入图片表
    @Autowired
    private ItemPictureMapper itemPictureMapper;

    /**
     * 查询商品列表
     * @return
     */
    @Override
    public DataGrid queryItemList(PageUtil pageUtil) {
        //准备分页
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
        List<ItemSpu> itemSpuList = itemSpuMapper.queryItemList();
        PageInfo<ItemSpu> pageInfo = new PageInfo<ItemSpu>(itemSpuList);
        return new DataGrid(pageInfo.getTotal(),itemSpuList);
    }

    /**
     * 发布商品(新增)
     * @param itemAllVo
     * @return
     */
    @Override
    public ResultVo insertItem(ItemAllVo itemAllVo) {
        ResultVo resultVo = new ResultVo(500,"发布商品出现问题");
        //员工id-缓存中获取---------------------------
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
        //判断图片路径是否为空
        if(itemAllVo.getPicPath()!=null&&!itemAllVo.getPicPath().equals("")){
            String[] split = itemAllVo.getPicPath().split(",");
            for(int i=0;i<split.length;i++){
                //创建图片实体   (商品Id,路径,次序,创建时间,状态)
                ItemPicture itemPicture = new ItemPicture(itemId,split[i],i,new Date(),0);
                //新增图片
                itemPictureMapper.insertSelective(itemPicture);
            }
        }
        //创建sku实体             参数: 商品spu Id         销售价格              库存
        ItemSku itemSku = new ItemSku(itemId, itemAllVo.getIskuSalePrice(), itemAllVo.getIskuKeepCount());
        //新增商品详情表
        itemSkuMapper.insertSelective(itemSku);
        //获取刚新增完的商品详情id
        int itemSkuId = itemSku.getIskuId();
        //判断属性是否为空
        itemAllVo.setAttrAttrKey(itemAllVo.getAttrAttrKey().replace(" ",""));
        itemAllVo.setAttrAttrValue(itemAllVo.getAttrAttrValue().replace(" ",""));
        if(itemAllVo.getAttrAttrValue()!=null&&itemAllVo.getAttrAttrKey()!=null&&!itemAllVo.getAttrAttrValue().equals("")&&!itemAllVo.getAttrAttrKey().equals("")){
            String[] split = itemAllVo.getAttrAttrValue().split(",");
            for(String value:split){
                //创建attr实体             参数: 详情sku Id         属性名            属性值
                ItemAttr itemAttr = new ItemAttr(itemSkuId,itemAllVo.getAttrAttrKey(),value);
                //新增商品属性attr表
                itemAttrMapper.insertSelective(itemAttr);
            }
        }
        resultVo.setCode(200);
        resultVo.setMsg("新增成功");

        return resultVo;
    }
}
