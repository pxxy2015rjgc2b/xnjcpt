package com.xnjcpt.domain.DO;

/**
 * 用户信息的实体类
 *
 */
public class xnjcpt_user {
	//用户主键
	private String user_id;
	//用户姓名
	private String user_name;
	//用户名
	private String user_username;
	//用户邮箱
	private String user_email;
	//用户密码
	private String user_password;
	//用户手机号码
	private String user_phone;
	//用户状态
	private String user_status;
	//用户角色
	private String user_role;
	//创建时间
	private String user_gmt_create;
	//修改时间
	private String user_gmt_modified;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_username() {
		return user_username;
	}
	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_status() {
		return user_status;
	}
	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	
	public String getUser_gmt_create() {
		return user_gmt_create;
	}
	public void setUser_gmt_create(String user_gmt_create) {
		this.user_gmt_create = user_gmt_create;
	}
	public String getUser_gmt_modified() {
		return user_gmt_modified;
	}
	public void setUser_gmt_modified(String user_gmt_modified) {
		this.user_gmt_modified = user_gmt_modified;
	}
	
	

}
