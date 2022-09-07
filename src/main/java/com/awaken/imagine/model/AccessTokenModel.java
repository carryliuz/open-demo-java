package com.awaken.imagine.model;

public class AccessTokenModel extends BaseResp {

	private String accessToken; // token
	private Long expiresIn; // 有效时间（秒）
	
	public String getAccessToken() {
		return accessToken;
	}
	
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	public Long getExpiresIn() {
		return expiresIn;
	}
	
	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}
	
}
