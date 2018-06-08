package com.xnjcpt.domain.DO;
/*网络状态表*/
public class xnjcpt_net_state {
	private String net_state_id;//网络状态表主键	
	private String disk_state_computer;	//主机表主键	
	private String disk_state_time;//时间	
	private String net_state_obandwidth;	//出带宽		
	private String net_state_ibandwidth;	//入带宽		
	private String net_state_opackage;//出包量	
	private String net_state_ipackage;//入包量	
	private String net_state_tcp_number;//tcp连接个数
	private String net_state_otraffic;//出流量	
	private String net_state_gmt_create;//字段创建时间
	private String net_state_gmt_modified;//字段修改时间
	public String getNet_state_id() {
		return net_state_id;
	}
	public void setNet_state_id(String net_state_id) {
		this.net_state_id = net_state_id;
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
	
	public String getNet_state_obandwidth() {
		return net_state_obandwidth;
	}
	public void setNet_state_obandwidth(String net_state_obandwidth) {
		this.net_state_obandwidth = net_state_obandwidth;
	}
	public String getNet_state_ibandwidth() {
		return net_state_ibandwidth;
	}
	public void setNet_state_ibandwidth(String net_state_ibandwidth) {
		this.net_state_ibandwidth = net_state_ibandwidth;
	}
	public String getNet_state_opackage() {
		return net_state_opackage;
	}
	public void setNet_state_opackage(String net_state_opackage) {
		this.net_state_opackage = net_state_opackage;
	}
	public String getNet_state_ipackage() {
		return net_state_ipackage;
	}
	public void setNet_state_ipackage(String net_state_ipackage) {
		this.net_state_ipackage = net_state_ipackage;
	}
	public String getNet_state_tcp_number() {
		return net_state_tcp_number;
	}
	public void setNet_state_tcp_number(String net_state_tcp_number) {
		this.net_state_tcp_number = net_state_tcp_number;
	}
	public String getNet_state_otraffic() {
		return net_state_otraffic;
	}
	public void setNet_state_otraffic(String net_state_otraffic) {
		this.net_state_otraffic = net_state_otraffic;
	}
	public String getNet_state_gmt_create() {
		return net_state_gmt_create;
	}
	public void setNet_state_gmt_create(String net_state_gmt_create) {
		this.net_state_gmt_create = net_state_gmt_create;
	}
	public String getNet_state_gmt_modified() {
		return net_state_gmt_modified;
	}
	public void setNet_state_gmt_modified(String net_state_gmt_modified) {
		this.net_state_gmt_modified = net_state_gmt_modified;
	}
	
}
