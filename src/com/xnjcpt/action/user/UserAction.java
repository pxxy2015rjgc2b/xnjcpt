package com.xnjcpt.action.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xnjcpt.domain.DO.xnjcpt_user;
import com.xnjcpt.service.user.UserService;

import util.SendEmail;



public class UserAction{
	//ע��ҵ������
	private UserService userService;
	private xnjcpt_user user;		//域模型

	public xnjcpt_user getUser() {
		return user;
	}

	public void setUser(xnjcpt_user user) {
		this.user = user;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void login() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		xnjcpt_user xu = userService.login(user);
		//System.out.println(xu);
		if (xu != null) {
			if (xu.getUser_password().equals(user.getUser_password())){
				pw.write("success");
				System.out.println("密码输入正确");
				session.setAttribute("user_name", xu.getUser_name());
			}else{
				System.out.println("密码输入错误");
			}
		} else {
			pw.write("error");
			System.out.println("用户名输入错误");
			System.out.println(user.getUser_name());
		}
		pw.flush();
		pw.close();
	}
	
	public void register() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		if(userService.judgeUserByUsername(user.getUser_name())){
			pw.write("error");
			System.out.println("用户名已存在!");
		}else{
			pw.write("success");
			System.out.println("用户名不存在，恭喜您可以注册!");
			xnjcpt_user xu = new xnjcpt_user();
			xu.setUser_email(user.getUser_email());
			xu.setUser_name(user.getUser_name());
			xu.setUser_password(user.getUser_password());
			userService.register(xu);
			
		}
		pw.flush();
		pw.close();	
	}
	
	public void sendEmail(){
		String receiveEmailAccount = user.getUser_email();// 用户邮箱
		try {
			String verifyCode = SendEmail.sendEmail(receiveEmailAccount, "陌陌");
			HttpServletResponse httpServletResponse = ServletActionContext.getResponse();
			httpServletResponse.getWriter().write("{\"verifyCode\":\"" + verifyCode + "\"}");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// --------------------------------------------------------�������--------------------------------------------------------------
		/*
		 *
		 * 
		 * 
		 * 
		 */
	private String user_id;
	private String user_name;
	private String user_username;
	private String user_email;
	private String user_password;
	private String user_phone;
	private String user_status;
	private String user_role;
	private Date user_gmt_creat;
	private Date user_gmt_modified;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_username() {
		return user_username;
	}

	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_status() {
		return user_status;
	}

	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	public Date getUser_gmt_creat() {
		return user_gmt_creat;
	}

	public void setUser_gmt_creat(Date user_gmt_creat) {
		this.user_gmt_creat = user_gmt_creat;
	}

	public Date getUser_gmt_modified() {
		return user_gmt_modified;
	}

	public void setUser_gmt_modified(Date user_gmt_modified) {
		this.user_gmt_modified = user_gmt_modified;
	}

	public UserService getUserService() {
		return userService;
	}
	
	
	
}
