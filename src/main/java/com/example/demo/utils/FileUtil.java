package com.example.demo.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileUtil implements Runnable{

    private String filePath = "E:\\utils\\dev\\logAnalysisUtilResource\\np统计访问日志\\host.access.202111day.log";//////

    public  static  List<String> formIds = new ArrayList<>();

    public static final String targetFormId = "e5a939a7c806375e451c33a01528e98c";

    public static final String timePrefix = "Nov/2021:";

    public static final Map< String,Map<String,Map<String,Integer>>> totalResult = new HashMap<>();

    public static final Map<String,Map<String,Integer>> totalCount = new HashMap<>();
    public static final Map<String,Map<String,Integer>> totalHPC = new HashMap<>();
    public static final Map<String,Map<String,String>> totalHPCKEY = new HashMap<>();

    public static void main(String[] args) throws IOException {
        formIds.add("99c57a659a86d6af4e8536bb9b4a9100");
        formIds.add("14a81ade9c4f0162dd6834d59b36e450");
        formIds.add("00069dc47ddb3e37a910cede6f8ccc5d");
        formIds.add("201481e162500846c818390d37cc1925");
        formIds.add("ddd71bf88de212be1f49e65371744bde");
        formIds.add("d82adda8a0ca407ab9f3fb849fbbfa3c");
        formIds.add("e5a939a7c806375e451c33a01528e98c");
//        formIds.add("f6ff36081a786d4e2bb9a64b137268c7");
        formIds.add("e5a939a7c806375e451c33a01528e98c");
        formIds.add("f6ff36081a786d4e2bb9a64b137268c7");
        formIds.add("0cf54d91f23269199a1cd4b5d037af8c");
        formIds.add("fccd86faf05db9fda271367f52e4a52f");
        formIds.add("d2a49fb8b3f69b7e5ee5e9e26c3cf72a");
        formIds.add("99c57a659a86d6af4e8536bb9b559100");
        formIds.add("7cfd3b25d8cac2b141c0a7b6677bc584");
        formIds.add("600db330b3f809c2cbd4c00d1aaf5914");
        formIds.add("cc7de3b472855d3c5affb5670ad3a448");
        formIds.add("e97fa1b6085624a6e873c4f03f54349d");
        for (int i = 11; i <= 24; i++) {
            String filePath = "E:\\utils\\dev\\logAnalysisUtilResource\\np统计访问日志\\host.access.202111day.log";
            new FileUtil(filePath.replace("day",String.valueOf(i))).printResult();
        }
        //用于记录formid 中并发量最高的日志路径map
        //key 为 formid   value 为 文件路径
        Map<String,String> HCPFileMap = new HashMap<>();
        totalHPC.forEach((filePath, HCP)->{
            HCP.forEach((formId, currentHPC) ->{
                if(HCPFileMap.containsKey(formId)){
                    //HCPFileMap.get(formId) 取到的为 文件路径
                    Integer preHPC = totalHPC.get(HCPFileMap.get(formId)).get(formId);
                    if(currentHPC>preHPC){
                        HCPFileMap.put(formId,filePath);
                    }
                }else{
                    HCPFileMap.put(formId,filePath);
                }
            });
        });
        //处理后得到 HCPFileMap
        HCPFileMap.forEach((formId,fileId)-> {
            Integer sum = 0;
            //最高的key
            String HPCTime = totalHPCKEY.get(fileId).get(formId);
            if(StringUtils.isBlank(HPCTime)){
                return;
            }
            LocalTime parsedHPC = LocalTime.parse(HPCTime.trim());
            LocalTime nextFive = parsedHPC.plusMinutes(5);
            LocalTime preFive = parsedHPC.minusMinutes(5);
            List<String> targetKeys = totalResult.get(fileId).get(formId).keySet()
                    .stream()
                    .filter(timerKey -> LocalTime.parse(timerKey.trim()).isAfter(preFive) && LocalTime.parse(timerKey.trim()).isBefore(nextFive))
                    .collect(Collectors.toList());
            //得到区间内的key
            for (String targetKey:targetKeys){
                sum += totalResult.get(fileId).get(formId).get(targetKey);
            }
            System.out.println("form:"+formId+"; file:"+fileId+"; counter: "+sum);
        });
        System.out.println(totalResult);
    }

    private void printResult() throws IOException{
        Map<String,Map<String,Integer>> formRelMap = new HashMap<>();
//        Map<String,Integer> timeRelationMap = new HashMap<>();
        File file = new File(filePath);
        BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis,"utf-8"),5*1024*1024);
        StringBuilder sb = new StringBuilder();
        String line = "";
        Map<String,Integer> counterMap = new HashMap<>();
        Map<String,String> HCPKeyMap = new HashMap<>();
        Map<String,Integer> HCPMap = new HashMap<>();
        //保存最终结果的 key v
        formIds.forEach(formId -> {
            counterMap.put(formId,0);
            HCPKeyMap.put(formId,"");
            HCPMap.put(formId,0);
        });
        while((line = reader.readLine()) != null){
            for (String formId : formIds) {
                if(line.contains(formId)){
                    Integer timeStrIndex = line.indexOf(timePrefix);
                    String timerKey = line.substring(timeStrIndex+9,timeStrIndex+18);
                    counterMap.put(formId,counterMap.get(formId)+1);
                    if (formRelMap.containsKey(formId)) {
                        if(formRelMap.get(formId).containsKey(timerKey)){
                            Integer currentCount = formRelMap.get(formId).get(timerKey);
                            if ((currentCount + 1) == Math.max(currentCount + 1, HCPMap.get(formId))) {
                                HCPMap.put(formId, currentCount + 1);
                                HCPKeyMap.put(formId, timerKey);
                            }
                            formRelMap.get(formId).put(timerKey, currentCount + 1);
                        }else {
                            formRelMap.get(formId).put(timerKey,1);
                        }
                    } else {
                        formRelMap.put(formId, new HashMap<>());
                    }
                }
            }
//            if(line.contains(targetFormId)){
//                Integer timeStrIndex = line.indexOf(timePrefix);
//                String timerKey = line.substring(timeStrIndex+9,timeStrIndex+18);
//                counter++;
//                if(timeRelationMap.containsKey(timerKey)){
//                    Integer currentCount = timeRelationMap.get(timerKey);
//                    if((currentCount+1)==Math.max(currentCount+1,highestCounterPreSec)){
//                        highestCounterPreSec = currentCount+1;
//                        HCPKey = timerKey;
//                    }
//                    timeRelationMap.put(timerKey,currentCount+1);
//                }else {
//                    timeRelationMap.put(timerKey,1);
//                }
//            }
        }
        fis.close();
        reader.close();
        totalResult.put(filePath,formRelMap);
        totalCount.put(filePath,counterMap);
        totalHPC.put(filePath,HCPMap);
        totalHPCKEY.put(filePath,HCPKeyMap);
//        System.out.println("*******************************************");
//        System.out.println(filePath.substring(filePath.indexOf("202111"),filePath.indexOf("202111")+8));
//        System.out.println("key:"+HCPKey+"  value: "+timeRelationMap.get(HCPKey));
//        System.out.println(counter);
//        System.out.println("*******************************************");
    }

    @Override
    public void run() {
        try {
            printResult();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
