package com.xnjcpt.domain.DTO;

public class ComputerPageDTO {
	private String computer_id;
	private String computer_ip;
	private String computer_cpu_model;
	private String computer_disk_size;
	private String computer_memory_size;
	private String computer_status;

	public ComputerPageDTO(String computer_id, String computer_ip, String computer_cpu_model, String computer_disk_size,
			String computer_memory_size) {
		super();
		this.computer_id = computer_id;
		this.computer_ip = computer_ip;
		this.computer_cpu_model = computer_cpu_model;
		this.computer_disk_size = computer_disk_size;
		this.computer_memory_size = computer_memory_size;
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

	public String getComputer_cpu_model() {
		return computer_cpu_model;
	}

	public void setComputer_cpu_model(String computer_cpu_model) {
		this.computer_cpu_model = computer_cpu_model;
	}

	public String getComputer_disk_size() {
		return computer_disk_size;
	}

	public void setComputer_disk_size(String computer_disk_size) {
		this.computer_disk_size = computer_disk_size;
	}

	public String getComputer_memory_size() {
		return computer_memory_size;
	}

	public void setComputer_memory_size(String computer_memory_size) {
		this.computer_memory_size = computer_memory_size;
	}

	public String getComputer_status() {
		return computer_status;
	}

	public void setComputer_status(String computer_status) {
		this.computer_status = computer_status;
	}

}
