package com.thunisoft.excel.core.write;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import com.thunisoft.excel.model.SheetInformation;

import lombok.extern.slf4j.Slf4j;

/**
 * <p> Description: </p >
 * <p> CreationTime: 2021/1/19 18:06
 * <br>Copyright: 2021 < a href=" ">Thunisoft</ a>
 * <br>Email: < a href="mailto:jinbo-1@thunisoft.com">jinbo-1@thunisoft.com</ a></p >
 *
 * @author jinbo
 * @version 1.0
 */
@Slf4j
public class CommonExportXls {

    private static Map<Short,HSSFCellStyle> backgroundStyleContainer = new HashMap<>();

    /**
     * 设置内容样式
     *
     * @param wb               表格HSSFWorkbook对象
     * @param sheet            表格HSSFSheet对象
     * @param size             表格数据行数
     * @param cell             列的第几个格子
     * @param sheetInformation 表格对象
     */
    public static void setFormContentStyle(HSSFWorkbook wb, HSSFSheet sheet, int size, int cell,
            SheetInformation sheetInformation) {
        HSSFCellStyle style = getHssfCellStyle(wb);
        Map<Integer, Integer> columnWidthInformation = sheetInformation.getColumnWidthInformation();
        for (int i = 0; i < columnWidthInformation.size(); i++) {
            sheet.setColumnWidth(i, columnWidthInformation.get(i));
        }
        for (int i = 0; i < size; i++) {
            HSSFRow row = sheet.createRow(i);
            Short height = sheetInformation.getRowHeightInformation().get(i);
            if (height != null && height != 0) {
                row.setHeight(height);
            }
            if(sheetInformation.getCellBackgroundColor() != null){
                Map<Integer, Short> backgroundColorCells = sheetInformation.getCellBackgroundColor().get(i);
                for (int j = 0; j <= cell; j++) {
                    HSSFCellStyle styleBackground = getHssfCellStyle(wb);
                    if (backgroundColorCells != null && backgroundColorCells.get(j) != null) {
                        styleBackground.setFillForegroundColor(backgroundColorCells.get(j));
                    }
                    row.createCell(j).setCellStyle(styleBackground);
                }
            } else {
                for (int j = 0; j <= cell; j++) {
                    row.createCell(j).setCellStyle(style);
                }
            }
        }
    }

    private static HSSFCellStyle getHssfCellStyle(HSSFWorkbook wb) {
        HSSFCellStyle style = wb.createCellStyle();
        style.setWrapText(true);
        //设置表格边框样式
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        //水平居中
        style.setAlignment(HorizontalAlignment.CENTER);
        //垂直居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setFillBackgroundColor(IndexedColors.WHITE.getIndex());
        return style;
    }

    private static HSSFCellStyle getHssfCellStyleWithColor(HSSFWorkbook wb,Short color) {
        HSSFCellStyle style = wb.createCellStyle();
        style.setWrapText(true);
        //设置表格边框样式
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        //水平居中
        style.setAlignment(HorizontalAlignment.CENTER);
        //垂直居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFillForegroundColor(color);
        return style;
    }

    /**
     * 文件传输
     *
     * @param response response对象
     * @param wb       HSSFWorkbook对象
     * @param formName 表格名称
     */
    public static void fileTransmission(HttpServletResponse response, HSSFWorkbook wb, String formName) {
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        String name = new String(formName.getBytes(), StandardCharsets.ISO_8859_1);
        response.setHeader("Content-disposition", "attachment;filename=" + name);
        try {
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (IOException e) {
            log.error("下载表格异常:{}", e.getMessage(), e);
        }
    }

    private static HSSFCellStyle getStyle(HSSFCellStyle style){
        if (!backgroundStyleContainer.containsKey(style)) {
        }
        return backgroundStyleContainer.get(style);
    }
}
