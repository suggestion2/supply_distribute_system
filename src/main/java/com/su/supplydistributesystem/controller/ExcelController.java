package com.su.supplydistributesystem.controller;

import com.su.supplydistributesystem.interceptor.UserLoginRequired;
import com.su.supplydistributesystem.response.ViewExcel;
import com.su.supplydistributesystem.service.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.*;

@Controller
@RequestMapping("/management/excel")
@UserLoginRequired
public class ExcelController {
    @Autowired
    private ExcelService excelService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value="/goods", method = RequestMethod.GET)
    public ModelAndView goodsExcel(ModelMap model, HttpServletRequest request, HttpServletResponse response){
        List<GoodsDetailParams> goodsExcelParamsList = goodsService.getDetailParamsList(null);
        try {
            HSSFWorkbook workbook = excelService.generateGoodsExcel(goodsExcelParamsList);
            ViewExcel viewExcel = new ViewExcel();
            viewExcel.buildExcelDocument(Collections.singletonMap("fileName", URLEncoder.encode("商品","UTF-8")),workbook,request,response);
            return new ModelAndView(viewExcel,model);
        } catch (Exception e) {
            throw new RuntimeException("excel generate fail:" + e.getMessage(),e);
        }
    }

    @RequestMapping(value="/order", method = RequestMethod.GET)
    public ModelAndView orderExcel(@RequestParam(required = false) String date,@RequestParam(required = false) Integer status,@RequestParam(required = false) String content,
                                   ModelMap model,  HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> query = new HashMap<>();
        if(StringUtils.hasText(date)){
            query.put("date",date);
        }
        if(StringUtils.hasText(content)){
            query.put("content",content);
        }
        if(Objects.nonNull(status)){
            query.put("status",status);
        }
        List<OrderDetailParams> orderExcelParamsList = orderService.getDetailParamsList(query);
        try {
            HSSFWorkbook workbook = excelService.generateOrderExcel(orderExcelParamsList);
            ViewExcel viewExcel = new ViewExcel();
            viewExcel.buildExcelDocument(Collections.singletonMap("fileName", URLEncoder.encode("订单","UTF-8")),workbook,request,response);
            return new ModelAndView(viewExcel,model);
        } catch (Exception e) {
            throw new RuntimeException("excel generate fail:" + e.getMessage(),e);
        }
    }
}
