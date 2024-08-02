package com.example.notepro.service;

import com.example.notepro.domain.Co2Data;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface Co2DataService {
    List<Co2Data>  FindAllDataByIdandTime(String deviceid, String create_time);

    List<Co2Data>  FindAllDataByTime(String create_time);
    int InsertCo2Data(String data_type, String co2, String deviceid);

    List<Co2Data> FindAllDataByTimeFenYe(String create_time, int pageNumber,int pageSize);


}
