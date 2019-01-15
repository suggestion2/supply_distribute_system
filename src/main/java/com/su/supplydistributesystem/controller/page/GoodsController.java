package com.su.supplydistributesystem.controller.page;

import com.su.supplydistributesystem.context.SessionContext;
import com.su.supplydistributesystem.interceptor.UserLoginRequired;
import com.su.supplydistributesystem.service.GoodsCategoryService;
import com.su.supplydistributesystem.service.GoodsService;
import com.su.supplydistributesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static com.su.supplydistributesystem.constants.CommonConstants.*;

@Controller("goodsManagementController")
@RequestMapping(value = "/management/goods")
@UserLoginRequired
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsCategoryService goodsCategoryService;

    @RequestMapping(value = LIST, method = RequestMethod.GET)
    public String list(ModelMap modelMap) {
        modelMap.put("list", null);
        modelMap.put("category",goodsCategoryService.getListViewForCreateGoods());
        return "management/goodsList";
    }

    @RequestMapping(value = CREATE, method = RequestMethod.GET)
    public String create(ModelMap modelMap) {
        modelMap.put("category",goodsCategoryService.getListViewForCreateGoods());
        modelMap.put("supplier",null);
        return "management/goodsCreate";
    }

    @RequestMapping(value = DETAIL_ID, method = RequestMethod.GET)
    public String detail(@PathVariable Integer id,ModelMap modelMap) {
        modelMap.put("goods",null);
        modelMap.put("category",goodsCategoryService.getListViewForCreateGoods());
        modelMap.put("supplier",null);
        return "management/goodsDetail";
    }
}
