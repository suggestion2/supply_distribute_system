package com.su.supplydistributesystem.serviceImpl;

import com.su.supplydistributesystem.domain.Goods;
import com.su.supplydistributesystem.domain.GoodsSupply;
import com.su.supplydistributesystem.domain.Order;
import com.su.supplydistributesystem.service.excel.ExcelService;
import com.su.supplydistributesystem.service.excel.GoodsExcelParams;
import com.su.supplydistributesystem.service.excel.OrderExcelParams;
import com.sug.core.platform.web.rest.exception.InvalidRequestException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/21.
 */
@Service
public class ExcelServiceImpl implements ExcelService{

    @Override
    public HSSFWorkbook generateGoodsExcel(List<GoodsExcelParams> list) throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("/templates/excelTemplate/goodsTemplate.xls");

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);

        Sheet sheet = hssfWorkbook.getSheetAt(0);

        for(int i = 0;i < list.size();i ++){
            setGoodsCells(list.get(i),sheet,i + 1);
        }

        return hssfWorkbook;
    }

    private void setGoodsCells(GoodsExcelParams params,Sheet sheet,int currentRow) {
        Row row = sheet.getRow(currentRow);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        if(row == null){
            sheet.createRow(currentRow);
            row = sheet.getRow(currentRow);
        }
        List<String> list = generateGoodsCellList(decimalFormat,params);
        for(int i = 0;i < list.size(); i ++){
            Cell cell = row.getCell(i);
            if(cell == null){
                cell = row.createCell(i);
            }
            cell.setCellValue(list.get(i));
        }
    }

    private List<String> generateGoodsCellList(DecimalFormat decimalFormat,GoodsExcelParams params) {
        Goods goods = params.getGoods();
        List<String> list = new ArrayList<>();
        list.add(goods.getNumber());
        list.add(goods.getName());
        list.add(goods.getCategory1());
        list.add(goods.getCategory2());
        list.add(goods.getCategory3());
        list.add(goods.getColour());
        list.add(decimalFormat.format(goods.getTaobaoPrice()));
        list.add(decimalFormat.format(goods.getJdPrice()));
        list.add(decimalFormat.format(goods.getPrice()));
        list.add(decimalFormat.format(goods.getLowSupplyPrice()));
        list.add(decimalFormat.format(goods.getProfit1()));
        list.add(decimalFormat.format(goods.getProfit2()));
        list.add(decimalFormat.format(goods.getProfit3()));
        list.add(String.valueOf(goods.getSalesVolume().intValue()));
        list.add(StringUtils.hasText(goods.getRemarks()) ? goods.getRemarks() : "");

        for(GoodsSupply goodsSupply : params.getList()){
            list.add(goodsSupply.getSupplierName());
            list.add(decimalFormat.format(goodsSupply.getSupplyPrice()));
        }

        return list;
    }



    @Override
    public HSSFWorkbook generateOrderExcel(List<OrderExcelParams> list) {
        /*InputStream inputStream = this.getClass().getResourceAsStream("/templates/excelTemplate/orderTemplate.xls");

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);

        Sheet sheet = hssfWorkbook.getSheetAt(0);

        Row row = sheet.getRow(0);

        int first = row.getFirstCellNum();
        int last = row.getLastCellNum();

        if(first == last){
            throw new InvalidRequestException("ExcelTemplateError","excel模板为空");
        }

        for(int i = 0;i < list.size();i ++){
            row = sheet.getRow(i + 1);
            if(row == null){
                sheet.createRow(i + 1);
                row = sheet.getRow(i + 1);
            }
//            setOrderCells(list.get(i),first,last,row);
        }

        return hssfWorkbook;*/
        return null;
    }

    /*private void setOrderCells(Order order,Integer first,Integer last,Row row) throws Exception {
        List<String> list = generateOrderCellList(order);
        for(int i = first;i < last; i ++){
            Cell cell = row.getCell(i);
            if(cell == null){
                cell = row.createCell(i);
            }
            cell.setCellValue(list.get(i));
        }
    }

    private List<String> generateOrderCellList(Order order) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        List<String> list = new ArrayList<>();
        list.add(order.getNumber());
        list.add(order.getOwnerName());
        list.add(order.getOwnerPhone());
        list.add(order.getOriProvince());
        list.add(order.getOriCity());
        list.add(order.getOriCounty());
        list.add(order.getArrProvince());
        list.add(order.getArrCity());
        list.add(order.getArrCounty());
        list.add(simpleDateFormat.format(order.getLoadTime()));
        list.add(decimalFormat.format(order.getCargoValue()) + "元");
        list.add(decimalFormat.format(order.getOwnerFreight()) + "元");
        list.add(simpleDateFormat.format(order.getCreateTime()));

        return list;
    }*/
}
