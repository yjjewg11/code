package com.company.news.jsonform;


public class UserRelationTrainingCourseJsonform extends AbstractJsonform {
  private Long id;//主键
  private Long course_id;//关联课程id
  private Long time_schedule_id;//关联课程时段id
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public Long getCourse_id() {
    return course_id;
  }
  public void setCourse_id(Long course_id) {
    this.course_id = course_id;
  }
  public Long getTime_schedule_id() {
    return time_schedule_id;
  }
  public void setTime_schedule_id(Long time_schedule_id) {
    this.time_schedule_id = time_schedule_id;
  }
  
  
}
