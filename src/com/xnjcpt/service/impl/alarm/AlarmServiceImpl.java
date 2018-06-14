package com.xnjcpt.service.impl.alarm;

import java.util.List;

import com.xnjcpt.dao.alarm.AlarmDao;
import com.xnjcpt.domain.DO.xnjcpt_alarm;
import com.xnjcpt.domain.VO.showAlarmInforVo;
import com.xnjcpt.service.alarm.AlarmService;

import util.TeamUtil;

public class AlarmServiceImpl implements AlarmService {
	//注入dao层的类
	private AlarmDao alarmDao;

	public void setAlarmDao(AlarmDao alarmDao) {
		this.alarmDao = alarmDao;
	}

	/**
	 * service层保存警报信息的方法
	 */
	
	@Override
	public void saveAlarmInfor(xnjcpt_alarm xnjcpt_alarm) {
		// TODO Auto-generated method stub
		alarmDao.saveAlarmInfor(xnjcpt_alarm);
	}
	
	/**
	 * 根据主机ip查询对应的警报信息
	 */
	@Override
	public xnjcpt_alarm getAlarmInforByAlarmComputer(String alarm_id) {
		// TODO Auto-generated method stub
		xnjcpt_alarm xa=alarmDao.getAlarmInforByAlarmInfor(alarm_id);
		return xa;
	}
	
	/**
	 * service层更改警报状态的方法
	 */
	@Override
	public void updateAlarmState(String alarm_id, String alarm_state) {
		// TODO Auto-generated method stub
		alarmDao.updateAlarmState(alarm_id,alarm_state);
	}
	
	/**
	 * service层删除警报信息的方法
	 */

	@Override
	public void deleteAlarmInfor(String alarm_id) {
		// TODO Auto-generated method stub
		alarmDao.deleteAlarmInfor(alarm_id);
	}
	
	/**
	 * 分页显示所有的警报信息
	 */
	@Override
	public showAlarmInforVo getAlarmInfor(String queryString, int currPage) {
		// TODO Auto-generated method stub
		//分页实例化对象
		showAlarmInforVo alarm_infor=new showAlarmInforVo();
		//当前的页码
		alarm_infor.setCurrPage(currPage);
		//查询的条件
		alarm_infor.setQueryString(queryString);
		//总的记录条数
		int count=alarmDao.getAlarmInforCount(queryString);
		alarm_infor.setCount(count);
		
		//每页显示的记录条数
		alarm_infor.setPageSize(10);
		
		//总页数
		double cou=count;
		int totalPage = (int) Math.ceil(cou / 10);
		alarm_infor.setTotalPage(totalPage);
		
		//需要显示的数据
		List<xnjcpt_alarm> alarm_list=alarmDao.getAlarmInforList(queryString,currPage);
		alarm_infor.setAlarm_list(alarm_list);
		
		return alarm_infor;
	}

	/**
	 * 点击详细信息获取对应的警报信息
	 */
	@Override
	public xnjcpt_alarm getAlarmInforById(String alarm_id) {
		// TODO Auto-generated method stub
		return alarmDao.getAlarmInforById(alarm_id);
	}

	/**
	 * 修改警报信息
	 */
	@Override
	public void updateAlarmInfor(xnjcpt_alarm xnjcpt_alarm) {
		// TODO Auto-generated method stub
		xnjcpt_alarm xa=alarmDao.getAlarmInforById(xnjcpt_alarm.getAlarm_id());
		xnjcpt_alarm.setAlarm_computer(xa.getAlarm_computer());
		xnjcpt_alarm.setAlarm_gmt_create(xa.getAlarm_gmt_create());
		xnjcpt_alarm.setAlarm_gmt_modified(TeamUtil.getStringSecond());
		xnjcpt_alarm.setAlarm_user(xa.getAlarm_user());
		
		alarmDao.updateAlarmInfor(xnjcpt_alarm);
		
	}

	/**
	 * 批量删除警报信息的方法
	 */
	@Override
	public void deleteAlarmInfors(String[] strAlarmIds) {
		// TODO Auto-generated method stub
		alarmDao.deleteAlarmInfors(strAlarmIds);
	}
	

	
	

}
