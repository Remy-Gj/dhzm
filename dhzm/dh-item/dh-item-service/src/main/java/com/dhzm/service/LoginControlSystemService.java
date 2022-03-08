package com.dhzm.service;

import com.dhzm.entity.LoginInfo;

/**
 * @author Remy~
 * @date 来自:2022年03月04日 15:49
 */
public interface LoginControlSystemService {

    LoginInfo UserLogin(String admin, String password);
}
