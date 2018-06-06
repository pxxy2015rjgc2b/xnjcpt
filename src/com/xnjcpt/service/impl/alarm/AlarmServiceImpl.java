package com.xnjcpt.service.impl.alarm;

import com.xnjcpt.dao.alarm.AlarmDao;
import com.xnjcpt.service.alarm.AlarmService;

public class AlarmServiceImpl implements AlarmService {
	//×¢Èëdao²ãµÄÀà
	private AlarmDao alarmDao;

	public void setAlarmDao(AlarmDao alarmDao) {
		this.alarmDao = alarmDao;
	}
	

}
