package com.example.notepro.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Co2Data {
    private Long cid;
    private String data_type;
    private String co2;
    private String message_id;
    private Timestamp create_time;
    private Timestamp update_time;
    private String deviceid;
}
