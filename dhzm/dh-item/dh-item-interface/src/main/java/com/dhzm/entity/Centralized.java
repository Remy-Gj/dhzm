package com.dhzm.entity;


public class Centralized {
  private long jid;
  private String network;
  private String ip;
  private Integer port;


  public long getJid() {
    return jid;
  }

  public void setJid(long jid) {
    this.jid = jid;
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


  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }

}
