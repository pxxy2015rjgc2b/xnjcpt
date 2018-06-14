package com.xnjcpt.dao.alarm;

import java.util.List;

import com.xnjcpt.domain.DO.xnjcpt_alarm;
import com.xnjcpt.domain.DO.xnjcpt_alarm_message;
import com.xnjcpt.domain.DO.xnjcpt_computer;
import com.xnjcpt.domain.DO.xnjcpt_user_computer;
import com.xnjcpt.domain.VO.AlarmMessageVO;
import com.xnjcpt.domain.VO.AlarmPageVO;

public interface AlarmDao {

	boolean saveAlarm(xnjcpt_alarm xnjcpt_alarm);

	int getCount(AlarmPageVO alarmPageVO);

	void getAlarmByPage(AlarmPageVO alarmPageVO);

	boolean deleteAlarm(xnjcpt_alarm xnjcpt_alarm);

	xnjcpt_alarm getAlarmById(String alarm_id);

	boolean updateAlarmById(xnjcpt_alarm xnjcpt_alarm);

	xnjcpt_computer getComputerByIp(String ip);

	List<xnjcpt_alarm> getAlarm(String computer_id, String string);

	xnjcpt_user_computer getUserById(String computer_id);

	void saveMessage(xnjcpt_alarm_message xam);

	int getCountAlamrMessage();

	void getAlarmMessageByPage(AlarmMessageVO alarmMessageVO);

	boolean updateStatus(String message_id);

	boolean deleteMessage(String message_id);

}
