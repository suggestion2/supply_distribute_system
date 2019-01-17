package com.su.supplydistributesystem.controller.page;

import com.su.supplydistributesystem.interceptor.UserLoginRequired;
import com.su.supplydistributesystem.service.GoodsCategoryService;
import com.su.supplydistributesystem.service.GoodsService;
import org.apache.poi.hssf.record.chart.CategorySeriesAxisRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;

import static com.su.supplydistributesystem.constants.CommonConstants.*;

@Controller("categoryManagementController")
@RequestMapping(value = "/management/category")
@UserLoginRequired
public class CategoryController {
    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @RequestMapping(value = LIST, method = RequestMethod.GET)
    public String list(ModelMap modelMap) {
        modelMap.put("list", goodsCategoryService.getAllListView());
        return "management/category/categoryList";
    }
}
