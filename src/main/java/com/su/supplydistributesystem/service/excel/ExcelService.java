package com.su.supplydistributesystem.service.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import java.util.List;

public interface ExcelService {
    HSSFWorkbook generateGoodsExcel(List<GoodsExcelParams> list) throws IOException;

    HSSFWorkbook generateOrderExcel(List<OrderExcelParams> list);
}
