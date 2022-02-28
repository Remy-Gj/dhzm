package com.dhzm.service.impl;

import com.dhzm.Utils.CommandProcessing;
import com.dhzm.Utils.ObjTransForm;
import com.dhzm.Utils.TcpSend;
import com.dhzm.entity.Centralized;
import com.dhzm.mapper.CentralizedMapper;
import com.dhzm.service.CentralizedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
@Service
public class CentralizedServiceImpl implements CentralizedService {
    public String hander ="FBFB";//包头
    public String pktail ="FEFE";//包尾
    public String instructions="EC";//命令字
    public String lamps = "03";//灯号

    @Autowired
    private CentralizedMapper centralizedMapper;


    @Override
    public List<Centralized> selectCentralized() {
        List<Centralized> list=centralizedMapper.selectCentralized();
        return list;
    }


    @Override
    public Object findByCentralized(String  uid, String command, String groups, String  grade, Integer jid) {
        List<Centralized>centralizedList=centralizedMapper.findByCentralized(jid);

        String network =null;//集中控制器名称
        String ip=null;//ip
        Integer port =null;//端口
        for (Centralized a : centralizedList) {
            network= a.getNetwork();
            ip=a.getIp();
            port=a.getPort();
        }
        //计算光亮等级grades
        String grades=null;
        String a="00";
        if (grade.equals(a)==true){
            grades=a;
        }else {
            ObjTransForm objTransForm = new ObjTransForm();
            grades = objTransForm.intToHex(Integer.parseInt(grade), command);
        }

        CommandProcessing commandProcessing = new CommandProcessing();
        //计算包长pklength
        String commandsSum=uid+command+groups+lamps+grades;//命令段10000020819332000300

        commandsSum=commandsSum.replaceAll("\"","");//去掉拼接字符串中的“”
        String pklength=commandProcessing.packageLength(network,commandsSum);

        //计算校验码
        String checkcode= commandProcessing.packageVerification(instructions,pklength,network,commandsSum);
        checkcode=checkcode.replaceAll("\"","");//去掉拼接字符串中的“”

        String comand=hander+instructions+pklength+network+commandsSum+checkcode+pktail;
        comand=comand.replaceAll("\"","");//去掉拼接字符串中的“”

        TcpSend tcpSend = new TcpSend(ip,port,comand);
        tcpSend.connect();

        return command;
    }

    @Override
    public void insertCentralized(String network, String ip, String port) {
        centralizedMapper.insertCentralized( network,  ip,  port);
    }
}
