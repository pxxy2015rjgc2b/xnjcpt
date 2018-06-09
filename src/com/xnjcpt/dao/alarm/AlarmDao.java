package com.xnjcpt.dao.alarm;

import com.xnjcpt.domain.DO.xnjcpt_alarm;
import com.xnjcpt.domain.VO.AlarmPageVO;

public interface AlarmDao {

	boolean saveAlarm(xnjcpt_alarm xnjcpt_alarm);

	int getCount(AlarmPageVO alarmPageVO);

	void getAlarmByPage(AlarmPageVO alarmPageVO);

	boolean deleteAlarm(xnjcpt_alarm xnjcpt_alarm);

	xnjcpt_alarm getAlarmById(String alarm_id);

	boolean updateAlarmById(xnjcpt_alarm xnjcpt_alarm);

}
