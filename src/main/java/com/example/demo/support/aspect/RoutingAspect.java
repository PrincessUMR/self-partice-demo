package com.example.demo.support.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.example.demo.config.supplies.RoutingDataSourceContext;

import lombok.extern.slf4j.Slf4j;

/**
 * 数据源路由切面
 *
 * @description: 数据源路由切面
 * @author: mao ying jie
 * @create: 2022-03-11 09:21
 **/
@Aspect
@Component
@Slf4j
public class RoutingAspect {

    @Around("@annotation(RoutingAnnotation)")
    public Object proceedWithDataSourceSelection(ProceedingJoinPoint joinPoint, RoutingAnnotation RoutingAnnotation ) throws Throwable{
        try{
            log.info("切入数据源{}",RoutingAnnotation.value());
            RoutingDataSourceContext.setDataSourceKey(RoutingAnnotation.value());
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            log.error("数据路由错误：{}",throwable.getMessage());
            throw throwable;
        }
    }
}
