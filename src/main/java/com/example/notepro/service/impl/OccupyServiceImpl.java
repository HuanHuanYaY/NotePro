package com.example.notepro.service.impl;

import com.example.notepro.dao.OccupyDao;
import com.example.notepro.domain.Occupy;
import com.example.notepro.service.OccupyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OccupyServiceImpl implements OccupyService {

    @Autowired
    private OccupyDao occupyDao;

    @Override
    public List<Occupy> FindAllOccupyByIdandTime(String device_id, String create_time) {
        return occupyDao.FindAllOccupyByIdandTime(device_id,create_time);
    }

    @Override
    public List<Occupy> FindAllOccupyByTime(String create_time) {
        return occupyDao.FindAllOccupyByTime((create_time));
    }

    @Override
    public int InsertOccupy(String data_type, String occupy, String device_id) {
        return occupyDao.InsertOccupy(data_type,occupy,device_id);
    }

    @Override
    public int FindFreeTime(String device_id, String create_time) {
        try {
            // Your database query logic here
            return occupyDao.FindFreeTime(device_id,create_time);
        } catch (Exception e) {
            // Handle the exception
            return -1; // or any other appropriate default value
        }
    }

    @Override
    public int FindOccupyTime(String device_id, String create_time) {
        return occupyDao.FindOccupyTime(device_id,create_time);
    }

    @Override
    public float FindFreeTimePrecent(String device_id, String create_time) {
        int oneCount = occupyDao.FindOccupyTime(device_id,create_time);
        int zeroCount = occupyDao.FindFreeTime(device_id,create_time);
        float FreePrecent = (float) zeroCount / (oneCount+zeroCount) *100;
        return FreePrecent;
    }

    @Override
    public float FindOccupyTimePrecent(String device_id, String create_time) {
        int oneCount = occupyDao.FindOccupyTime(device_id,create_time);
        int zeroCount = occupyDao.FindFreeTime(device_id,create_time);
        float OccupyPrecent = (float) oneCount / (oneCount+zeroCount) *100;
        return OccupyPrecent;
    }


}
