package com.xnjcpt.dao.impl.computer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xnjcpt.dao.computer.ComputerDao;

public class ComputerDaoImpl implements ComputerDao {
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
