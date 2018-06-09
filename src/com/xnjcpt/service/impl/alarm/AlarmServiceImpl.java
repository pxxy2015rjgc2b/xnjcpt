package com.xnjcpt.service.impl.alarm;

import com.xnjcpt.dao.alarm.AlarmDao;
import com.xnjcpt.domain.DO.xnjcpt_alarm;
import com.xnjcpt.domain.VO.AlarmPageVO;
import com.xnjcpt.service.alarm.AlarmService;

import util.TeamUtil;

public class AlarmServiceImpl implements AlarmService {
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

	@Override
	public void getAlarmByPage(AlarmPageVO alarmPageVO) {
		// TODO Auto-generated method stub

		int count = alarmDao.getCount(alarmPageVO);
		alarmPageVO.setPageSize(10);
		alarmPageVO.setTotalCount(count);
		alarmPageVO.setTotalPage((int) Math.ceil((double) count / alarmPageVO.getPageSize()));
		alarmDao.getAlarmByPage(alarmPageVO);
	}

	@Override
	public boolean deleteAlarm(xnjcpt_alarm xnjcpt_alarm) {
		// TODO Auto-generated method stub
		boolean flag = alarmDao.deleteAlarm(xnjcpt_alarm);
		return flag;
	}

	@Override
	public xnjcpt_alarm getAlarmById(String alarm_id) {
		// TODO Auto-generated method stub

		return alarmDao.getAlarmById(alarm_id);
	}

	@Override
	public boolean updateAlarmById(xnjcpt_alarm xnjcpt_alarm) {
		// TODO Auto-generated method stub
		xnjcpt_alarm oldAlarm = alarmDao.getAlarmById(xnjcpt_alarm.getAlarm_id());
		xnjcpt_alarm.setAlarm_user(oldAlarm.getAlarm_user());
		xnjcpt_alarm.setAlarm_computer(oldAlarm.getAlarm_computer());
		xnjcpt_alarm.setAlarm_gmt_create(oldAlarm.getAlarm_gmt_create());
		xnjcpt_alarm.setAlarm_gmt_modified(TeamUtil.getStringSecond());

		return alarmDao.updateAlarmById(xnjcpt_alarm);
	}

}
