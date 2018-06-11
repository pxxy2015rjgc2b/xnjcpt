package com.xnjcpt.dao.impl.alarm;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metamodel.source.hbm.HierarchyBuilder;

import com.xnjcpt.dao.alarm.AlarmDao;
import com.xnjcpt.domain.DO.xnjcpt_alarm;

public class AlarmDaoImpl implements AlarmDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
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
}
