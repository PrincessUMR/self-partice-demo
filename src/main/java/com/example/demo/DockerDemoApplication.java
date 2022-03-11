package com.example.demo;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;

import com.example.demo.config.RoutingDataSourceConfig;

@EnableAspectJAutoProxy
@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class DockerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerDemoApplication.class, args);
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.write")
    @Primary
    DataSource masterDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.read")
    DataSource slaveDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    DataSource primaryDataSource( @Autowired @Qualifier("masterDataSource") DataSource masterDataSource,
                                  @Autowired @Qualifier("slaveDataSource") DataSource slaveDataSource){
        Map<Object, Object> map = new HashMap<>();
        map.put("masterDataSource", masterDataSource);
        map.put("slaveDataSource", slaveDataSource);
        RoutingDataSourceConfig routing = new RoutingDataSourceConfig();
        routing.setTargetDataSources(map);
        routing.setDefaultTargetDataSource(masterDataSource);
        return routing;
    }

}
