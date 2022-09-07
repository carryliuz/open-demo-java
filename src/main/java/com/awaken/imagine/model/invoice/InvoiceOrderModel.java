package com.awaken.imagine.model.invoice;

import java.util.List;

public class InvoiceOrderModel {

    /* 订单ID */
    private String id;

    /* 服务商ID */
    private String providerId;

    /* 开票总金额(项目款) */
    private String totalAmount;

    /* 待开票总金额(项目款) */
    private String preTotalAmount;

    /* 已开票金额 */
    private String useTotalAmount;
    
    /* 订单状态:10未申请,20部分已申请，30全部已申请，90过期，99作废 */
    private Integer status;

    /* 项目类型 */
    private String projectType;

    /* 可以开具的发票品目列表 */
    private List<InvoiceContentModel> invoiceContentList;

    /* 时间 */
    private String created;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPreTotalAmount() {
		return preTotalAmount;
	}

	public void setPreTotalAmount(String preTotalAmount) {
		this.preTotalAmount = preTotalAmount;
	}

	public String getUseTotalAmount() {
		return useTotalAmount;
	}

	public void setUseTotalAmount(String useTotalAmount) {
		this.useTotalAmount = useTotalAmount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public List<InvoiceContentModel> getInvoiceContentList() {
		return invoiceContentList;
	}

	public void setInvoiceContentList(List<InvoiceContentModel> invoiceContentList) {
		this.invoiceContentList = invoiceContentList;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}
    
}
