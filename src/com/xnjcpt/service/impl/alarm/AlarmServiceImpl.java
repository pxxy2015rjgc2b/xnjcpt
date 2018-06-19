package com.xnjcpt.service.impl.alarm;

import java.util.List;

import com.xnjcpt.dao.alarm.AlarmDao;
import com.xnjcpt.domain.DO.xnjcpt_alarm;
import com.xnjcpt.domain.VO.showAlarmInforVo;
import com.xnjcpt.service.alarm.AlarmService;

import util.TeamUtil;

public class AlarmServiceImpl implements AlarmService {
	//ע��dao�����
	private AlarmDao alarmDao;

	public void setAlarmDao(AlarmDao alarmDao) {
		this.alarmDao = alarmDao;
	}

	/**
	 * service�㱣�澯����Ϣ�ķ���
	 */
	
	@Override
	public void saveAlarmInfor(xnjcpt_alarm xnjcpt_alarm) {
		// TODO Auto-generated method stub
		alarmDao.saveAlarmInfor(xnjcpt_alarm);
	}
	
	/**
	 * ��������ip��ѯ��Ӧ�ľ�����Ϣ
	 */
	@Override
	public xnjcpt_alarm getAlarmInforByAlarmComputer(String alarm_id) {
		// TODO Auto-generated method stub
		xnjcpt_alarm xa=alarmDao.getAlarmInforByAlarmInfor(alarm_id);
		return xa;
	}
	
	/**
	 * service����ľ���״̬�ķ���
	 */
	@Override
	public void updateAlarmState(String alarm_id, String alarm_state) {
		// TODO Auto-generated method stub
		alarmDao.updateAlarmState(alarm_id,alarm_state);
	}
	
	/**
	 * service��ɾ��������Ϣ�ķ���
	 */

	@Override
	public void deleteAlarmInfor(String alarm_id) {
		// TODO Auto-generated method stub
		alarmDao.deleteAlarmInfor(alarm_id);
	}
	
	/**
	 * ��ҳ��ʾ���еľ�����Ϣ
	 */
	@Override
	public showAlarmInforVo getAlarmInfor(String queryString, int currPage) {
		// TODO Auto-generated method stub
		//��ҳʵ��������
		showAlarmInforVo alarm_infor=new showAlarmInforVo();
		//��ǰ��ҳ��
		alarm_infor.setCurrPage(currPage);
		//��ѯ������
		alarm_infor.setQueryString(queryString);
		//�ܵļ�¼����
		int count=alarmDao.getAlarmInforCount(queryString);
		alarm_infor.setCount(count);
		
		//ÿҳ��ʾ�ļ�¼����
		alarm_infor.setPageSize(6);
		
		//��ҳ��
		double cou=count;
		int totalPage = (int) Math.ceil(cou / 6);
		alarm_infor.setTotalPage(totalPage);
		
		//��Ҫ��ʾ������
		List<xnjcpt_alarm> alarm_list=alarmDao.getAlarmInforList(queryString,currPage);
		alarm_infor.setAlarm_list(alarm_list);
		
		return alarm_infor;
	}

	/**
	 * �����ϸ��Ϣ��ȡ��Ӧ�ľ�����Ϣ
	 */
	@Override
	public xnjcpt_alarm getAlarmInforById(String alarm_id) {
		// TODO Auto-generated method stub
		return alarmDao.getAlarmInforById(alarm_id);
	}

	/**
	 * �޸ľ�����Ϣ
	 */
	@Override
	public void updateAlarmInfor(xnjcpt_alarm xnjcpt_alarm) {
		// TODO Auto-generated method stub
		System.out.println("alarm_id="+xnjcpt_alarm.getAlarm_id());
		xnjcpt_alarm xa=alarmDao.getAlarmInforById(xnjcpt_alarm.getAlarm_id());
		xnjcpt_alarm.setAlarm_computer(xa.getAlarm_computer());
		xnjcpt_alarm.setAlarm_gmt_create(xa.getAlarm_gmt_create());
		xnjcpt_alarm.setAlarm_gmt_modified(TeamUtil.getStringSecond());
		xnjcpt_alarm.setAlarm_user(xa.getAlarm_user());
		
		alarmDao.updateAlarmInfor(xnjcpt_alarm);
		
	}

	/**
	 * ����ɾ��������Ϣ�ķ���
	 */
	@Override
	public void deleteAlarmInfors(String[] strAlarmIds) {
		// TODO Auto-generated method stub
		alarmDao.deleteAlarmInfors(strAlarmIds);
	}
	

	
	

}
