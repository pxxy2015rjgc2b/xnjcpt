package com.xnjcpt.domain.VO;

import java.util.List;

import com.xnjcpt.domain.DO.xnjcpt_alarm;

public class showAlarmInforVo {
	//当前页码
		private int currPage;
		//总页数
		private int totalPage;
		//总记录数
		private int count;
		//每页显示的记录数
		private int pageSize;
		//查询条件
		private String queryString;
		//每页显示的数据
		private List<xnjcpt_alarm> alarm_list;

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

		public List<xnjcpt_alarm> getAlarm_list() {
			return alarm_list;
		}

		public void setAlarm_list(List<xnjcpt_alarm> alarm_list) {
			this.alarm_list = alarm_list;
		}

		
}
