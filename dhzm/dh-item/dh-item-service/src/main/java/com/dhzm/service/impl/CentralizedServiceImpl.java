package com.dhzm.service.impl;

import com.dhzm.Utils.CommandProcessing;
import com.dhzm.Utils.ObjTransForm;
import com.dhzm.Utils.TcpSend;
import com.dhzm.entity.Centralized;
import com.dhzm.entity.Singlamp;
import com.dhzm.mapper.CentralizedMapper;
import com.dhzm.mapper.LampsMapper;
import com.dhzm.service.CentralizedService;
import com.dhzm.service.LampsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CentralizedServiceImpl implements CentralizedService {
    public String hander = "FBFB";//包头
    public String pktail = "FEFE";//包尾
    public String instructions = "EC";//命令字
    public String lamps = "03";//灯号

    @Autowired
    private CentralizedMapper centralizedMapper;

    @Autowired
    private LampsMapper lampsMapper;

    @Autowired
    private LampsService lampsService;

    @Override
    public List<Centralized> selectCentralized() {
        List<Centralized> list = centralizedMapper.selectCentralized();
        return list;
    }


    @Override
    public Object findByCentralized(String uid, String command, String groups, String grade, Integer jid) {
        List<Centralized> centralizedList = centralizedMapper.findByCentralized(jid);
        if (!"33".equals(command)){
            lampsService.update(uid, command);
        }

        if ("33".equals(command)) {
            lampsMapper.updateGrade(grade, uid);
        }
        Singlamp singlamp = lampsMapper.selectLamp(uid);
        String network = null;//集中控制器名称
        String ip = null;//ip
        Integer port = null;//端口
        for (Centralized a : centralizedList) {
            network = a.getNetwork().replaceAll(":", "");
            ip = a.getIp();
            port = a.getPort();
        }

        //计算光亮等级grades
        String grades = null;
        String a = "00";
        if (grade.equals(a)) {
            grades = a;
        } else {
            Integer grade1 = Integer.parseInt(grade);
            grade = String.valueOf(grade1 / 5);
            ObjTransForm objTransForm = new ObjTransForm();
            grades = objTransForm.intToHex(Integer.parseInt(grade), command);
        }


        CommandProcessing commandProcessing = new CommandProcessing();
        //计算包长pklength
        String commandsSum = uid + command + groups + lamps + grades;//命令段10000020819332000300
        //commandsSum = commandsSum.replaceAll("\"", "");//去掉拼接字符串中的“”
        String pklength = commandProcessing.packageLength(network, commandsSum);

        //计算校验码
        String checkcode = commandProcessing.packageVerification(instructions, pklength, network, commandsSum);
        //checkcode = checkcode.replaceAll("\"", "");//去掉拼接字符串中的“”
        String comand = hander + instructions + pklength + network + commandsSum + checkcode + pktail;
        //comand = comand.replaceAll("\"", "");//去掉拼接字符串中的“”
        TcpSend tcpSend = new TcpSend(ip, port, comand);
        tcpSend.connect();


        if ("31".equals(command)) {
            Integer grade1 = Integer.parseInt(singlamp.getGrade());
            grade = String.valueOf(grade1 / 5);
            ObjTransForm objTransForm = new ObjTransForm();
            grades = objTransForm.intToHex(Integer.parseInt(grade), command);

            String commandsSumGrade = uid + "33" + groups + lamps + grades;
            String gradelength = commandProcessing.packageLength(network, commandsSumGrade);
            String gradecode = commandProcessing.packageVerification(instructions, gradelength, network, commandsSumGrade);
            String gradecomand = hander + instructions + gradelength + network + commandsSumGrade + gradecode + pktail;

            System.err.println(gradecomand);
            try {
                Thread.sleep(50);
                TcpSend tcpSendgrade = new TcpSend(ip, port, gradecomand);
                tcpSendgrade.connect();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return command;
    }

    @Override
    public void insertCentralized(String position, String network, String ip, String port) {
        Date date = new Date();
        long time = date.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(time);
        centralizedMapper.insertCentralized(position, network, ip, port, format, format);
    }

    @Override
    public Object editCentralized(Integer ecJid, String ecPosition, String ecIp, String ecNetwork, String ecPort) {
        if (ecIp == null && ecPosition == null && ecNetwork == null && ecPort == null) {
            centralizedMapper.deleteCentralized(ecJid);
            return "delok";
        } else {
            Date date = new Date();
            long time = date.getTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = simpleDateFormat.format(time);
            centralizedMapper.updateCentralized(ecJid, ecPosition, ecIp, ecNetwork, ecPort, format);
            return "editok";
        }
    }
}
