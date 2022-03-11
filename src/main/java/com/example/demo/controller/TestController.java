package com.example.demo.controller;


import com.example.demo.entity.RepositoryInfo;
import com.example.demo.entity.jbzbajfk.Brief;
import com.example.demo.entity.jbzbajfk.Data;
import com.example.demo.entity.jbzbajfk.Jbzbajfkxx;
import com.example.demo.entity.jbzbajfk.Resource;
import com.example.demo.mapper.PgnewtestMapper;
import com.example.demo.mapper.RepositoryMapper;
import com.example.demo.mapper.TarRepStockMapper;
import com.example.demo.support.aspect.RoutingAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class TestController {

    @Value("${env.javaHome}")
    private String javaHome;

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @ResponseBody
    @RequestMapping("/hw")
    public String hw(){
        return "";
    }

    @ResponseBody
    @RequestMapping("/javahome")
    public String jh(){
        return ""+javaHome;
    }

    @ResponseBody
    @PostMapping("/interf")
    public String huawei(){
        return "{\n" +
                "    \"totalSize\": 6,\n" +
                "    \"pageNo\": 1,\n" +
                "    \"datas\": [\n" +
                "        {\n" +
                "            \"cpuUsage\": 0.6487564255112375,\n" +
                "            \"vdcLevel1\": \"长宁OA\",\n" +
                "            \"azoneName\": \"上海市长宁区政务云\",\n" +
                "            \"memoryUsage\": 46.21898344371394,\n" +
                "            \"regionName\": \"上海市长宁区\",\n" +
                "            \"diskIoOut\": 0.0011138293415870507,\n" +
                "            \"resourcePoolName\": \"OpenStack_sh-cnxc-1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cpuUsage\": 0.25033333121488494,\n" +
                "            \"vdcLevel1\": \"长宁财务\",\n" +
                "            \"azoneName\": \"上海市长宁区政务云\",\n" +
                "            \"regionName\": \"上海市长宁区\",\n" +
                "            \"resourcePoolName\": \"OpenStack_sh-cnxc-1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cpuUsage\": 1.16949682111486,\n" +
                "            \"vdcLevel1\": \"开发环境\",\n" +
                "            \"azoneName\": \"上海市长宁区政务云\",\n" +
                "            \"memoryUsage\": 50.73255284627279,\n" +
                "            \"regionName\": \"上海市长宁区\",\n" +
                "            \"diskIoOut\": 0.0,\n" +
                "            \"resourcePoolName\": \"OpenStack_sh-cnxc-1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cpuUsage\": 2.3448959465216226,\n" +
                "            \"vdcLevel1\": \"\",\n" +
                "            \"azoneName\": \"上海市长宁区政务云\",\n" +
                "            \"memoryUsage\": 29.26225365532769,\n" +
                "            \"regionName\": \"上海市长宁区\",\n" +
                "            \"diskIoOut\": 0.0,\n" +
                "            \"resourcePoolName\": \"OpenStack_sh-cnxc-1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cpuUsage\": 6.709863901138306,\n" +
                "            \"vdcLevel1\": \"CN_CY_VDC\",\n" +
                "            \"azoneName\": \"上海市长宁区政务云\",\n" +
                "            \"memoryUsage\": 38.92314704259237,\n" +
                "            \"regionName\": \"上海市长宁区\",\n" +
                "            \"diskIoOut\": 0.0,\n" +
                "            \"resourcePoolName\": \"OpenStack_sh-cnxc-1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"cpuUsage\": 3.2377444207668304,\n" +
                "            \"vdcLevel1\": \"CN_FGW_VDC\",\n" +
                "            \"azoneName\": \"上海市长宁区政务云\",\n" +
                "            \"memoryUsage\": 53.9953989982605,\n" +
                "            \"regionName\": \"上海市长宁区\",\n" +
                "            \"diskIoOut\": 0.0,\n" +
                "            \"resourcePoolName\": \"OpenStack_sh-cnxc-1\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"pageSize\": 100\n" +
                "}";
    }

    @ResponseBody
    @GetMapping("/cdjk")
    public String unitTest(){
        return "{\n" +
                "  \"code\": 200,\n" +
                "  \"msg\": \"success\",\n" +
                "  \"content\": " +
                "  {" +
                "   \"total\":1 ,\n" +
                "   \"totalPages\":1 ," +
                "   \"pageSize\":10 ," +
                "   \"pageNum:\":1 ," +
                "   \"list\": " +
                "   [{\"rnum\":1,\n" +
                "\"ajbs\":\"300100001093369\",\n" +
                "\"lxrq\":\"\",\n" +
                "\"zt\":\"办结\",\n" +
                "\"laaymc\":\"侵害商标权和不正当竞争纠纷\",\n" +
                "\"fydm\":\"510100\",\n" +
                "\"ajzt\":\"归档\",\n" +
                "\"ykzxnr\":\"\",\n" +
                "\"ajlb\":\"0301\",\n" +
                "\"dtxp\":\"\",\n" +
                "\"gksl\":\"\",\n" +
                "\"sfsa\":\"\",\n" +
                "\"sfsg\":\"\",\n" +
                "\"sfss\":\"1\",\n" +
                "\"sfst\":\"\",\n" +
                "\"sfsw\":\"2\",\n" +
                "\"mqzz\":\"0\",\n" +
                "\"lb\":\"上抗诉\",\n" +
                "\"saly\":\"当事人起诉\",\n" +
                "\"ssxz\":\"\",\n" +
                "\"sjdwje\":\"\",\n" +
                "\"qxbgcs\":\"\",\n" +
                "\"ycts\":\"0\",\n" +
                "\"ajsj\":\"涉知识产权\",\n" +
                "\"ah\":\"(2021)川0112民初2181号\"}\n" +
                "   ]" +
                "   }" +
                "}";

    }

    @ResponseBody
    @GetMapping("/xmljk")
    public Resource xmlReturn(){
        Resource resource = new Resource();
        resource.setBrief(new Brief(1));
        Data data = new Data();
        List<Jbzbajfkxx> list = new ArrayList<>();
        Jbzbajfkxx jbzbajfkxx = new Jbzbajfkxx();
        jbzbajfkxx.setCBh("cbh11");
        jbzbajfkxx.setCCsmc("cmc");
        jbzbajfkxx.setCFybh("fybh001");
        jbzbajfkxx.setDtCreatetime(new Date());
        jbzbajfkxx.setNJbajfks(1);
        jbzbajfkxx.setDtCssjgxsj(new Date());
        jbzbajfkxx.setNJbajs(2);
        list.add(jbzbajfkxx);
        data.setJbzbajfkxxes(list);
        resource.setData(data);
        return resource;

    }

    @ResponseBody
    @GetMapping(value = "/reqXml",produces = "application/xml")
    public String reqXml(Map<String,String> paramMAP){
        String result =  "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "\n" +
                "<resource xmlns=\"http://dataexchange.court.gov.cn/2009/data\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "    <brief>\n" +
                "        <count>620</count>\n" +
                "    </brief>\n" +
                "    <data>\n";
        for (int i = 1; i <= 620; i++) {
            result +=
                    "        <T_SFZX_SSXF_ZDXFAJHJXX>\n" +
                            "            <C_BH>cbh"+i+"</C_BH>\n" +
                            "            <C_CSMC>传送门查</C_CSMC>\n" +
                            "            <DT_CSSJGXSJ>"+LocalDateTime.now().format(dateTimeFormatter)+"</DT_CSSJGXSJ>\n" +
                            "            <DT_CREATETIME>"+LocalDateTime.now().format(dateTimeFormatter)+"</DT_CREATETIME>\n" +
                            "            <C_FYBH>fybh1551</C_FYBH>\n" +
                            "            <N_GJFYZDXFAJBHJS>235</N_GJFYZDXFAJBHJS>\n" +
                            "            <N_GJFYZDXFAJS>31733</N_GJFYZDXFAJS>\n" +
                            "            <DT_UPDATETIME>"+LocalDateTime.now().format(dateTimeFormatter)+"</DT_UPDATETIME>\n" +
                            "            <N_JZBDZDAJHJS>31680</N_JZBDZDAJHJS>\n" +
                            "            <N_JBZBDZDAJS>31040</N_JBZBDZDAJS>\n" +
                            "            <DT_TJSJ>"+LocalDateTime.now().format(dateTimeFormatter)+"</DT_TJSJ>\n" +
                            "        </T_SFZX_SSXF_ZDXFAJHJXX>\n";

        }
                result +=
                "    </data>\n" +
                "</resource>\n";

        return result;
    }

    @ResponseBody
    @GetMapping("/cdfb")
    public String cdfb(String token,Integer pageSize, Integer pageNum){

        return "{\"code\":200,\"msg\":\"success\",\"content\":{\"total\":10,\"totalPages\":1,\"pageSize\":10,\"list\":[{\"rnum\":1,\"ajbs\":\"300420210301003696\",\"lxrq\":\"20JAN21\",\"zt\":null,\"laaymc\":\"劳动争议\",\"fydm\":null,\"ajzt\":\"归档\",\"ykzxnr\":null,\"ajlb\":\"0301\",\"dtxp\":null,\"gksl\":null,\"sfsa\":null,\"sfsg\":null,\"sfss\":null,\"sfst\":null,\"sfsw\":\"2\",\"mqzz\":\"0\",\"lb\":null,\"saly\":\"当事人起诉\",\"ssxz\":null,\"sjdwje\":null,\"qxbgcs\":null,\"ycts\":null,\"ajsj\":null,\"ah\":\"(2021)川0107民初3640号\"},{\"rnum\":2,\"ajbs\":\"300420210301003696\",\"lxrq\":null,\"zt\":null,\"laaymc\":\"申请诉前财产保全\",\"fydm\":null,\"ajzt\":\"归档\",\"ykzxnr\":null,\"ajlb\":\"0901\",\"dtxp\":null,\"gksl\":null,\"sfsa\":null,\"sfsg\":null,\"sfss\":null,\"sfst\":null,\"sfsw\":\"2\",\"mqzz\":\"0\",\"lb\":null,\"saly\":\"申请人申请\",\"ssxz\":null,\"sjdwje\":null,\"qxbgcs\":null,\"ycts\":null,\"ajsj\":null,\"ah\":\"(2021)川01财保17号\"},{\"rnum\":3,\"ajbs\":\"300520210301001737\",\"lxrq\":null,\"zt\":null,\"laaymc\":\"买卖合同纠纷\",\"fydm\":null,\"ajzt\":\"归档\",\"ykzxnr\":null,\"ajlb\":\"0301\",\"dtxp\":null,\"gksl\":null,\"sfsa\":null,\"sfsg\":null,\"sfss\":null,\"sfst\":null,\"sfsw\":\"2\",\"mqzz\":\"0\",\"lb\":null,\"saly\":\"当事人起诉\",\"ssxz\":null,\"sjdwje\":null,\"qxbgcs\":null,\"ycts\":null,\"ajsj\":null,\"ah\":\"(2021)川0108民初2172号\"},{\"rnum\":4,\"ajbs\":\"300720210301001852\",\"lxrq\":null,\"zt\":null,\"laaymc\":\"融资租赁合同纠纷\",\"fydm\":null,\"ajzt\":\"归档\",\"ykzxnr\":null,\"ajlb\":\"0301\",\"dtxp\":null,\"gksl\":null,\"sfsa\":null,\"sfsg\":null,\"sfss\":null,\"sfst\":null,\"sfsw\":\"2\",\"mqzz\":\"0\",\"lb\":null,\"saly\":\"当事人起诉\",\"ssxz\":null,\"sjdwje\":null,\"qxbgcs\":null,\"ycts\":null,\"ajsj\":null,\"ah\":\"(2021)川0112民初1890号\"},{\"rnum\":5,\"ajbs\":\"300220210409000013\",\"lxrq\":null,\"zt\":null,\"laaymc\":\"罚款\",\"fydm\":null,\"ajzt\":\"归档\",\"ykzxnr\":null,\"ajlb\":\"0409\",\"dtxp\":null,\"gksl\":null,\"sfsa\":null,\"sfsg\":null,\"sfss\":null,\"sfst\":null,\"sfsw\":\"2\",\"mqzz\":\"0\",\"lb\":null,\"saly\":\"行政机关或行政行为权利人申请\",\"ssxz\":null,\"sjdwje\":null,\"qxbgcs\":null,\"ycts\":null,\"ajsj\":null,\"ah\":\"(2021)川0104行审13号\"},{\"rnum\":6,\"ajbs\":\"300220210409000014\",\"lxrq\":null,\"zt\":null,\"laaymc\":\"罚款\",\"fydm\":null,\"ajzt\":\"归档\",\"ykzxnr\":null,\"ajlb\":\"0409\",\"dtxp\":null,\"gksl\":null,\"sfsa\":null,\"sfsg\":null,\"sfss\":null,\"sfst\":null,\"sfsw\":\"2\",\"mqzz\":\"0\",\"lb\":null,\"saly\":\"行政机关或行政行为权利人申请\",\"ssxz\":null,\"sjdwje\":null,\"qxbgcs\":null,\"ycts\":null,\"ajsj\":null,\"ah\":\"(2021)川0104行审14号\"},{\"rnum\":7,\"ajbs\":\"300220210409000015\",\"lxrq\":null,\"zt\":null,\"laaymc\":\"罚款\",\"fydm\":null,\"ajzt\":\"归档\",\"ykzxnr\":null,\"ajlb\":\"0409\",\"dtxp\":null,\"gksl\":null,\"sfsa\":null,\"sfsg\":null,\"sfss\":null,\"sfst\":null,\"sfsw\":\"2\",\"mqzz\":\"0\",\"lb\":null,\"saly\":\"行政机关或行政行为权利人申请\",\"ssxz\":null,\"sjdwje\":null,\"qxbgcs\":null,\"ycts\":null,\"ajsj\":null,\"ah\":\"(2021)川0104行审15号\"},{\"rnum\":8,\"ajbs\":\"301620210301000188\",\"lxrq\":null,\"zt\":null,\"laaymc\":\"买卖合同纠纷\",\"fydm\":null,\"ajzt\":\"归档\",\"ykzxnr\":null,\"ajlb\":\"0301\",\"dtxp\":null,\"gksl\":null,\"sfsa\":null,\"sfsg\":null,\"sfss\":null,\"sfst\":null,\"sfsw\":\"2\",\"mqzz\":\"0\",\"lb\":null,\"saly\":\"当事人起诉\",\"ssxz\":null,\"sjdwje\":null,\"qxbgcs\":null,\"ycts\":null,\"ajsj\":null,\"ah\":\"(2021)川0182民初181号\"},{\"rnum\":9,\"ajbs\":\"300220219901000825\",\"lxrq\":null,\"zt\":null,\"laaymc\":\"民间借贷纠纷\",\"fydm\":null,\"ajzt\":\"结案\",\"ykzxnr\":null,\"ajlb\":\"9901\",\"dtxp\":null,\"gksl\":null,\"sfsa\":null,\"sfsg\":null,\"sfss\":\"0\",\"sfst\":null,\"sfsw\":\"2\",\"mqzz\":null,\"lb\":null,\"saly\":null,\"ssxz\":null,\"sjdwje\":null,\"qxbgcs\":null,\"ycts\":null,\"ajsj\":null,\"ah\":\"(2021)川0104民诉前调801号\"},{\"rnum\":10,\"ajbs\":\"300420210301003684\",\"lxrq\":null,\"zt\":null,\"laaymc\":\"买卖合同纠纷\",\"fydm\":null,\"ajzt\":\"归档\",\"ykzxnr\":null,\"ajlb\":\"0301\",\"dtxp\":null,\"gksl\":null,\"sfsa\":null,\"sfsg\":null,\"sfss\":null,\"sfst\":null,\"sfsw\":\"2\",\"mqzz\":\"0\",\"lb\":null,\"saly\":\"当事人起诉\",\"ssxz\":null,\"sjdwje\":null,\"qxbgcs\":null,\"ycts\":null,\"ajsj\":null,\"ah\":\"(2021)川0107民初3627号\"}],\"pageNum\":1}}";
    }
}
