package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.example.demo.entity.CaseDetail;
import com.thunisoft.excel.core.write.annotation.AnnotationExcelExport;
import com.thunisoft.excel.model.ExcelData;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CaseListService {
 private final AnnotationExcelExport<CaseDetail> annotationExcelExport;
    /**
     * 导出案件详情EXCEL
     * @param response         http信息
     */
    public void exportTest(HttpServletResponse response){
        //获取数据
        List<CaseDetail> caseDetailData = new ArrayList<>();
        //构建导出对象
        ExcelData<CaseDetail> excelData = new ExcelData<>();
        excelData.setClassType(CaseDetail.class);
        excelData.setData(caseDetailData);
        //调用导出方法
        annotationExcelExport.export(response, excelData, "xx");
    }
}
