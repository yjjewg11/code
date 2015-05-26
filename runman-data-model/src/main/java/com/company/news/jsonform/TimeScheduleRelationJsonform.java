package com.company.news.jsonform;


/**
 * 训练课程表(教练用户发起，1对多）
 * @author Administrator
 *
 */
public class TimeScheduleRelationJsonform extends AbstractJsonform{
  private Long id;//主键
  private Integer type;//类型。1：关联课程时段。2：关联教练可授课时间段
  private Long relation_id;//关联对象id。与type配合使用确定关联对象。
  private Integer time_period;//[必填]时间周期设置。1：表示每周。2：表示每天。3：表示每月
  private String start_time;//[必填]开始时间。格式24H：mm:SS,举例：14：00：00。
  private String end_time;//[必填]结束时间。格式24H：mm:SS,举例：17：00：00。
  private Integer total_time_length;//时长（单位分钟，自动计算），根据end_time-start_time计算。
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public Integer getType() {
    return type;
  }
  public void setType(Integer type) {
    this.type = type;
  }
  public Long getRelation_id() {
    return relation_id;
  }
  public void setRelation_id(Long relation_id) {
    this.relation_id = relation_id;
  }
  public Integer getTime_period() {
    return time_period;
  }
  public void setTime_period(Integer time_period) {
    this.time_period = time_period;
  }
  public Integer getTotal_time_length() {
    return total_time_length;
  }
  public void setTotal_time_length(Integer total_time_length) {
    this.total_time_length = total_time_length;
  }
  public String getStart_time() {
    return start_time;
  }
  public void setStart_time(String start_time) {
    this.start_time = start_time;
  }
  public String getEnd_time() {
    return end_time;
  }
  public void setEnd_time(String end_time) {
    this.end_time = end_time;
  }
  

}
