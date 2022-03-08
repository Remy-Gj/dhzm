package com.dhzm.entity;

/**
 * @author Remy~
 * @date 来自:2022年03月04日 15:45
 */
public class LoginInfo {
    //账户名
    private String admin;
    //密码
    private String password;
    //权限号（用于权限路由）
    private String PerId;


    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPerId() {
        return PerId;
    }

    public void setPerId(String perId) {
        PerId = perId;
    }
}
