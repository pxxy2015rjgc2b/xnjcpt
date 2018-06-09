package com.xnjcpt.action.alarm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.xnjcpt.domain.DO.xnjcpt_alarm;
import com.xnjcpt.domain.VO.AlarmPageVO;
import com.xnjcpt.service.alarm.AlarmService;

/**
 * 
 * @author 孙毅 警报管理
 */
public class AlarmAction {
	private AlarmService alarmService;

	private xnjcpt_alarm xnjcpt_alarm;
	private AlarmPageVO alarmPageVO;
	private String alarm_id;

	// 保存警报
	public void saveAlarm() {
		String user_id = (String) ActionContext.getContext().getSession().get("user_id");
		xnjcpt_alarm.setAlarm_user(user_id);
		boolean result = alarmService.saveAlarm(xnjcpt_alarm);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		if (result) {
			try {
				response.getWriter().write("saveSuccess");
				response.getWriter().flush();
				response.getWriter().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				response.getWriter().write("saveError");
				response.getWriter().flush();
				response.getWriter().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	// 分页获得警报

	public void getAlarmByPage() {
		alarmService.getAlarmByPage(alarmPageVO);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		Gson gson = new Gson();
		try {
			response.getWriter().write(gson.toJson(alarmPageVO));
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 删除警报
	public void deleteAlarm() {
		boolean flag = alarmService.deleteAlarm(xnjcpt_alarm);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		try {
			PrintWriter pw = response.getWriter();
			if (flag) {
				pw.write("deleteSuccess");
				pw.flush();
				pw.close();
			} else {
				pw.write("deleteError");
				pw.flush();
				pw.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 获得一条警报
	public void getAlarmById() {
		xnjcpt_alarm alarm = alarmService.getAlarmById(alarm_id);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(new Gson().toJson(alarm));
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 修改警报
	public void updateAlarmById() {
		boolean flag = alarmService.updateAlarmById(xnjcpt_alarm);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		try {
			PrintWriter pw = response.getWriter();
			if (flag) {
				pw.write("updateSuccess");
				pw.flush();
				pw.close();
			} else {
				pw.write("updateError");
				pw.flush();
				pw.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public AlarmPageVO getAlarmPageVO() {
		return alarmPageVO;
	}

	public void setAlarmPageVO(AlarmPageVO alarmPageVO) {
		this.alarmPageVO = alarmPageVO;
	}

	public String getAlarm_id() {
		return alarm_id;
	}

	public void setAlarm_id(String alarm_id) {
		this.alarm_id = alarm_id;
	}

}
