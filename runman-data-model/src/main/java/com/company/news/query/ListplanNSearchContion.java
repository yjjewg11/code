package com.company.news.query;

public class ListplanNSearchContion extends NSearchContion {
	private Integer orderlistid;

	private Integer flowStatus;
	
	private Integer isassign;

	private Integer channelId;

	private Integer coverstatus;

	private String coverleader;

	private String coverleadercode;

	public Integer getCoverstatus() {
		return coverstatus;
	}

	public void setCoverstatus(Integer coverstatus) {
		this.coverstatus = coverstatus;
	}

	private Boolean isassgin = false;

	public Boolean getIsassgin() {
		return isassgin;
	}

	public void setIsassgin(Boolean isassgin) {
		this.isassgin = isassgin;
	}

	private Boolean isimportantlevelstar = false;

	public Boolean getIsimportantlevelstar() {
		return isimportantlevelstar;
	}

	public void setIsimportantlevelstar(Boolean isimportantlevelstar) {
		this.isimportantlevelstar = isimportantlevelstar;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
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

	public String getCoverleader() {
		return coverleader;
	}

	public void setCoverleader(String coverleader) {
		this.coverleader = coverleader;
	}

	public String getCoverleadercode() {
		return coverleadercode;
	}

	public void setCoverleadercode(String coverleadercode) {
		this.coverleadercode = coverleadercode;
	}

	public Integer getIsassign() {
		return isassign;
	}

	public void setIsassign(Integer isassign) {
		this.isassign = isassign;
	}

}
