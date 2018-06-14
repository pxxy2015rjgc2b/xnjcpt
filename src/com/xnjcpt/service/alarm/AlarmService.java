package com.xnjcpt.service.alarm;

import com.xnjcpt.domain.VO.showAlarmInforVo;

public interface AlarmService {

	void saveAlarmInfor(com.xnjcpt.domain.DO.xnjcpt_alarm xnjcpt_alarm);

	com.xnjcpt.domain.DO.xnjcpt_alarm getAlarmInforByAlarmComputer(String alarm_id);

	void updateAlarmState(String alarm_id, String alarm_state);

	void deleteAlarmInfor(String alarm_id);

	showAlarmInforVo getAlarmInfor(String queryString, int currPage);

	com.xnjcpt.domain.DO.xnjcpt_alarm getAlarmInforById(String alarm_id);

	void updateAlarmInfor(com.xnjcpt.domain.DO.xnjcpt_alarm xnjcpt_alarm);

	void deleteAlarmInfors(String[] strAlarmIds);

}
