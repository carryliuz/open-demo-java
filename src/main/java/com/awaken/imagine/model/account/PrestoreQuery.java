package com.awaken.imagine.model.account;

import com.awaken.imagine.model.BaseQuery;

public class PrestoreQuery extends BaseQuery {
		
	/* 充值申请ID */
    private String id;

    /* 充值状态 0 已提交 1 余额检查中 2 完成充值 9 充值驳回 */
    private Integer status;

    /*  订单编号/开户人姓名/开户行名称 */
    private String bankKeyword;

    /* 开始日期 格式：yyyyMMddHHmmss*/
    private String startDate;

    /* 结束日期 格式：yyyyMMddHHmmss */
    private String endDate;
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getBankKeyword() {
		return bankKeyword;
	}

	public void setBankKeyword(String bankKeyword) {
		this.bankKeyword = bankKeyword;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}