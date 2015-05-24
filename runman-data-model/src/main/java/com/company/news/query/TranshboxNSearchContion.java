package com.company.news.query;

public class TranshboxNSearchContion extends NSearchContion {
  private Integer objtype;
  private String objname;
  
public String getObjname() {
	return objname;
}

public void setObjname(String objname) {
	this.objname = objname;
}

public Integer getObjtype() {
	return objtype;
}

public void setObjtype(Integer objtype) {
	this.objtype = objtype;
}
}
