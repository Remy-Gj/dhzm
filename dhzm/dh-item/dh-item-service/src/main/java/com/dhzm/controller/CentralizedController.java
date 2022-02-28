package com.dhzm.controller;


import com.dhzm.entity.Centralized;
import com.dhzm.service.CentralizedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ecc")
public class CentralizedController {
    @Autowired

    private CentralizedService centralizedService;

    @RequestMapping("selectEcc")
    public Object SelectCentralized (){
        List<Centralized>list=centralizedService.selectCentralized();
        return list;
    }
    @RequestMapping("addEcc")
    public Object insertCentralized(@RequestParam("eccUid") String network,
                                    @RequestParam("eccIp") String ip,
                                    @RequestParam("eccPort") String port){
        centralizedService.insertCentralized(network,ip,port);
        return "ok";
    }

}
