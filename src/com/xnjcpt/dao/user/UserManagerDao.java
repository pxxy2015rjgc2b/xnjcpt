package com.xnjcpt.dao.user;

import java.util.List;

import com.xnjcpt.domain.DO.xnjcpt_user;

public interface UserManagerDao {
	void adduser(xnjcpt_user user);//增加用户
	void deleteuser(String user_id);	//根据id删除用户
	void updateuser(xnjcpt_user user);//更新用户
	void updatePassword(String user_id, String newPassword);//修改密码
	
	xnjcpt_user getUserByUserEmail(String user_email);//根据邮箱查找用户
	xnjcpt_user getUserByUserId(String user_id);//根据id查找用户
	xnjcpt_user getUserByUseruser_username(String user_username);//根据user_username查找
	xnjcpt_user getUserByuser_name(String user_name);//根据user_name查找
	
	int getUserCount(String keyword, int currPage);//查询xx用户总数
	List<xnjcpt_user> findPageBy(int currentPage, int pageSize);
	List<xnjcpt_user> findPageByKeyword(int currentPage, int pageSize,String keyword);
	//根据关键字查找

}
