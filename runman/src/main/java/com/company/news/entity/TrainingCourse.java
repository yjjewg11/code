package com.company.news.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 训练课程表(教练用户发起，1对多）
 * @author Administrator
 *
 */
@Entity
@Table(name="run_training_course") 
public class TrainingCourse implements DBEntityInterface {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id", unique = true, nullable = false)
  private Long id;//主键
  @Column
  private Long create_userid;//创建用户id
  @Column
  private Integer exercise_mode;//[必填]锻炼方式.枚举值：1.普通跑步(默认)。2.马拉松
  @Column
  private String title;//课程名称【必填】，20字符
  @Column
  private String length;//课程时长【必填】，单位分钟
  @Column
  private String context;//授课内容，自由填写。不限字数
  @Column
  private String palce;//授课地点。40字符
  @Column
  private Double price;//[必填]发布价格 1~9999
  @Column
  private String plan_time_period;//时段偏好。40字符
  
  
  @Override
  public Long getId() {
    // TODO Auto-generated method stub
    return id;
  }

}
