package com.xnjcpt.action.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xnjcpt.domain.DO.xnjcpt_user;
import com.xnjcpt.service.user.UserService;

import util.SendEmail;
import util.SendEmailUpdatePassword;
import util.TeamUtil;
import util.md5;



public class UserAction{
	
	private UserService userService;
	private xnjcpt_user user;		//域模型
	String st=null;
	public xnjcpt_user getUser() {
		return user;
	}

	public void setUser(xnjcpt_user user) {
		this.user = user;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//用户登陆
	public void login() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		/*response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");*/
		response.setContentType("text/html;charset=utf-8");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		xnjcpt_user xu = userService.login(user);
		xnjcpt_user xu2=userService.getUserByUserEmail(user.getUser_email());
		//System.out.println(xu);
		System.out.println(xu);
		System.out.println(xu2);
		if(xu != null ){
			if (xu.getUser_password().equals(user.getUser_password())){
				String sst=xu.getUser_status();
				System.out.println(sst);
				if(sst.equals("1")){
				System.out.println("密码输入正确");
				pw.write("success");	
				session.setAttribute("user_name", xu.getUser_name());
				session.setAttribute("user_role", xu.getUser_role());//存用户角色状态
				session.setAttribute("user_id", xu.getUser_id());//session存user_id
			}else{
			pw.write("该账户已被封禁");
				}}else{
				pw.write("password_error");
			}			
		}
			
		else if (xu2!=null) {
			if (xu2.getUser_password().equals(user.getUser_password())){
				String sst=xu.getUser_status();
				System.out.println(sst);
				if(sst.equals("1")){
				pw.write("success");
				System.out.println("密码输入正确");
				/*String st="0";
				xu.setUser_status(st);*/
				session.setAttribute("user_name", xu2.getUser_name());
				session.setAttribute("user_role", xu.getUser_role());//存用户角色状态
				session.setAttribute("user_id", xu2.getUser_id());  //session存user_id
			}else{
				pw.write("该账户已被封禁");
			}
			}else{
				pw.write("password_error");
				System.out.println("密码输入错误");	
			}}
		else {
			pw.write("用户名或邮箱账户输入错误");
			System.out.println("用户名或邮箱账户输入错误");
		}
		pw.flush();
		pw.close();
	}
	
	//用户注册
	public void register() throws IOException{
		//System.out.println("dffdf=--");
		/*user.setUser_name(new String(user.getUser_name().getBytes("ISO-8859-1"),"utf-8"));*/
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		response.setContentType("text/html;charset=utf-8");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		if(userService.judgeUserByUsername(user.getUser_name())){
			pw.write("name_error");
			System.out.println("用户名已存在!");
		}else{
			System.out.println("用户名不存在，恭喜您可以注册!");
			if(userService.judgeUserByUserEmail(user.getUser_email())){
				System.out.println("该邮箱已注册，请重新输入");
				pw.write("email_error");
			}else{
			System.out.println("该邮箱可用！");
			xnjcpt_user xu = new xnjcpt_user();
			xu.setUser_email(user.getUser_email());
			xu.setUser_name(user.getUser_name());
			xu.setUser_role("0");
			xu.setUser_password(user.getUser_password());
			xu.setUser_gmt_create(TeamUtil.getStringSecond());
			xu.setUser_id(UUID.randomUUID().toString());
			st="0";
			xu.setUser_status(st);
			System.out.println(user.getUser_name());
			userService.register(xu);
			pw.write("register_success");
		
		}}
		pw.flush();
		pw.close();	
	}
	
	//激活用户邮件发送
	public void sendEmail() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		response.setContentType("text/html;charset=utf-8");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		xnjcpt_user ux=userService.getUserByUserEmail(user.getUser_email());

		if(ux!=null){
		String receiveEmailAccount = ux.getUser_email();// 用户邮箱
		String verifyCode=ux.getUser_id();
		String username=ux.getUser_name();
		SendEmail.sendEmail(receiveEmailAccount, username, verifyCode);
		pw.write("激活邮件发送成功");
		}else{
		pw.write("激活邮件发送成功");	
		}
	}
	
	//修改密码邮件发送
	public void sendEmailtoUpdatePassword() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		response.setContentType("text/html;charset=utf-8");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		String receiveEmailAccount = user.getUser_email();// 用户邮箱
		xnjcpt_user ux=userService.getUserByUserEmail(receiveEmailAccount);
		if(ux!=null){
		String username=ux.getUser_name();
		String verifyCode=SendEmailUpdatePassword.sendEmail(receiveEmailAccount, username);
		pw.write(verifyCode);
		}else{
		pw.write("验证码发送失败");
		}
	
	}
	//邮件激活
	public void activate() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		response.setContentType("text/html;charset=utf-8");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		xnjcpt_user existuser=new xnjcpt_user();
		existuser=userService.getUserByUserId(user.getUser_id());
		if(existuser==null){
			System.out.println("激活失败");
			pw.write("activate_error");
		}else{
			st="1";
			existuser.setUser_status(st);
			existuser.setUser_gmt_create(TeamUtil.getStringSecond());
			userService.updateuser(existuser);
			System.out.println("激活成功");
			pw.write("activate_success");
		}
	}
	
	//注销用户
	public String logout() {
		ActionContext.getContext().getSession().remove("user_id");
		ActionContext.getContext().getSession().remove("user_name");
		ActionContext.getContext().getSession().remove("user_role");
		return "logoutSuccess";
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
	private String user_gmt_creat;
	private String user_gmt_modified;

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

	public String getUser_gmt_creat() {
		return user_gmt_creat;
	}

	public void setUser_gmt_creat(String user_gmt_creat) {
		this.user_gmt_creat = user_gmt_creat;
	}

	public String getUser_gmt_modified() {
		return user_gmt_modified;
	}

	public void setUser_gmt_modified(String user_gmt_modified) {
		this.user_gmt_modified = user_gmt_modified;
	}

	
	
	
}
