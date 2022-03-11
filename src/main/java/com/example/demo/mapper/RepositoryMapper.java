package com.example.demo.mapper;

import com.example.demo.entity.RepositoryInfo;

import java.util.List;

public interface RepositoryMapper {
    public List<RepositoryInfo> queryRepStock();
    public RepositoryInfo queryRepById(Integer id);
}
