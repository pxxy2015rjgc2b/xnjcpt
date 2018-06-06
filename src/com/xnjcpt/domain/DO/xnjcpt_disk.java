package com.xnjcpt.domain.DO;

/**
 * 磁盘信息的实体类
 *
 */
public class xnjcpt_disk {
	
	//磁盘主键
	private String disk_id;
	
	//主机主键
	private String disk_computer;
	//磁盘大小
	private String disk_size;
	//创建时间
	private String disk_gmt_create;
	//修改时间
	private String disk_gmt_modified;
	public String getDisk_id() {
		return disk_id;
	}
	public void setDisk_id(String disk_id) {
		this.disk_id = disk_id;
	}
	public String getDisk_computer() {
		return disk_computer;
	}
	public void setDisk_computer(String disk_computer) {
		this.disk_computer = disk_computer;
	}
	public String getDisk_size() {
		return disk_size;
	}
	public void setDisk_size(String disk_size) {
		this.disk_size = disk_size;
	}
	public String getDisk_gmt_create() {
		return disk_gmt_create;
	}
	public void setDisk_gmt_create(String disk_gmt_create) {
		this.disk_gmt_create = disk_gmt_create;
	}
	public String getDisk_gmt_modified() {
		return disk_gmt_modified;
	}
	public void setDisk_gmt_modified(String disk_gmt_modified) {
		this.disk_gmt_modified = disk_gmt_modified;
	}
	
	
}
