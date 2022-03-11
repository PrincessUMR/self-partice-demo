package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.thunisoft.excel.core.write.template.ExportXls;
import com.thunisoft.excel.model.ExcelTemplateData;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExportService {
    private final ExportXls exportXls;
    /**
     * 表格导出大表格
     * @param response respose参数
     * @param fileName 文件名称
     */
    public void tableExport(HttpServletResponse response, String fileName) {
        //假数据、
        List<String> rowData = new ArrayList<>();
        rowData.add("1.11");
        rowData.add("8.0");
        rowData.add("1.13");
        rowData.add("8.0");
        rowData.add("1.16");
        rowData.add("8.0");
        rowData.add("1.09");
        rowData.add("8.0");

       //获取数据
       List<List<String>> data = new ArrayList<>();
       data.add(rowData);
       data.add(rowData);
        //多sheet，可以新建多个ExcelTemplateData
        ExcelTemplateData excelTemplateData = new ExcelTemplateData();
        //放入数据
        excelTemplateData.setStandardData(data);
        List<ExcelTemplateData> res = new ArrayList<>();
        res.add(excelTemplateData);
        //调用导出发放 其中fileName为文件名
        exportXls.export(response,res,fileName);
    }
}
