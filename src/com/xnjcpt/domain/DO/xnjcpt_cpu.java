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
	//创建时间
	private String cpu_gmt_creat;
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
	public String getCpu_gmt_creat() {
		return cpu_gmt_creat;
	}
	public void setCpu_gmt_creat(String cpu_gmt_creat) {
		this.cpu_gmt_creat = cpu_gmt_creat;
	}
	public String getCpu_gmt_modified() {
		return cpu_gmt_modified;
	}
	public void setCpu_gmt_modified(String cpu_gmt_modified) {
		this.cpu_gmt_modified = cpu_gmt_modified;
	}
	
	
}
