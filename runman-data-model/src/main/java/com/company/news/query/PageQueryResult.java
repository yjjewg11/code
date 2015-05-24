package com.company.news.query;

import java.io.Serializable;
import java.util.List;

public class PageQueryResult implements Serializable{
  
  public PageQueryResult(int pageSize, long pageNo, List data, long totalCount) {
    super();
    this.pageSize = pageSize;
    this.pageNo = pageNo;
    this.data = data;
    this.totalCount = totalCount;
  }
  public int getPageSize() {
    return pageSize;
  }
  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }
  public long getPageNo() {
    return pageNo;
  }
  public void setPageNo(long pageNo) {
    this.pageNo = pageNo;
  }
  public List getData() {
    return data;
  }
  public void setData(List data) {
    this.data = data;
  }
  public long getTotalCount() {
    return totalCount;
  }
  public void setTotalCount(long totalCount) {
    this.totalCount = totalCount;
  }
  private int pageSize;
  private long pageNo;
  private List data;
  private long totalCount;

}
