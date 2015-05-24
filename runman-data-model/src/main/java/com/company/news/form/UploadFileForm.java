package com.company.news.form;


public class UploadFileForm {
  private String type;//文件类型.头像,身份证认证,教练认证
  private String file_name;// 文件名
  private Long file_size;// [必填]文件大小
  private Integer deleteOldFile;// [必填]文件大小.1:删除，其他不删除
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  public String getFile_name() {
    return file_name;
  }
  public void setFile_name(String file_name) {
    this.file_name = file_name;
  }
  public Long getFile_size() {
    return file_size;
  }
  public void setFile_size(Long file_size) {
    this.file_size = file_size;
  }
  public Integer getDeleteOldFile() {
    return deleteOldFile;
  }
  public void setDeleteOldFile(Integer deleteOldFile) {
    this.deleteOldFile = deleteOldFile;
  }
  
}
