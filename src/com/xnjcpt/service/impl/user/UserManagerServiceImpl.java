package com.xnjcpt.service.impl.user;

import com.xnjcpt.dao.user.UserManagerDao;
import com.xnjcpt.service.user.UserManagerService;
import com.xnjcpt.service.user.UserService;

public class UserManagerServiceImpl implements UserManagerService {
	//×¢Èëdao²ãµÄÀà
	private UserManagerDao userManagerDao;

	public UserManagerDao getUserManagerDao() {
		return userManagerDao;
	}

	public void setUserManagerDao(UserManagerDao userManagerDao) {
		this.userManagerDao = userManagerDao;
	}

	

}
