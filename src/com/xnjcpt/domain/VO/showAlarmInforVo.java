package com.xnjcpt.domain.VO;

import java.util.List;

import com.xnjcpt.domain.DO.xnjcpt_alarm;

public class showAlarmInforVo {
	//��ǰҳ��
		private int currPage;
		//��ҳ��
		private int totalPage;
		//�ܼ�¼��
		private int count;
		//ÿҳ��ʾ�ļ�¼��
		private int pageSize;
		//��ѯ����
		private String queryString;
		//ÿҳ��ʾ������
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
