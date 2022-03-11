package com.example.demo.mapper;

import com.example.demo.entity.Target;

import java.util.List;

public interface TargetMapper {
    public List<Target> queryAll();
    public List<Target> queryTarRep();
    public Target queryByTarId(Integer id);
}
