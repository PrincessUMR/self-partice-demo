package com.example.demo.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Target {
    private Integer targetId;
    private String name;
    private List<TarRepStock> tarRepStocks;
}
