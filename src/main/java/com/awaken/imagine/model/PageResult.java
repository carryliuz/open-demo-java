package com.awaken.imagine.model;

import java.util.List;

public class PageResult<T> {

	/**
     * 总数
     */
    private long total;

    /**
     * 总页数
     */
    private int pages;

    /**
     * 结果列表
     */
    private List<T> list;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
}
