package com.example.notepro.mqtt;

import com.example.notepro.service.ClassService;
import com.example.notepro.service.Co2DataService;
import com.example.notepro.service.OccupyService;
import com.example.notepro.util.SpringUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Objects;


public class MqttConsumerCallBack implements MqttCallback {

    @Override
    public void connectionLost(Throwable throwable) {
        System.out.println("与服务器断开连接，可重连");
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        System.out.println(String.format("接收消息主题 : %s", topic));
        System.out.println(String.format("接收消息Qos : %d", message.getQos()));
        System.out.println(String.format("接收消息内容 : %s", new String(message.getPayload())));
        System.out.println(String.format("接收消息retained : %b", message.isRetained()));
        if (Objects.equals(topic, "arrowgd/sensor/infineon/u/CBO-010446")){
            String[] parts = topic.split("/");
            String device_id = parts[parts.length - 1];
            String payload = new String(message.getPayload());
            ObjectMapper objectMapper = new ObjectMapper();
//            JsonNode rootNode = objectMapper.readTree(payload);
//            String data_type = rootNode.get("data_type").asText();
//            String co2 = rootNode.get("co2").asText();
//            //co2ServiceImpl.InsertCo2Data(data_type,co2,deviceid);
            try {
                JsonNode rootNode = objectMapper.readTree(payload);
                String data_type = rootNode.get("data_type").asText();
                String occupy = rootNode.get("occupy").asText();

                //co2DataService.InsertCo2Data(data_type,co2,deviceid);
                ApplicationContext context = SpringUtil.context;  //获取Spring容器
                OccupyService occupyService = context.getBean(OccupyService.class);  //获取bean

                occupyService.InsertOccupy(data_type, occupy, device_id);
            } catch (Exception e) {
                e.printStackTrace(); // 打印具体的异常信息，方便排查问题
            }
        }else {
            String[] parts = topic.split("/");
            String deviceid = parts[parts.length - 1];
            String payload = new String(message.getPayload());
            ObjectMapper objectMapper = new ObjectMapper();
//            JsonNode rootNode = objectMapper.readTree(payload);
//            String data_type = rootNode.get("data_type").asText();
//            String co2 = rootNode.get("co2").asText();
//            //co2ServiceImpl.InsertCo2Data(data_type,co2,deviceid);
            try {
                JsonNode rootNode = objectMapper.readTree(payload);
                String data_type = rootNode.get("data_type").asText();
                String co2 = rootNode.get("co2").asText();

                //co2DataService.InsertCo2Data(data_type,co2,deviceid);
                ApplicationContext context = SpringUtil.context;  //获取Spring容器
                Co2DataService co2DataService = context.getBean(Co2DataService.class);  //获取bean

                co2DataService.InsertCo2Data(data_type, co2, deviceid);
            } catch (Exception e) {
                e.printStackTrace(); // 打印具体的异常信息，方便排查问题
            }
        }
    }



    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}
