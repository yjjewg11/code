package com.company.news.vo;

import java.sql.Timestamp;




public class UserInfoReturn implements java.io.Serializable{
  private String loginname;//登录名。手机号码或邮箱
  private String name;//昵称
  private String head_imgurl;//头像地址。
  private Timestamp logintime;//最后一次登录时间。
  public String getLoginname() {
    return loginname;
  }
  public void setLoginname(String loginname) {
    this.loginname = loginname;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getHead_imgurl() {
    return head_imgurl;
  }
  public void setHead_imgurl(String head_imgurl) {
    this.head_imgurl = head_imgurl;
  }
  public Timestamp getLogintime() {
    return logintime;
  }
  public void setLogintime(Timestamp logintime) {
    this.logintime = logintime;
  }
 
}
