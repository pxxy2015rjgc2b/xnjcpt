package com.xnjcpt.action.computer;
import com.xnjcpt.service.computer.ComputerService;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.google.gson.Gson;
import com.xnjcpt.domain.DO.xnjcpt_computer;
import com.xnjcpt.domain.VO.computerInformationVO;
public class ComputerAction {
	//注入业务层的类
	private ComputerService computerService;
	private xnjcpt_computer xc;
	private String user_id;
	private computerInformationVO cv;
	
	public void setComputerService(ComputerService computerService) {
		this.computerService = computerService;
	}
	// 增加主机
	public void addComputer() {
		boolean result =computerService.addComputer(xc);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		if (result) {
			try {
				response.getWriter().write("增加成功");
				response.getWriter().flush();
				response.getWriter().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				response.getWriter().write("ip已存在,无法增加");
				response.getWriter().flush();
				response.getWriter().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	// 删除主机
			public void deleteComputerById()throws IOException {
				
				HttpServletRequest resquest = ServletActionContext.getRequest();
				String[] strComputerIds=resquest.getParameterValues("computer_id");
				computerService.deleteComputerById(strComputerIds);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=utf-8");
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.setHeader("Access-Control-Allow-Methods", "GET,POST");
						response.getWriter().write("删除成功");
						response.getWriter().flush();
						response.getWriter().close();
			}
			//分页显示主机信息
			public void getComputerByPage() {
				
				computerService.getComputerByPage(cv);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=utf-8");
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.setHeader("Access-Control-Allow-Methods", "GET,POST");
				try {
					PrintWriter pw = response.getWriter();
					pw.write(new Gson().toJson(cv));
					pw.flush();
					pw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				}
			public xnjcpt_computer getXc() {
				return xc;
			}
			public void setXc(xnjcpt_computer xc) {
				this.xc = xc;
			}
			public String getUser_id() {
				return user_id;
			}
			public void setUser_id(String user_id) {
				this.user_id = user_id;
			}
			public computerInformationVO getCv() {
				return cv;
			}
			public void setCv(computerInformationVO cv) {
				this.cv = cv;
			}	
}