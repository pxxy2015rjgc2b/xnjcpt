package com.xnjcpt.domain.VO;

import java.util.List;

import com.xnjcpt.domain.DO.xnjcpt_alarm_message;

public class AlarmMessageVO {
	private int currPage;
	private int totalPage;
	private int totalCount;
	private int pageSize;
	private List<xnjcpt_alarm_message> list;

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

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<xnjcpt_alarm_message> getList() {
		return list;
	}

	public void setList(List<xnjcpt_alarm_message> list) {
		this.list = list;
	}

}
