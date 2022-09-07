package com.awaken.imagine.model.order;

import java.math.BigDecimal;
import java.util.Date;

import com.awaken.imagine.model.BaseResp;

/**
 * 提现订单
 * @creator Carry.Liu
 */
public class OrderModel extends BaseResp {

	/* 职乐订单唯一id */
    private String id;

	/* 企业订单号,批次号,单个企业内唯一 */
    private String tradeNo;

	/* 企业id */
    private String corpId;

	/* 业务经营费用(个人到手) */
    private BigDecimal bizFee;

	/* 订单状态:0:支付中,1:支付成功,9:支付失败 */
    private Integer status;

	/* 下单时间 */
    private Date created;

	/* 服务商ID */
    private String providerId;

	/* 自由职业者工号 */
    private String employeeNo;

	/* 自由职业者id */
    private String employeeId;

	/* 银行卡号 */
    private String bankCardNo;

	/* 银行卡预留姓名 */
    private String bankName;

	/* 银行卡预留手机 */
    private String bankPhone;

	/* 姓名 */
    private String name;

	/* 证件号 */
    private String papersNo;

	/* 证件类型(0:身份证) */
    private Integer papersType;

	/* 扩展参数 原封不动回调给商户 可选 */
    private String extendParams;

	/* 性别 */
    private String sex;

	/* 出生日期 */
    private String birthday;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public BigDecimal getBizFee() {
		return bizFee;
	}

	public void setBizFee(BigDecimal bizFee) {
		this.bizFee = bizFee;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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

	public String getExtendParams() {
		return extendParams;
	}

	public void setExtendParams(String extendParams) {
		this.extendParams = extendParams;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
}
