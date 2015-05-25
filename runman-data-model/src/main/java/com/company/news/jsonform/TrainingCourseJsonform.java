package com.company.news.jsonform;

import java.sql.Timestamp;

/**
 * 训练课程表(教练用户发起，1对多）
 * @author Administrator
 *
 */
public class TrainingCourseJsonform extends AbstractJsonform{
  private Long id;//主键 
  private Integer exercise_mode;//[必填]锻炼方式.枚举值：1.普通跑步(默认)。2.马拉松
  private String title;//课程名称【必填】，20字符
  private String time_length;//课程时长【必填】，单位分钟
  private Integer difficulty_degree;//课程难度。1-5星。
  private Integer max_students;//授课人数限制。默认1.
  private String context;//授课内容，自由填写。不限字数
  private String place;//授课地点。40字符
  private Double price;//[必填]发布价格 1~9999
  
  
  public Long getId() {
    // TODO Auto-generated method stub
    return id;
  }


  public Integer getExercise_mode() {
    return exercise_mode;
  }


  public void setExercise_mode(Integer exercise_mode) {
    this.exercise_mode = exercise_mode;
  }


  public String getTitle() {
    return title;
  }


  public void setTitle(String title) {
    this.title = title;
  }


  public String getTime_length() {
    return time_length;
  }


  public void setTime_length(String time_length) {
    this.time_length = time_length;
  }


  public Integer getDifficulty_degree() {
    return difficulty_degree;
  }


  public void setDifficulty_degree(Integer difficulty_degree) {
    this.difficulty_degree = difficulty_degree;
  }


  public Integer getMax_students() {
    return max_students;
  }


  public void setMax_students(Integer max_students) {
    this.max_students = max_students;
  }


  public String getContext() {
    return context;
  }


  public void setContext(String context) {
    this.context = context;
  }


  public String getPlace() {
    return place;
  }


  public void setPlace(String place) {
    this.place = place;
  }


  public Double getPrice() {
    return price;
  }


  public void setPrice(Double price) {
    this.price = price;
  }


  public void setId(Long id) {
    this.id = id;
  }

}
