package com.xnjcpt.domain.DTO;

public class UserComputerPageDTO {
	private String computer_id;
	private String computer_name;
	private String computer_ip;
	private String cpu_model;
	private String cpu_basic_frequency;
	private String cpu_catch_size;
	private String cpu_cores;
	private String disk_size;
	private String memory_size;
	private String memory_swap;
	private String net_mac;
	private String net_ipv6;
	private String computer_status;
	
	

	

	
	public UserComputerPageDTO(String computer_id,String computer_ip, String cpu_model, String disk_size, String memory_size) {
		super();
		this.computer_id = computer_id;
		this.computer_ip = computer_ip;
		this.cpu_model = cpu_model;
		this.disk_size = disk_size;
		this.memory_size = memory_size;
		
	}





	public UserComputerPageDTO(String computer_name, String computer_ip, String cpu_model, String cpu_basic_frequency,
			String cpu_catch_size, String cpu_cores, String disk_size, String memory_size, String memory_swap,
			String net_mac, String net_ipv6) {
		super();
		this.computer_name = computer_name;
		this.computer_ip = computer_ip;
		this.cpu_model = cpu_model;
		this.cpu_basic_frequency = cpu_basic_frequency;
		this.cpu_catch_size = cpu_catch_size;
		this.cpu_cores = cpu_cores;
		this.disk_size = disk_size;
		this.memory_size = memory_size;
		this.memory_swap = memory_swap;
		this.net_mac = net_mac;
		this.net_ipv6 = net_ipv6;
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

	

	public String getCpu_model() {
		return cpu_model;
	}




	public void setCpu_model(String cpu_model) {
		this.cpu_model = cpu_model;
	}




	public String getDisk_size() {
		return disk_size;
	}




	public void setDisk_size(String disk_size) {
		this.disk_size = disk_size;
	}




	public String getMemory_size() {
		return memory_size;
	}




	public void setMemory_size(String memory_size) {
		this.memory_size = memory_size;
	}




	




	public String getComputer_status() {
		return computer_status;
	}





	public void setComputer_status(String computer_status) {
		this.computer_status = computer_status;
	}





	public String getCpu_basic_frequency() {
		return cpu_basic_frequency;
	}




	public void setCpu_basic_frequency(String cpu_basic_frequency) {
		this.cpu_basic_frequency = cpu_basic_frequency;
	}




	public String getCpu_catch_size() {
		return cpu_catch_size;
	}




	public void setCpu_catch_size(String cpu_catch_size) {
		this.cpu_catch_size = cpu_catch_size;
	}




	public String getCpu_cores() {
		return cpu_cores;
	}




	public void setCpu_cores(String cpu_cores) {
		this.cpu_cores = cpu_cores;
	}




	public String getMemory_swap() {
		return memory_swap;
	}




	public void setMemory_swap(String memory_swap) {
		this.memory_swap = memory_swap;
	}




	public String getNet_mac() {
		return net_mac;
	}




	public void setNet_mac(String net_mac) {
		this.net_mac = net_mac;
	}




	public String getNet_ipv6() {
		return net_ipv6;
	}




	public void setNet_ipv6(String net_ipv6) {
		this.net_ipv6 = net_ipv6;
	}

	

}
