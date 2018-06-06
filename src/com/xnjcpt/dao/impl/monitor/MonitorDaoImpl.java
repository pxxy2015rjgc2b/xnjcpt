package com.xnjcpt.dao.impl.monitor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xnjcpt.dao.monitor.MonitorDao;

public class MonitorDaoImpl implements MonitorDao {
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
