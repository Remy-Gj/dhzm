package com.dhzm.service;

import com.dhzm.entity.Centralized;

import java.util.List;

public interface CentralizedService {
    List<Centralized> selectCentralized();

    Object findByCentralized(String  uid, String command, String groups, String  grade, Integer jid);

    void insertCentralized(String position,String network, String ip, String port);
}
