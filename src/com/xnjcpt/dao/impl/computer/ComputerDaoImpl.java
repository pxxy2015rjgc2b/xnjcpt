package com.xnjcpt.dao.impl.computer;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xnjcpt.dao.computer.ComputerDao;
import com.xnjcpt.domain.DO.xnjcpt_computer;

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

	@Override
	public List<xnjcpt_computer> getComputerByUserId(String user_id) {
		// TODO Auto-generated method stub
		
		String hql ="select new com.xnjcpt.domain.DTO.ChooseComputerDTO(c.computer_id , c.computer_ip) from xnjcpt_computer as c,xnjcpt_user_computer as uc where uc.user_computer_computer = computer_id and uc.user_computer_user = '"+user_id+"'";
		Query query = this.getSession().createQuery(hql);
		System.out.println(hql);
		return query.list();
	}
}
