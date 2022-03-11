package com.example.demo.mapper;

import com.example.demo.entity.TarRepStock;

import java.util.List;

public interface TarRepStockMapper {
    public List<TarRepStock> queryAllTarget();
    public List<TarRepStock> queryAll();
}
