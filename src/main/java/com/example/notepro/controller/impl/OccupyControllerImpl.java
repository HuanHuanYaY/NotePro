package com.example.notepro.controller.impl;

import com.example.notepro.domain.Co2Data;
import com.example.notepro.domain.Occupy;
import com.example.notepro.service.Co2DataService;
import com.example.notepro.service.OccupyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Occupy")
public class OccupyControllerImpl {
    @Autowired
    private OccupyService occupyService;

    @PostMapping("/FindAllOccupyByIdandTime")
    public List<Occupy> FindAllOccupyByIdandTime(@RequestParam String  device_id, @RequestParam String create_time){
        return occupyService.FindAllOccupyByIdandTime(device_id,create_time);
    }


    @PostMapping("/InsertOccupy")
    public int InsertOccupy(@RequestParam String data_type, @RequestParam String occupy,@RequestParam String device_id){
        return occupyService.InsertOccupy(data_type,occupy,device_id);
    }

    @PostMapping("/FindAllOccupyByTime")
    public List<Occupy> FindAllOccupyByTime(@RequestParam String create_time){
        return occupyService.FindAllOccupyByTime(create_time);
    }

    @PostMapping("/FindFreeTime")
    public int FindFreeTime(@RequestParam String device_id,@RequestParam String create_time){
        return occupyService.FindFreeTime(device_id,create_time);
    }

    @PostMapping("/FindFreeTimePrecent")
    public float FindFreeTimePrecent(@RequestParam String device_id,@RequestParam String create_time){
        return occupyService.FindFreeTimePrecent(device_id,create_time);
    }

    @PostMapping("/FindOccupyTimePrecent")
    public float FindOccupyTimePrecent(@RequestParam String device_id,@RequestParam String create_time){
        return occupyService.FindOccupyTimePrecent(device_id,create_time);
    }

    @PostMapping("/FindOccupyTime")
    public int FindOccupyTime(@RequestParam String device_id,@RequestParam String create_time){
        return occupyService.FindOccupyTime(device_id,create_time);
    }

}
