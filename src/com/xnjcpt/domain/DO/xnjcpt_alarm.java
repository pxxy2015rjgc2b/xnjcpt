package com.xnjcpt.domain.DO;

public class xnjcpt_alarm {
	//警报主键
	private String alarm_id;
	//主机主键
	private String alarm_computer;
	//用户主键
	private String alarm_user;
	//警报阈值
	private String alarm_threshold_value;
	//警报类型
	private String alarm_type;
	//警报状态
	private String alarm_state;
	//创建时间
	private String alarm_gmt_create;
	//修改时间
	private String alarm_gmt_modified;
	public String getAlarm_id() {
		return alarm_id;
	}
	public void setAlarm_id(String alarm_id) {
		this.alarm_id = alarm_id;
	}
	public String getAlarm_computer() {
		return alarm_computer;
	}
	public void setAlarm_computer(String alarm_computer) {
		this.alarm_computer = alarm_computer;
	}
	public String getAlarm_user() {
		return alarm_user;
	}
	public void setAlarm_user(String alarm_user) {
		this.alarm_user = alarm_user;
	}
	public String getAlarm_threshold_value() {
		return alarm_threshold_value;
	}
	public void setAlarm_threshold_value(String alarm_threshold_value) {
		this.alarm_threshold_value = alarm_threshold_value;
	}
	public String getAlarm_type() {
		return alarm_type;
	}
	public void setAlarm_type(String alarm_type) {
		this.alarm_type = alarm_type;
	}
	public String getAlarm_state() {
		return alarm_state;
	}
	public void setAlarm_state(String alarm_state) {
		this.alarm_state = alarm_state;
	}
	public String getAlarm_gmt_create() {
		return alarm_gmt_create;
	}
	public void setAlarm_gmt_create(String alarm_gmt_create) {
		this.alarm_gmt_create = alarm_gmt_create;
	}
	public String getAlarm_gmt_modified() {
		return alarm_gmt_modified;
	}
	public void setAlarm_gmt_modified(String alarm_gmt_modified) {
		this.alarm_gmt_modified = alarm_gmt_modified;
	}
	
	
}
