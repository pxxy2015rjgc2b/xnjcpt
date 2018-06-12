package com.xnjcpt.domain.DTO;

import java.util.List;

import com.xnjcpt.domain.DO.xnjcpt_progress;

public class ProgressDTO {
	private String ip;
	private List<xnjcpt_progress> list;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public List<xnjcpt_progress> getList() {
		return list;
	}

	public void setList(List<xnjcpt_progress> list) {
		this.list = list;
	}
}
