package com.xnjcpt.service.user;

import com.xnjcpt.domain.DO.xnjcpt_user;

public interface UserService {

	public  xnjcpt_user login(xnjcpt_user user);	//登陆方法
	public void register(xnjcpt_user user);		//注册方法
	public void resetPassword(String user_id, String newPassword);//找回密码
	public void updateuser(xnjcpt_user user);//更新用户
	public void deleteuser(String user_id);	//根据id删除用户
	
	public xnjcpt_user getUserByUsername(String user_name);
	//得到用户名（去比对）
	public boolean judgeUserByUsername(String user_name);
	//根据用户名判断用户是否存在
	xnjcpt_user getUserByUserEmail(String user_email);
	//根据邮箱查找用户
	public boolean judgeUserByUserEmail(String user_email);
	//根据邮箱是否已注册
	xnjcpt_user getUserByUserId(String user_id);
	//根据id查找用户
}
