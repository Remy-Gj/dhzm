package com.dhzm.mapper;

import com.dhzm.entity.Ceshi;
import com.dhzm.entity.Singlecontrol;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TestMapper {

    @Select("SELECT uid,uname FROM ceshi")
    List<Ceshi> select();

    @Select("SELECT hander,instructions,pklength,centralized,uid,command,groups,lamps,bright,checkcode,pktail FROM SingleControl WHERE uid=#{uid} AND command =#{command}")
    List<Singlecontrol> openLamps(@Param("uid") String uid, @Param("command")String command);

    @Update("UPDATE `singlamp` SET command = #{command} WHERE uid =#{uid} ")
    void update(@Param("uid") String uid, @Param("command")String command);

}
