package com.awaken.imagine.model.account;

import java.util.Date;

import com.awaken.imagine.model.BaseResp;

public class PrestoreModel extends BaseResp {

	/* 充值记录ID */
    private String id;

    /* 服务商ID */
    private String providerId;

    /* 充值金额 */
    private String amount;

    /* 充值余额 */
    private String balance;

    /* 付款时间 */
    private Date payTime;

    /* 开户行 */
    private String bank;

    /* 付款账号 */
    private String bankNo;

    /* 银行开户户名 */
    private String bankName;

    /* 备注 */
    private String remarks;

    /* 付款凭证 */
    private String payImg;

    /* 充值状态：0,已提交 1，余额审查中 2,充值完成 9,充值驳回 */
    private int status;

    /* 流水号 */
    private String serialNumber;

    /* 项目ID */
    private String projectId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getPayImg() {
		return payImg;
	}

	public void setPayImg(String payImg) {
		this.payImg = payImg;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
    
}