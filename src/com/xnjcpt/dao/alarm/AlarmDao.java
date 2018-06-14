package com.xnjcpt.dao.alarm;

import java.util.List;

import com.xnjcpt.domain.DO.xnjcpt_alarm;

public interface AlarmDao {

	void saveAlarmInfor(xnjcpt_alarm xnjcpt_alarm);

	xnjcpt_alarm getAlarmInforByAlarmInfor(String alarm_id);

	void updateAlarmState(String alarm_id, String alarm_state);

	void deleteAlarmInfor(String alarm_id);

	int getAlarmInforCount(String queryString);

	List<xnjcpt_alarm> getAlarmInforList(String queryString, int currPage);

	xnjcpt_alarm getAlarmInforById(String alarm_id);

	void updateAlarmInfor(xnjcpt_alarm xnjcpt_alarm);

	void deleteAlarmInfors(String[] strAlarmIds);

	


}
