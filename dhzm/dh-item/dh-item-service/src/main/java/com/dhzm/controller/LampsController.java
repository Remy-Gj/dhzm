package com.dhzm.controller;
import com.dhzm.Utils.CommandProcessing;
import com.dhzm.Utils.ObjTransForm;
import com.dhzm.Utils.TcpSend;
import com.dhzm.entity.Centralized;
import com.dhzm.entity.Singlamp;
import com.dhzm.entity.Singlecontrol;
import com.dhzm.service.CentralizedService;
import com.dhzm.service.LampsService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("lamps")
public class LampsController {
    @Autowired
    private LampsService lampsService;
    @Autowired
    private CentralizedService centralizedService;
     /**
     * 查询灯具
     * @return
     */
    @RequestMapping("selectLamp")
    public Object selectLamp (Integer jid) {
        List<Singlamp> list = lampsService.select(jid);
        if (list.isEmpty()){
            return null;
        }
        return list;
    }

    /**
     * 灯状态
     * @param uid
     * @param command
     * @return
     */

//    @RequestMapping("LampState")
//    public Object dopenLamps(@RequestParam("uid")String uid, @RequestParam("command")String command){
//        List<Singlecontrol> list=lampsService.openLamps(uid,command);
//        String ml = null;//那一大串
//        for (Singlecontrol a : list) {
//            ml=a.toString();
//        }
//        TcpSend tcpSend = new TcpSend("192.168.1.99", 99, ml);
//        tcpSend.connect();
//        lampsService.update(uid,command);
//        return "ok";
//    }

    @RequestMapping("LampState")
    public Object lampState(@RequestParam("uid") String  uid,//单灯uid
                            @RequestParam("command") String command,//,命令动作
                            @RequestParam("groups") String groups,//组号
                            @RequestParam("grade") String  grade,//光亮等级
                            @RequestParam("jid") Integer jid//集中控制器id
    ){
        Object byCentralized = centralizedService.findByCentralized(uid, command, groups, grade, jid);
        return byCentralized;
    }




    @RequestMapping("Dimming")
    public Object dimming (){
        return null;
    }


}
