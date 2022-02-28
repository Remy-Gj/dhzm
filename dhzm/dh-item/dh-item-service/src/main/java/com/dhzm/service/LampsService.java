package com.dhzm.service;

import com.dhzm.entity.Singlamp;
import com.dhzm.entity.Singlecontrol;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LampsService {
    List<Singlamp> select(Integer jid);

    List<Singlecontrol> openLamps(@Param("uid") String uid, @Param("command")String command);


    void update(@Param("uid") String uid, @Param("command")String command);
}
