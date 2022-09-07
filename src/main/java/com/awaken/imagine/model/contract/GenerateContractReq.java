package com.awaken.imagine.model.contract;

public class GenerateContractReq {

	/* 自由职业者ID */
	private String employeeId;
	
	/* 自由职业者临时token */
	private String userToken;
	
	/* 银行账号 */
	private String bankCardNo;
	
	/* 身份证正面照片base64字符串格式 */
	private String idCardFrontBase64;
	
	/* 身份证反面照片base64字符串格式 */
	private String idCardBackBase64;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public String getBankCardNo() {
		return bankCardNo;
	}

	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
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
	
}
