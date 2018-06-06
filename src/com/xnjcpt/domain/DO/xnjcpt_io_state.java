package com.xnjcpt.domain.DO;
/*io状态表*/
public class xnjcpt_io_state {
	private String io_state_id;//io状态表主键	
	private String io_state_computer;//主机表主键	
	private String io_state_time;//时间	
	private String io_state_rsec;//每秒读取的扇区数	
	private String io_state_wsec;//每秒写入的扇区数	
	private String io_state_rkb;//每秒读取的数据总量	
	private String io_state_wkb;//每秒写入的数据总量	
	private String io_state_wait;//io请求平均处理时间	
	private String io_state_util;//io处理时间百分比	
	private String io_state_gmt_create;//字段创建时间		
	private String io_state_gmt_modified;//字段修改时间		
	public String getIo_state_id() {
		return io_state_id;
	}
	public void setIo_state_id(String io_state_id) {
		this.io_state_id = io_state_id;
	}
	public String getIo_state_computer() {
		return io_state_computer;
	}
	public void setIo_state_computer(String io_state_computer) {
		this.io_state_computer = io_state_computer;
	}
	public String getIo_state_time() {
		return io_state_time;
	}
	public void setIo_state_time(String io_state_time) {
		this.io_state_time = io_state_time;
	}
	public String getIo_state_rsec() {
		return io_state_rsec;
	}
	public void setIo_state_rsec(String io_state_rsec) {
		this.io_state_rsec = io_state_rsec;
	}
	public String getIo_state_wsec() {
		return io_state_wsec;
	}
	public void setIo_state_wsec(String io_state_wsec) {
		this.io_state_wsec = io_state_wsec;
	}
	public String getIo_state_rkb() {
		return io_state_rkb;
	}
	public void setIo_state_rkb(String io_state_rkb) {
		this.io_state_rkb = io_state_rkb;
	}
	public String getIo_state_wkb() {
		return io_state_wkb;
	}
	public void setIo_state_wkb(String io_state_wkb) {
		this.io_state_wkb = io_state_wkb;
	}
	public String getIo_state_wait() {
		return io_state_wait;
	}
	public void setIo_state_wait(String io_state_wait) {
		this.io_state_wait = io_state_wait;
	}
	public String getIo_state_util() {
		return io_state_util;
	}
	public void setIo_state_util(String io_state_util) {
		this.io_state_util = io_state_util;
	}
	public String getIo_state_gmt_create() {
		return io_state_gmt_create;
	}
	public void setIo_state_gmt_create(String io_state_gmt_create) {
		this.io_state_gmt_create = io_state_gmt_create;
	}
	public String getIo_state_gmt_modified() {
		return io_state_gmt_modified;
	}
	public void setIo_state_gmt_modified(String io_state_gmt_modified) {
		this.io_state_gmt_modified = io_state_gmt_modified;
	}
	
}
