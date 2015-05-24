package com.company.news.jsonform;

import java.sql.Timestamp;



/**
 * 用户表-教练用户信息提交
 * 
 * @author Administrator
 * 
 */
public class UserTraninerInfoJsonform extends AbstractJsonform {
  private Long id;//主键
  private String real_name;//真实姓名
  private String identity_card;//身份证号
  private String identity_card_imgurl;//上传身份证图片地址。用于认证
  private Integer sex;//0:男,1:女
  private Timestamp birth;//出生年月日
  private String city;// 所在城市
  private String context;//简介，自由填写（300个字符）
  private Integer trainer_status;//教练工作状态：。1：可以接单。2：暂停接单。
  private String marathon_imgurl;//马拉松认证图片地址.
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
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
  public String getIdentity_card_imgurl() {
    return identity_card_imgurl;
  }
  public void setIdentity_card_imgurl(String identity_card_imgurl) {
    this.identity_card_imgurl = identity_card_imgurl;
  }
  public Integer getSex() {
    return sex;
  }
  public void setSex(Integer sex) {
    this.sex = sex;
  }
  public Timestamp getBirth() {
    return birth;
  }
  public void setBirth(Timestamp birth) {
    this.birth = birth;
  }
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }
  public String getContext() {
    return context;
  }
  public void setContext(String context) {
    this.context = context;
  }
  public Integer getTrainer_status() {
    return trainer_status;
  }
  public void setTrainer_status(Integer trainer_status) {
    this.trainer_status = trainer_status;
  }
  public String getMarathon_imgurl() {
    return marathon_imgurl;
  }
  public void setMarathon_imgurl(String marathon_imgurl) {
    this.marathon_imgurl = marathon_imgurl;
  }

}
