package com.dhzm.controller;



import com.dhzm.util.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Remy~
 * @date 来自:2021年12月07日 15:13
 */
@RestController
@RequestMapping("user")
public class MainLoginController{

    /**
     * 登录
     * @author Remy~
     * @date 2021/12/7 15:17
     */
    @RequestMapping("login")
    public R login() {
        System.out.println("登录成功~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return R.ok().data("token","admin");
    }

    /**
     *  登录信息 好像没用到？
     * @author Remy~
     * @date 2021/12/7 15:19
     */
    @RequestMapping("info")
    public R info() {
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","?");
    }

    /**
     *  登出
     * @author Remy~
     * @date 2021/12/7 15:19
     */
    @RequestMapping("logout")
    public R logins() {
        return R.ok();
    }
}
