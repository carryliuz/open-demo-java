package com.awaken.imagine.model.order;

import java.math.BigDecimal;

/**
 * 同步历史订单
 * @author Carry.Liu
 */
public class AddHistoryOrderReq extends AddOrderReq {

	/* 基础服务费 */
    private BigDecimal baseFee;

	/* 支付手续费 */
    private BigDecimal channelFee;

	/* 业务发生时间 格式：2022-01-01 09:21:35*/
    private String payMonth;
    
	/* 支付时间 格式：2022-01-01 09:21:35*/
    private String payTime;

	public BigDecimal getBaseFee() {
		return baseFee;
	}

	public void setBaseFee(BigDecimal baseFee) {
		this.baseFee = baseFee;
	}

	public BigDecimal getChannelFee() {
		return channelFee;
	}

	public void setChannelFee(BigDecimal channelFee) {
		this.channelFee = channelFee;
	}

	public String getPayMonth() {
		return payMonth;
	}

	public void setPayMonth(String payMonth) {
		this.payMonth = payMonth;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
    
}
