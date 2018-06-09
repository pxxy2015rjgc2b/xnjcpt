package com.xnjcpt.dao.user;

import java.util.List;

import com.xnjcpt.domain.DO.xnjcpt_user;


public interface UserDao {
	
	public  xnjcpt_user login(xnjcpt_user user);	//登陆方法
	public void register(xnjcpt_user user);		//注册方法
	public void resetPassword(String user_id, String newPassword);//找回密码
	public void updateuser(xnjcpt_user user);//更新用户
	public void deleteuser(String user_id);	//根据id删除用户
	
	
	public xnjcpt_user getUserByUsername(String user_name);
	//得到用户名（去比对）
	public boolean judgeUserByUsername(String user_name);
	//根据用户名判断用户是否存在
	public boolean judgeUserByUseremail(String user_email);
	//判断邮箱是否注册
	xnjcpt_user getUserByUserEmail(String user_email);
	//根据邮箱查找用户
	xnjcpt_user getUserByUserId(String user_id);
	//根据id查找用户
	
	int getUserCount();		//得到用户总数
	xnjcpt_user findUserByUserId();		//根据id查找user
	List<xnjcpt_user> findPageBy(int currentPage, int pageSize);
	List<xnjcpt_user> findPageByKeyword(int currentPage, int pageSize,String keyword);
	//根据关键字查找
	int getUserKeyCount();		//关键字查找得到用户总数
}
