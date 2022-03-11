package com.example.demo.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RepositoryInfo {
    private Integer repId;
    private String repName;
    private  String repLocation;
    private List<TarRepStock> tarRepStocks;
}
