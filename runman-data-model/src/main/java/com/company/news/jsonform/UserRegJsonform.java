package com.company.news.jsonform;

import java.sql.Timestamp;


/**
 * 用户注册，body传入json数据转对象。
 * 
 * @author Administrator
 * 
 */
public class UserRegJsonform extends AbstractJsonform {

  private String loginname;// 登录名。手机号码【必填】

  private String name;// 昵称

  private String password;// 密码，md5加密。（UTF-8）区分大小写

  private String tel;// 电话号码。【必填】
  
  private String tel_smscode;// 手机验证码

  private String real_name;// 真实姓名

  private String identity_card;// 身份证号

  private Integer sex;// 0:男,1:女

  private String city;// 所在城市


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


  public String getPassword() {
    return password;
  }


  public void setPassword(String password) {
    this.password = password;
  }


  public String getTel() {
    return tel;
  }


  public void setTel(String tel) {
    this.tel = tel;
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


  public String getTel_smscode() {
    return tel_smscode;
  }


  public void setTel_smscode(String tel_smscode) {
    this.tel_smscode = tel_smscode;
  }


  public String getCity() {
    return city;
  }


  public void setCity(String city) {
    this.city = city;
  }


}
