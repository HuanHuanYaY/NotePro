package com.example.notepro.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ClassDao {
    int InsertCo2DataInClass(@Param("data_type") String data_type, @Param("co2") String co2, @Param("deviceid") String deviceid);
}
