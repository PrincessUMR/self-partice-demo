package com.example.demo.config.supplies;

import com.sun.org.apache.bcel.internal.generic.NEW;

import lombok.extern.slf4j.Slf4j;

/**
 * 数据源路由 线程控制
 *
 * @description: 数据源路由 线程控制
 * @author: mao ying jie
 * @create: 2022-03-10 17:51
 **/
@Slf4j
public class RoutingDataSourceContext implements AutoCloseable{

    static final ThreadLocal<String> dataSourceKey = new ThreadLocal<>();

    public static String getDataSourceRoutingKey() {
        String key = dataSourceKey.get();
        log.info("{}:{}",Thread.currentThread().getName(),key);
        return key == null ? "masterDataSource" : key;
    }

    public static void setDataSourceKey(String key) {
        dataSourceKey.set(key);
    }

    @Override
    public void close() {
        dataSourceKey.remove();
    }
}
