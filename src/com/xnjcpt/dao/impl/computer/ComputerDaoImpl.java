package com.xnjcpt.dao.impl.computer;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateTemplate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.xnjcpt.dao.computer.ComputerDao;
import com.xnjcpt.domain.DO.xnjcpt_computer;
import com.xnjcpt.domain.DO.xnjcpt_user;
import com.xnjcpt.domain.DO.xnjcpt_user_computer;
import com.xnjcpt.domain.VO.page_list_user_computerVO;


import util.TeamUtil;



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
	public void addComputer(xnjcpt_computer xc,xnjcpt_user user,xnjcpt_user_computer xuc) {
		xc.setComputer_gmt_create(TeamUtil.getStringSecond());
		xc.setComputer_gmt_modified(TeamUtil.getStringSecond());
		xc.setComputer_id(TeamUtil.getUuid());
		xuc.setUser_computer_computer(xc.getComputer_id());
		xuc.setUser_computer_user(user.getUser_id());
		xuc.setUser_computer_gmt_create(TeamUtil.getStringSecond());
		xuc.setUser_computer_gmt_modified(TeamUtil.getStringSecond());
		xuc.setUser_computer_id(TeamUtil.getUuid());
		getSession().save(xc);
		getSession().save(xuc);
		
	}

	@Override
	public void deleteComputer(String user_computer_id) {
		String hql ="from xnjcpt_user_computer where user_computer_id = '" + user_computer_id + "' ";
		
		Query query=getSession().createQuery(hql);
		List<xnjcpt_user_computer> usercomputerList=query.list();
		
				String hql1 = "delete from xnjcpt_user_computer where user_computer_id = '" + user_computer_id + "'";
		getSession().createQuery(hql1).executeUpdate();
		String hql2 = "delete from xnjcpt_computer where computer_id = '" + usercomputerList.get(0).getUser_computer_computer() + "'";
		getSession().createQuery(hql2).executeUpdate();
	}

	@Override
	public void updateComputer(String user_computer_id,xnjcpt_computer xc) {
String hql ="from xnjcpt_user_computer where user_computer_id = '" + user_computer_id + "' ";
		
		Query query=getSession().createQuery(hql);
		List<xnjcpt_user_computer> usercomputerList=query.list();
		
		String hql1 = "update xnjcpt_computer set computer_name='"+xc.getComputer_name()+"',computer_ip='"+xc.getComputer_ip()+"',computer_gmt_create='"+TeamUtil.getStringSecond()+"',computer_gmt_modified='"+TeamUtil.getStringSecond()+"'where computer_id = '" + usercomputerList.get(0).getUser_computer_computer() + "'";
		getSession().createQuery(hql1).executeUpdate();
	}

	@Override
	public xnjcpt_user_computer getUser_computerById(String user_computer_id) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		xnjcpt_user_computer xuc = (xnjcpt_user_computer) session.get(xnjcpt_user_computer.class,user_computer_id);
	
String hql ="from xnjcpt_computer where computer_id = '" + xuc.getUser_computer_computer() + "' ";
		
		Query query=getSession().createQuery(hql);
		List<xnjcpt_computer> usercomputerList=query.list();
System.out.println(usercomputerList);
		return xuc;
		
	}

	

	

	/*@Override
	
	@Override
	public int getCountByCondition(page_list_user_computerVO computerVO) {
		String hql = "select count(*) from xnjcpt_computer where 1=1";
		if (computerVO.getQueryContent() != null && !"".equals(computerVO.getQueryContent()))
			hql = hql + " and (user_computer_id	 like '%" + computerVO.getQueryContent() + "%' or "
					+ "user_computer_user		 like '%" + computerVO.getQueryContent() + "%'or "
					+ "user_computer_computer			 like '%" + computerVO.getQueryContent() + "%')";
		if (computerVO.getQuery_time_start() != null && !"".equals(computerVO.getQuery_time_start()))
			hql = hql + " and user_computer_gmt_create >='" + computerVO.getQuery_time_start() + "'";
		if (computerVO.getQuery_time_end() != null && !"".equals(computerVO.getQuery_time_start()))
			hql = hql + " and user_computer_gmt_modified<='" + computerVO.getQuery_time_end() + "'";

		Session session = this.getSession();
		long count = (long) session.createQuery(hql).uniqueResult();
		return new Long(count).intValue();
	}

	@Override
	public void getComputerByPage(page_list_user_computerVO computerVO) {
		String hql = "from xnjcpt_user_computer where 1=1";
		if (computerVO.getQueryContent() != null && !"".equals(computerVO.getQueryContent()))
			hql = hql + " and (user_computer_id	 like '%" + computerVO.getQueryContent() + "%' or "
					+ "user_computer_user		 like '%" + computerVO.getQueryContent() + "%'or "
					+ "user_computer_computer			 like '%" + computerVO.getQueryContent() + "%')";
		if (computerVO.getQuery_time_start() != null && !"".equals(computerVO.getQuery_time_start()))
			hql = hql + " and user_computer_gmt_create		 >='" + computerVO.getQuery_time_start() + "'";
		if (computerVO.getQuery_time_end() != null && !"".equals(computerVO.getQuery_time_start()))
			hql = hql + " and user_computer_gmt_modified		<='" + computerVO.getQuery_time_end() + "'";
		hql = hql + " order by user_computer_gmt_create		 " +computerVO.getQuery_time_sort();
		Session session = this.getSession();
		List<xnjcpt_user_computer> computerList = session.createQuery(hql)
				.setFirstResult((computerVO.getCurrPage() - 1) * computerVO.getPageSize())
				.setMaxResults(computerVO.getPageSize()).list();
		computerVO.setUsercomputerList(computerList);
	}
*/
	
}
