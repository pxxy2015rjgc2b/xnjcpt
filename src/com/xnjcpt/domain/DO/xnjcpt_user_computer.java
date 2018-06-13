package com.xnjcpt.domain.DO;
/*用户机器表*/
public class xnjcpt_user_computer {
	private String user_computer_id;//用户机器表主键
	
	private String user_computer_user;//用户表主键	
	private String user_computer_computer;//主机表主键
	private String user_computer_gmt_create;	//字段创建时间		
	private String user_computer_gmt_modified;	//字段修改时间	
	public String getUser_computer_id() {
		return user_computer_id;
	}
	public void setUser_computer_id(String user_computer_id) {
		this.user_computer_id = user_computer_id;
	}
	public String getUser_computer_user() {
		return user_computer_user;
	}
	public void setUser_computer_user(String user_computer_user) {
		this.user_computer_user = user_computer_user;
	}
	public String getUser_computer_computer() {
		return user_computer_computer;
	}
	public void setUser_computer_computer(String user_computer_computer) {
		this.user_computer_computer = user_computer_computer;
	}
	public String getUser_computer_gmt_create() {
		return user_computer_gmt_create;
	}
	public void setUser_computer_gmt_create(String user_computer_gmt_create) {
		this.user_computer_gmt_create = user_computer_gmt_create;
	}
	public String getUser_computer_gmt_modified() {
		return user_computer_gmt_modified;
	}
	public void setUser_computer_gmt_modified(String user_computer_gmt_modified) {
		this.user_computer_gmt_modified = user_computer_gmt_modified;
	}
	
}
