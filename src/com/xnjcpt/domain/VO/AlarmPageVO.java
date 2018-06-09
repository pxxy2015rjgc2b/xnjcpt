package com.xnjcpt.domain.VO;

import java.util.List;

import com.xnjcpt.domain.DTO.AlarmPageDTO;

public class AlarmPageVO {
	private int currPage;
	private int pageSize;
	private int totalPage;
	private int totalCount;
	private String searchContent; // 搜索内容
	private String searchAlarmType; // 警报类型
	private List<AlarmPageDTO> list;

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
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

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public String getSearchAlarmType() {
		return searchAlarmType;
	}

	public void setSearchAlarmType(String searchAlarmType) {
		this.searchAlarmType = searchAlarmType;
	}

	public List<AlarmPageDTO> getList() {
		return list;
	}

	public void setList(List<AlarmPageDTO> list) {
		this.list = list;
	}

}
