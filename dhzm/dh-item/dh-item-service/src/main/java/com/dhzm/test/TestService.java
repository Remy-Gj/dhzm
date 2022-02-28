package com.dhzm.test;

import com.dhzm.entity.Ceshi;
import com.dhzm.entity.Singlecontrol;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface TestService {

    List<Ceshi> find();

    List<Singlecontrol> openLamps(@Param("uid") String uid, @Param("command")String command);


    void update(@Param("uid") String uid, @Param("command")String command);

}
