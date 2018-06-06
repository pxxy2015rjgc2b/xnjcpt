package com.xnjcpt.dao.impl.receive;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xnjcpt.dao.receive.ReceiveDao;

public class ReceiveDaoImpl implements ReceiveDao {
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
