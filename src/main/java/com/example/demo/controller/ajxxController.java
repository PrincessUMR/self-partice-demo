package com.example.demo.controller;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.YnFbxxParams;
import com.fasterxml.jackson.databind.util.JSONPObject;


@CrossOrigin
@Controller
public class ajxxController {

    @ResponseBody
    @PostMapping("/trialAJXX")
    public String trialAJXX(Integer pageSize, Integer startPage,@RequestBody String  lastModifiedTime){
        StringBuilder sb = new StringBuilder("{\n" +
                "  count: \"181234\",\n" +
                "  data: [\n");
        List list = new ArrayList<String>();
        for (int i = 0; i < 181234; i++) {
            String data = "    {\n" +
                    "      \"cbh\": \"ajbh1000"+i+"\",\n" +
                    "      \"cah\": \"100\",\n" +
                    "      \"cjbfy\": \"经办法院\",\n" +
                    "      \"csfdtxp\": \"是否当庭宣判\",\n" +
                    "      \"cajlb\": \"案件类别\",\n" +
                    "      \"cajzlb\": \"案件子类别\",\n" +
                    "      \"claspyj\": \"立案审批意见\",\n" +
                    "      \"dsxrq\": \"2021-04-01\",\n" +
                    "      \"csfss\": \"1\",\n" +
                    "      \"cskslx\": \"上抗诉类型\",\n" +
                    "      \"csycx\": \"适用程序\",\n" +
                    "      \"csfsc\": \"是否速裁\",\n" +
                    "      \"cfhcsyy\": \"发回重审原因\",\n" +
                    "      \"csfktsl\": \"是否开庭审理\",\n" +
                    "      \"nkcts\": \"15\",\n" +
                    "      \"nycts\": \"2\",\n" +
                    "      \"csfzz\": \"是否中止\",\n" +
                    "      \"cgsjg\": \"公诉机关\",\n" +
                    "      \"dssajjsrq\": \"2020-12-14\",\n" +
                    "      \"csftqfdmsss\": \"是否提起附带民事诉讼\",\n" +
                    "      \"ccpwsjykzxnr\": \"裁判文书具有可执行内容\",\n" +
                    "      \"cssyy\": \"上诉原因\",\n" +
                    "      \"dzhgxsj\": \"2021-04-09 12:54:37\"\n" +
                    "    },\n";
            list.add(data);
        }
        if(startPage==null){
            JSONObject json = JSON.parseObject(lastModifiedTime);
            startPage = (Integer) json.get("startPage");
            pageSize = (Integer) json.get("pageSize");
        }
        list = list.subList((startPage-1)*pageSize,((startPage-1)*pageSize)+pageSize>= list.size()? list.size():((startPage-1)*pageSize)+pageSize);
        list.forEach(node -> {
            sb.append(node);
        });
                String result = sb.substring(0,sb.length()-2);
        result+="  ]\n" +
                "}\n";
                return result;
    }

    @ResponseBody
    @PostMapping("/executingAJXX")
    public String executingAJXX(Integer pageSize, Integer startPage,@RequestBody String  body){
        StringBuilder sb = new StringBuilder("{\n" +
                "  count: \"150\",\n" +
                "  data: [\n");
        List list = new ArrayList<String>();
        for (int i = 0; i < 150; i++) {
            String data = "    {\n" +
                    "      \"cbh\": \""+i+"\",\n" +
                    "      \"cah\": \"002\",\n" +
                    "      \"cjbfy\": \"经办法院\",\n" +
                    "      \"cajzlb\": \"案件子类别\",\n" +
                    "      \"nycts\": \"3\",\n" +
                    "      \"nsqzxbdje\": \"114411\",\n" +
                    "      \"nsjdwje\": \"155411\",\n" +
                    "      \"dzhgxsj\": \""+DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())+"\"\n" +
                    "    },\n";
            list.add(data);
        }
        if(startPage==null){
            JSONObject json = JSON.parseObject(body);
            startPage = Integer.parseInt(String.valueOf(json.get("startPage")));
            pageSize = Integer.parseInt(String.valueOf(json.get("pageSize")));
        }
        list = list.subList((startPage-1)*pageSize,((startPage-1)*pageSize)+pageSize>= list.size()? list.size():((startPage-1)*pageSize)+pageSize);
        list.forEach(node -> {
            sb.append(node);
        });
        String result = sb.substring(0,sb.length()-2);
        result+="  ]\n" +
                "}\n";
        return result;
    }

    @ResponseBody
    @PostMapping("/courtMemberInfo")
    public String courtMemberInfo(){
        return "{\n" +
                "  count: \"1\",\n" +
                "  data: [\n" +
                "    {\n" +
                "      \"czw\": \"职务\",\n" +
                "      \"cbh\": \"pep"+new Date().getTime()+"001\",\n" +
                "      \"cfy\": \"法院\",\n" +
                "      \"cbm\": \"部门/机构\",\n" +
                "      \"csfyx\": \"是否有效\",\n" +
                "      \"dzhgxsj\": \""+DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())+"\"\n" +
                "    }\n" +
                "    ,{\n" +
                "      \"czw\": \"职务\",\n" +
                "      \"cbh\": \"pep"+new Date().getTime()+"002\",\n" +
                "      \"cfy\": \"法院\",\n" +
                "      \"cbm\": \"部门/机构\",\n" +
                "      \"csfyx\": \"是否有效\",\n" +
                "      \"dzhgxsj\": \""+DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())+"\"\n" +
                "    }\n" +
                "    ,{\n" +
                "      \"czw\": \"职务\",\n" +
                "      \"cbh\": \"pep"+new Date().getTime()+"003\",\n" +
                "      \"cfy\": \"法院\",\n" +
                "      \"cbm\": \"部门/机构\",\n" +
                "      \"csfyx\": \"是否有效\",\n" +
                "      \"dzhgxsj\": \""+DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())+"\"\n" +
                "    }\n" +
                "  ]\n" +
                "}\n";
    }

    @ResponseBody
    @PostMapping("/trialLitigant")
    public String trialLitigant(){
        return "{\n" +
                "  count: \"1\",\n" +
                "  data: []\n" +
                "}\n";
    }

    @ResponseBody
    @PostMapping("/compensateInfo")
    public String compensateInfo(){
        return "{\n" +
                "  count: \"1\",\n" +
                "  data: [\n" +
                "    {\n" +
                "      \"cbh\": \""+new Date().getTime()+"005\",\n" +
                "      \"cajbh\": \"案件编号/赔偿义务机关所属案件\",\n" +
                "      \"cah\": \"案号\",\n" +
                "      \"cjbfy\": \"经办法院\",\n" +
                "      \"cpcywjglx\": \"赔偿义务机关类型\",\n" +
                "      \"dzhgxsj\": \""+DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())+"\"\n" +
                "    }\n" +
                "  ]\n" +
                "}\n";
    }

    @ResponseBody
    @PostMapping("/eventContinue")
    public String eventContinue(){
        return "{\n" +
                "  count: \"1\",\n" +
                "  data: [\n" +
                "    {\n" +
                "      \"cbh\": \""+new Date().getTime()+"006\",\n" +
                "      \"cdqajbh\": \"当前案件编号/当前案件信息主键\",\n" +
                "      \"cdqajah\": \"当前案件案号\",\n" +
                "      \"cdqajjbfy\": \"当前案件经办法院\",\n" +
                "      \"cdqajajzlb\": \"当前案件案件子类别\",\n" +
                "      \"cajbh\": \"案件编号/后续案件所属案件\",\n" +
                "      \"dhxjarq\": \""+DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now())+"\" ,\n" +
                "      \"chxajzlb\": \"后续案件子类别\",\n" +
                "      \"chxjafs\": \"后续结案方式\",\n" +
                "      \"chxah\": \"后续案号\",\n" +
                "      \"chxajjbfy\": \"后续案件经办法院\",\n" +
                "      \"chxgpyy\": \"后续改判原因\",\n" +
                "      \"cfhcsyy\": \"发回重审原因\",\n" +
                "      \"dhxlarq\": \""+ LocalDate.now().minusDays((int)Math.random()*100)+"\",\n" +
                "      \"dzhgxsj\": \""+DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())+"\"\n" +
                "    }\n" +
                "  ]\n" +
                "}\n";
    }

    @ResponseBody
    @PostMapping("/splitEvenTrial")
    public String splitEvenTrial(Integer pageSize, Integer startPage){
        return "{\n" +
                "  count: \"1\",\n" +
                "  data: [\n" +
                "{\n" +
                "      \"cstm\": \""+new Date().getTime()+"007\",\n" +
                "      \"cajbh\": \"案件编号/扣除审限所属案件\",\n" +
                "      \"cah\": \"案号\",\n" +
                "      \"cjbfy\": \"经办法院\",\n" +
                "      \"ckcsxlx\": \"扣除审限类型\",\n" +
                "      \"ckskcsxsfsx\": \"开始扣除审限是否生效\",\n" +
                "      \"cspzt\": \"审批状态\",\n" +
                "      \"cksbz\": \"扣审备注\",\n" +
                "      \"dzhgxsj\": \""+DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now())+"\"\n" +
                "    }\n" +
                "  ]\n" +
                "}\n";
    }

    @ResponseBody
    @PostMapping("/trailPreCheckInfo")
    public String trailPreCheckInfo(){
        return "{\n" +
                "  count: \"1\",\n" +
                "  data: [\n" +
                "    {\"cah\":\"\\u00282011\\u0029玉中刑初字第14号\",\"cajbh\":\"338800000000195\",\"cbh\":\"1\",\"cftyt\":\"15_000046-1\",\"cjbfy\":\"532300\",\"dydkssj\":\"2012-03-13 09:00:00\",\"dzhgxsj\":\"2016-10-14 20:25:28\"}" +
                "  ]\n" +
                "}\n";
    }

    @ResponseBody
    @PostMapping("/trailStartInfo")
    public String trailStartInfo(Integer pageSize, Integer startPage,Date lastModifiedTime){
        StringBuilder sb =  new StringBuilder("{\n" +
                "  count: \"2560\",\n" +
                "  data: [\n");
        List list = new ArrayList<String>();
        for (int i = 0; i < 2560; i++) {
            String data = "    {\n" +
                    "      \"cbh\": \"01\",\n" +
                    "      \"cajbh\": \"bh"+i+"\",\n" +
                    "      \"cah\": \"案号\",\n" +
                    "      \"cjbfy\": \"经办法院\",\n" +
                    "      \"cxpqk\": \"宣判情况\",\n" +
                    "      \"dzhgxsj\": \""+DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now().minusDays(3))+"\"\n" +
                    "    },\n";
            list.add(data);
        }
        list = list.subList((startPage-1)*pageSize,((startPage-1)*pageSize)+pageSize>= list.size()? list.size():((startPage-1)*pageSize)+pageSize);
        list.forEach(node -> {
            sb.append(node);
        });
        String result = sb.substring(0,sb.length()-2);
        result+="  ]\n" +
                "}\n";
        return result;
    }

    @ResponseBody
    @PostMapping("/shcnEip")
    public String shcnEip(){
        return "{\n" +
                "    \"totalSize\": 7,\n" +
                "    \"pageNo\": 1,\n" +
                "    \"datas\": [\n" +
                "        {\n" +
                "            \"count1\": 371.0,\n" +
                "            \"vdcLevel1\": \"长宁OA\",\n" +
                "            \"regionName\": \"上海市长宁区\",\n" +
                "            \"name\": \"长宁OA\",\n" +
                "            \"resourcePoolName\": \"OpenStack_sh-cnxc-1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"count1\": 105.0,\n" +
                "            \"vdcLevel1\": \"CN_ZZB_VDC\",\n" +
                "            \"regionName\": \"上海市长宁区\",\n" +
                "            \"name\": \"CN_ZZB_VDC\",\n" +
                "            \"resourcePoolName\": \"OpenStack_sh-cnxc-1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"count1\": 59.0,\n" +
                "            \"vdcLevel1\": \"CNXC_QFB_VDC\",\n" +
                "            \"regionName\": \"上海市长宁区\",\n" +
                "            \"name\": \"CNXC_QFB_VDC\",\n" +
                "            \"resourcePoolName\": \"OpenStack_sh-cnxc-1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"count1\": 28.0,\n" +
                "            \"vdcLevel1\": \"CN_CY_VDC\",\n" +
                "            \"regionName\": \"上海市长宁区\",\n" +
                "            \"name\": \"CN_CY_VDC\",\n" +
                "            \"resourcePoolName\": \"OpenStack_sh-cnxc-1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"count1\": 22.0,\n" +
                "            \"vdcLevel1\": \"开发环境\",\n" +
                "            \"regionName\": \"上海市长宁区\",\n" +
                "            \"name\": \"开发环境\",\n" +
                "            \"resourcePoolName\": \"OpenStack_sh-cnxc-1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"count1\": 14.0,\n" +
                "            \"vdcLevel1\": \"CN_FGW_VDC\",\n" +
                "            \"regionName\": \"上海市长宁区\",\n" +
                "            \"name\": \"CN_FGW_VDC\",\n" +
                "            \"resourcePoolName\": \"OpenStack_sh-cnxc-1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"count1\": 7.0,\n" +
                "            \"vdcLevel1\": \"CN_BMJ_VDC\",\n" +
                "            \"regionName\": \"上海市长宁区\",\n" +
                "            \"name\": \"CN_BMJ_VDC\",\n" +
                "            \"resourcePoolName\": \"OpenStack_sh-cnxc-1\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"pageSize\": 100\n" +
                "}";
    }

    @ResponseBody
    @PostMapping("shcnMCHypervisor")
    public String shcnMCHypervisor(){
        return "{\n" +
                "    \"totalSize\": 9,\n" +
                "    \"pageNo\": 1,\n" +
                "    \"datas\": [\n" +
                "        {\n" +
                "            \"vcpusLeft\": 588.0,\n" +
                "            \"azoneName\": \"上海市长宁区政务云\",\n" +
                "            \"memory\": 6598.621520996094,\n" +
                "            \"vcpusUsed\": 560.0,\n" +
                "            \"memoryLeft\": 4260.40234375,\n" +
                "            \"regionName\": \"上海市长宁区\",\n" +
                "            \"manageFlagName\": \"管理\",\n" +
                "            \"memoryUsed\": 2338.2183227539062,\n" +
                "            \"vcpus\": 1148.0,\n" +
                "            \"resourcePoolName\": \"OpenStack_sh-cnxc-1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"vcpusLeft\": 17326.0,\n" +
                "            \"azoneName\": \"上海市长宁区政务云\",\n" +
                "            \"memory\": 36396.9580078125,\n" +
                "            \"vcpusUsed\": 8504.0,\n" +
                "            \"memoryLeft\": 19171.9482421875,\n" +
                "            \"regionName\": \"上海市长宁区\",\n" +
                "            \"manageFlagName\": \"非管理\",\n" +
                "            \"memoryUsed\": 17225.009765625,\n" +
                "            \"vcpus\": 25830.0,\n" +
                "            \"resourcePoolName\": \"OpenStack_sh-cnxc-1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"vcpusLeft\": 5558.0,\n" +
                "            \"azoneName\": \"manage-az\",\n" +
                "            \"memory\": 21892.03515625,\n" +
                "            \"vcpusUsed\": 2128.0,\n" +
                "            \"memoryLeft\": 16907.9462890625,\n" +
                "            \"regionName\": \"上海市长宁区\",\n" +
                "            \"manageFlagName\": \"管理\",\n" +
                "            \"memoryUsed\": 4984.0888671875,\n" +
                "            \"vcpus\": 7686.0,\n" +
                "            \"resourcePoolName\": \"OpenStack_sh-cnxc-1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"vcpusLeft\": 24525.0,\n" +
                "            \"azoneName\": \"上海市长宁区政务云_X86资源池\",\n" +
                "            \"memory\": 26863.8427734375,\n" +
                "            \"vcpusUsed\": 2025.0,\n" +
                "            \"memoryLeft\": 20584.6923828125,\n" +
                "            \"regionName\": \"上海市长宁区\",\n" +
                "            \"manageFlagName\": \"非管理\",\n" +
                "            \"memoryUsed\": 6279.150390625,\n" +
                "            \"vcpus\": 26550.0,\n" +
                "            \"resourcePoolName\": \"OpenStack_sh-cnxc-1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"vcpusLeft\": 5490.0,\n" +
                "            \"azoneName\": \"az3.dc3\",\n" +
                "            \"memory\": 5477.7685546875,\n" +
                "            \"vcpusUsed\": 0.0,\n" +
                "            \"memoryLeft\": 5477.7685546875,\n" +
                "            \"regionName\": \"上海市长宁区\",\n" +
                "            \"manageFlagName\": \"非管理\",\n" +
                "            \"memoryUsed\": 0.0,\n" +
                "            \"vcpus\": 5490.0,\n" +
                "            \"resourcePoolName\": \"OpenStack_sh-cnxc-1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"vcpusLeft\": 3556.0,\n" +
                "            \"azoneName\": \"az1.gov\",\n" +
                "            \"memory\": 44142.45458984375,\n" +
                "            \"vcpusUsed\": 15722.0,\n" +
                "            \"memoryLeft\": 5930.829895019531,\n" +
                "            \"regionName\": \"cloud_az1_gov\",\n" +
                "            \"manageFlagName\": \"非管理\",\n" +
                "            \"memoryUsed\": 38211.6123046875,\n" +
                "            \"vcpus\": 19278.0,\n" +
                "            \"resourcePoolName\": \"OpenStack_cucc-gov\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"vcpusLeft\": 1610.0,\n" +
                "            \"azoneName\": \"manage-az\",\n" +
                "            \"memory\": 12600.333251953125,\n" +
                "            \"vcpusUsed\": 2674.0,\n" +
                "            \"memoryLeft\": 6642.022888183594,\n" +
                "            \"regionName\": \"cloud_az1_gov\",\n" +
                "            \"manageFlagName\": \"管理\",\n" +
                "            \"memoryUsed\": 5958.3125,\n" +
                "            \"vcpus\": 4284.0,\n" +
                "            \"resourcePoolName\": \"OpenStack_cucc-gov\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"vcpusLeft\": 2660.0,\n" +
                "            \"azoneName\": \"az1.int\",\n" +
                "            \"memory\": 14723.48486328125,\n" +
                "            \"vcpusUsed\": 3766.0,\n" +
                "            \"memoryLeft\": 3976.9360961914062,\n" +
                "            \"regionName\": \"cloud_az1_int\",\n" +
                "            \"manageFlagName\": \"非管理\",\n" +
                "            \"memoryUsed\": 10746.544067382812,\n" +
                "            \"vcpus\": 6426.0,\n" +
                "            \"resourcePoolName\": \"OpenStack_cucc-int\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"vcpusLeft\": 2422.0,\n" +
                "            \"azoneName\": \"manage-az\",\n" +
                "            \"memory\": 12740.333251953125,\n" +
                "            \"vcpusUsed\": 1862.0,\n" +
                "            \"memoryLeft\": 9037.021362304688,\n" +
                "            \"regionName\": \"cloud_az1_int\",\n" +
                "            \"manageFlagName\": \"管理\",\n" +
                "            \"memoryUsed\": 3703.314453125,\n" +
                "            \"vcpus\": 4284.0,\n" +
                "            \"resourcePoolName\": \"OpenStack_cucc-int\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"pageSize\": 100\n" +
                "}";
    }
}
