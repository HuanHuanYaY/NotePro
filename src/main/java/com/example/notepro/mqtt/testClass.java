package com.example.notepro.mqtt;

import com.example.notepro.service.Co2DataService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class testClass {
    @Autowired
    private Co2DataService co2DataService;

    @PostConstruct
    public void init() {
        if (co2DataService != null) {
            System.out.println("Co2DataService 注入成功");
        } else {
            System.out.println("Co2DataService 注入失败");
        }
    }
}
