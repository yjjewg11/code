package com.company.news.query;

public class TimeScheduleRelationSearchContion extends NSearchContion {
  private String type;//类型。1：关联课程时段。2：关联教练可授课时间段
  private Long relation_id;//关联对象id。与type配合使用确定关联对象。
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public Long getRelation_id() {
    return relation_id;
  }
  public void setRelation_id(Long relation_id) {
    this.relation_id = relation_id;
  }

}
