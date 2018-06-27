package com.xnjcpt.action.computer;
import com.xnjcpt.service.computer.ComputerService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.formula.functions.T;
import org.apache.struts2.ServletActionContext;
import com.google.gson.Gson;
import com.xnjcpt.domain.DO.xnjcpt_computer;
import com.xnjcpt.domain.DTO.UserComputerPageDTO;
import com.xnjcpt.domain.VO.ComputerInformationVO;
public class ComputerAction {
	//注入业务层的类
	private ComputerService computerService;
	private xnjcpt_computer xc;
	private ComputerInformationVO cv;
	public void setComputerService(ComputerService computerService) {
		this.computerService = computerService;
	}
	// 增加主机
	public void saveComputer() {
		boolean result =computerService.saveComputer(xc);
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
			public void removeComputerById()throws IOException {
				
				HttpServletRequest resquest = ServletActionContext.getRequest();
				String[] strComputerIds=resquest.getParameterValues("computer_id");
				computerService.removeComputerById(strComputerIds);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=utf-8");
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.setHeader("Access-Control-Allow-Methods", "GET,POST");
						response.getWriter().write("删除成功");
						response.getWriter().flush();
						response.getWriter().close();
			}
			//分页显示主机信息
			public void getComputerInformationByPage() {
				computerService.getComputerInformationByPage(cv);
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
			//主机详情页
			public void getComputerDetials() {
				List<UserComputerPageDTO> result=computerService.getComputerDetials(xc);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=utf-8");
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.setHeader("Access-Control-Allow-Methods", "GET,POST");
				try {
					PrintWriter pw = response.getWriter();
					pw.write(new Gson().toJson(result));
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
			public ComputerInformationVO getCv() {
				return cv;
			}
			public void setCv(ComputerInformationVO cv) {
				this.cv = cv;
			}	
}