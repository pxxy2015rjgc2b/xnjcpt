package com.xnjcpt.domain.DO;

/**
 * 内存信息表
 *
 */
public class xnjcpt_memory {
	
	//内存主键
	private String memory_id;
	//主机主键
	private String memory_computer;
	//内存大小
	private String memory_size;
	//交换区大小
	private String memory_swap;
	//创建时间
	private String memory_gmt_create;
	//修改时间
	private String memory_gmt_modified;
	public String getMemory_id() {
		return memory_id;
	}
	public void setMemory_id(String memory_id) {
		this.memory_id = memory_id;
	}
	public String getMemory_computer() {
		return memory_computer;
	}
	public void setMemory_computer(String memory_computer) {
		this.memory_computer = memory_computer;
	}
	public String getMemory_size() {
		return memory_size;
	}
	public void setMemory_size(String memory_size) {
		this.memory_size = memory_size;
	}
	public String getMemory_swap() {
		return memory_swap;
	}
	public void setMemory_swap(String memory_swap) {
		this.memory_swap = memory_swap;
	}
	public String getMemory_gmt_create() {
		return memory_gmt_create;
	}
	public void setMemory_gmt_create(String memory_gmt_create) {
		this.memory_gmt_create = memory_gmt_create;
	}
	public String getMemory_gmt_modified() {
		return memory_gmt_modified;
	}
	public void setMemory_gmt_modified(String memory_gmt_modified) {
		this.memory_gmt_modified = memory_gmt_modified;
	}
	
	
}
