package com.xnjcpt.domain.VO;

import java.util.List;
import com.xnjcpt.domain.DTO.UserComputerPageDTO;
public class ComputerInformationVO {
	private int currPage;
	private int totalPage;
	private int Count;
	private int pageSize;
	private String searchContent;
	private List<UserComputerPageDTO> list;
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
	public int getCurrPage() {
		return currPage;
	}
	private void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getCount() {
		return Count;
	}
	public void setCount(int count) {
		Count = count;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<UserComputerPageDTO> getList() {
		return list;
	}
	public void setList(List<UserComputerPageDTO> list) {
		this.list = list;
	}
	public String getSearchContent() {
		return searchContent;
	}
	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}
}
