package com.xnjcpt.action.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.xnjcpt.domain.DO.xnjcpt_user;
import com.xnjcpt.domain.VO.PageBean_user;
import com.xnjcpt.service.user.UserManagerService;

import util.TeamUtil;

public class UserManagerAction {
	
	/*
	 * @author：叶凯
	 * 
	 * */
	
	//ע��ҵ������
	private UserManagerService userManagerService;

	public UserManagerService getUserManagerService() {
		return userManagerService;
	}

	public void setUserManagerService(UserManagerService userManagerService) {
		this.userManagerService = userManagerService;
	}

	public String skipToUser() {
		return "skipToUser";
	}

	//通过旧密码更新用户密码
	public void updatePassword() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		String user_id = (String) ActionContext.getContext().getSession().get("user_id");
		if (user_id != null || user_id != "") {
			xnjcpt_user xu = userManagerService.getUserByUserId(user_id);
			if (xu.getUser_password().equals(oldPassword)) {
				userManagerService.updatePassword(user_id, newPassword);
				xu.setUser_gmt_modified(TeamUtil.getStringSecond());
				pw.write("updateSuccess");
			} else {
				pw.write("oldPasswordError");
			}
		} else{
			pw.write("updateFail");
		}
	}
	
	//通过邮箱发送修改旧密码
	public void updatePasswordbyverifyCode() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		xnjcpt_user existuser=new xnjcpt_user();
		existuser=userManagerService.getUserByUserId(user_id);
		if(existuser==null){
			System.out.println("修改密码失败");
			pw.write("findpassword_error");
		}else{
			userManagerService.updatePassword(user_id, newPassword);
			pw.write("updatesuccess");
		}
	}
	
	//得到用户搜索列表
	public void getUser() throws IOException {
		PageBean_user<xnjcpt_user> pb = userManagerService.findPageByKeyword(currentPage, pageSize, keyword);
		Gson gson = new Gson();//用来转换JSON数据类型的
		String result = gson.toJson(pb);
		System.out.println(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.write(result);
		pw.flush();
		pw.close();
	}
	
	//用户列表
		public void getUserlist() throws IOException {
			PageBean_user<xnjcpt_user> pb = userManagerService.findPageBy(pb2.getCurrentPage(), pageSize);
			Gson gson = new Gson();//用来转换JSON数据类型的
			String result = gson.toJson(pb);
			System.out.println(result); 
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.write(result);
			pw.flush();
			pw.close();
		}
	
	//根据id得到用户
	public void getUserById() throws IOException {
		String user_id = (String) ActionContext.getContext().getSession().get("user_id");
		xnjcpt_user xu = userManagerService.getUserByUserId(user_id);
		Gson gson = new Gson();
		String result = gson.toJson(xu);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.write(result);
		pw.flush();
		pw.close();
	}
	
	//修改用户信息
		public void updateUser() throws IOException {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			String user_id = (String) ActionContext.getContext().getSession().get("user_id");
			System.out.println(user_id);
			xnjcpt_user user=userManagerService.getUserByUserId(user_id);
			if(user_username!=null && user_phone==null){
			user.setUser_username(user_username);
			user.setUser_gmt_modified(TeamUtil.getStringSecond());//保存修改时间信息
			userManagerService.updateuser(user);
			pw.write("修改用户姓名成功");
			pw.flush();
			pw.close();
			}else if(user_phone!=null && user_username==null){
				user.setUser_phone(user_phone);
				user.setUser_gmt_modified(TeamUtil.getStringSecond());//保存修改时间信息
				userManagerService.updateuser(user);
				pw.write("修改用户电话成功");
				pw.flush();
				pw.close();
			}
			else{
				pw.write("修改用户信息失败");
				pw.flush();
				pw.close();
			}
			
		}

	//删除用户
	public void deleteUser() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		 HttpServletRequest request = ServletActionContext.getRequest();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		PrintWriter pw = response.getWriter();
		String[] user_ids = request.getParameterValues("user_id");
		if(user_ids!=null){
			userManagerService.deleteuser(user_ids);
		pw.write("删除用户");
		pw.flush();
		pw.close();
	}else{
		pw.write("删除失败");
		pw.flush();
		pw.close();
	}}
	
	//封禁用户
	public void banUser() throws IOException{
		xnjcpt_user user=userManagerService.getUserByUserId(user_id);
		user.setUser_status("0");
		user.setUser_gmt_modified(TeamUtil.getStringSecond());
		userManagerService.updateuser(user);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.write("封禁用户");
		pw.flush();
		pw.close();
	}
	
	//解禁用户
		public void liftUser() throws IOException{
			xnjcpt_user user=userManagerService.getUserByUserId(user_id);
			user.setUser_status("1");
			user.setUser_gmt_modified(TeamUtil.getStringSecond());
			userManagerService.updateuser(user);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.write("解禁用户");
			pw.flush();
			pw.close();
		}
	
	private String oldPassword;
	private String newPassword;
	private int currentPage=1; //当前页
	private int pageSize = 6;//默认每页显示条数
	private String keyword;
	private String user_name;
	private String user_id;
	private String user_username;
	private String user_phone;
	private PageBean_user<xnjcpt_user> pb2;
	public String getKeyword() {
		return keyword;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public PageBean_user<xnjcpt_user> getPb() {
		return pb2;
	}

	public void setPb(PageBean_user<xnjcpt_user> pb) {
		this.pb2 = pb;
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
	
	
}
