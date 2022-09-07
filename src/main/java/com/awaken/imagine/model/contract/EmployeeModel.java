package com.awaken.imagine.model.contract;

import com.awaken.imagine.model.BaseReq;

public class EmployeeModel extends BaseReq {

	/* 人员id */
    private String id;

    /* 所属服务商ID */
    private String providerId;

    /* 姓名 */
    private String name;

    /* 登记手机号 */
    private String phone;

    /* 证件类型0:身份证 */
    private Integer papersType;

    /* 证件号码 */
    private String papersNo;

    /* 银行卡号 */
    private String bankCardNo;

    /* 开户行 */
    private String bankName;

    /* 银行预留手机号 */
    private String bankPhone;
    
    /* 工号 */
    private String employeeNo;

    /* 扩展参数，回调时原文返回 */
    private String extra;

    /* 电签状态 0未签 1已签 2签署中 9作废 */
    private Integer contractStatus;

    /* 回调通知url */
    private String notifyUrl;
    
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getPapersType() {
		return papersType;
	}

	public void setPapersType(Integer papersType) {
		this.papersType = papersType;
	}

	public String getPapersNo() {
		return papersNo;
	}

	public void setPapersNo(String papersNo) {
		this.papersNo = papersNo;
	}

	public String getBankCardNo() {
		return bankCardNo;
	}

	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
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

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public Integer getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(Integer contractStatus) {
		this.contractStatus = contractStatus;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
    
}
