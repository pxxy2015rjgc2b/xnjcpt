package com.xnjcpt.action.alarm;

import com.xnjcpt.service.alarm.AlarmService;

public class AlarmAction {
	//注入业务层的类
	private AlarmService alarmService;

	public void setAlarmService(AlarmService alarmService) {
		this.alarmService = alarmService;
	}
	

}
