package com.example.notepro.service.impl;

import com.example.notepro.dao.AccountDao;
import com.example.notepro.domain.Account;
import com.example.notepro.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Account SelectOneAccount(String email, String password){
        return accountDao.SelectOneAccount(email, password);
    }

    @Override
    public Account FindByAccountEmail(String email) {
        return accountDao.FindByAccountEmail(email);
    }

    @Override
    public int FindUserIDByEmail(String email){
        return accountDao.FindUserIDByEmail(email);
    }

    @Override
    public String FindUserNameByUserid(int userid){
        return accountDao.FindUserNameByUserid(userid);
    }

    @Override
    public int insertNewUser(String userName,String password,String email){
        return accountDao.insertNewUser(userName, password, email);
    }
}
