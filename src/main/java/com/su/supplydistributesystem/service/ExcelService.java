package com.su.supplydistributesystem.service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import java.util.List;

public interface ExcelService {
    HSSFWorkbook generateGoodsExcel(List<GoodsDetailParams> list) throws IOException;

    HSSFWorkbook generateOrderExcel(List<OrderDetailParams> list) throws IOException;
}
