package com.example.demo.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thunisoft.excel.model.Excel;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Excel(name = "明细数据")
public class CaseDetail {
    @ApiModelProperty("部门受案号")
    @Excel(name = "部门受案号", width = 10000, defaultValue = "--")
    private String deptCase;
    @Excel(name = "案件名称", width = 10000)
    @ApiModelProperty("案件名称")
    private String caseName;
    @Excel(name = "承办单位")
    @ApiModelProperty("承办单位名称")
    private String corpName;
    @ApiModelProperty("案件类别id")
    private String caseType;
    @Excel(name = "案件类别")
    @ApiModelProperty("案件类别名称")
    private String caseTypeName;
    @ApiModelProperty("承办部门id")
    private String dept;
    @Excel(name = "承办部门")
    @ApiModelProperty("承办部门名称")
    private String deptName;
    @Excel(name = "嫌疑人姓名")
    @ApiModelProperty("嫌疑人姓名")
    private String suspectName;
    @JsonIgnore
    @ApiModelProperty("统计期")
    private String timeList;
    @Excel(name = "统计期", column = 0, width = 150,dateFormat = "YYYY-MM")
    @ApiModelProperty("统计期")
    private Date period;
}
