package com.xnjcpt.domain.VO;

import java.util.List;

import com.xnjcpt.domain.DO.xnjcpt_user_computer;

public class page_list_user_computerVO {
	private int currPage;
	private int totalPage;
	private int count;
	private int pageSize;
	private String queryString;
	private List<xnjcpt_user_computer> list;

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public List<xnjcpt_user_computer> getList() {
		return list;
	}

	public void setList(List<xnjcpt_user_computer> list) {
		this.list = list;
	}

}
