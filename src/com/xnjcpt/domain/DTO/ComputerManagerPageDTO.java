package com.xnjcpt.domain.DTO;

public class ComputerManagerPageDTO {
	private String computer_id;
	private String computer_user; // 用户名
	private String computer_username; // 用户账号
	private String computer_ip;// 主机ip
	private String computer_name;// 主机名用于判断状态
	private String computer_status;// 主机状态

	public ComputerManagerPageDTO(String computer_id, String computer_user, String computer_username,
			String computer_ip, String computer_name) {
		super();
		this.computer_id = computer_id;
		this.computer_user = computer_user;
		this.computer_username = computer_username;
		this.computer_ip = computer_ip;
		this.computer_name = computer_name;
	}

	public String getComputer_id() {
		return computer_id;
	}

	public void setComputer_id(String computer_id) {
		this.computer_id = computer_id;
	}

	public String getComputer_user() {
		return computer_user;
	}

	public void setComputer_user(String computer_user) {
		this.computer_user = computer_user;
	}

	public String getComputer_username() {
		return computer_username;
	}

	public void setComputer_username(String computer_username) {
		this.computer_username = computer_username;
	}

	public String getComputer_ip() {
		return computer_ip;
	}

	public void setComputer_ip(String computer_ip) {
		this.computer_ip = computer_ip;
	}

	public String getComputer_status() {
		return computer_status;
	}

	public void setComputer_status(String computer_status) {
		this.computer_status = computer_status;
	}

	public String getComputer_name() {
		return computer_name;
	}

	public void setComputer_name(String computer_name) {
		this.computer_name = computer_name;
	}

}
