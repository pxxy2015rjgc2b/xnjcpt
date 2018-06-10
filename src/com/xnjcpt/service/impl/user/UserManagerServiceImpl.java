package com.xnjcpt.service.impl.user;

import java.util.List;

import com.xnjcpt.dao.user.UserManagerDao;
import com.xnjcpt.domain.DO.xnjcpt_user;
import com.xnjcpt.service.user.UserManagerService;
import com.xnjcpt.service.user.UserService;

public class UserManagerServiceImpl implements UserManagerService {
	//ע��dao�����
	private UserManagerDao userManagerDao;

	public UserManagerDao getUserManagerDao() {
		return userManagerDao;
	}

	public void setUserManagerDao(UserManagerDao userManagerDao) {
		this.userManagerDao = userManagerDao;
	}

	@Override
	public void adduser(xnjcpt_user user) {
		// TODO Auto-generated method stub
		userManagerDao.adduser(user);
	}

	@Override
	public void deleteuser(String user_id) {
		// TODO Auto-generated method stub
		userManagerDao.deleteuser(user_id);
	}

	@Override
	public void updateuser(xnjcpt_user user) {
		// TODO Auto-generated method stub
		userManagerDao.updateuser(user);
	}

	@Override
	public void updatePassword(String user_id, String newPassword) {
		// TODO Auto-generated method stub
		userManagerDao.updatePassword(user_id, newPassword);
	}

	@Override
	public xnjcpt_user getUserByUserEmail(String user_email) {
		// TODO Auto-generated method stub
		return userManagerDao.getUserByUserEmail(user_email);
	}

	@Override
	public xnjcpt_user getUserByUserId(String user_id) {
		// TODO Auto-generated method stub
		return userManagerDao.getUserByUserId(user_id);
	}

	@Override
	public xnjcpt_user getUserByUseruser_username(String user_username) {
		// TODO Auto-generated method stub
		return userManagerDao.getUserByUseruser_username(user_username);
	}

	@Override
	public xnjcpt_user getUserByuser_name(String user_name) {
		// TODO Auto-generated method stub
		return userManagerDao.getUserByuser_name(user_name);
	}

	@Override
	public int getUserCount(String keyword, int currPage) {
		// TODO Auto-generated method stub
		return userManagerDao.getUserCount(keyword, currPage);
	}

	@Override
	public List<xnjcpt_user> findPageBy(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return userManagerDao.findPageBy(currentPage, pageSize);
	}

	@Override
	public List<xnjcpt_user> findPageByKeyword(int currentPage, int pageSize, String keyword) {
		// TODO Auto-generated method stub
		return userManagerDao.findPageByKeyword(currentPage, pageSize, keyword);
	}

}
