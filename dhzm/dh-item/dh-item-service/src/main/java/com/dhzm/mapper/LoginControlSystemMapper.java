package com.dhzm.mapper;

import com.dhzm.entity.LoginInfo;
import org.apache.ibatis.annotations.Select;

/**
 * @author Remy~
 * @date 来自:2022年03月04日 15:51
 */
public interface LoginControlSystemMapper {

    @Select("SELECT * Form user where admin = #{admin} and password = #{password}")
    LoginInfo Verification(String admin, String password);
}
