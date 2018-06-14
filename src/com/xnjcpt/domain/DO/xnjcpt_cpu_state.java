package com.xnjcpt.domain.DO;

/*cpu状态表*/
public class xnjcpt_cpu_state {
	private String cpu_state_id;// cpu状态表主键
	private String cpu_state_computer;// 主机表主键
	private String cpu_state_time;// 时间
	private String cpu_state_user;// 用户空间占用cpu百分比
	private String cpu_state_nice;// 用户进程空间内改变过优先级百分比
	private String cpu_state_system;// 内和空间占用cpu百分比
	private String cpu_state_iowait;// 等待输入输出的cpu时间百分比
	private String cpu_state_idle;// 空闲cpu百分比
	private String cpu_state_gmt_create;// 字段创建时间
	private String cpu_state_gmt_modified;// 字段修改时间

	public String getCpu_state_id() {
		return cpu_state_id;
	}

	public void setCpu_state_id(String cpu_state_id) {
		this.cpu_state_id = cpu_state_id;
	}

	public String getCpu_state_computer() {
		return cpu_state_computer;
	}

	public void setCpu_state_computer(String cpu_state_computer) {
		this.cpu_state_computer = cpu_state_computer;
	}

	public String getCpu_state_time() {
		return cpu_state_time;
	}

	public void setCpu_state_time(String cpu_state_time) {
		this.cpu_state_time = cpu_state_time;
	}

	public String getCpu_state_user() {
		return cpu_state_user;
	}

	public void setCpu_state_user(String cpu_state_user) {
		this.cpu_state_user = cpu_state_user;
	}

	public String getCpu_state_nice() {
		return cpu_state_nice;
	}

	public void setCpu_state_nice(String cpu_state_nice) {
		this.cpu_state_nice = cpu_state_nice;
	}

	public String getCpu_state_system() {
		return cpu_state_system;
	}

	public void setCpu_state_system(String cpu_state_system) {
		this.cpu_state_system = cpu_state_system;
	}

	public String getCpu_state_iowait() {
		return cpu_state_iowait;
	}

	public void setCpu_state_iowait(String cpu_state_iowait) {
		this.cpu_state_iowait = cpu_state_iowait;
	}

	public String getCpu_state_idle() {
		return cpu_state_idle;
	}

	public void setCpu_state_idle(String cpu_state_idle) {
		this.cpu_state_idle = cpu_state_idle;
	}

	public String getCpu_state_gmt_create() {
		return cpu_state_gmt_create;
	}

	public void setCpu_state_gmt_create(String cpu_state_gmt_create) {
		this.cpu_state_gmt_create = cpu_state_gmt_create;
	}

	public String getCpu_state_gmt_modified() {
		return cpu_state_gmt_modified;
	}

	public void setCpu_state_gmt_modified(String cpu_state_gmt_modified) {
		this.cpu_state_gmt_modified = cpu_state_gmt_modified;
	}

}
