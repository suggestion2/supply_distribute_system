package com.su.supplydistributesystem.controller.api.management;

import com.sug.core.platform.exception.ResourceNotFoundException;
import com.sug.core.rest.view.SuccessView;
import com.su.supplydistributesystem.domain.GoodsSuppliy;
import com.su.supplydistributesystem.service.GoodsSuppliyService;
import com.su.supplydistributesystem.request.GoodsSuppliyCreateForm;
import com.su.supplydistributesystem.request.GoodsSuppliyUpdateForm;
import com.su.supplydistributesystem.request.GoodsSuppliyListForm;
import com.su.supplydistributesystem.response.GoodsSuppliyListView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Objects;

import static com.su.supplydistributesystem.constants.CommonConstants.*;

@RestController
@RequestMapping(value = "/goodsSuppliy")
public class GoodsSuppliyController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsSuppliyController.class);

    @Autowired
    private GoodsSuppliyService goodsSuppliyService;

    @RequestMapping(value = LIST,method = RequestMethod.POST)
    public GoodsSuppliyListView list(@Valid @RequestBody GoodsSuppliyListForm form){
        return new GoodsSuppliyListView(goodsSuppliyService.selectList(form.getQueryMap()));
    }

    @RequestMapping(value = DETAIL,method = RequestMethod.GET)
    public GoodsSuppliy detail(@PathVariable Integer id){
        return goodsSuppliyService.getById(id);
    }

    @RequestMapping(value = CREATE,method = RequestMethod.POST)
    public SuccessView create(@Valid @RequestBody GoodsSuppliyCreateForm form){
        GoodsSuppliy goodsSuppliy = new GoodsSuppliy();
        BeanUtils.copyProperties(form,goodsSuppliy);
        goodsSuppliyService.create(goodsSuppliy);
        return new SuccessView();
    }

    @RequestMapping(value = UPDATE,method = RequestMethod.PUT)
    public SuccessView update(@Valid @RequestBody GoodsSuppliyUpdateForm form){
        GoodsSuppliy goodsSuppliy = goodsSuppliyService.getById(form.getId());
        if(Objects.isNull(goodsSuppliy)){
            throw new ResourceNotFoundException("goodsSuppliy not exists");
        }
        BeanUtils.copyProperties(form,goodsSuppliy);
        goodsSuppliyService.update(goodsSuppliy);
        return new SuccessView();
    }
}
