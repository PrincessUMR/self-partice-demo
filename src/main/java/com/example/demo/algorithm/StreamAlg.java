package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.poi.ss.formula.functions.T;

import static java.util.stream.Collectors.counting;

/**
 * 流题
 *
 * @description: 流题
 * @author: mao ying jie
 * @create: 2022-03-05 16:38
 **/
public class StreamAlg {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abe", "srew");
    }

    /**
     * 问题： 尝试用reduce重写map ？
     *
     * reduce的三个参数
     * 参数 identity 是规约操作的初始值。
     * 参数accumulator 是与Stream中单个元素的合并操作，等同于函数 U apply(U u, T t)。
     * 参数 combiner 是将并行执行得到的多个中间结果进行合并的操作，等同于函数 U apply(U u1, U u2)。
     *
     * @param stream
     * @param mapper
     * @param <I>
     * @param <O>
     * @return
     */
    public static <I, O> List<O> map(Stream<I> stream, Function<I, O> mapper) {
        //mapper泛型 Function中的O是转换结果, I是mapper转换之前的入参
        //参数1、reduce累加器中的第0个元素。
        return stream.reduce(new ArrayList<O>(),(acc,element) -> {
//            官方答案
            List<O> newAcc = new ArrayList<>(acc);
            newAcc.add(mapper.apply(element));

            //每次累加器、先将上次的累加结果返回
            //上次累加结果中加入本次循环的元素
//            acc.add(mapper.apply(element));
            //如果直接用上次累加返回的结果，在并行流的情况下会出现问题,在参数三合并多线程的结果的时候 引用的是同一个地址
            return newAcc;
        },(List<O> o1, List<O> o2) ->{
            //并行流下、合并不同流的方式
           List<O> result = new ArrayList<>(o1);
           result.addAll(o2);
           return result;
        });
    }

    public static List<String> upCase(Stream<String> stream) {
        return stream.reduce(new ArrayList<String>(),(acc,item)->{
            List<String> perAcc = new ArrayList<>(acc);
            perAcc.add(item.toUpperCase());
            return perAcc;
        },(List<String> o1, List<String> o2) ->{
            //并行流下、合并不同流的方式
            List<String> result = new ArrayList<>(o1);
            result.addAll(o2);
            return result;
        });
    }

}
