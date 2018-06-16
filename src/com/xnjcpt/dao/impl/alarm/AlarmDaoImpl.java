package com.xnjcpt.dao.impl.alarm;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.ActionContext;
import com.xnjcpt.dao.alarm.AlarmDao;
import com.xnjcpt.domain.DO.xnjcpt_alarm;
import com.xnjcpt.domain.DO.xnjcpt_alarm_message;
import com.xnjcpt.domain.DO.xnjcpt_computer;
import com.xnjcpt.domain.DO.xnjcpt_user_computer;
import com.xnjcpt.domain.VO.AlarmMessageVO;
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

	@Override
	public xnjcpt_computer getComputerByIp(String ip) {
		// TODO Auto-generated method stub

		String hql = " from xnjcpt_computer where computer_ip = '" + ip + "'";

		List<xnjcpt_computer> list = this.getSession().createQuery(hql).list();
		if (list != null && list.size() > 0)
			return list.get(0);
		else {
			return null;
		}
	}

	@Override
	public List<xnjcpt_alarm> getAlarm(String computer_id, String string) {
		// TODO Auto-generated method stub

		String hql = "from xnjcpt_alarm where alarm_computer = '" + computer_id + "' and alarm_type ='" + string
				+ "' and alarm_state ='1' order by alarm_threshold_value desc";

		return this.getSession().createQuery(hql).list();
	}

	@Override
	public xnjcpt_user_computer getUserById(String computer_id) {
		// TODO Auto-generated method stub

		String hql = "from xnjcpt_user_computer where user_computer_computer ='" + computer_id + "'";

		return (xnjcpt_user_computer) this.getSession().createQuery(hql).list().get(0);
	}

	@Override
	public void saveMessage(xnjcpt_alarm_message xam) {
		// TODO Auto-generated method stub
		this.getSession().save(xam);
	}

	@Override
	public int getCountAlamrMessage() {
		// TODO Auto-generated method stub
		String user_id = (String) ActionContext.getContext().getSession().get("user_id");
		String hql = "select count(*) from xnjcpt_alarm_message where message_user='" + user_id
				+ "' and message_status = '" + 0 + "'";
		long count = (long) this.getSession().createQuery(hql).uniqueResult();
		return (int) count;
	}

	@Override
	public void getAlarmMessageByPage(AlarmMessageVO alarmMessageVO) {
		// TODO Auto-generated method stub
		String user_id = (String) ActionContext.getContext().getSession().get("user_id");
		String hql = "from xnjcpt_alarm_message where message_user='" + user_id + "' order by message_status asc";
		List<xnjcpt_alarm_message> list = this.getSession().createQuery(hql)
				.setFirstResult((alarmMessageVO.getCurrPage() - 1) * alarmMessageVO.getPageSize())
				.setMaxResults(alarmMessageVO.getPageSize()).list();
		alarmMessageVO.setList(list);
	}

	@Override
	public boolean updateStatus(String message_id) {
		// TODO Auto-generated method stub
		String hql = "update xnjcpt_alarm_message set message_status = '1' where message_id = '" + message_id + "'";
		try {
			this.getSession().createQuery(hql).executeUpdate();
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}

	}

	@Override
	public boolean deleteMessage(String message_id) {
		// TODO Auto-generated method stub
		String hql = "delete from xnjcpt_alarm_message where message_id = '" + message_id + "'";
		try {
			this.getSession().createQuery(hql).executeUpdate();
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}

	}

	@Override
	public int getCountAllAlamrMessage() {
		// TODO Auto-generated method stub
		String user_id = (String) ActionContext.getContext().getSession().get("user_id");
		String hql = "select count(*) from xnjcpt_alarm_message where message_user='" + user_id + "'";
		long count = (long) this.getSession().createQuery(hql).uniqueResult();
		return (int) count;
	}
}
