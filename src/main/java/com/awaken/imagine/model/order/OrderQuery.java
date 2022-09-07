package com.awaken.imagine.model.order;

import java.util.List;

import com.awaken.imagine.model.BaseQuery;

public class OrderQuery extends BaseQuery {

	/* 职乐订单唯一id */
    private String id;

    /* 企业订单号,批次号,单个企业内唯一 */
    private String tradeNo;

    /* 订单状态:0:支付中,1:支付成功,9:支付失败 */
    private Integer status;

    /* 自由职业者人员ID列表 */
    private List<String> employeeIdList;

    /* 证件号列表 */
    private List<String> papersNoList;

    /* 交易开始日期 格式：yyyy-MM-dd HH:mm:ss */
    private String startDate;

    /* 交易截止日期 格式：yyyy-MM-dd HH:mm:ss */
    private String endDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<String> getEmployeeIdList() {
		return employeeIdList;
	}

	public void setEmployeeIdList(List<String> employeeIdList) {
		this.employeeIdList = employeeIdList;
	}

	public List<String> getPapersNoList() {
		return papersNoList;
	}

	public void setPapersNoList(List<String> papersNoList) {
		this.papersNoList = papersNoList;
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
