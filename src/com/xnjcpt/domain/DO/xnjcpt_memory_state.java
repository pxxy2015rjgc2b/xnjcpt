package com.xnjcpt.domain.DO;
/*内存状态表*/
public class xnjcpt_memory_state {
	private String memory_state_id;//内存状态表主键	
	private String memory_state_computer;//主机表主键	
	private String memory_state_time;//时间	
	private String memory_state_swap_rate;//交换区使用率	
	private String memory_state_mem_rate;//物理内存使用率	
	private String memory_state_gmt_create;//字段创建时间		
	private String memory_state_gmt_modified;//字段修改时间		
	public String getMemory_state_id() {
		return memory_state_id;
	}
	public void setMemory_state_id(String memory_state_id) {
		this.memory_state_id = memory_state_id;
	}
	public String getMemory_state_computer() {
		return memory_state_computer;
	}
	public void setMemory_state_computer(String memory_state_computer) {
		this.memory_state_computer = memory_state_computer;
	}
	public String getMemory_state_time() {
		return memory_state_time;
	}
	public void setMemory_state_time(String memory_state_time) {
		this.memory_state_time = memory_state_time;
	}
	public String getMemory_state_swap_rate() {
		return memory_state_swap_rate;
	}
	public void setMemory_state_swap_rate(String memory_state_swap_rate) {
		this.memory_state_swap_rate = memory_state_swap_rate;
	}
	public String getMemory_state_mem_rate() {
		return memory_state_mem_rate;
	}
	public void setMemory_state_mem_rate(String memory_state_mem_rate) {
		this.memory_state_mem_rate = memory_state_mem_rate;
	}
	public String getMemory_state_gmt_create() {
		return memory_state_gmt_create;
	}
	public void setMemory_state_gmt_create(String memory_state_gmt_create) {
		this.memory_state_gmt_create = memory_state_gmt_create;
	}
	public String getMemory_state_gmt_modified() {
		return memory_state_gmt_modified;
	}
	public void setMemory_state_gmt_modified(String memory_state_gmt_modified) {
		this.memory_state_gmt_modified = memory_state_gmt_modified;
	}
	
}
