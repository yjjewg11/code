package com.company.news.query;

public class ViedocheckNSearchContion extends NSearchContion {
	private Integer orderlistid;

	private Integer flowStatus;
	
	private Integer playStatus;

	private Integer columnid;

	private Integer channelId;

	private Integer isshowed;

	private Integer emphasislevel;
	
	private String count;
	
	private String editorcode;
	
	private String keyword;
	
	private String author;
	
	private String pgmsecstatus;
	
	private String departmentcode;
	
	private String programedit;
	public Integer getIsshowed() {
		return isshowed;
	}

	public void setIsshowed(Integer isshowed) {
		this.isshowed = isshowed;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	private Integer timePeriodId;

	public Integer getTimePeriodId() {
		return timePeriodId;
	}

	public void setTimePeriodId(Integer timePeriodId) {
		this.timePeriodId = timePeriodId;
	}

	public Integer getColumnid() {
		return columnid;
	}

	public void setColumnid(Integer columnid) {
		this.columnid = columnid;
	}

	public Integer getOrderlistid() {
		return orderlistid;
	}

	public void setOrderlistid(Integer orderlistid) {
		this.orderlistid = orderlistid;
	}

	public Integer getFlowStatus() {
		return flowStatus;
	}

	public void setFlowStatus(Integer flowStatus) {
		this.flowStatus = flowStatus;
	}

	public Integer getEmphasislevel() {
		return emphasislevel;
	}

	public void setEmphasislevel(Integer emphasislevel) {
		this.emphasislevel = emphasislevel;
	}

	public Integer getPlayStatus() {
		return playStatus;
	}

	public void setPlayStatus(Integer playStatus) {
		this.playStatus = playStatus;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getEditorcode() {
		return editorcode;
	}

	public void setEditorcode(String editorcode) {
		this.editorcode = editorcode;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPgmsecstatus() {
		return pgmsecstatus;
	}

	public void setPgmsecstatus(String pgmsecstatus) {
		this.pgmsecstatus = pgmsecstatus;
	}

	public String getDepartmentcode() {
		return departmentcode;
	}

	public void setDepartmentcode(String departmentcode) {
		this.departmentcode = departmentcode;
	}

	public String getProgramedit() {
		return programedit;
	}

	public void setProgramedit(String programedit) {
		this.programedit = programedit;
	}
}
