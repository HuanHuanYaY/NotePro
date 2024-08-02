package com.example.notepro.controller.impl;

import com.example.notepro.domain.Co2Data;
import com.example.notepro.service.Co2DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Co2")
public class Co2ControllerImpl {
    @Autowired
    private Co2DataService co2DataServiceService;

    @PostMapping("/FindAllDataByIdandTime")
    public List<Co2Data> FindAllDataByIdandTime(@RequestParam String  deviceid, @RequestParam String create_time){
        return co2DataServiceService.FindAllDataByIdandTime(deviceid,create_time);
    }

    @PostMapping("/FindAllDataByTime")
    public List<Co2Data> FindAllDataByTime(@RequestParam String create_time){
        return co2DataServiceService.FindAllDataByTime(create_time);
    }


    @PostMapping("/InsertCo2Data")
    public int InsertCo2Data(@RequestParam String data_type, @RequestParam String co2,@RequestParam String deviceid){
        return co2DataServiceService.InsertCo2Data(data_type,co2,deviceid);
    }

    @PostMapping("/FindAllDataByTimeFenYe")
    public List<Co2Data> FindAllDataByTimeFenYe(@RequestParam String create_time,@RequestParam(defaultValue = "1") int pageNumber,@RequestParam(defaultValue = "10") int pageSize){
        return co2DataServiceService.FindAllDataByTimeFenYe(create_time,pageNumber,pageSize);
    }

}
