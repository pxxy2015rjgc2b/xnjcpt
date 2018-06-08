package com.xnjcpt.domain.DO;

/**
 * cpu信息的实体类
 *
 */
public class xnjcpt_cpu {
	
	//cpu主键
	private String cpu_id;
	//主机主键
	private String cpu_computer;
	//型号
	private String cpu_model;
	//主频
	private String cpu_basic_frequency;
	//cpu缓存大小
	private String cpu_catch_size;
	//核数
	private String cpu_cores;
	//创建时间
	private String cpu_gmt_create;
	//修改时间
	private String cpu_gmt_modified;
	public String getCpu_id() {
		return cpu_id;
	}
	public void setCpu_id(String cpu_id) {
		this.cpu_id = cpu_id;
	}
	public String getCpu_computer() {
		return cpu_computer;
	}
	public void setCpu_computer(String cpu_computer) {
		this.cpu_computer = cpu_computer;
	}
	public String getCpu_model() {
		return cpu_model;
	}
	public void setCpu_model(String cpu_model) {
		this.cpu_model = cpu_model;
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

	public String getCpu_gmt_create() {
		return cpu_gmt_create;
	}
	public void setCpu_gmt_create(String cpu_gmt_create) {
		this.cpu_gmt_create = cpu_gmt_create;
	}
	public String getCpu_gmt_modified() {
		return cpu_gmt_modified;
	}
	public void setCpu_gmt_modified(String cpu_gmt_modified) {
		this.cpu_gmt_modified = cpu_gmt_modified;
	}
	
	
}
