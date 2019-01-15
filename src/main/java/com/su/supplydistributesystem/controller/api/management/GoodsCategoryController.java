package com.su.supplydistributesystem.controller.api.management;

import com.sug.core.platform.exception.ResourceNotFoundException;
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

import java.util.Objects;

import static com.su.supplydistributesystem.constants.CommonConstants.*;

@RestController
@RequestMapping(value = "/goodsCategory")
public class GoodsCategoryController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsCategoryController.class);

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @RequestMapping(value = LIST,method = RequestMethod.POST)
    public GoodsCategoryListView list(@Valid @RequestBody GoodsCategoryListForm form){
        return new GoodsCategoryListView(goodsCategoryService.selectList(form.getQueryMap()));
    }

    @RequestMapping(value = DETAIL,method = RequestMethod.GET)
    public GoodsCategory detail(@PathVariable Integer id){
        return goodsCategoryService.getById(id);
    }

    @RequestMapping(value = CREATE,method = RequestMethod.POST)
    public SuccessView create(@Valid @RequestBody GoodsCategoryCreateForm form){
        GoodsCategory goodsCategory = new GoodsCategory();
        BeanUtils.copyProperties(form,goodsCategory);
        goodsCategoryService.create(goodsCategory);
        return new SuccessView();
    }

    @RequestMapping(value = UPDATE,method = RequestMethod.PUT)
    public SuccessView update(@Valid @RequestBody GoodsCategoryUpdateForm form){
        GoodsCategory goodsCategory = goodsCategoryService.getById(form.getId());
        if(Objects.isNull(goodsCategory)){
            throw new ResourceNotFoundException("goodsCategory not exists");
        }
        BeanUtils.copyProperties(form,goodsCategory);
        goodsCategoryService.update(goodsCategory);
        return new SuccessView();
    }
}
