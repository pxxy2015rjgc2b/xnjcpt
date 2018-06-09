package com.xnjcpt.service.alarm;

import com.xnjcpt.domain.VO.AlarmPageVO;

public interface AlarmService {

	boolean saveAlarm(com.xnjcpt.domain.DO.xnjcpt_alarm xnjcpt_alarm);

	void getAlarmByPage(AlarmPageVO alarmPageVO);

	boolean deleteAlarm(com.xnjcpt.domain.DO.xnjcpt_alarm xnjcpt_alarm);

	com.xnjcpt.domain.DO.xnjcpt_alarm getAlarmById(String alarm_id);

	boolean updateAlarmById(com.xnjcpt.domain.DO.xnjcpt_alarm xnjcpt_alarm);

}
