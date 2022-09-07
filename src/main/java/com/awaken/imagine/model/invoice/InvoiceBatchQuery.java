package com.awaken.imagine.model.invoice;

import java.util.List;

import com.awaken.imagine.model.BaseQuery;

public class InvoiceBatchQuery extends BaseQuery {
	
	/* 发票申请记录ID集合 */
    private List<String> ids;

	/* 发票状态: 0 未审核  1 正在审核  2 审核未通过  3 已审核  4 已开票  5 待邮寄  6 已邮寄  7 取消 */
    private Integer invoiceStatus;

	/* 发票状态集合: 0 未审核  1 正在审核  2 审核未通过  3 已审核  4 已开票  5 待邮寄  6 已邮寄  7 取消 */
    private List<Integer> invoiceStatusList;

	/* 发票类型: 0 企业增值税普通发票  1 增值税专用发票  */
    private Integer invoiceType;

	/* 发票性质 (0: 纸质发票 1: 电子发票) */
    private Integer property;

	/* 批次号 */
    private String batchNo;

	/* 添加日期开始 格式 yyyyMMdd */
    private String startDate;

	/* 添加日期结束 格式 yyyyMMdd */
    private String endDate;

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	public Integer getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(Integer invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public List<Integer> getInvoiceStatusList() {
		return invoiceStatusList;
	}

	public void setInvoiceStatusList(List<Integer> invoiceStatusList) {
		this.invoiceStatusList = invoiceStatusList;
	}

	public Integer getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(Integer invoiceType) {
		this.invoiceType = invoiceType;
	}

	public Integer getProperty() {
		return property;
	}

	public void setProperty(Integer property) {
		this.property = property;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
    
}
