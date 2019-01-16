package com.su.supplydistributesystem.controller.api.distribute;

import com.su.supplydistributesystem.interceptor.DistributorLoginRequired;
import com.su.supplydistributesystem.request.*;
import com.su.supplydistributesystem.response.GoodsDetailView;
import com.su.supplydistributesystem.response.GoodsListView;
import com.su.supplydistributesystem.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.su.supplydistributesystem.constants.CommonConstants.*;

@RestController("distributeGoodsManagementApiController")
@RequestMapping(value = "/dApi/goods")
@DistributorLoginRequired
public class GoodsController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private GoodsService goodsService;


    @RequestMapping(value = LIST,method = RequestMethod.POST)
    public GoodsListView list(@Valid @RequestBody GoodsListForm form){
        return new GoodsListView(goodsService.selectList(form.getQueryMap()),goodsService.selectCount(form.getQueryMap()));
    }

    @RequestMapping(value = DETAIL_ID,method = RequestMethod.GET)
    public GoodsDetailView detail(@PathVariable Integer id){
        return goodsService.getDetail(id);
    }

}
