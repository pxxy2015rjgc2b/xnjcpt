package com.xnjcpt.service.user;

import com.xnjcpt.domain.DO.xnjcpt_user;

public interface UserService {

	public  xnjcpt_user login(xnjcpt_user user);	//登陆方法
	public void register(xnjcpt_user user);		//注册方法
	public void resetPassword(String user_id, String newPassword);//找回密码
	
	public xnjcpt_user getUserByUsername(String user_name);
	//得到用户名（去比对）
	public boolean judgeUserByUsername(String user_name);
	//根据用户名判断用户是否存在
}
