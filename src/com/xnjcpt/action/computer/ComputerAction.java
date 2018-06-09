package com.xnjcpt.action.computer;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.xnjcpt.domain.DO.xnjcpt_computer;
import com.xnjcpt.service.computer.ComputerService;

import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
public class ComputerAction {
	//注入业务层的类
	private ComputerService computerService;

	public void setComputerService(ComputerService computerService) {
		this.computerService = computerService;
	}
	//获得用户所有主机
	public void getComputerByUserId(){
//		ActionContext.getContext().getSession().put("user_id", "1");
		String user_id = (String) ActionContext.getContext().getSession().get("user_id");
		List<xnjcpt_computer> result = computerService.getComputerByUserId(user_id);
		HttpServletResponse response =ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		Gson gson = new Gson();
		try {
			response.getWriter().write(gson.toJson(result));
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
