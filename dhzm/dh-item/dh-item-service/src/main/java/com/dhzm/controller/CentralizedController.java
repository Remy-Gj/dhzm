package com.dhzm.controller;


import com.dhzm.entity.Centralized;
import com.dhzm.service.CentralizedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    public Object SelectCentralized() {
        List<Centralized> list = centralizedService.selectCentralized();
        return list;
    }

    @RequestMapping("addEcc")
    public Object insertCentralized(@RequestParam("eccPosition") String position,
                                    @RequestParam("eccUid") String network,
                                    @RequestParam("eccIp") String ip,
                                    @RequestParam("eccPort") String port) {
        centralizedService.insertCentralized(position, network, ip, port);
        return "ok";
    }

    /**
     * 修改和删除一体
     *
     * @param ecJid      集中器id
     * @param ecPosition 集中器位置
     * @param ecIp       集中器ip
     * @param ecNetwork  集中器Uid
     * @param ecPort     集中器端口
     * @return java.lang.Object
     * @author Remy~
     * @date 2022/3/1 0001 14:24
     */
    @CrossOrigin
    @RequestMapping("editEcc")
    public Object editCentralized(
            @RequestParam(value = "eccJid") Integer ecJid,
            @RequestParam(value = "eccPosition", required = false) String ecPosition,
            @RequestParam(value = "eccIp", required = false) String ecIp,
            @RequestParam(value = "eccUid", required = false) String ecNetwork,
            @RequestParam(value = "eccPort", required = false) String ecPort) {
        Object o = centralizedService.editCentralized(ecJid, ecPosition, ecIp, ecNetwork, ecPort);
        return o;
    }

}
