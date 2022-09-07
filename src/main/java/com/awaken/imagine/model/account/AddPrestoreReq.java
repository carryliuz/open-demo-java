package com.awaken.imagine.model.account;

import java.math.BigDecimal;

import com.awaken.imagine.model.BaseReq;

public class AddPrestoreReq extends BaseReq {
	
    /* 服务商ID */
    private String providerId;

    /* 充值金额 */
    private BigDecimal amount;

    /* 开户行 */
    private String bank;

    /* 付款账号 */
    private String bankNo;

    /* 银行开户户名 */
    private String bankName;

    /* 付款凭证（图片转base64字符串）非必传 */
    private String payImg;

    /* 付款时间 格式2021-08-10 */
    private String payTime;

    /* 支付类型,0,银行转账 1,支付宝 */
    private Integer payType;

    /* 项目ID */
    private String projectId;

    /* 备注 */
    private String remarks;

    /* 流水号 */
    private String serialNumber;

    /* 异步通知地址 */
    private String notifyUrl;

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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

	public String getPayImg() {
		return payImg;
	}

	public void setPayImg(String payImg) {
		this.payImg = payImg;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
    
}
