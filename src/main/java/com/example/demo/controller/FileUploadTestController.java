package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.CaseListService;
import com.example.demo.service.ExportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@CrossOrigin
@Api(tags = "导入接口")
@RequestMapping("/api/import")
public class FileUploadTestController {

    @Autowired
    private CaseListService caseListService;

    @Autowired
    private ExportService exportService;

    @PostMapping("/uploadTest")
    @ApiOperation("upload test")
    public String upload(@RequestParam(value = "file", required = true) MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        return originalFilename;
    }

    /**
     * 导出指标
     *
     * @return 指标Excel
     */
    @PostMapping("/indicator")
    @ApiOperation("导出指标")
    @ApiResponses({
            @ApiResponse(code = 200, message = "导出指标成功！"),
            @ApiResponse(code = 500, message = "导出指标失败！")
    })
    public void exportIndicator(HttpServletResponse httpServletResponse)  {
        exportService.tableExport(httpServletResponse,"exp");
    }

}
