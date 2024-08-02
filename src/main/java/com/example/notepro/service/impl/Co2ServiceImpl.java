package com.example.notepro.service.impl;

import com.example.notepro.dao.Co2DataDao;
import com.example.notepro.domain.Co2Data;
import com.example.notepro.service.Co2DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class Co2ServiceImpl implements Co2DataService {
    @Autowired
    private Co2DataDao co2DataDao;

    @Override
    public List<Co2Data> FindAllDataByIdandTime(String deviceid, String create_time) {
        return co2DataDao.FindAllDataByIdandTime(deviceid,create_time);
    }

    @Override
    public List<Co2Data> FindAllDataByTime(String create_time) {
        return co2DataDao.FindAllDataByTime(create_time);
    }

    @Override
    public int InsertCo2Data(String data_type, String co2, String deviceid) {
        return co2DataDao.InsertCo2Data(data_type,co2,deviceid);
    }

    @Override
    public List<Co2Data> FindAllDataByTimeFenYe(String create_time, int pageNumber, int pageSize) {
        if(pageNumber==1){
            pageNumber=0;
        }
        return co2DataDao.FindAllDataByTimeFenYe(create_time,pageNumber,pageSize);
    }

}
