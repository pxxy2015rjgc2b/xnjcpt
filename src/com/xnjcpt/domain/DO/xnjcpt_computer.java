package com.xnjcpt.domain.DO;

/**
 * 主机的实体类
 *
 */
public class xnjcpt_computer {
	//主机主键
	private String computer_id;
	//主机名
	private String computer_name;
	//主机ip
	private String computer_ip;
	//创建时间
	private String computer_gmt_create;
	//修改时间
	private String computer_gmt_modified;
	
	public String getComputer_id() {
		return computer_id;
	}
	public void setComputer_id(String computer_id) {
		this.computer_id = computer_id;
	}
	public String getComputer_name() {
		return computer_name;
	}
	public void setComputer_name(String computer_name) {
		this.computer_name = computer_name;
	}
	public String getComputer_ip() {
		return computer_ip;
	}
	public void setComputer_ip(String computer_ip) {
		this.computer_ip = computer_ip;
	}
	public String getComputer_gmt_create() {
		return computer_gmt_create;
	}
	public void setComputer_gmt_create(String computer_gmt_create) {
		this.computer_gmt_create = computer_gmt_create;
	}
	public String getComputer_gmt_modified() {
		return computer_gmt_modified;
	}
	public void setComputer_gmt_modified(String computer_gmt_modified) {
		this.computer_gmt_modified = computer_gmt_modified;
	}
	
	

}
