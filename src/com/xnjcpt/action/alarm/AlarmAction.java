package com.xnjcpt.action.alarm;

import com.xnjcpt.service.alarm.AlarmService;

import util.TeamUtil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.xnjcpt.domain.DO.*;
import com.xnjcpt.domain.VO.showAlarmInforVo;;

public class AlarmAction {
	//注入service
	private AlarmService alarmService;

	public void setAlarmService(AlarmService alarmService) {
		this.alarmService = alarmService;
	}
	
	public String skipToUser() {
		return "skipToUser";
	}

	public void test() {
		ApplicationContext a = (ApplicationContext) ServletActionContext.getServletContext()
				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
	}
	private xnjcpt_computer xnjcpt_computer;
	private xnjcpt_user xnjcpt_user;
	private xnjcpt_alarm xnjcpt_alarm;
	
	/**
	 * 添加警报信息
	 * @throws IOException 
	 */
	public void saveAlarmInfor() throws IOException{

		System.out.println("saveAlarmInfor");
		xnjcpt_alarm xnjcpt_alarm=new xnjcpt_alarm();
		xnjcpt_alarm.setAlarm_computer(alarm_computer);
		xnjcpt_alarm.setAlarm_state(alarm_state);
		xnjcpt_alarm.setAlarm_threshold_value(alarm_threshold_value);
		xnjcpt_alarm.setAlarm_type(alarm_type);
		xnjcpt_alarm.setAlarm_gmt_create(TeamUtil.getStringSecond());
		xnjcpt_alarm.setAlarm_gmt_modified(TeamUtil.getStringSecond());
		xnjcpt_alarm.setAlarm_id(TeamUtil.getUuid());
		/**
		 * 获取session对象中的user_id
		 */
		//String user_id = (String) ActionContext.getContext().getSession().get("user_id");
		String alarm_user = (String) ActionContext.getContext().getSession().get("user_id");
		xnjcpt_alarm.setAlarm_user(alarm_user);
		
		 HttpServletResponse response = ServletActionContext.getResponse();
		 response.setContentType("text/html;charset=utf-8");
		 response.setHeader("Access-Control-Allow-Origin", "*");
		 response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		
		 alarmService.saveAlarmInfor(xnjcpt_alarm);
		 
		 PrintWriter pw = response.getWriter();

		 pw.write("警报信息存储成功");

		
		
	}
//	/**
//	 * 更改警报的状态
//	 * @return
//	 * @throws IOException 
//	 */
//	public void updateAlarmState() throws IOException{
//		HttpServletResponse response = ServletActionContext.getResponse();
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter pw = response.getWriter();
//判断alarm_id是否为空
//		if(alarm_id=="" ||alarm_id==null){		
//			pw.write("Error!");
//		}else{
//			//System.out.println(alarm_id);
//			//pw.write(alarm_id);
//			//获取警报的详细信息
//			xnjcpt_alarm xa=alarmService.getAlarmInforByAlarmComputer(alarm_id);
//			//判断警报的状态是否变更
//			if(xa.getAlarm_state().equals(alarm_state)){
//				pw.write(alarm_state+"       "+xa.getAlarm_state());
//				pw.write("请选择需要更改的状态");
//			}else{
//				//pw.write("ok");
//				pw.write(alarm_state+"   else    "+xa.getAlarm_state());
//				pw.write("警报状态更改成功");
//				alarmService.updateAlarmState(alarm_id,alarm_state);
//			}
//		}
//	}
	
	/**
	 * 删除单个警报信息
	 * @return
	 * @throws IOException 
	 */
	public void deleteAlarmInfor() throws IOException{
		//根据id删除警报信息
		alarmService.deleteAlarmInfor(alarm_id);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();

		pw.write("警报信息删除成功！");

		pw.flush();
		pw.close();
		
	}
	
	/**
	 * 分页显示警报信息
	 * @return
	 * @throws IOException 
	 */
	public void getAlarmInfor() throws IOException{
		showAlarmInforVo saiv=alarmService.getAlarmInfor(queryString,currPage);
		Gson gson = new Gson();
		String result = gson.toJson(saiv);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.write(result);
		pw.flush();
		pw.close();
	}
	
	/**
	 * 获得一条警报信息ʾ
	 * @return
	 * @throws IOException 
	 */
	public void getAlarmInforById() throws IOException{
		xnjcpt_alarm xnjcpt_alarm=alarmService.getAlarmInforById(alarm_id);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		Gson gson=new Gson();
		String result=gson.toJson(gson);
		PrintWriter pw = response.getWriter();
		pw.write(result);
		pw.flush();
		pw.close();
	}
	
	/**
	 * 修改警报信息
	 * @return
	 * @throws IOException 
	 */
	public void updateAlarmInfor() throws IOException{
		
		alarmService.updateAlarmInfor(xnjcpt_alarm);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		
		PrintWriter pw = response.getWriter();
		pw.write("警报信息修改成功");
		
	}
	
	/**
	 * 批量删除警报信息
	 * @return
	 * @throws IOException 
	 */
	public void deleteAlarmInfors() throws IOException{
		 HttpServletResponse response = ServletActionContext.getResponse();
		 response.setContentType("text/html;charset=utf-8");
		 response.setHeader("Access-Control-Allow-Origin", "*");
		 response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		 
		 PrintWriter pw = response.getWriter();
		 
		 HttpServletRequest request = ServletActionContext.getRequest();
		 String[] strAlarmIds = request.getParameterValues("alarm_id");
		 if(strAlarmIds.length>0){
		 alarmService.deleteAlarmInfors(strAlarmIds);	 
		 pw.write("警报信息删除成功");
		 }else{
			 pw.write("请选择需要删除的警报信息");
		 }
	}
	

	public xnjcpt_computer getXnjcpt_computer() {
		return xnjcpt_computer;
	}
	public void setXnjcpt_computer(xnjcpt_computer xnjcpt_computer) {
		this.xnjcpt_computer = xnjcpt_computer;
	}
	public AlarmService getAlarmService() {
		return alarmService;
	}


	public xnjcpt_alarm getXnjcpt_alarm() {
		return xnjcpt_alarm;
	}


	public void setXnjcpt_alarm(xnjcpt_alarm xnjcpt_alarm) {
		this.xnjcpt_alarm = xnjcpt_alarm;
	}


	public xnjcpt_user getXnjcpt_user() {
		return xnjcpt_user;
	}


	public void setXnjcpt_user(xnjcpt_user xnjcpt_user) {
		this.xnjcpt_user = xnjcpt_user;
	}
	
	private String alarm_id;
	private String alarm_computer;
	private String alarm_threshold_value;
	private String alarm_type;
	private String alarm_state;
	private int currPage;
	private String queryString;

	
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

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	
	

}
