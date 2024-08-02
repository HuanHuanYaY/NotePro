package com.example.notepro.dao;

import com.example.notepro.domain.Co2Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface Co2DataDao {
    List<Co2Data> FindAllDataByIdandTime(@Param("deviceid") String deviceid, @Param("create_time") String create_time);

    List<Co2Data> FindAllDataByTime(@Param("create_time") String create_time);
    int InsertCo2Data(@Param("data_type") String data_type, @Param("co2") String co2, @Param("deviceid") String deviceid);

    List<Co2Data> FindAllDataByTimeFenYe(@Param("create_time") String create_time,@Param("pageNumber") int pageNumber,@Param("pageSize") int pageSize);



}
