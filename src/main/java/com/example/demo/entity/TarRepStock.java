package com.example.demo.entity;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TarRepStock {
    private Integer tarId;
    private Integer repId;
    private Integer stock;
    private Target target;
    private RepositoryInfo repositoryInfo;
}
