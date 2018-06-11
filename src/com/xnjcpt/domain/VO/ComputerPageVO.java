package com.xnjcpt.domain.VO;

import java.util.List;

import com.xnjcpt.domain.DTO.ComputerPageDTO;

public class ComputerPageVO {
	private int currPage;
	private int totalPage;
	private int totalCount;
	private int pageSize;
	private String searchContent;
	private List<ComputerPageDTO> list;

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

	public List<ComputerPageDTO> getList() {
		return list;
	}

	public void setList(List<ComputerPageDTO> list) {
		this.list = list;
	}

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}
}
