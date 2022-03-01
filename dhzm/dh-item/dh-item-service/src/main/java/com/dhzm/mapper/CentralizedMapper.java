package com.dhzm.mapper;

import com.dhzm.entity.Centralized;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CentralizedMapper {

    @Select("SELECT a.* FROM `centralized` a")
    List<Centralized> selectCentralized();

    @Select("SELECT network,ip,`port` FROM `centralized` WHERE  jid=#{jid}")
    List<Centralized> findByCentralized(Integer jid);

    @Insert("INSERT INTO `centralized` VALUES(NULL,#{position},#{ip},#{network},#{port},NULL,#{addTime},#{lastUpdateTime})\n")
    void insertCentralized(String position, String network, String ip, String port, String addTime, String lastUpdateTime);

    @Update("UPDATE `centralized` a SET position = #{ecPosition} , ip = #{ecIp}, network = #{ecNetwork},port = #{ecPort},updatetime = #{lastUpdateTime} WHERE a.jid = #{ecJid}")
    void updateCentralized(Integer ecJid, String ecPosition, String ecIp, String ecNetwork, String ecPort, String lastUpdateTime);

    @Delete("DELETE FROM centralized WHERE jid =#{ecJid} ")
    void deleteCentralized(Integer ecJid);
}
