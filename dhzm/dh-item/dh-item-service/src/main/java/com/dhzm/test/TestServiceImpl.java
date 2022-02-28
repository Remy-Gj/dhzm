package com.dhzm.test;

import com.dhzm.entity.Ceshi;
import com.dhzm.entity.Singlecontrol;
import com.dhzm.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Ceshi> find() {
        List list=testMapper.select();
        return list;
    }

    @Override
    public List<Singlecontrol> openLamps(String uid, String command) {
        List<Singlecontrol> list=testMapper.openLamps(uid,command);
        return list;
    }

    @Override
    public void update(String uid, String command) {
        testMapper.update(uid,command);
    }



}
