package com.example.notepro.domain;

import lombok.Data;

@Data
public class Account {
    private int userid;
    private String userName;
    private String password;
    private String email;
}
