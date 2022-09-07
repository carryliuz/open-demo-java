package com.awaken.imagine.model.contract;

import com.awaken.imagine.model.BaseResp;

public class EmployeeUserTokenResp extends BaseResp {

	/* 自由职业者签约跳转token */
	private String userToken;
	
	/* 有效时间（秒）*/
	private Long expiresIn;

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public Long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}
	
}
