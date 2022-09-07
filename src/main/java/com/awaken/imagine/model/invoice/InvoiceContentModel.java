package com.awaken.imagine.model.invoice;

/**
 * 发票品目
 * @author Carry.Liu
 */
public class InvoiceContentModel {
	
    private String id;
	
    /* 发票品目 */
    private String subitem;

    /* 是否需要上传开票业务凭证附件,0不需要，1需要 */
    private Integer isNeedAttachment;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubitem() {
		return subitem;
	}

	public void setSubitem(String subitem) {
		this.subitem = subitem;
	}

	public Integer getIsNeedAttachment() {
		return isNeedAttachment;
	}

	public void setIsNeedAttachment(Integer isNeedAttachment) {
		this.isNeedAttachment = isNeedAttachment;
	}

}