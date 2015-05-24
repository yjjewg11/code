package com.company.news.jsonform;

import java.sql.Timestamp;


/**
 * 用户修改资料，body传入json数据转对象。
 * 
 * @author Administrator
 * 
 */
public class UserModifyJsonform extends AbstractJsonform {

  private String name;// 昵称
  private String real_name;// 真实姓名
  private String identity_card;// 身份证号
  private Integer sex;// 0:男,1:女
  private String city;// 所在城市
  private Timestamp birth;//出生年月日.格式：2012-01-01 00:00:00
  private String context;//简介，自由填写（300个字符）
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getReal_name() {
    return real_name;
  }

  public void setReal_name(String real_name) {
    this.real_name = real_name;
  }

  public String getIdentity_card() {
    return identity_card;
  }

  public void setIdentity_card(String identity_card) {
    this.identity_card = identity_card;
  }

  public Integer getSex() {
    return sex;
  }

  public void setSex(Integer sex) {
    this.sex = sex;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Timestamp getBirth() {
    return birth;
  }

  public void setBirth(Timestamp birth) {
    this.birth = birth;
  }

  public String getContext() {
    return context;
  }

  public void setContext(String context) {
    this.context = context;
  }

}
