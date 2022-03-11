package com.example.demo.reflectDemo;

public class TargetClass {
    static {
        System.out.printf("target class static");
    }
    private String prop;

    public String getProp() {
        return prop;
    }

    public TargetClass setProp(String prop) {
        this.prop = prop;
        return this;
    }
}
