package com.fy.item.commons;

/**
 * 分页与排序
 */
public class PageUtil {
	//当前页
	private Integer page;
	//每页条数
	private Integer rows; 
	//排序方式 desc asc 
	private String order = "desc";
	//排序字段
	private String sort;
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "PageUtil{" +
				"page=" + page +
				", rows=" + rows +
				", order='" + order + '\'' +
				", sort='" + sort + '\'' +
				'}';
	}
}
