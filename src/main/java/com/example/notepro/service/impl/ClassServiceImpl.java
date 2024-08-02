package com.example.notepro.service.impl;

import com.example.notepro.dao.ClassDao;
import com.example.notepro.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassDao classDao;

    @Override
    public int InsertCo2DataInClass(String data_type, String co2, String deviceid) {
        return classDao.InsertCo2DataInClass(data_type,co2,deviceid);
    }
}
