package com.xnjcpt.action.alarm;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.xnjcpt.domain.DO.xnjcpt_alarm;
import com.xnjcpt.service.alarm.AlarmService;
/**
 * 
 * @author 孙毅
 *警报管理
 */
public class AlarmAction {
	//ע��ҵ������
	private AlarmService alarmService;

	private xnjcpt_alarm xnjcpt_alarm;
	//保存警报
	public void saveAlarm(){
		String user_id = (String) ActionContext.getContext().getSession().get("user_id");
		xnjcpt_alarm.setAlarm_user(user_id);
		boolean result = alarmService.saveAlarm(xnjcpt_alarm);
		HttpServletResponse response =ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		if(result){
			try {
				response.getWriter().write("saveSuccess");
				response.getWriter().flush();
				response.getWriter().close();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				response.getWriter().write("saveError");
				response.getWriter().flush();
				response.getWriter().close();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//分页获得警报
	
	public void getAlarmByPage(){
		
	}
	
	public void setAlarmService(AlarmService alarmService) {
		this.alarmService = alarmService;
	}


	public xnjcpt_alarm getXnjcpt_alarm() {
		return xnjcpt_alarm;
	}


	public void setXnjcpt_alarm(xnjcpt_alarm xnjcpt_alarm) {
		this.xnjcpt_alarm = xnjcpt_alarm;
	}


	public AlarmService getAlarmService() {
		return alarmService;
	}
	

}
