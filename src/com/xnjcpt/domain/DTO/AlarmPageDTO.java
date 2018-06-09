package com.xnjcpt.domain.DTO;

public class AlarmPageDTO {
	private String alarm_id;//警报id
	private String computer_ip;//主机ip
	private String alarm_type; //警报类型
	private String alarm_value;//警报值
	private String alarm_state; //警报状态
	
	public AlarmPageDTO(String alarm_id, String computer_ip, String alarm_type, String alarm_value,
			String alarm_state) {
		super();
		this.alarm_id = alarm_id;
		this.computer_ip = computer_ip;
		this.alarm_type = alarm_type;
		this.alarm_value = alarm_value;
		this.alarm_state = alarm_state;
	}
	public String getAlarm_id() {
		return alarm_id;
	}
	public void setAlarm_id(String alarm_id) {
		this.alarm_id = alarm_id;
	}
	public String getComputer_ip() {
		return computer_ip;
	}
	public void setComputer_ip(String computer_ip) {
		this.computer_ip = computer_ip;
	}
	public String getAlarm_type() {
		return alarm_type;
	}
	public void setAlarm_type(String alarm_type) {
		this.alarm_type = alarm_type;
	}
	public String getAlarm_value() {
		return alarm_value;
	}
	public void setAlarm_value(String alarm_value) {
		this.alarm_value = alarm_value;
	}
	public String getAlarm_state() {
		return alarm_state;
	}
	public void setAlarm_state(String alarm_state) {
		this.alarm_state = alarm_state;
	}
	
}
