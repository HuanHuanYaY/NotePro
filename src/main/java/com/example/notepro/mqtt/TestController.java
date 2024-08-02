package com.example.notepro.mqtt;

import com.example.notepro.service.Co2DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    private MqttConsumerConfig client;

    @Autowired
    private Co2DataService co2DataService;

    @Value("${spring.mqtt.client.id}")
    private String clientId;

    //搞多了一次连接了
    @RequestMapping("/connect")
    @ResponseBody
    public String connect(){
        co2DataService.InsertCo2Data("co2","122","CO2-0102B6GD");
        return clientId + "连接到服务器";
    }

    @RequestMapping("/disConnect")
    @ResponseBody
    public String disConnect(){
        client.disConnect();
        return clientId + "与服务器断开连接";
    }
}
