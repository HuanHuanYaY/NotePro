package com.example.notepro.controller.impl;

import com.example.notepro.common.CommonResult;
import com.example.notepro.dao.AccountDao;
import com.example.notepro.domain.Account;
import com.example.notepro.service.AccountService;
import com.example.notepro.util.JwtUtils;
import jakarta.annotation.Resource;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class AccountControllerImpl {

    @Autowired
    private AccountService accountService;


    @Resource
    private JwtUtils jwtUtils;

    @PostMapping("/SelectOneAccount")
    public CommonResult SelectOneAccount(@RequestParam String email, @RequestParam String password){
        Account account = accountService.SelectOneAccount(email, password);
        if(account != null){
            String exitingToken = jwtUtils.getTokenIfExists(email);
            if(exitingToken!=null) {
                return CommonResult.success(exitingToken);
            }else {
                String token=jwtUtils.generateToken(email);
                System.out.println(token);
                return CommonResult.success(token);
            }
        }else {
            return CommonResult.failed();
        }

    }

    @GetMapping("/FindByAccountEmail")
    public Account FindByAccountEmail(@RequestParam String email){
        return accountService.FindByAccountEmail(email);
    }


    @PostMapping("/FindUserIDByEmail")
    public int FindUserIDByEmail(@RequestParam String email){
        return accountService.FindUserIDByEmail(email);
    }

    @PostMapping("/FindUserNameByUserid")
    public String FindUserNameByUserid(@RequestParam int userid){
        return accountService.FindUserNameByUserid(userid);
    }

    @PostMapping("/insertNewUser")
    public int insertNewUser(@RequestParam String userName,@RequestParam String password,@RequestParam String email){
        return accountService.insertNewUser(userName, password, email);
    }
}
