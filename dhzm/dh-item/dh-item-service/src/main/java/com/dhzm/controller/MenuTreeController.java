package com.dhzm.controller;


import com.dhzm.entity.MainUrl;
import com.dhzm.service.MenuTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Remy~
 * @date 来自:2022年01月06日 16:08
 */
@RestController
@RequestMapping("menu")
public class MenuTreeController {

    @Autowired
    private MenuTreeService menuTreeService;

    @RequestMapping("findTree")
    public MainUrl findTree(){

        return null;
    }
}
