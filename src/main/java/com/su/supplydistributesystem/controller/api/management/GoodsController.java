package com.su.supplydistributesystem.controller.api.management;

import com.su.supplydistributesystem.constants.CategoryConstants;
import com.su.supplydistributesystem.context.SessionContext;
import com.su.supplydistributesystem.domain.*;
import com.su.supplydistributesystem.interceptor.UserLoginRequired;
import com.su.supplydistributesystem.mapper.GoodsSupplyUpdateParams;
import com.su.supplydistributesystem.request.*;
import com.su.supplydistributesystem.response.GoodsDetailView;
import com.su.supplydistributesystem.service.GoodsCategoryService;
import com.su.supplydistributesystem.service.GoodsSupplyService;
import com.sug.core.platform.exception.ResourceNotFoundException;
import com.sug.core.platform.web.rest.exception.InvalidRequestException;
import com.sug.core.rest.view.ResponseView;
import com.sug.core.rest.view.SuccessView;
import com.su.supplydistributesystem.service.GoodsService;
import com.su.supplydistributesystem.response.GoodsListView;
import com.sug.core.util.BigDecimalUtils;
import com.sug.core.util.SequenceNumUtils;
import com.sug.core.util.UUIDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.su.supplydistributesystem.constants.CommonConstants.*;
import static com.su.supplydistributesystem.constants.GoodsConstants.*;

@RestController("goodsManagementApiController")
@RequestMapping(value = "/mApi/goods")
@UserLoginRequired
public class GoodsController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsSupplyService goodsSupplyService;

    @Autowired
    private SessionContext sessionContext;

    @RequestMapping(value = LIST,method = RequestMethod.POST)
    public GoodsListView list(@Valid @RequestBody GoodsListForm form){
        return new GoodsListView(goodsService.selectList(form.getQueryMap()),goodsService.selectCount(form.getQueryMap()));
    }

    @RequestMapping(value = DETAIL_ID,method = RequestMethod.GET)
    public GoodsDetailView detail(@PathVariable Integer id){
        return goodsService.getDetail(id);
    }

    @RequestMapping(value = CREATE,method = RequestMethod.POST)
    @Transactional
    public ResponseView create(@Valid @RequestBody GoodsCreateForm form){
        Goods goods = new Goods();
        if(Objects.nonNull(goodsService.getByName(form.getName()))){
            throw new InvalidRequestException("duplicateName","duplicate goods name");
        }
        BeanUtils.copyProperties(form,goods);
        goods.setNumber(UUIDUtils.random());

        List<GoodsSupplyForm> goodsSupplyList = form.getGoodsSupplyList();
        goodsSupplyList.forEach(g->goods.setLowSupplyPrice(Objects.isNull(goods.getLowSupplyPrice()) || goods.getLowSupplyPrice().compareTo(g.getSupplyPrice()) > 0 ? g.getSupplyPrice() : goods.getLowSupplyPrice()));

        goods.setProfit1(BigDecimalUtils.subtract(goods.getPrice(),goods.getLowSupplyPrice()));
        goods.setProfit2(BigDecimalUtils.subtract(goods.getTaobaoPrice(),goods.getPrice()));
        goods.setProfit3(BigDecimalUtils.subtract(goods.getJdPrice(),goods.getPrice()));

        User current = sessionContext.getUser();
        goods.setCreateBy(current.getId());

        goodsService.create(goods);

        goodsSupplyList.forEach(g->{
            g.setGoodsId(goods.getId());
            g.setCreateBy(current.getId());
        });

        goodsSupplyService.batchCreate(goodsSupplyList);

        return new ResponseView();
    }

    @RequestMapping(value = UPDATE,method = RequestMethod.PUT)
    @Transactional
    public ResponseView update(@Valid @RequestBody GoodsUpdateForm form){
        Goods goods = goodsService.getById(form.getId());
        Goods existGoods;
        if(Objects.nonNull(existGoods = goodsService.getByName(form.getName())) && !existGoods.getId().equals(form.getId())){
            throw new InvalidRequestException("duplicateName","duplicate goods name");
        }
        if(Objects.isNull(goods)){
            throw new ResourceNotFoundException("goods not exists");
        }
        if(goods.getStatus().equals(ENABLE)){
            throw new InvalidRequestException("invalidStatus","invalid status");
        }

        User current = sessionContext.getUser();

        List<GoodsSupplyForm> goodsSupplyList = form.getGoodsSupplyList();
        //reset goods low supply price null to re calculate
        goods.setLowSupplyPrice(null);
        goodsSupplyList.forEach(g->{
            goods.setLowSupplyPrice(Objects.isNull(goods.getLowSupplyPrice()) || goods.getLowSupplyPrice().compareTo(g.getSupplyPrice()) > 0 ? g.getSupplyPrice() : goods.getLowSupplyPrice());
            g.setGoodsId(goods.getId());
            g.setCreateBy(current.getId());
        });

        BeanUtils.copyProperties(form,goods);
        goods.setProfit1(BigDecimalUtils.subtract(goods.getPrice(),goods.getLowSupplyPrice()));
        goods.setProfit2(BigDecimalUtils.subtract(goods.getTaobaoPrice(),goods.getPrice()));
        goods.setProfit3(BigDecimalUtils.subtract(goods.getJdPrice(),goods.getPrice()));
        goods.setUpdateBy(current.getId());

        List<GoodsSupplyForm> createList = new ArrayList<>();
        List<GoodsSupplyForm> updateList = new ArrayList<>();

        for(GoodsSupplyForm goodsSupplyForm : goodsSupplyList){
            if(Objects.nonNull(goodsSupplyForm.getId())){
                updateList.add(goodsSupplyForm);
            }else {
                createList.add(goodsSupplyForm);
            }
        }

        GoodsSupplyUpdateParams params = new GoodsSupplyUpdateParams(goods.getId(),current.getId(),updateList);

        goodsService.update(goods);
        goodsSupplyService.batchUpdate(params);
        goodsSupplyService.batchCreate(createList);

        return new ResponseView();
    }

    @RequestMapping(value = "/resetStatus",method = RequestMethod.PUT)
    public ResponseView resetStatus(@Valid @RequestBody GoodsStatusForm form){
        Goods goods = goodsService.getById(form.getId());
        if(Objects.isNull(goods)){
            throw new ResourceNotFoundException("goods not exists");
        }
        if(!form.getStatus().equals(ENABLE) && !form.getStatus().equals(DISABLE)){
            throw new InvalidRequestException("invalidStatus","invalid status");
        }
        if(form.getStatus().equals(ENABLE)){
            List<GoodsCategory> categoryList = goodsCategoryService.getListByGoodsId(goods.getId());
            if(categoryList.size() < 3){
                throw new InvalidRequestException("invalidCategory","goods category not found");
            }
            categoryList.forEach(c->{
                if(c.getStatus().equals(CategoryConstants.DISABLE)){
                    throw new InvalidRequestException("invalidCategory","goods category is disabled");
                }
            });
        }

        if(!goods.getStatus().equals(form.getStatus())){
            goods.setStatus(form.getStatus());
            goods.setUpdateBy(sessionContext.getUser().getId());
            goodsService.updateStatus(goods);
        }
        return new ResponseView();
    }

    @RequestMapping(value = DELETE_BY_ID,method = RequestMethod.DELETE)
    @Transactional
    public ResponseView deleteById(@PathVariable Integer id){
        Goods goods = goodsService.getById(id);
        if(Objects.isNull(goods)){
            throw new ResourceNotFoundException("goods not exists");
        }
        if(!goods.getStatus().equals(DISABLE)){
            throw new InvalidRequestException("invalidStatus","invalid status");
        }
        goodsService.deleteById(goods.getId());
        goodsSupplyService.deleteByGoodsId(goods.getId());
        return new ResponseView();
    }
}
