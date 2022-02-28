package com.dhzm.mapper;

import com.dhzm.entity.Centralized;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CentralizedMapper {

    @Select("SELECT jid ,network,ip,`port` FROM `centralized`")
    List<Centralized> selectCentralized();

    @Select("SELECT network,ip,`port` FROM `centralized` WHERE  jid=#{jid}")
    List<Centralized> findByCentralized(Integer jid);

    @Insert("INSERT INTO `centralized` VALUES(NULL,#{network},#{ip},#{port},NULL,NULL,NULL)\n")
    void insertCentralized(String network, String ip, String port);
}
