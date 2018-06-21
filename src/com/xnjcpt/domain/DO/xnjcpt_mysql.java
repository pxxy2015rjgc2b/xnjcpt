package com.xnjcpt.domain.DO;

public class xnjcpt_mysql {
	private String mysql_id;
	private String mysql_computer;
	private String mysql_time;
	private float mysql_qps;
	private float mysql_tps;
	private String mysql_gmt_create;
	private String mysql_gmt_modified;

	public String getMysql_id() {
		return mysql_id;
	}

	public void setMysql_id(String mysql_id) {
		this.mysql_id = mysql_id;
	}

	public String getMysql_computer() {
		return mysql_computer;
	}

	public void setMysql_computer(String mysql_computer) {
		this.mysql_computer = mysql_computer;
	}

	public String getMysql_time() {
		return mysql_time;
	}

	public void setMysql_time(String mysql_time) {
		this.mysql_time = mysql_time;
	}

	public String getMysql_gmt_create() {
		return mysql_gmt_create;
	}

	public float getMysql_qps() {
		return mysql_qps;
	}

	public void setMysql_qps(float mysql_qps) {
		this.mysql_qps = mysql_qps;
	}

	public float getMysql_tps() {
		return mysql_tps;
	}

	public void setMysql_tps(float mysql_tps) {
		this.mysql_tps = mysql_tps;
	}

	public void setMysql_gmt_create(String mysql_gmt_create) {
		this.mysql_gmt_create = mysql_gmt_create;
	}

	public String getMysql_gmt_modified() {
		return mysql_gmt_modified;
	}

	public void setMysql_gmt_modified(String mysql_gmt_modified) {
		this.mysql_gmt_modified = mysql_gmt_modified;
	}

}
