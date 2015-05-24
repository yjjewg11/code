package com.company.news.query;
import java.util.HashMap;
import java.util.Map;


public class NSearchContion {
  public static final String WORK = "w";  //相隔一周
  public static final String MONTH = "m"; //相隔一月
  public static final String DAY = "d";   //相隔一天

  private String type; //类型，我的查询类型，发布查询类型
  private String title; //标题
  private String startTime; // 开始时间
  private String endTime; // 结束时间
  private String status;
  private String content;
  private String keyword;
  private String queryType;
  public String getQueryType() {
    return queryType;
  }
  public void setQueryType(String queryType) {
    this.queryType = queryType;
  }
 
  private PaginationData psoData = new PaginationData();// 分页排序参数 
  private Map<String,String> extendData = new HashMap<String, String>();// 扩展参数

    /**
     * 分页加一
     */
    public void addPageNo(){
        this.getPsoData().setPageNo(this.getPsoData().getPageNo()+1);
    }
    /**
     * 重置分页为1
     */
    public void restPageNo(){
        this.getPsoData().setPageNo(1);
    }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getKeyword() {
    return keyword;
  }
  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getStartTime() {
    return startTime;
  }
  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }
  public String getEndTime() {
    return endTime;
  }
  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }
  public PaginationData getPsoData() {
    return psoData;
  }
  public void setPsoData(PaginationData psoData) {
    this.psoData = psoData;
  }
  public Map<String, String> getExtendData() {
    return extendData;
  }
  public void setExtendData(Map<String, String> extendData) {
    this.extendData = extendData;
  }
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  
}
