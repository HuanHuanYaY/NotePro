package com.example.notepro.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Occupy {
    private long oid;
    private String data_type;
    private String occupy;
    private String message_id;
    private Timestamp create_time;
    private Timestamp update_time;
    private String device_id;
}
