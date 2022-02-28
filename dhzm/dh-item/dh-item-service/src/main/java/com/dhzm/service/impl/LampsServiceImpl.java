package com.dhzm.service.impl;

import com.dhzm.entity.Singlamp;
import com.dhzm.entity.Singlecontrol;
import com.dhzm.mapper.LampsMapper;
import com.dhzm.service.LampsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LampsServiceImpl implements LampsService {
@Autowired
private LampsMapper lampsMapper;


    @Override
    public List<Singlamp> select(Integer jid) {
        List<Singlamp> select = lampsMapper.select(jid);
        return select;
    }

    @Override
    public List<Singlecontrol> openLamps(String uid, String command) {
        List<Singlecontrol> list=lampsMapper.openLamps(uid,command);
        return list;
    }

    @Override
    public void update(String uid, String command) {
        lampsMapper.update(uid,command);
    }

}
