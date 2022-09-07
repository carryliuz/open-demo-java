package com.awaken.imagine.model.invoice;

import java.util.List;

import com.awaken.imagine.model.BaseQuery;

public class InvoiceOrderQuery extends BaseQuery {
	
	/* 订单状态:10未申请,20部分已申请，30全部已申请，90过期，99作废 */
    private Integer status;

	/* 状态集合 */
    private List<Integer> statusList;

	/* 开始日期  格式：yyyyMMdd */
    private String startDate;

	/* 截止日期 格式：yyyyMMdd */
    private String endDate;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<Integer> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<Integer> statusList) {
		this.statusList = statusList;
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