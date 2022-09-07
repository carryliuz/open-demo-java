package com.awaken.imagine.model.order;

import java.math.BigDecimal;

import com.awaken.imagine.model.BaseReq;

/**
 * 添加提现订单
 * @creator Carry.Liu
 */
public class AddOrderReq extends BaseReq {

    /* 企业订单号,批次号,单个企业内唯一 */
    private String tradeNo;

    /* 业务经营费用(个人到手) */
    private BigDecimal bizFee;

    /* 服务商ID，选填 */
    private String providerId;

    /* 项目ID，选填 */
    private String projectId;

    /* 自由职业者在企业编号，选填 */
    private String employeeNo;

    /* 收款账户(支付宝账户或银行卡号) */
    private String bankCardNo;

    /* 收款方式，选填 1:银行卡，2:支付宝 */
    private Integer paymentType;

    /* 银行卡预留姓名，选填 */
    private String bankName;

    /* 银行预留手机号，选填 */
    private String bankPhone;

    /* 付款备注，选填 */
    private String purpose;

    /* 扩展参数 原封不动回调给商户 可选 */
    private String extendParams;

    /* 姓名 */
    private String name;

    /* 证件号 */
    private String papersNo;

    /* 证件类型(0:身份证 1:护照 2:军官证 3:港澳台身份证) */
    private Integer papersType;

    /* 异步通知地址，选填 */
    private String notifyUrl;

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public BigDecimal getBizFee() {
		return bizFee;
	}

	public void setBizFee(BigDecimal bizFee) {
		this.bizFee = bizFee;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getBankCardNo() {
		return bankCardNo;
	}

	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}

	public Integer getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankPhone() {
		return bankPhone;
	}

	public void setBankPhone(String bankPhone) {
		this.bankPhone = bankPhone;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getExtendParams() {
		return extendParams;
	}

	public void setExtendParams(String extendParams) {
		this.extendParams = extendParams;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPapersNo() {
		return papersNo;
	}

	public void setPapersNo(String papersNo) {
		this.papersNo = papersNo;
	}

	public Integer getPapersType() {
		return papersType;
	}

	public void setPapersType(Integer papersType) {
		this.papersType = papersType;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	
}
