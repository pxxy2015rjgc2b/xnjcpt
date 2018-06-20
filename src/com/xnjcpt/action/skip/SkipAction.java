package com.xnjcpt.action.skip;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author 孙毅 用于页面跳转
 */
public class SkipAction extends ActionSupport {
	public String intoNavbar() {
		return "intoNavbar";
	}

	public String intoSlider() {
		return "intoSlider";
	}

	// 进入警报
	public String intoAlarm() {
		return "intoAlarm";
	}

	// 进入用户
	public String intoUser() {
		return "intoUser";
	}

	// 进入主机
	public String intoComputer() {
		return "intoComputer";
	}

	// 进入性能监测
	public String intoMonitor() {
		return "intoMonitor";
	}

	// 进入进程管理
	public String intoProgress() {
		return "intoProgress";
	}

	// 进入远程控制
	public String intoControl() {
		return "intoControl";
	}

	// 进入个人信息管理
	public String intoPerson() {
		return "intoPerson";
	}

	// 进入警报通知页面
	public String intoAlarmMessage() {
		return "intoAlarmMessage";
	}

	// 进入主机主页的侧边栏
	public String intoSilderForComputer() {
		return "intoSilderForComputer";
	}

	// 进入集群总览
	public String intoOverview() {
		return "intoOverview";
	}

	// 登出
	public String logout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("user_id");
		session.removeAttribute("user_username");
		session.removeAttribute("user_role");
		session.removeAttribute("user_name");
		return "index";
	}

	// 进入后台管理侧边栏
	public String skipIntoManagerSlider() {
		return "skipIntoManagerSlider";
	}

	public String intoApply() {
		return "intoApply";
	}
}