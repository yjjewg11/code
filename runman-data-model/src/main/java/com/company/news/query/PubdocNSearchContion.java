package com.company.news.query;

public class PubdocNSearchContion extends NSearchContion {
	private Integer orderlistid;

	private Integer flowStatus;
	
	private Integer playStatus;

	private Integer columnid;

	private Integer channelId;

	private Integer isshowed;

	private Integer emphasislevel;
	
	private String editorby;

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

	public String getEditorby() {
		return editorby;
	}

	public void setEditorby(String editorby) {
		this.editorby = editorby;
	}
}
