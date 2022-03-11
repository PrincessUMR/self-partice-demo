package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * 云南非标接口所需参数实体
 */
@Data
public class YnFbxxParams {
    private Integer startPage;
    private Integer pageSize;
    private LocalDateTime lastModifiedTime;
}
