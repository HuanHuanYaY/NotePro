package com.example.notepro.service;

import com.example.notepro.dao.AccountDao;
import com.example.notepro.domain.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


public interface AccountService {

    Account SelectOneAccount(String email, String password);

    Account FindByAccountEmail(String email);

    int FindUserIDByEmail(String email);

    String FindUserNameByUserid(int userid);

    int insertNewUser(String userName,String password,String email);
}
