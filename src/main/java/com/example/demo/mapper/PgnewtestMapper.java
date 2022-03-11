package com.example.demo.mapper;

import com.example.demo.entity.Pgnewtest;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PgnewtestMapper {
    @Select({
            "select * from pgModel.pgnewtest limit 50 offset 0"
    })
    public List<Pgnewtest> queryAll();
    public Pgnewtest findById(Integer paramId);
}
