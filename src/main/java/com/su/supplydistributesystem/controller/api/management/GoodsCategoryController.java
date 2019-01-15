package com.su.supplydistributesystem.controller.api.management;

import com.su.supplydistributesystem.context.SessionContext;
import com.su.supplydistributesystem.domain.Goods;
import com.su.supplydistributesystem.interceptor.UserLoginRequired;
import com.su.supplydistributesystem.request.GoodsCategoryStatusForm;
import com.su.supplydistributesystem.service.GoodsService;
import com.sug.core.platform.exception.ResourceNotFoundException;
import com.sug.core.platform.web.rest.exception.InvalidRequestException;
import com.sug.core.rest.view.ResponseView;
import com.sug.core.rest.view.SuccessView;
import com.su.supplydistributesystem.domain.GoodsCategory;
import com.su.supplydistributesystem.service.GoodsCategoryService;
import com.su.supplydistributesystem.request.GoodsCategoryCreateForm;
import com.su.supplydistributesystem.request.GoodsCategoryUpdateForm;
import com.su.supplydistributesystem.request.GoodsCategoryListForm;
import com.su.supplydistributesystem.response.GoodsCategoryListView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;

import java.util.Objects;

import static com.su.supplydistributesystem.constants.CategoryConstants.*;
import static com.su.supplydistributesystem.constants.CommonConstants.*;

@RestController("categoryManagementApiController")
@RequestMapping(value = "/mApi/category")
@UserLoginRequired
public class GoodsCategoryController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsCategoryController.class);

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @Autowired
    private SessionContext sessionContext;

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = LIST, method = RequestMethod.GET)
    public GoodsCategoryListView list() {
        return new GoodsCategoryListView(goodsCategoryService.getAllListView());
    }

    @RequestMapping(value = CREATE, method = RequestMethod.POST)
    public ResponseView create(@Valid @RequestBody GoodsCategoryCreateForm form) {
        GoodsCategory parentCategory = form.getParentId().equals(NOT_PARENT_ID) ? new GoodsCategory() : goodsCategoryService.getById(form.getParentId());
        if (Objects.isNull(parentCategory)) {
            throw new InvalidRequestException("invalidParentId", "parent category not found");
        }
        if (Objects.nonNull(parentCategory.getLevel()) && parentCategory.getLevel().equals(MAX_LEVEL)){
            throw new InvalidRequestException("invalidLevel", "parent category is max level");
        }
        GoodsCategory goodsCategory = new GoodsCategory();
        BeanUtils.copyProperties(form, goodsCategory);
        goodsCategory.setLevel(Objects.isNull(parentCategory.getLevel()) ? INIT_LEVEL : parentCategory.getLevel() + 1);
        goodsCategory.setCreateBy(sessionContext.getUser().getId());
        goodsCategoryService.create(goodsCategory);
        return new ResponseView();
    }

    @RequestMapping(value = UPDATE, method = RequestMethod.PUT)
    public ResponseView update(@Valid @RequestBody GoodsCategoryUpdateForm form) {
        GoodsCategory goodsCategory = goodsCategoryService.getById(form.getId());
        if (Objects.isNull(goodsCategory)) {
            throw new ResourceNotFoundException("goodsCategory not exists");
        }
        BeanUtils.copyProperties(form, goodsCategory);
        goodsCategory.setUpdateBy(sessionContext.getUser().getId());
        goodsCategoryService.update(goodsCategory);
        return new ResponseView();
    }

    @RequestMapping(value = "/resetStatus", method = RequestMethod.PUT)
    public ResponseView resetStatus(@Valid @RequestBody GoodsCategoryStatusForm form) {
        GoodsCategory goodsCategory = goodsCategoryService.getById(form.getId());
        if (Objects.isNull(goodsCategory)) {
            throw new ResourceNotFoundException("goodsCategory not exists");
        }
        if (!form.getStatus().equals(ENABLE) && !form.getStatus().equals(DISABLE)){
            throw new InvalidRequestException("invalidStatus","invalid status");
        }
        if(form.getStatus().equals(DISABLE) && goodsService.selectCountByCategoryId(goodsCategory.getId()) > 0){
            throw new InvalidRequestException("goodsExists","goods which use this category exists");
        }
        if (!goodsCategory.getStatus().equals(form.getStatus())){
            goodsCategory.setStatus(form.getStatus());
            goodsCategory.setUpdateBy(sessionContext.getUser().getId());
            goodsCategoryService.update(goodsCategory);
        }
        return new ResponseView();
    }

    @RequestMapping(value = DELETE_BY_ID, method = RequestMethod.DELETE)
    public ResponseView deleteById(@PathVariable Integer id) {
        GoodsCategory goodsCategory = goodsCategoryService.getById(id);
        if (Objects.isNull(goodsCategory)) {
            throw new ResourceNotFoundException("goodsCategory not exists");
        }
        if (goodsCategory.getStatus().equals(ENABLE)){
            throw new InvalidRequestException("invalidStatus","invalid status");
        }
        goodsCategoryService.deleteById(id);
        return new ResponseView();
    }
}
