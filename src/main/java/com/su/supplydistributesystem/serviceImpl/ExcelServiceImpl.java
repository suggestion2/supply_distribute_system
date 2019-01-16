package com.su.supplydistributesystem.serviceImpl;

import com.su.supplydistributesystem.domain.Goods;
import com.su.supplydistributesystem.domain.GoodsSupply;
import com.su.supplydistributesystem.domain.Order;
import com.su.supplydistributesystem.domain.OrderItem;
import com.su.supplydistributesystem.service.ExcelService;
import com.su.supplydistributesystem.service.GoodsDetailParams;
import com.su.supplydistributesystem.service.OrderDetailParams;
import com.sug.core.platform.web.rest.exception.InvalidRequestException;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
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
    public HSSFWorkbook generateGoodsExcel(List<GoodsDetailParams> list) throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("/templates/excelTemplate/goodsTemplate.xls");

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);

        Sheet sheet = hssfWorkbook.getSheetAt(0);

        for(int i = 0;i < list.size();i ++){
            setGoodsCells(list.get(i),sheet,i + 1);
        }

        return hssfWorkbook;
    }

    private void setGoodsCells(GoodsDetailParams params,Sheet sheet,int currentRow) {
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

    private List<String> generateGoodsCellList(DecimalFormat decimalFormat,GoodsDetailParams params) {
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
    public HSSFWorkbook generateOrderExcel(List<OrderDetailParams> list) throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("/templates/excelTemplate/orderTemplate.xls");

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);

        Sheet sheet = hssfWorkbook.getSheetAt(0);

        int currentRow = 3;

        for (OrderDetailParams params : list) {
            currentRow = setOrderCells(params, sheet, currentRow);
        }

        return hssfWorkbook;
    }

    private int setOrderCells(OrderDetailParams params,Sheet sheet,int currentRow) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Row row = sheet.getRow(currentRow);
        if(row == null){
            sheet.createRow(currentRow);
            row = sheet.getRow(currentRow);
        }
        List<String> list = generateOrderCellList(simpleDateFormat,decimalFormat,params.getOrder());
        for(int i = 0;i < list.size(); i ++){
            Cell cell = row.getCell(i);
            if(cell == null){
                cell = row.createCell(i);
            }
            cell.setCellValue(list.get(i));
        }
        for(int i = 0;i < params.getList().size(); i ++){
            currentRow ++;
            row = sheet.getRow(currentRow);
            if(row == null){
                sheet.createRow(currentRow);
                row = sheet.getRow(currentRow);
            }
            List<String> itemList = generateOrderItemCellList(decimalFormat,params.getList().get(i));
            for(int j = 0;j < itemList.size(); j ++){
                Cell cell = row.getCell(j);
                if(cell == null){
                    cell = row.createCell(j);
                }
                cell.setCellValue(j==0? String.valueOf(i + 1) : itemList.get(j));
            }
        }
        
        return currentRow + 2;
    }

    private List<String> generateOrderCellList(SimpleDateFormat simpleDateFormat,DecimalFormat decimalFormat,Order order) {
        List<String> list = new ArrayList<>();
        list.add(order.getNumber());
        list.add(order.getGoodsNames());
        list.add(order.getDistributorName());
        list.add(order.getDistributorPhone());
        list.add(order.getCustomerName());
        list.add(order.getCustomerAddress());
        list.add(order.getCustomerPhone());
        list.add(order.getDispatchCompany());
        list.add(order.getDispatchNumber());
        list.add(String.valueOf(order.getCount().intValue()));
        list.add(decimalFormat.format(order.getAmount()));
        list.add(decimalFormat.format(order.getProfit1()));
        list.add(decimalFormat.format(order.getProfit2()));
        list.add(decimalFormat.format(order.getProfit3()));
        list.add(simpleDateFormat.format(order.getCreateTime()));
        list.add(StringUtils.hasText(order.getRemarks()) ? order.getRemarks() : "");
        return list;
    }

    private List<String> generateOrderItemCellList(DecimalFormat decimalFormat,OrderItem orderItem) {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(orderItem.getGoodsName());
        list.add(orderItem.getSupplierName());
        list.add(decimalFormat.format(orderItem.getTaobaoPrice()));
        list.add(decimalFormat.format(orderItem.getJdPrice()));
        list.add(decimalFormat.format(orderItem.getPrice()));
        list.add(decimalFormat.format(orderItem.getSupplyPrice()));
        list.add(String.valueOf(orderItem.getCount().intValue()));
        list.add(decimalFormat.format(orderItem.getAmount()));
        list.add(decimalFormat.format(orderItem.getProfit1()));
        list.add(decimalFormat.format(orderItem.getProfit2()));
        list.add(decimalFormat.format(orderItem.getProfit3()));
        return list;
    }
}
