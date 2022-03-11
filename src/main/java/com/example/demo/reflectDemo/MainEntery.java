package com.example.demo.reflectDemo;

import java.lang.reflect.Method;
import java.util.concurrent.ArrayBlockingQueue;

public class MainEntery {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("com.example.demo.reflectDemo.TargetClass");
            ArrayBlockingQueue queue = new ArrayBlockingQueue<>(5);
            queue.add("1");
            queue.add("2");
            queue.add("3");
            queue.add("4");
            queue.add("5");
            System.out.printf("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
