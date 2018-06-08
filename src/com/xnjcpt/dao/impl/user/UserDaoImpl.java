package com.xnjcpt.dao.impl.user;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xnjcpt.dao.user.UserDao;
import com.xnjcpt.domain.DO.xnjcpt_user;


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

	@Override
	public xnjcpt_user login(xnjcpt_user user) {
		// TODO Auto-generated method stub
		String hql = "from xnjcpt_user where user_name = '" + user.getUser_name() + "'";
		Query query = getSession().createQuery(hql);
		xnjcpt_user list = (xnjcpt_user) query.uniqueResult();
		return  list;
	}

	@Override
	public void register(xnjcpt_user user) {
		// TODO Auto-generated method stub
		getSession().save(user);		//保存用户数据
	}

	

	@Override
	public xnjcpt_user getUserByUsername(String user_name) {
		String hql = "from xnjcpt_user where user_name = '" + user_name + "'";
		Query query = getSession().createQuery(hql);
		List<xnjcpt_user> list = query.list();
		if(list.size()>0){
		return list.get(0);
		}return null;
	}

	@Override
	public boolean judgeUserByUsername(String user_name) {
		// TODO Auto-generated method stub
		String hql = "from xnjcpt_user where user_name = '" + user_name + "'";
		Query query = getSession().createQuery(hql);
		List<xnjcpt_user> list = query.list();
		if (list.size() <= 0) {
			return false; // 查找的用户小于等于0，返回flase
		} else {
			return true; // 查找的用户大于0，返回true
		}}

	@Override
	public void resetPassword(String user_id, String newPassword) {
		// TODO Auto-generated method stub
		String hql = "update xnjcpt_user set user_password ='" + newPassword + "' where user_id = '" + user_id + "'";
		getSession().createQuery(hql).executeUpdate();		
		//更新用户数据
	}

	@Override
	public boolean judgeUserByUseremail(String user_email) {
		// TODO Auto-generated method stub
		String hql = "from xnjcpt_user where user_email = '" + user_email + "'";
		Query query = getSession().createQuery(hql);
		List<xnjcpt_user> list = query.list();
		if (list.size() <= 0) {
			return false; // 查找的用户小于等于0，返回flase  boolean默认返回值为false
		} else {
			return true; // 查找的用户大于0，返回true
		}}
	
	@Override
	public xnjcpt_user getUserByUserEmail(String user_email){
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
	public void updateuser(xnjcpt_user user) {
		// TODO Auto-generated method stub
		getSession().update(user);		//更新用户
	}

	@Override
	public void deleteuser(String user_id) {
		// TODO Auto-generated method stub
		String hql = "delete from xnjcpt_user where user_id = '" + user_id + "'";
		getSession().createQuery(hql).executeUpdate();	
		//根据id删除用户
	}

	
}
