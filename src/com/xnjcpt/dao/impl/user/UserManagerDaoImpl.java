package com.xnjcpt.dao.impl.user;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xnjcpt.dao.user.UserDao;
import com.xnjcpt.dao.user.UserManagerDao;

public class UserManagerDaoImpl implements UserManagerDao {
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
