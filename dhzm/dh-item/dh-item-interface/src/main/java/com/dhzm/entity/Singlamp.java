package com.dhzm.entity;
public class Singlamp {

  private long id;
  private String uid;
  private double voltage;
  private double flow;
  private String  groups;
  private String field;
  private String state;
  private String brightness1;
  private String types;
  private java.sql.Timestamp comtime;
  private String operation;
  private String  grade;
  private String command;
  private long jid;
  private String  network;

  @Override
  public String toString() {
    return
            id +
            uid +
            voltage +
            flow +
             groups +
             field +
            state +
             brightness1 +
            types +
           comtime +
            operation +
           grade +
            command +
             jid +
            network ;

  }

  public String getNetwork() {
    return network;
  }
  public void setNetwork(String network) {
    this.network = network;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }


  public double getVoltage() {
    return voltage;
  }

  public void setVoltage(double voltage) {
    this.voltage = voltage;
  }


  public double getFlow() {
    return flow;
  }

  public void setFlow(double flow) {
    this.flow = flow;
  }


  public String  getGroups() {
    return groups;
  }

  public void setGroups(String  groups) {
    this.groups = groups;
  }


  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public String getBrightness1() {
    return brightness1;
  }

  public void setBrightness1(String brightness1) {
    this.brightness1 = brightness1;
  }


  public String getTypes() {
    return types;
  }

  public void setTypes(String types) {
    this.types = types;
  }


  public java.sql.Timestamp getComtime() {
    return comtime;
  }

  public void setComtime(java.sql.Timestamp comtime) {
    this.comtime = comtime;
  }


  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }


  public String  getGrade() {
    return grade;
  }

  public void setGrade(String  grade) {
    this.grade = grade;
  }


  public String getCommand() {
    return command;
  }

  public void setCommand(String command) {
    this.command = command;
  }


  public long getJid() {
    return jid;
  }

  public void setJid(long jid) {
    this.jid = jid;
  }

}
