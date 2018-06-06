package com.xnjcpt.domain.DO;

/**
 *网络信息表
 *
 */
public class xnjcpt_net {
	//网络主键
	private String net_id;
	
	//主机主键
	private String net_computer;
	//MAC地址
	private String net_mac;
	//IPV6
	private String net_ipv6;
	//创建时间
	private String net_gmt_create;
	//修改时间
	private String net_gmt_modified;
	public String getNet_id() {
		return net_id;
	}
	public void setNet_id(String net_id) {
		this.net_id = net_id;
	}
	public String getNet_computer() {
		return net_computer;
	}
	public void setNet_computer(String net_computer) {
		this.net_computer = net_computer;
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
	public String getNet_gmt_create() {
		return net_gmt_create;
	}
	public void setNet_gmt_create(String net_gmt_create) {
		this.net_gmt_create = net_gmt_create;
	}
	public String getNet_gmt_modified() {
		return net_gmt_modified;
	}
	public void setNet_gmt_modified(String net_gmt_modified) {
		this.net_gmt_modified = net_gmt_modified;
	}
	
	
}
