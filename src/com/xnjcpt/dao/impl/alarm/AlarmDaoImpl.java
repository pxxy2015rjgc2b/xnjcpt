package com.xnjcpt.dao.impl.alarm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xnjcpt.dao.alarm.AlarmDao;

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
}
