package com.xnjcpt.service.impl.alarm;

import com.xnjcpt.dao.alarm.AlarmDao;
import com.xnjcpt.domain.DO.xnjcpt_alarm;
import com.xnjcpt.service.alarm.AlarmService;

import util.TeamUtil;

public class AlarmServiceImpl implements AlarmService {
	//×¢Èëdao²ãµÄÀà
	private AlarmDao alarmDao;

	public void setAlarmDao(AlarmDao alarmDao) {
		this.alarmDao = alarmDao;
	}

	@Override
	public boolean saveAlarm(xnjcpt_alarm xnjcpt_alarm) {
		// TODO Auto-generated method stub
		
		xnjcpt_alarm.setAlarm_id(TeamUtil.getUuid());
		xnjcpt_alarm.setAlarm_gmt_create(TeamUtil.getStringSecond());
		xnjcpt_alarm.setAlarm_gmt_modified(TeamUtil.getStringSecond());
		boolean flag = alarmDao.saveAlarm(xnjcpt_alarm);
		
		
		return flag;
	}
	

}
