package com.xnjcpt.dao.impl.alarm;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.ActionContext;
import com.xnjcpt.dao.alarm.AlarmDao;
import com.xnjcpt.domain.DO.xnjcpt_alarm;
import com.xnjcpt.domain.VO.AlarmPageVO;

public class AlarmDaoImpl implements AlarmDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public boolean saveAlarm(xnjcpt_alarm xnjcpt_alarm) {
		// TODO Auto-generated method stub
		try {
			this.getSession().save(xnjcpt_alarm);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}

	}

	@Override
	public int getCount(AlarmPageVO alarmPageVO) {
		// TODO Auto-generated method stub
		String user_id = (String) ActionContext.getContext().getSession().get("user_id");
		String hql = "select count(*) from xnjcpt_alarm as a , xnjcpt_computer as c  where a.alarm_computer = c.computer_id and  1=1 and a.alarm_user = '"
				+ user_id + "'";
		if (alarmPageVO.getSearchContent() != null && !"".equals(alarmPageVO.getSearchContent().trim())) {
			hql = hql + " and c.computer_ip like '%" + alarmPageVO.getSearchContent() + "%'";
		}
		if (alarmPageVO.getSearchAlarmType() != null && !"".equals(alarmPageVO.getSearchAlarmType().trim())) {
			hql = hql + " and a.alarm_type = '" + alarmPageVO.getSearchAlarmType() + "'";
		}
		Query query = this.getSession().createQuery(hql);
		long count = (long) query.uniqueResult();
		return (int) count;
	}

	@Override
	public void getAlarmByPage(AlarmPageVO alarmPageVO) {
		// TODO Auto-generated method stub
		String user_id = (String) ActionContext.getContext().getSession().get("user_id");
		String hql = "select new com.xnjcpt.domain.DTO.AlarmPageDTO(a.alarm_id,c.computer_ip,a.alarm_type,a.alarm_threshold_value,a.alarm_state) from xnjcpt_alarm as a , xnjcpt_computer as c  where a.alarm_computer = c.computer_id and  1=1 and a.alarm_user = '"
				+ user_id + "'";
		if (alarmPageVO.getSearchContent() != null && !"".equals(alarmPageVO.getSearchContent().trim())) {
			hql = hql + " and c.computer_ip like '%" + alarmPageVO.getSearchContent() + "%'";
		}
		if (alarmPageVO.getSearchAlarmType() != null && !"".equals(alarmPageVO.getSearchAlarmType().trim())) {
			hql = hql + " and a.alarm_type = '" + alarmPageVO.getSearchAlarmType() + "'";
		}
		hql = hql + " order by a.alarm_gmt_create desc";
		Query query = this.getSession().createQuery(hql)
				.setFirstResult((alarmPageVO.getCurrPage() - 1) * alarmPageVO.getPageSize())
				.setMaxResults(alarmPageVO.getPageSize());
		alarmPageVO.setList(query.list());
	}

	@Override
	public boolean deleteAlarm(xnjcpt_alarm xnjcpt_alarm) {
		// TODO Auto-generated method stub
		try {
			this.getSession().delete(xnjcpt_alarm);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}

	}

	@Override
	public xnjcpt_alarm getAlarmById(String alarm_id) {
		// TODO Auto-generated method stub
		xnjcpt_alarm xnjcpt_alarm = (xnjcpt_alarm) this.getSession().get(xnjcpt_alarm.class, alarm_id);
		this.getSession().clear();
		return xnjcpt_alarm;
	}

	@Override
	public boolean updateAlarmById(xnjcpt_alarm xnjcpt_alarm) {
		// TODO Auto-generated method stub

		try {
			this.getSession().saveOrUpdate(xnjcpt_alarm);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}
}
