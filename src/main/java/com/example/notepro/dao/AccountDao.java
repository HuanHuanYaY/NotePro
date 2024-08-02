package com.example.notepro.dao;

import com.example.notepro.domain.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface AccountDao {

    void selectAccount(Account account);

    Account SelectOneAccount(@Param("email")String email, @Param("password")String password);

    Account FindByAccountEmail(@Param("email")String email);

    int FindUserIDByEmail(@Param("email")String email);

    String FindUserNameByUserid(@Param("userid")int userid);

    int insertNewUser(@Param("userName")String userName,@Param("password")String password,@Param("email")String email);

}
