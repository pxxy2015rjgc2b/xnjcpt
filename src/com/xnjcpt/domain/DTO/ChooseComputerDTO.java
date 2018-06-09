package com.xnjcpt.domain.DTO;

public class ChooseComputerDTO {
	private String computer_id;
	private String computer_ip;
	public ChooseComputerDTO(String computer_id, String computer_ip) {
		super();
		this.computer_id = computer_id;
		this.computer_ip = computer_ip;
	}
	public String getComputer_id() {
		return computer_id;
	}
	public void setComputer_id(String computer_id) {
		this.computer_id = computer_id;
	}
	public String getComputer_ip() {
		return computer_ip;
	}
	public void setComputer_ip(String computer_ip) {
		this.computer_ip = computer_ip;
	}
	
}
