package com.awaken.imagine.model;

public class BaseReq {

	/* 随机字符串，长度要求在32位以内 */
	private String nonce;

	/* 签名字符串 */
	private String sign;

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
}
