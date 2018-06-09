package com.xnjcpt.action.user;

import com.xnjcpt.service.user.UserManagerService;

public class UserManagerAction {
	//注入业务层的类
	private UserManagerService userManagerService;

	public UserManagerService getUserManagerService() {
		return userManagerService;
	}

	public void setUserManagerService(UserManagerService userManagerService) {
		this.userManagerService = userManagerService;
	}


}
