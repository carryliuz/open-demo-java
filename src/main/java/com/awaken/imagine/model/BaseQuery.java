package com.awaken.imagine.model;

public class BaseQuery {

	/* 服务商ID */
	private String providerId;
	
    /* 页码（默认第1页）*/
    private Integer pageNum = 1;

    /* 每页行数（默认查10行） */
    private Integer pageSize = 10;
    
	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
