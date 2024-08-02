package com.example.notepro.service;

import com.example.notepro.domain.Occupy;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OccupyService {
    List<Occupy> FindAllOccupyByIdandTime(@Param("device_id") String device_id, @Param("create_time") String create_time);

    List<Occupy> FindAllOccupyByTime(@Param("create_time") String create_time);

    int InsertOccupy(@Param("data_type") String data_type, @Param("occupy") String occupy, @Param("devicei_d") String device_id);

    int FindFreeTime(@Param("device_id") String device_id,@Param("create_time") String create_time);

    int FindOccupyTime(@Param("device_id") String device_id,@Param("create_time") String create_time);

    float FindFreeTimePrecent(@Param("device_id") String device_id,@Param("create_time") String create_tim);

    float FindOccupyTimePrecent(@Param("device_id") String device_id,@Param("create_time") String create_tim);

}
