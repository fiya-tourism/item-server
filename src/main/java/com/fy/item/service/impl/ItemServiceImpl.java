package com.fy.item.service.impl;

import com.fy.item.commons.DataGrid;
import com.fy.item.commons.PageUtil;
import com.fy.item.commons.ResultVo;
import com.fy.item.commons.StrTool;
import com.fy.item.domain.ItemAllVo;
import com.fy.item.domain.ItemAttr;
import com.fy.item.domain.ItemComment;
import com.fy.item.domain.ItemPicture;
import com.fy.item.domain.ItemSku;
import com.fy.item.domain.ItemSpu;
import com.fy.item.domain.ItemSpuSearchVo;
import com.fy.item.domain.ItemReShow;
import com.fy.item.mapper.ItemAttrMapper;
import com.fy.item.mapper.ItemPictureMapper;
import com.fy.item.mapper.ItemSkuMapper;
import com.fy.item.mapper.ItemSpuMapper;
import com.fy.item.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    //mongodb工具类
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询商品列表
     * @return
     */
    @Override
    public DataGrid queryItemList(PageUtil pageUtil,ItemSpuSearchVo itemSpuSearchVo) {
        //准备分页
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
        //驼峰转化为下划线
        pageUtil.setSort(StrTool.humpToLine2(pageUtil.getSort()));
        //结束时间格式化
        if(itemSpuSearchVo!=null&&itemSpuSearchVo.getTimeE()!=null&&!itemSpuSearchVo.getTimeE().equals("")){
            itemSpuSearchVo.setTimeE(itemSpuSearchVo.getTimeE()+" 23:23:59");
        }
        List<ItemSpu> itemPage = itemSpuMapper.queryPage(itemSpuSearchVo,pageUtil.getSort(),pageUtil.getOrder());
        PageInfo<ItemSpu> pageInfo = new PageInfo<ItemSpu>(itemPage);
        List<ItemSpu> itemSpuList = new ArrayList<ItemSpu>();
        if(itemPage.size()!=0){
            //将要分页的id拼成一个字符串
            String ids = "";
            for(int i=0;i<itemPage.size();i++){
                ids += itemPage.get(i).getItemId()+",";
            }
            itemSpuList = itemSpuMapper.queryItemList(ids);
        }
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
        // mongodb内容key
        itemAllVo.setItemIntroduceId("item"+itemAllVo.getItemId());
        //创建详情对象
        ItemComment itemComment = new ItemComment(itemAllVo.getItemIntroduceId(),itemAllVo.getItemIntroduceValue(),new Date());
        mongoTemplate.save(itemComment);

        //判断图片路径是否为空
        if(itemAllVo.getPictureUrl()!=null&&!itemAllVo.getPictureUrl().equals("")){
            String[] split = itemAllVo.getPictureUrl().split(",");
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
        if(itemAllVo.getAttrAttrValue()!=null&&itemAllVo.getAttrAttrKey()!=null&&!itemAllVo.getAttrAttrValue().equals("")&&!itemAllVo.getAttrAttrKey().equals("")){
            String[] split = itemAllVo.getAttrAttrValue().replace(" ","").split(",");
            for(String value:split){
                //创建attr实体             参数: 详情sku Id         属性名            属性值
                ItemAttr itemAttr = new ItemAttr(itemSkuId,itemAllVo.getAttrAttrKey(),value);
                //新增商品属性attr表
                itemAttrMapper.insertSelective(itemAttr);
            }
        }
        if(itemAllVo.getAttrAttrValue2()!=null&&itemAllVo.getAttrAttrKey2()!=null&&!itemAllVo.getAttrAttrValue2().equals("")&&!itemAllVo.getAttrAttrKey2().equals("")){
            String[] split = itemAllVo.getAttrAttrValue2().replace(" ","").split(",");
            for(String value:split){
                //创建attr实体             参数: 详情sku Id         属性名            属性值
                ItemAttr itemAttr = new ItemAttr(itemSkuId,itemAllVo.getAttrAttrKey2(),value);
                //新增商品属性attr表
                itemAttrMapper.insertSelective(itemAttr);
            }
        }
        resultVo.setCode(200);
        resultVo.setMsg("新增成功");

        return resultVo;
    }

    /**
     * 根据id查询
     * @param itemId
     * @return
     */
    @Override
    public ItemReShow getItemById(Integer itemId) {
        ItemReShow itemReShow = itemSpuMapper.getItemById(itemId);
        //创建 itemComment 对象 用来获取mongodb中的详情
        Query query = new Query(Criteria.where("_id").is("item"+itemId));
        List<ItemComment> itemComments = mongoTemplate.find(query, ItemComment.class);
        if(itemComments.size()!=0){
            ItemComment itemComment = itemComments.get(0);
            itemReShow.setItemIntroduceValue(itemComment.getValue());
        }
        //查询该商品的图片集合
        List<ItemPicture> itemPictureList = itemPictureMapper.queryPicList(itemId);
        itemReShow.setItemPictureList(itemPictureList);
        //根据sku Id查询该商品的attr集合
        List<ItemAttr> itemAttrList = itemAttrMapper.queryAttrList(itemReShow.getIskuId());
        itemReShow.setItemAttrList(itemAttrList);
        return itemReShow;
    }

    /**
     * 修改
     * @param itemAllVo
     * @return
     */
    @Override
    public ResultVo updateItem(ItemAllVo itemAllVo) {
        ResultVo resultVo = new ResultVo(500,"修改商品出现问题");
        // 修改时间
        itemAllVo.setItemUpdate(new Date());
        //修改商品表
        itemSpuMapper.updateByPrimaryKeySelective(itemAllVo);
        //创建详情对象
        ItemComment itemComment = new ItemComment("item"+itemAllVo.getItemId(),itemAllVo.getItemIntroduceValue(),new Date());
        //修改mongodb中的详情
        mongoTemplate.save(itemComment);

        //创建sku实体             参数:     skuId           商品spu Id         销售价格              库存
        ItemSku itemSku = new ItemSku(itemAllVo.getIskuId(),itemAllVo.getItemId(), itemAllVo.getIskuSalePrice(), itemAllVo.getIskuKeepCount());
        //修改商品详情表
        itemSkuMapper.updateByPrimaryKey(itemSku);
        resultVo.setCode(200);
        resultVo.setMsg("修改成功");
        return resultVo;
    }

    //删除
    @Override
    public ResultVo deleteItem(Integer itemId) {
        ResultVo resultVo = new ResultVo(500,"删除商品出现问题");
        itemSpuMapper.updateStatus(itemId);
        resultVo.setCode(200);
        resultVo.setMsg("删除商品成功");
        return resultVo;
    }
}
