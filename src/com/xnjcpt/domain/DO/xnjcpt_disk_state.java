package com.xnjcpt.domain.DO;
/*磁盘状态表*/
public class xnjcpt_disk_state {
	private String disk_state_id;//磁盘状态表主键	
	private String disk_state_computer;//主机表主键	
	private String disk_state_time;//时间	
	private String disk_state_use_size;//已使用磁盘大小	
	private String disk_state_tps;//每秒传输次数	
	private String disk_state_r;//每秒读取次数	
	private String disk_state_w;//每秒写入次数	
	private String disk_state_gmt_create;//字段创建时间		
	private String disk_state_gmt_modified;//字段修改时间		
	public String getDisk_state_id() {
		return disk_state_id;
	}
	public void setDisk_state_id(String disk_state_id) {
		this.disk_state_id = disk_state_id;
	}
	public String getDisk_state_computer() {
		return disk_state_computer;
	}
	public void setDisk_state_computer(String disk_state_computer) {
		this.disk_state_computer = disk_state_computer;
	}
	public String getDisk_state_time() {
		return disk_state_time;
	}
	public void setDisk_state_time(String disk_state_time) {
		this.disk_state_time = disk_state_time;
	}
	public String getDisk_state_use_size() {
		return disk_state_use_size;
	}
	public void setDisk_state_use_size(String disk_state_use_size) {
		this.disk_state_use_size = disk_state_use_size;
	}
	public String getDisk_state_tps() {
		return disk_state_tps;
	}
	public void setDisk_state_tps(String disk_state_tps) {
		this.disk_state_tps = disk_state_tps;
	}
	public String getDisk_state_r() {
		return disk_state_r;
	}
	public void setDisk_state_r(String disk_state_r) {
		this.disk_state_r = disk_state_r;
	}
	public String getDisk_state_w() {
		return disk_state_w;
	}
	public void setDisk_state_w(String disk_state_w) {
		this.disk_state_w = disk_state_w;
	}
	public String getDisk_state_gmt_create() {
		return disk_state_gmt_create;
	}
	public void setDisk_state_gmt_create(String disk_state_gmt_create) {
		this.disk_state_gmt_create = disk_state_gmt_create;
	}
	public String getDisk_state_gmt_modified() {
		return disk_state_gmt_modified;
	}
	public void setDisk_state_gmt_modified(String disk_state_gmt_modified) {
		this.disk_state_gmt_modified = disk_state_gmt_modified;
	}
	

}
