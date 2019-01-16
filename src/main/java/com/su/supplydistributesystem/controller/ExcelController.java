package com.su.supplydistributesystem.controller;

import com.su.supplydistributesystem.interceptor.UserLoginRequired;
import com.su.supplydistributesystem.response.ViewExcel;
import com.su.supplydistributesystem.service.GoodsService;
import com.su.supplydistributesystem.service.excel.ExcelService;
import com.su.supplydistributesystem.service.excel.GoodsExcelParams;
import com.sug.core.platform.exception.ResourceNotFoundException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/management/excel")
@UserLoginRequired
public class ExcelController {
    @Autowired
    private ExcelService excelService;

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value="/goods", method = RequestMethod.GET)
    public ModelAndView goodsExcel(ModelMap model, HttpServletRequest request, HttpServletResponse response){
        List<GoodsExcelParams> goodsExcelParamsList = goodsService.getExcelList(null);
        try {
            HSSFWorkbook workbook = excelService.generateGoodsExcel(goodsExcelParamsList);
            ViewExcel viewExcel = new ViewExcel();
            viewExcel.buildExcelDocument(Collections.singletonMap("fileName", URLEncoder.encode("商品","UTF-8")),workbook,request,response);
            return new ModelAndView(viewExcel,model);
        } catch (Exception e) {
            throw new RuntimeException("excel generate fail:" + e.getMessage(),e);
        }
    }
}
