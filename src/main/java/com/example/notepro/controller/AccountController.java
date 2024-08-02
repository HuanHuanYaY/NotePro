package com.example.notepro.controller;

import com.example.notepro.dao.AccountDao;

public interface AccountController {
    void SelectOneAccount(String email, String password);

    void FindByAccountEmail(String email);
}
