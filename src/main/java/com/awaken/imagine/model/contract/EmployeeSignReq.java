package com.awaken.imagine.model.contract;

import com.awaken.imagine.model.BaseReq;

public class EmployeeSignReq extends BaseReq {

	/* 企业端用户编号 */
    private String employeeNo;

    /* 所属服务商ID */
    private String providerId;
    
    /* 项目ID */
    private String projectId;

    /* 姓名 */
    private String name;

    /* 登记手机号 */
    private String phone;

    /* 证件号码 */
    private String papersNo;

    /* 银行卡号 */
    private String bankCardNo;
    
    /* 银行名称 */
    private String bankName;

    /* 回调通知url（如果为空则使用企业后台配置的地址，如果参数既为空，后台也没配置则不回调） */
    private String notifyUrl;

    /* 身份证人像面照片文件的base64字符串 */
    private String idCardFrontBase64;
    
    /* 份证国徽面照片文件的base64字符串 */
    private String idCardBackBase64;

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
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

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getIdCardFrontBase64() {
		return idCardFrontBase64;
	}

	public void setIdCardFrontBase64(String idCardFrontBase64) {
		this.idCardFrontBase64 = idCardFrontBase64;
	}

	public String getIdCardBackBase64() {
		return idCardBackBase64;
	}

	public void setIdCardBackBase64(String idCardBackBase64) {
		this.idCardBackBase64 = idCardBackBase64;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
}
