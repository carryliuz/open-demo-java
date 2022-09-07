package com.awaken.imagine.model.contract;

import com.awaken.imagine.model.BaseResp;

public class AddEmployeeResp extends BaseResp{

	/* 自由职业者ID*/
	private String employeeId;

	/* 扩展参数（原样返回） */
	private String extra;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}
	
}
