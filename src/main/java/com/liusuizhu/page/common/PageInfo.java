package com.liusuizhu.page.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * 网页数据内容分页model类
 * @author John Liu
 */
public class PageInfo {
	private int page;// 当前页
	private int pageSize;//当前页的数目
	@JsonIgnore
	private int startNum;// 起始数目
	private int totalPage;// 页数
	private int total;// 总数目
	private List<?> list;

	public PageInfo() {
		super();
	}
	
	public PageInfo(List<?> list) {
		super();
		this.list = list;
		
	}

	public PageInfo(int page, int pageSize) {
		super();
		this.page = page;
		this.pageSize = pageSize;
	}
	
	public PageInfo(int page, int pageSize, int total) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		if (total % pageSize == 0) {
			totalPage = total / pageSize;
		} else {
			totalPage = total / pageSize + 1;
		}
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public int getStartNum() {
		startNum = (page - 1) * pageSize;
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

}
