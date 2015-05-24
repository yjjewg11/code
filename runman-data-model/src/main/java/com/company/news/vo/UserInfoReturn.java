package com.company.news.vo;

import java.sql.Timestamp;



public class UserInfoReturn implements java.io.Serializable{
    private String loginname;//登录名。手机号码或邮箱
    private String name;//昵称
    private Timestamp logintime;//最后一次登录时间。
    private String tel;// 电话号码。
    private String real_name;// 真实姓名
    private String identity_card;// 身份证号
    private String real_name_verify;//实名认证。默认0，0:没验证。1:验证。2：提交验证
    private Integer sex;// 0:男,1:女
    private String city;// 所在城市
    private String head_imgurl;//头像地址。
    private Integer type;//用户类型。0:普通用户(默认)；1：跑步教练（马拉松教练）
    private String context;//简介，自由填写（300个字符）
    private Integer trainer_status;//教练工作状态：。1：可以接单。2：暂停接单。
    private String marathon_imgurl;//马拉松认证图片地址.
    private String marathon_verify;//马拉松认证状态。默认0，0:没验证。1:验证。2：提交验证
    private Timestamp birth;//出生年月日

    public Timestamp getBirth() {
        return birth;
    }

    public void setBirth(Timestamp birth) {
        this.birth = birth;
    }

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

    public Timestamp getLogintime() {
        return logintime;
    }

    public void setLogintime(Timestamp logintime) {
        this.logintime = logintime;
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

    public String getReal_name_verify() {
        return real_name_verify;
    }

    public void setReal_name_verify(String real_name_verify) {
        this.real_name_verify = real_name_verify;
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

    public String getHead_imgurl() {
        return head_imgurl;
    }

    public void setHead_imgurl(String head_imgurl) {
        this.head_imgurl = head_imgurl;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public String getMarathon_verify() {
        return marathon_verify;
    }

    public void setMarathon_verify(String marathon_verify) {
        this.marathon_verify = marathon_verify;
    }
}
