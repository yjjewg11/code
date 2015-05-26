package com.company.news.query;

public class UserRelationTrainingCourseSearchContion extends NSearchContion {
  private Long user_id;//关联普通用户id
  private Long course_id;//关联课程id
  private Long time_schedule_id;//关联课程时段id
  public Long getUser_id() {
    return user_id;
  }
  public void setUser_id(Long user_id) {
    this.user_id = user_id;
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
