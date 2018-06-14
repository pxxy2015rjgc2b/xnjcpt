package com.xnjcpt.service.alarm;

import com.xnjcpt.domain.DO.xnjcpt_memory_state;
import com.xnjcpt.domain.VO.AlarmMessageVO;
import com.xnjcpt.domain.VO.AlarmPageVO;

public interface AlarmService {

	boolean saveAlarm(com.xnjcpt.domain.DO.xnjcpt_alarm xnjcpt_alarm);

	void getAlarmByPage(AlarmPageVO alarmPageVO);

	boolean deleteAlarm(com.xnjcpt.domain.DO.xnjcpt_alarm xnjcpt_alarm);

	com.xnjcpt.domain.DO.xnjcpt_alarm getAlarmById(String alarm_id);

	boolean updateAlarmById(com.xnjcpt.domain.DO.xnjcpt_alarm xnjcpt_alarm);

	void issueCpuUtilAlarm(String ip, com.xnjcpt.domain.DO.xnjcpt_cpu_state xnjcpt_cpu_state);

	void issueMemoryUtilAlarm(String ip, xnjcpt_memory_state xnjcpt_memory_state);

	void issueOutObandAlarm(String ip, com.xnjcpt.domain.DO.xnjcpt_net_state xnjcpt_net_state);

	void issueInObandAlarm(String ip, com.xnjcpt.domain.DO.xnjcpt_net_state xnjcpt_net_state);

	void issueOutPackageAlarm(String ip, com.xnjcpt.domain.DO.xnjcpt_net_state xnjcpt_net_state);

	void issueInPackageAlarm(String ip, com.xnjcpt.domain.DO.xnjcpt_net_state xnjcpt_net_state);

	int getCountAlamrMessage();

	void getAlarmMessageByPage(AlarmMessageVO alarmMessageVO);

	boolean updateStatus(String message_id);

	boolean deleteMessage(String message_id);

}
