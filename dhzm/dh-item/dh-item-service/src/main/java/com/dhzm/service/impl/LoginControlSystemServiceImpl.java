package com.dhzm.service.impl;

import com.dhzm.entity.LoginInfo;
import com.dhzm.mapper.LoginControlSystemMapper;
import com.dhzm.service.LoginControlSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Remy~
 * @date 来自:2022年03月04日 15:50
 */
@Service
public class LoginControlSystemServiceImpl implements LoginControlSystemService {
    @Autowired
    private LoginControlSystemMapper loginControlSystemMapper;

    @Override
    public LoginInfo UserLogin(String admin, String password) {
        LoginInfo verification = loginControlSystemMapper.Verification(admin, password);
        return verification;
    }
}
