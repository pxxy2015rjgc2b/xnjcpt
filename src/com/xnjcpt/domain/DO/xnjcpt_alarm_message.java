package com.xnjcpt.domain.DO;

/*警报通知表*/
public class xnjcpt_alarm_message {
	private String message_id;// 警报通知表主键
	private String message_user;// 用户表主键
	private String message_info;// 警报通知内容
	private String message_status;// 警报通知状态
	private String message_gmt_create;// 字段创建时间
	private String message_gmt_modified;// 字段修改时间
	private String message_alarm; // 所属警报主键

	public String getMessage_id() {
		return message_id;
	}

	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}

	public String getMessage_user() {
		return message_user;
	}

	public void setMessage_user(String message_user) {
		this.message_user = message_user;
	}

	public String getMessage_info() {
		return message_info;
	}

	public void setMessage_info(String message_info) {
		this.message_info = message_info;
	}

	public String getMessage_status() {
		return message_status;
	}

	public void setMessage_status(String message_status) {
		this.message_status = message_status;
	}

	public String getMessage_gmt_create() {
		return message_gmt_create;
	}

	public void setMessage_gmt_create(String message_gmt_create) {
		this.message_gmt_create = message_gmt_create;
	}

	public String getMessage_gmt_modified() {
		return message_gmt_modified;
	}

	public void setMessage_gmt_modified(String message_gmt_modified) {
		this.message_gmt_modified = message_gmt_modified;
	}

	public String getMessage_alarm() {
		return message_alarm;
	}

	public void setMessage_alarm(String message_alarm) {
		this.message_alarm = message_alarm;
	}

}
