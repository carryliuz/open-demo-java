package com.awaken.imagine.model.invoice;

import java.util.List;

/**
 * 发票明细
 * @author Carry.Liu
 */
public class InvoiceDetailModel {

	/* ID */
    private String id;

	/* 唯一标识 */
    private String detailNo;

	/* 发票订单ID */
    private String invoiceOrderId;
    
	/* 发票明细 */
	private List<InvoiceDetailContentModel> contentList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDetailNo() {
		return detailNo;
	}

	public void setDetailNo(String detailNo) {
		this.detailNo = detailNo;
	}

	public String getInvoiceOrderId() {
		return invoiceOrderId;
	}

	public void setInvoiceOrderId(String invoiceOrderId) {
		this.invoiceOrderId = invoiceOrderId;
	}

	public List<InvoiceDetailContentModel> getContentList() {
		return contentList;
	}

	public void setContentList(List<InvoiceDetailContentModel> contentList) {
		this.contentList = contentList;
	}

}
