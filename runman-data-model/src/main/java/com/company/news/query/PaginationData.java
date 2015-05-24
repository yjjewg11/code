package com.company.news.query;

public class PaginationData {
    private String orderFiled;

    private String orderType;

    public static final int DEFAULT_PAGESIZE = 20;

    private int pageSize = DEFAULT_PAGESIZE;

    public static final int DEFAULT_PAGENO = 1;

    private int pageNo = DEFAULT_PAGENO;

    public static final String SORT_NONE = "";

    public static final String SORT_ASC = "ASC";

    public static final String SORT_DESC = "DESC";

    public int getStartIndex(){
      return (pageNo-1)*pageSize;
    }
    public String getOrderFiled() {
      return orderFiled;
    }

    public void setOrderFiled(String orderFiled) {
      this.orderFiled = orderFiled;
    }

    public String getOrderType() {
      return orderType;
    }

    public void setOrderType(String orderType) {
      this.orderType = orderType;
    }

    public int getPageSize() {
      return pageSize;
    }

    public void setPageSize(int pageSize) {
      this.pageSize = pageSize;
    }

    public int getPageNo() {
      return pageNo;
    }

    public void setPageNo(int pageNo) {
      this.pageNo = pageNo;
    }

}
