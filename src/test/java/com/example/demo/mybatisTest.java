package com.example.demo;

import com.example.demo.entity.Target;
import com.example.demo.mapper.PgnewtestMapper;
import com.example.demo.mapper.RepositoryMapper;
import com.example.demo.mapper.TarRepStockMapper;
import com.example.demo.mapper.TargetMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class mybatisTest {

    @Autowired
    PgnewtestMapper pgnewtestMapper;
    @Autowired
    TargetMapper targetMapper;
    @Autowired
    TarRepStockMapper tarRepStockMapper;
    @Autowired
    RepositoryMapper repositoryMapper;

    @Test
    public void test(){
        System.out.println(pgnewtestMapper.queryAll());
    }

    @Test
    public void mtmTest(){
        tarRepStockMapper.queryAll().forEach((tarRepStock)->{
            System.out.println(tarRepStock);
        });
    }
}
