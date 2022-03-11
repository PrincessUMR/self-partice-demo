package com.example.demo.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.example.demo.config.supplies.RoutingDataSourceContext;

/**
 * 多数据源路由
 *
 * @description: 多数据源路由
 * @author: mao ying jie
 * @create: 2022-03-10 17:39
 **/
public class RoutingDataSourceConfig extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return RoutingDataSourceContext.getDataSourceRoutingKey();
    }
}
