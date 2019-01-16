package com.su.supplydistributesystem.response;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.Map;

public class ViewExcel extends AbstractXlsView {

    @Override
    public void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws Exception {
        String filename = map.get("fileName").toString() + ".xls";//设置下载时客户端Excel的名称
        httpServletResponse.setContentType("application/vnd.ms-excel");
        httpServletResponse.setHeader("Content-disposition", "attachment;filename=" + filename);
        OutputStream outputStream = httpServletResponse.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }
}