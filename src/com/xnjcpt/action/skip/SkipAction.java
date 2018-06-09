package com.xnjcpt.action.skip;


import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author ����
 *������תҳ��
 */
public class SkipAction extends ActionSupport{	 
	public String intoNavbar(){
		return "intoNavbar";
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
	//������������
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
