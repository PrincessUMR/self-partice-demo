package com.example.demo.support.aspect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RoutingAnnotation {

    String DEFAULT_DATA_SOURCE = "masterDataSource";

    String value() default  DEFAULT_DATA_SOURCE;
}
