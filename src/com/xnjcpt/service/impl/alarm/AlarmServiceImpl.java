package com.xnjcpt.service.impl.alarm;

import java.util.List;

import com.xnjcpt.dao.alarm.AlarmDao;
import com.xnjcpt.domain.DO.xnjcpt_alarm;
import com.xnjcpt.domain.DO.xnjcpt_alarm_message;
import com.xnjcpt.domain.DO.xnjcpt_computer;
import com.xnjcpt.domain.DO.xnjcpt_cpu_state;
import com.xnjcpt.domain.DO.xnjcpt_memory_state;
import com.xnjcpt.domain.DO.xnjcpt_net_state;
import com.xnjcpt.domain.DO.xnjcpt_user_computer;
import com.xnjcpt.domain.VO.AlarmMessageVO;
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

	@Override
	public void issueCpuUtilAlarm(String ip, xnjcpt_cpu_state xnjcpt_cpu_state) {
		// TODO Auto-generated method stub
		xnjcpt_computer xc = alarmDao.getComputerByIp(ip);

		if (xc != null) {
			xnjcpt_user_computer xuc = alarmDao.getUserById(xc.getComputer_id());
			List<xnjcpt_alarm> list = alarmDao.getAlarm(xc.getComputer_id(), "CPU利用率");
			if (list != null && list.size() > 0) {
				for (xnjcpt_alarm xnjcpt_alarm : list) {
					if ((1 - Float.parseFloat(xnjcpt_cpu_state.getCpu_state_idle())) > Float
							.parseFloat(xnjcpt_alarm.getAlarm_threshold_value())) {
						xnjcpt_alarm_message xam = new xnjcpt_alarm_message();
						xam.setMessage_id(TeamUtil.getUuid());
						xam.setMessage_gmt_create(TeamUtil.getStringSecond());
						xam.setMessage_gmt_modified(TeamUtil.getStringSecond());
						xam.setMessage_status("0");
						xam.setMessage_user(xuc.getUser_computer_user());
						xam.setMessage_info("您ip为" + ip + "的主机CPU利用率超过了您设定的警告值！请注意！");
						alarmDao.saveMessage(xam);
					}
				}
			}
		}

	}

	@Override
	public void issueMemoryUtilAlarm(String ip, xnjcpt_memory_state xnjcpt_memory_state) {
		// TODO Auto-generated method stub
		xnjcpt_computer xc = alarmDao.getComputerByIp(ip);
		if (xc != null) {
			xnjcpt_user_computer xuc = alarmDao.getUserById(xc.getComputer_id());
			List<xnjcpt_alarm> list = alarmDao.getAlarm(xc.getComputer_id(), "内存利用率");
			if (list != null && list.size() > 0) {
				for (xnjcpt_alarm xnjcpt_alarm : list) {
					if ((Float.parseFloat(xnjcpt_memory_state.getMemory_state_mem_rate())) > Float
							.parseFloat(xnjcpt_alarm.getAlarm_threshold_value())) {
						xnjcpt_alarm_message xam = new xnjcpt_alarm_message();
						xam.setMessage_id(TeamUtil.getUuid());
						xam.setMessage_gmt_create(TeamUtil.getStringSecond());
						xam.setMessage_gmt_modified(TeamUtil.getStringSecond());
						xam.setMessage_status("0");
						xam.setMessage_user(xuc.getUser_computer_user());
						xam.setMessage_info("您ip为" + ip + "的主机内存使用率超过了您设定的警告值！请注意！");
						alarmDao.saveMessage(xam);
					}
				}
			}
		}
	}

	@Override
	public void issueOutObandAlarm(String ip, xnjcpt_net_state xnjcpt_net_state) {
		// TODO Auto-generated method stub
		xnjcpt_computer xc = alarmDao.getComputerByIp(ip);
		if (xc != null) {
			xnjcpt_user_computer xuc = alarmDao.getUserById(xc.getComputer_id());
			List<xnjcpt_alarm> list = alarmDao.getAlarm(xc.getComputer_id(), "出带宽");
			if (list != null && list.size() > 0) {
				for (xnjcpt_alarm xnjcpt_alarm : list) {
					if ((Float.parseFloat(xnjcpt_net_state.getNet_state_obandwidth())) > Float
							.parseFloat(xnjcpt_alarm.getAlarm_threshold_value())) {
						xnjcpt_alarm_message xam = new xnjcpt_alarm_message();
						xam.setMessage_id(TeamUtil.getUuid());
						xam.setMessage_gmt_create(TeamUtil.getStringSecond());
						xam.setMessage_gmt_modified(TeamUtil.getStringSecond());
						xam.setMessage_status("0");
						xam.setMessage_user(xuc.getUser_computer_user());
						xam.setMessage_info("您ip为" + ip + "的主机出带宽超过了您设定的警告值！请注意！");
						alarmDao.saveMessage(xam);
					}
				}
			}
		}
	}

	@Override
	public void issueInObandAlarm(String ip, xnjcpt_net_state xnjcpt_net_state) {
		// TODO Auto-generated method stub
		xnjcpt_computer xc = alarmDao.getComputerByIp(ip);
		if (xc != null) {
			xnjcpt_user_computer xuc = alarmDao.getUserById(xc.getComputer_id());
			List<xnjcpt_alarm> list = alarmDao.getAlarm(xc.getComputer_id(), "入带宽");
			if (list != null && list.size() > 0) {
				for (xnjcpt_alarm xnjcpt_alarm : list) {
					if ((Float.parseFloat(xnjcpt_net_state.getNet_state_ibandwidth())) > Float
							.parseFloat(xnjcpt_alarm.getAlarm_threshold_value())) {
						xnjcpt_alarm_message xam = new xnjcpt_alarm_message();
						xam.setMessage_id(TeamUtil.getUuid());
						xam.setMessage_gmt_create(TeamUtil.getStringSecond());
						xam.setMessage_gmt_modified(TeamUtil.getStringSecond());
						xam.setMessage_status("0");
						xam.setMessage_user(xuc.getUser_computer_user());
						xam.setMessage_info("您ip为" + ip + "的主机入带宽超过了您设定的警告值！请注意！");
						alarmDao.saveMessage(xam);
					}
				}
			}
		}
	}

	@Override
	public void issueOutPackageAlarm(String ip, xnjcpt_net_state xnjcpt_net_state) {
		// TODO Auto-generated method stub
		xnjcpt_computer xc = alarmDao.getComputerByIp(ip);
		if (xc != null) {
			xnjcpt_user_computer xuc = alarmDao.getUserById(xc.getComputer_id());
			List<xnjcpt_alarm> list = alarmDao.getAlarm(xc.getComputer_id(), "出包量");
			if (list != null && list.size() > 0) {
				for (xnjcpt_alarm xnjcpt_alarm : list) {
					if ((Float.parseFloat(xnjcpt_net_state.getNet_state_opackage())) > Float
							.parseFloat(xnjcpt_alarm.getAlarm_threshold_value())) {
						xnjcpt_alarm_message xam = new xnjcpt_alarm_message();
						xam.setMessage_id(TeamUtil.getUuid());
						xam.setMessage_gmt_create(TeamUtil.getStringSecond());
						xam.setMessage_gmt_modified(TeamUtil.getStringSecond());
						xam.setMessage_status("0");
						xam.setMessage_user(xuc.getUser_computer_user());
						xam.setMessage_info("您ip为" + ip + "的主机出包量超过了您设定的警告值！请注意！");
						alarmDao.saveMessage(xam);
					}
				}
			}
		}
	}

	@Override
	public void issueInPackageAlarm(String ip, xnjcpt_net_state xnjcpt_net_state) {
		// TODO Auto-generated method stub
		xnjcpt_computer xc = alarmDao.getComputerByIp(ip);
		if (xc != null) {
			xnjcpt_user_computer xuc = alarmDao.getUserById(xc.getComputer_id());
			List<xnjcpt_alarm> list = alarmDao.getAlarm(xc.getComputer_id(), "入包量");
			if (list != null && list.size() > 0) {
				for (xnjcpt_alarm xnjcpt_alarm : list) {
					if ((Float.parseFloat(xnjcpt_net_state.getNet_state_ipackage())) > Float
							.parseFloat(xnjcpt_alarm.getAlarm_threshold_value())) {
						xnjcpt_alarm_message xam = new xnjcpt_alarm_message();
						xam.setMessage_id(TeamUtil.getUuid());
						xam.setMessage_gmt_create(TeamUtil.getStringSecond());
						xam.setMessage_gmt_modified(TeamUtil.getStringSecond());
						xam.setMessage_status("0");
						xam.setMessage_user(xuc.getUser_computer_user());
						xam.setMessage_info("您ip为" + ip + "的主机入包量超过了您设定的警告值！请注意！");
						alarmDao.saveMessage(xam);
					}
				}
			}
		}
	}

	@Override
	public int getCountAlamrMessage() {
		// TODO Auto-generated method stub
		return alarmDao.getCountAlamrMessage();
	}

	@Override
	public void getAlarmMessageByPage(AlarmMessageVO alarmMessageVO) {
		// TODO Auto-generated method stub
		int count = alarmDao.getCountAlamrMessage();
		alarmMessageVO.setPageSize(10);
		alarmMessageVO.setTotalCount(count);
		alarmMessageVO.setTotalPage((int) Math.ceil((double) count / alarmMessageVO.getPageSize()));
		alarmDao.getAlarmMessageByPage(alarmMessageVO);
	}

	@Override
	public boolean updateStatus(String message_id) {
		// TODO Auto-generated method stub
		return alarmDao.updateStatus(message_id);
	}

	@Override
	public boolean deleteMessage(String message_id) {
		// TODO Auto-generated method stub
		return alarmDao.deleteMessage(message_id);
	}

}
