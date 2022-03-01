package com.dhzm.entity;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Centralized {
  private long jid;
  private String position;
  private String network;
  private String ip;
  private String address;
  private String updatetime;
  private String addtime;
  private Integer port;


  public long getJid() {
    return jid;
  }

  public void setJid(long jid) {
    this.jid = jid;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getNetwork() {
    return network;
  }

  public void setNetwork(String network) {
    this.network = network;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getUpdatetime() {
    return updatetime;
  }

  public void setUpdatetime(String updatetime) {
    this.updatetime = updatetime;
  }

  public String getAddtime() {
    return addtime;
  }

  public void setAddtime(String addtime) {
    this.addtime = addtime;
  }

  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }
}
