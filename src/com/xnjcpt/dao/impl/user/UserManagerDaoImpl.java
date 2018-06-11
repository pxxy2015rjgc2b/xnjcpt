package com.xnjcpt.dao.impl.user;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.xnjcpt.dao.user.UserManagerDao;
import com.xnjcpt.domain.DO.xnjcpt_user;

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
	
	@Override
	public int getUserCount(String keyword, int currPage) {
		// TODO Auto-generated method stub
		String hql =null;
		if(keyword!=""||keyword!=null){
		String query = "%" + keyword + "%";
		hql = "select count(*) from xnjcpt_user where (user_name like '" + query + "' or user_username like ''" + query + "')";
		System.out.println(hql);}
		else{
		hql = "select count(*) from xnjcpt_user where 1=1";
		}
		int count = ((Number) getSession().createQuery(hql).uniqueResult()).intValue();
		return count;
}


	@Override
	public List<xnjcpt_user> findPageBy(int currentPage, int pageSize,String keyword) {
		// TODO Auto-generated method stub
		String hql="from xnjcpt_user";
		return (List<xnjcpt_user>) getSession().createQuery(hql)
		.setFirstResult((currentPage-1)*pageSize).setMaxResults(pageSize).list();
		//查找分页信息
	}

	@Override
	public List<xnjcpt_user> findPageByKeyword(int currentPage, int pageSize, String keyword) {
		// TODO Auto-generated method stub
		String query = "%" + keyword + "%";
		String hql = "from xnjcpt_user where (user_name like '" + query + "' or user_username like '" + query
				+ "' or user_email like '" + query+ "') order by user_gmt_create desc";
		List<xnjcpt_user> list = getSession().createQuery(hql).setFirstResult((currentPage - 1) * pageSize).setMaxResults(10)
				.list();
		System.out.println("当前查询的信息:" + list.size());
		return list;
		//根据关键字查询分页信息
	
		}

	@Override
	public void adduser(xnjcpt_user user) {
		// TODO Auto-generated method stub
		getSession().save(user);
	}

	@Override
	public void deleteuser(String user_id) {
		// TODO Auto-generated method stub
		String hql = "delete from xnjcpt_user where user_id = '" + user_id + "'";
		getSession().createQuery(hql).executeUpdate();
	}

	@Override
	public void updateuser(xnjcpt_user user) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(user);
	}

	@Override
	public void updatePassword(String user_id, String newPassword) {
		// TODO Auto-generated method stub
		String hql = "update xnjcpt_user set user_password ='" + newPassword + "' where user_id = '" + user_id + "'";
		getSession().createQuery(hql).executeUpdate();
	}

	@Override
	public xnjcpt_user getUserByUserEmail(String user_email) {
		// TODO Auto-generated method stub
		String hql = "from xnjcpt_user where user_email = '" + user_email + "'";
		Query query = getSession().createQuery(hql);
		xnjcpt_user user = (xnjcpt_user) query.uniqueResult();
		return user;
	}

	@Override
	public xnjcpt_user getUserByUserId(String user_id) {
		// TODO Auto-generated method stub
		return (xnjcpt_user) getSession().get(xnjcpt_user.class, user_id);
	}

	@Override
	public xnjcpt_user getUserByUseruser_username(String user_username) {
		// TODO Auto-generated method stub
		String hql = "from xnjcpt_user where user_username = '" + user_username + "'";
		Query query = getSession().createQuery(hql);
		xnjcpt_user user = (xnjcpt_user) query.uniqueResult();
		return user;
	}

	@Override
	public xnjcpt_user getUserByuser_name(String user_name) {
		// TODO Auto-generated method stub
		String hql = "from xnjcpt_user where user_name = '" + user_name + "'";
		Query query = getSession().createQuery(hql);
		xnjcpt_user user = (xnjcpt_user) query.uniqueResult();
		return user;
	}
}
