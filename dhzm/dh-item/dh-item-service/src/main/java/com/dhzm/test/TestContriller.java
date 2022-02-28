package com.dhzm.test;
import com.dhzm.Utils.TcpSend;
import com.dhzm.entity.Singlecontrol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("test")
public class TestContriller {
    @Autowired
    private TestService testService;
    @RequestMapping("ss")
    public void openLamps() {
        String i="FBFBEC0010B0C5CAB054131000002081933100030005CAFEFE";
                //FBFBEC0010B0C5CAB054131000002081933100030005CBFEFE
        TcpSend tcpSend = new TcpSend("192.168.1.99",99,i);
        tcpSend.connect();
    }

//    @GetMapping("LampState")
//    public Object openLamps(@RequestParam("uid")String uid, @RequestParam("command")String command){
////
////        命令段：ec
////                包头 FBFB,
////                        包尾:FEFE
////                                灯号：03
//        List<Singlecontrol> list=testService.openLamps(uid,command);
//        String ml = null;//那一大串
//        for (Singlecontrol a : list) {
//            ml=a.toString();
//        }
//        TcpSend tcpSend = new TcpSend("192.168.1.99", 99, ml);
//        tcpSend.connect();
//        testService.update(uid,command);
//        return "ok";
//    }




    public void offLamp(){
        TcpSend tcpSend = new TcpSend("192.168.1.99", 99, "FBFBEC0010B0C5CAB054131000002081933200030005CBFEFE");
        tcpSend.connect();
    }

}

