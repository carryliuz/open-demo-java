package com.awaken.imagine.model.invoice;

import java.util.List;

import com.awaken.imagine.model.BaseResp;

/**
 * 发票申请批次
 * @author Carry.Liu
 */
public class InvoiceBatchModel extends BaseResp {

	/* 发票申请ID */
    private String id;

	/* 批次号 */
    private String batchNo;

	/* 服务商ID */
    private String providerId;

	/* 服务商名称 */
    private String providerName;

	/* 企业ID */
    private String corpId;

	/* 企业名称/发票抬头 */
    private String corpName;
    
	/* 企业信用代码 */
    private String bizLicenseCode;

	/* 发票类型: 0 企业增值税普通发票  1 增值税专用发票 */
    private Integer invoiceType;

	/* 开户行 */
	private String bank;

	/* 开户行账号 */
	private String bankNo;

	/* 注册地址 */
	private String registeredAddress;

	/* 税务登记固定电话 */
	private String registeredPhone;
	
	/* 收件人姓名 */
	private String expressName;

	/* 收件人电话 */
	private String expressPhone;
	
	/* 邮编 */
	private String expressPostcode;

	/* 收件地址 */
	private String expressAddress;

	/* 邮箱地址 */
    private String email;

	/* 发票订单ID集合 */
	private List<String> invoiceOrderIdList;
    
	/* 发票状态: 0 取消  1 正在审核  2 审核未通过  3 已审核  4 已开票待邮寄 5 已邮寄   */
    private Integer invoiceStatus;

	/* 回调通知url */
    private String notifyUrl;
    
	/* 发票记录集合 */
    private List<InvoiceDetailModel> detailList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getCorpId() {
		return corpId;
	}

	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getBizLicenseCode() {
		return bizLicenseCode;
	}

	public void setBizLicenseCode(String bizLicenseCode) {
		this.bizLicenseCode = bizLicenseCode;
	}

	public Integer getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(Integer invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getRegisteredAddress() {
		return registeredAddress;
	}

	public void setRegisteredAddress(String registeredAddress) {
		this.registeredAddress = registeredAddress;
	}

	public String getRegisteredPhone() {
		return registeredPhone;
	}

	public void setRegisteredPhone(String registeredPhone) {
		this.registeredPhone = registeredPhone;
	}

	public String getExpressName() {
		return expressName;
	}

	public void setExpressName(String expressName) {
		this.expressName = expressName;
	}

	public String getExpressPhone() {
		return expressPhone;
	}

	public void setExpressPhone(String expressPhone) {
		this.expressPhone = expressPhone;
	}

	public String getExpressPostcode() {
		return expressPostcode;
	}

	public void setExpressPostcode(String expressPostcode) {
		this.expressPostcode = expressPostcode;
	}

	public String getExpressAddress() {
		return expressAddress;
	}

	public void setExpressAddress(String expressAddress) {
		this.expressAddress = expressAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getInvoiceOrderIdList() {
		return invoiceOrderIdList;
	}

	public void setInvoiceOrderIdList(List<String> invoiceOrderIdList) {
		this.invoiceOrderIdList = invoiceOrderIdList;
	}

	public Integer getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(Integer invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public List<InvoiceDetailModel> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<InvoiceDetailModel> detailList) {
		this.detailList = detailList;
	}
    
}
