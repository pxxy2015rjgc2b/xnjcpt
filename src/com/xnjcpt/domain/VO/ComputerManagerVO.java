package com.xnjcpt.domain.VO;

import java.util.List;

import com.xnjcpt.domain.DTO.ComputerManagerPageDTO;

public class ComputerManagerVO {
	private int currPage;
	private int totalPage;
	private int pageSize;
	private int totalCount;
	private String searchContent;
	private String searchStatus;
	private List<ComputerManagerPageDTO> list;

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

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
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

	public String getSearchStatus() {
		return searchStatus;
	}

	public void setSearchStatus(String searchStatus) {
		this.searchStatus = searchStatus;
	}

	public List<ComputerManagerPageDTO> getList() {
		return list;
	}

	public void setList(List<ComputerManagerPageDTO> list) {
		this.list = list;
	}

}
