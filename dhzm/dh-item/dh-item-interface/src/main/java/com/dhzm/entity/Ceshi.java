package com.dhzm.entity;

import lombok.Data;

import javax.persistence.Table;

@Table(name = "ceshi")
public class Ceshi {

  private String uid;
  private String uname;


  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }


  public String getUname() {
    return uname;
  }

  public void setUname(String uname) {
    this.uname = uname;
  }

}
