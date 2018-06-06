package com.xnjcpt.dao.impl.user;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xnjcpt.dao.user.UserDao;

public class UserDaoImpl implements UserDao {
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
