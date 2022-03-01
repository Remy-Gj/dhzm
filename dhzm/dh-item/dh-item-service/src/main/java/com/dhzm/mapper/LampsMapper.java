package com.dhzm.mapper;

import com.dhzm.entity.Singlamp;
import com.dhzm.entity.Singlecontrol;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface LampsMapper {

    @Select("select a.*,b.network from singlamp a , centralized b where a.jid = b.jid and a.jid = #{jid}")
    List<Singlamp> select(@Param("jid") Integer jid);

    @Select("SELECT hander,instructions,pklength,centralized,uid,command,groups,lamps,bright,checkcode,pktail FROM SingleControl WHERE uid=#{uid} AND command =#{command}")
    List<Singlecontrol> openLamps(@Param("uid") String uid, @Param("command")String command);

    @Update("UPDATE `singlamp` SET command = #{command} , comtime = #{communicationTime} WHERE uid =#{uid} ")
    void update(@Param("uid") String uid, @Param("command")String command,String communicationTime);
}
