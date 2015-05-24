package com.company.news.jsonform;

import java.sql.Timestamp;

/**
 * 训练计划创建或修改表单
 * @author Administrator
 *
 */
public class TrainingPlanJsonform {
  private Long id;//主键
  private Integer exercise_mode;//锻炼方式.枚举值：1.普通跑步。2.马拉松
  private String context;//其他要求，自由填写
  private Timestamp start_time;//开始日期时间
  private Timestamp end_time;//结束日期时间
  private String place;//地点
  private String map_coordinates;//地点坐标,(比如:116.307629,40.058359)
  private Integer runKM;//距离（单位KM），计划跑多少公里
  private Integer run_times;//计划跑多少公里时间要求
  private Double price;//发布价格
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public Integer getExercise_mode() {
    return exercise_mode;
  }
  public void setExercise_mode(Integer exercise_mode) {
    this.exercise_mode = exercise_mode;
  }
  public String getContext() {
    return context;
  }
  public void setContext(String context) {
    this.context = context;
  }
  public Timestamp getStart_time() {
    return start_time;
  }
  public void setStart_time(Timestamp start_time) {
    this.start_time = start_time;
  }
  public Timestamp getEnd_time() {
    return end_time;
  }
  public void setEnd_time(Timestamp end_time) {
    this.end_time = end_time;
  }
  public String getPlace() {
    return place;
  }
  public void setPlace(String place) {
    this.place = place;
  }
  public String getMap_coordinates() {
    return map_coordinates;
  }
  public void setMap_coordinates(String map_coordinates) {
    this.map_coordinates = map_coordinates;
  }
  public Integer getRunKM() {
    return runKM;
  }
  public void setRunKM(Integer runKM) {
    this.runKM = runKM;
  }
  public Integer getRun_times() {
    return run_times;
  }
  public void setRun_times(Integer run_times) {
    this.run_times = run_times;
  }
  public Double getPrice() {
    return price;
  }
  public void setPrice(Double price) {
    this.price = price;
  }
  
}
