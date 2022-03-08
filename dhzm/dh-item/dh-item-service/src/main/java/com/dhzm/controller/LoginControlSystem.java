package com.dhzm.controller;

import com.dhzm.Utils.TcpRead;
import com.dhzm.entity.LoginInfo;
import com.dhzm.service.LoginControlSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Remy~
 * @date 来自:2022年03月04日 15:41
 */
@RestController
@RequestMapping("user")
public class LoginControlSystem {
    @Autowired
    private LoginControlSystemService loginControlSystemService;
    @RequestMapping("login")
    public Object Login(@RequestBody LoginInfo loginInfo){
        LoginInfo loginInfo1 = loginControlSystemService.UserLogin(loginInfo.getAdmin(), loginInfo.getPassword());
        if (loginInfo1!=null&&!"".equals(loginInfo1)){
            return "LoginIn";
        }else if (loginInfo.getAdmin()==null&&loginInfo.getPassword()==null){
            return "LoginOut";
        }else {
            return "ErrorInput";
        }
    }
}
