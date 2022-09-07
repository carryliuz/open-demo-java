package com.awaken.imagine.model.invoice;

import java.math.BigDecimal;

import com.awaken.imagine.model.BaseResp;

/**
 * 发票设置
 * @author Carry.Liu
 */
public class InvoiceSettingModel extends BaseResp {
	
    /* 服务商ID */
    private String providerId;

    /* 服务商开票类型: 0 差额发票 1 全额发票 */
    private Integer providerType;

    /* 发票类型: 0 增值税普通发票 1 增值税专用发票;多选,逗号分隔 */
    private String invoiceTypes;

    /* 普通发票性质(0: 纸质发票 1: 电子发票) */
    private Integer commonProperty;

    /* 专用发票性质(0: 纸质发票 1: 电子发票) */
    private Integer specialProperty;

    /* 普票可开的明细数量上限 */
    private Integer detailNumber;

    /* 普票可开的单张发票金额上限 */
    private BigDecimal amountLimit;

    /* 专票可开的明细数量上限 */
    private Integer specialDetailNumber;

    /* 专票可开的单张发票金额上限 */
    private BigDecimal specialAmountLimit;

    /* 小额发票金额限额开关 */
    private Boolean smallAmountSwitch;

    /* 小额发票金额限额 */
    private BigDecimal smallAmountLimit;

    /* 小额发票金额限额张数 */
    private Integer smallAmountNumber;

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public Integer getProviderType() {
		return providerType;
	}

	public void setProviderType(Integer providerType) {
		this.providerType = providerType;
	}

	public String getInvoiceTypes() {
		return invoiceTypes;
	}

	public void setInvoiceTypes(String invoiceTypes) {
		this.invoiceTypes = invoiceTypes;
	}

	public Integer getCommonProperty() {
		return commonProperty;
	}

	public void setCommonProperty(Integer commonProperty) {
		this.commonProperty = commonProperty;
	}

	public Integer getSpecialProperty() {
		return specialProperty;
	}

	public void setSpecialProperty(Integer specialProperty) {
		this.specialProperty = specialProperty;
	}

	public Integer getDetailNumber() {
		return detailNumber;
	}

	public void setDetailNumber(Integer detailNumber) {
		this.detailNumber = detailNumber;
	}

	public BigDecimal getAmountLimit() {
		return amountLimit;
	}

	public void setAmountLimit(BigDecimal amountLimit) {
		this.amountLimit = amountLimit;
	}

	public Integer getSpecialDetailNumber() {
		return specialDetailNumber;
	}

	public void setSpecialDetailNumber(Integer specialDetailNumber) {
		this.specialDetailNumber = specialDetailNumber;
	}

	public BigDecimal getSpecialAmountLimit() {
		return specialAmountLimit;
	}

	public void setSpecialAmountLimit(BigDecimal specialAmountLimit) {
		this.specialAmountLimit = specialAmountLimit;
	}

	public Boolean getSmallAmountSwitch() {
		return smallAmountSwitch;
	}

	public void setSmallAmountSwitch(Boolean smallAmountSwitch) {
		this.smallAmountSwitch = smallAmountSwitch;
	}

	public BigDecimal getSmallAmountLimit() {
		return smallAmountLimit;
	}

	public void setSmallAmountLimit(BigDecimal smallAmountLimit) {
		this.smallAmountLimit = smallAmountLimit;
	}

	public Integer getSmallAmountNumber() {
		return smallAmountNumber;
	}

	public void setSmallAmountNumber(Integer smallAmountNumber) {
		this.smallAmountNumber = smallAmountNumber;
	}
    
}