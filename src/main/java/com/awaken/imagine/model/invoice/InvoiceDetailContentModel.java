package com.awaken.imagine.model.invoice;

import java.math.BigDecimal;

/**
 * 发票品目/类目
 * @author Carry.Liu
 */
public class InvoiceDetailContentModel {

    private String id;
	
    /* 唯一标识 */
	private String contentNo;
	
	/* 明细金额 */
	private BigDecimal amount;

	/* 开票品目 */
	private String content;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContentNo() {
		return contentNo;
	}

	public void setContentNo(String contentNo) {
		this.contentNo = contentNo;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public InvoiceDetailContentModel(BigDecimal amount, String content) {
		this.amount = amount;
		this.content = content;
	}

	public InvoiceDetailContentModel() {
	}
	
}
