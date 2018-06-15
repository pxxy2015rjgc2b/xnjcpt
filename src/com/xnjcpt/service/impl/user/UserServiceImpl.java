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
	public xnjcpt_user getUserByUsername(String user_name) {
		// TODO Auto-generated method stub
		return userDao.getUserByUsername(user_name);
	}

	@Override
	public boolean judgeUserByUsername(String user_name) {
		// TODO Auto-generated method stub
		return userDao.judgeUserByUsername(user_name);
	}

	@Override
	public xnjcpt_user getUserByUserEmail(String user_email) {
		// TODO Auto-generated method stub
		return userDao.getUserByUserEmail(user_email);
	}

	@Override
	public boolean judgeUserByUserEmail(String user_email) {
		// TODO Auto-generated method stub
		return userDao.judgeUserByUseremail(user_email);
	}

	@Override
	public xnjcpt_user getUserByUserId(String user_id) {
		// TODO Auto-generated method stub
		return userDao.getUserByUserId(user_id);
	}

	@Override
	public void updateuser(xnjcpt_user user) {
		// TODO Auto-generated method stub
		userDao.updateuser(user);
	}

	@Override
	public void deleteuser(String user_id) {
		// TODO Auto-generated method stub
		userDao.deleteuser(user_id);
	}
	
	@Override
	public void updatePassword(String user_id, String newPassword) {
		// TODO Auto-generated method stub
		userDao.updatePassword(user_id, newPassword);
	}

}
