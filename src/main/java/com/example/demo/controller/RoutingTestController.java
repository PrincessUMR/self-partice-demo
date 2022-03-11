package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Pgnewtest;
import com.example.demo.service.RoutingTestService;
import com.example.demo.support.aspect.RoutingAnnotation;

/**
 * @description:
 * @author: mao ying jie
 * @create: 2022-03-11 10:23
 **/
@Controller
public class RoutingTestController {

    @Autowired
    RoutingTestService routingTestService;

    @RoutingAnnotation
    @ResponseBody
    @RequestMapping("/masterRoutingTest")
    public List<Pgnewtest> hw(){
        return routingTestService.queryPGN();
    }

    @RoutingAnnotation("slaveDataSource")
    @ResponseBody
    @RequestMapping("/slaveRoutingTest")
    public List<Pgnewtest> read(){
        return routingTestService.queryPGN();
    }
}
