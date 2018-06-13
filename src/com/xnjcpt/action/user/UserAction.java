package com.xnjcpt.action.user;

import com.xnjcpt.service.user.UserService;

public class UserAction {
	//注入业务层的类
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
