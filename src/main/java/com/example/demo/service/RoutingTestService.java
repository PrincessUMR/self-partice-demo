package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Pgnewtest;
import com.example.demo.mapper.PgnewtestMapper;

/**
 * @description:
 * @author: mao ying jie
 * @create: 2022-03-11 10:24
 **/
@Service
public class RoutingTestService {

    @Autowired
    private PgnewtestMapper pgnewtestMapper;

    public List<Pgnewtest> queryPGN(){
        return pgnewtestMapper.queryAll();
    }
}
