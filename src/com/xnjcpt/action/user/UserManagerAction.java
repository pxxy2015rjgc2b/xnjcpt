package com.xnjcpt.action.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.xnjcpt.domain.DO.xnjcpt_user;
import com.xnjcpt.domain.VO.PageBean_user;
import com.xnjcpt.service.user.UserManagerService;


public class UserManagerAction {
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

	//更新用户密码
	public void updatePassword() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		String user_id = (String) ActionContext.getContext().getSession().get("user_id");
		if (user_id != null || user_id != "") {
			xnjcpt_user xu = userManagerService.getUserByUserId(user_id);
			if (xu.getUser_password().equals(oldPassword)) {
				userManagerService.updatePassword(user_id, newPassword);
				pw.write("updateSuccess");
			} else {
				pw.write("oldPasswordError");
			}
		} else{
			pw.write("updateFail");
		}
	}
	
	//得到用户列表
	public void getUser() throws IOException {
		List<xnjcpt_user> suv = userManagerService.findPageByKeyword(currentPage, pageSize, keyword);
		Gson gson = new Gson();//用来转换JSON数据类型的
		String result = gson.toJson(suv);
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

	//删除用户
	public void deleteUser() throws IOException {
		userManagerService.deleteuser(user_id);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.write("删除用户");
		pw.flush();
		pw.close();
	}
	
	//封禁用户
	public void banUser() throws IOException{
		xnjcpt_user user=userManagerService.getUserByUserId(user_id);
		user.setUser_status("0");
		userManagerService.updateuser(user);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.write("封禁用户");
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


	private PageBean_user<xnjcpt_user> pb;

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
		return pb;
	}

	public void setPb(PageBean_user<xnjcpt_user> pb) {
		this.pb = pb;
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
