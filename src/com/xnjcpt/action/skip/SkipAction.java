package com.xnjcpt.action.skip;


import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author 孙毅
 *用于页面跳转
 */
public class SkipAction extends ActionSupport{	 
	public String intoNavbar(){
		return "intoNavbar";
	}
	public String intoSlider(){
		return "intoSlider";
	}
	//进入警报
	public String intoAlarm(){
		return "intoAlarm";
	}
	//进入用户
	public String intoUser(){
		return "intoUser";
	}
	//进入主机
	public String intoComputer(){
		return "intoComputer";
	}
	//进入性能监测
	public String intoMonitor(){
		return "intoMonitor";
	}
	//进入个人信息管理
	public String intoPerson(){
		return "intoPerson";
	}

}
