package com.xnjcpt.service.impl.user;

import com.xnjcpt.dao.user.UserDao;
import com.xnjcpt.domain.DO.xnjcpt_user;
import com.xnjcpt.service.user.UserService;

public class UserServiceImpl implements UserService {
	//ע��dao�����
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public xnjcpt_user login(xnjcpt_user user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

	@Override
	public void register(xnjcpt_user user) {
		// TODO Auto-generated method stub
		userDao.register(user);
	}

	@Override
	public void resetPassword( String user_id, String newPassword) {
		// TODO Auto-generated method stub
		userDao.resetPassword(user_id, newPassword);
	}

	@Override
	public xnjcpt_user getUserByUsername(String user_name) {
		// TODO Auto-generated method stub
		return userDao.getUserByUsername(user_name);
	}

	@Override
	public boolean judgeUserByUsername(String user_name) {
		// TODO Auto-generated method stub
		return userDao.judgeUserByUsername(user_name);
	}
	

}
