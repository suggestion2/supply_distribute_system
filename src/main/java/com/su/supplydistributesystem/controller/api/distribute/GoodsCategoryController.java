package com.su.supplydistributesystem.controller.api.distribute;

import com.su.supplydistributesystem.interceptor.DistributorLoginRequired;
import com.su.supplydistributesystem.response.GoodsCategoryListView;
import com.su.supplydistributesystem.service.GoodsCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.su.supplydistributesystem.constants.CommonConstants.LIST;

@RestController("distributeGoodsCategoryApiController")
@RequestMapping(value = "/dApi/category")
@DistributorLoginRequired
public class GoodsCategoryController {

    private static final Logger logger = LoggerFactory.getLogger(com.su.supplydistributesystem.controller.api.management.GoodsCategoryController.class);

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @RequestMapping(value = LIST, method = RequestMethod.GET)
    public GoodsCategoryListView list() {
        return new GoodsCategoryListView(goodsCategoryService.getAllListView());
    }

}
