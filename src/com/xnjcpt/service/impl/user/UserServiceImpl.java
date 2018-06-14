package com.xnjcpt.service.impl.user;

import com.xnjcpt.dao.user.UserDao;
import com.xnjcpt.service.user.UserService;

public class UserServiceImpl implements UserService {
	//×¢Èëdao²ãµÄÀà
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	

}
