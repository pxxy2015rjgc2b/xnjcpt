package com.xnjcpt.action.skip;

import com.opensymphony.xwork2.ActionSupport;
import com.xnjcpt.service.user.UserService;

/**
 * 
 * @author ����
 *������תҳ��
 */




public class SkipAction extends ActionSupport{	 
	
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	

	public String intoNavbar(){
		return "intoNavbar";
	}
	public String intoSlider2(){
		return "intoSlider2";
	}
	public String intoSlider(){
		return "intoSlider";
	}
	//���뾯�����
	public String intoAlarm(){
		return "intoAlarm";
	}
	//�����û�
	public String intoUser(){
		return "intoUser";
	}

	//进入用户详情
	public String intoUserInfo(){
		return "intoUserInfo";
	}
	//进入主机

	public String intoComputer(){
		return "intoComputer";
	}
	//�������ܼ��
	public String intoMonitor(){
		return "intoMonitor";
	}
	//���������Ϣ����
	public String intoPerson(){
		return "intoPerson";

	}
}
