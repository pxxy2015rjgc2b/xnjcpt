package com.xnjcpt.action.computer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.xnjcpt.domain.DO.xnjcpt_computer;
import com.xnjcpt.domain.VO.ComputerPageVO;
import com.xnjcpt.service.computer.ComputerService;

public class ComputerAction {
	private ComputerService computerService;
	private xnjcpt_computer xnjcpt_computer;
	private ComputerPageVO computerPageVO;

	public void setComputerService(ComputerService computerService) {
		this.computerService = computerService;
	}

	// 通过用户id获得主机
	public void getComputerByUserId() {
		String user_id = (String) ActionContext.getContext().getSession().get("user_id");
		List<xnjcpt_computer> result = computerService.getComputerByUserId(user_id);
		HttpServletResponse response = ServletActionContext.getResponse();
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

	// 验证ip是否重复
	public void verifyIp() {
		boolean flag = computerService.verifyIp(xnjcpt_computer);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");

		try {
			PrintWriter pw = response.getWriter();
			if (flag) {
				pw.write("ipIsOk");
				pw.flush();
				pw.close();
			} else {
				pw.write("ipIsExist");
				pw.flush();
				pw.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 保存主机
	public void saveComputer() {
		boolean flag = computerService.saveComputer(xnjcpt_computer);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		if (flag) {
			try {
				response.getWriter().write("saveSuccess");
				response.getWriter().flush();
				response.getWriter().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				response.getWriter().write("saveError");
				response.getWriter().flush();
				response.getWriter().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 分页获得用户的主机
	public void getComputerByPage() {
		computerService.getComputerByPage(computerPageVO);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(new Gson().toJson(computerPageVO));
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 删除主机
	public void deleteComputerById() {
		boolean flag = computerService.deleteComputerById(xnjcpt_computer.getComputer_id());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		if (flag) {
			try {
				response.getWriter().write("deleteSuccess");
				response.getWriter().flush();
				response.getWriter().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				response.getWriter().write("deleteError");
				response.getWriter().flush();
				response.getWriter().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public xnjcpt_computer getXnjcpt_computer() {
		return xnjcpt_computer;
	}

	public void setXnjcpt_computer(xnjcpt_computer xnjcpt_computer) {
		this.xnjcpt_computer = xnjcpt_computer;
	}

	public ComputerService getComputerService() {
		return computerService;
	}

	public ComputerPageVO getComputerPageVO() {
		return computerPageVO;
	}

	public void setComputerPageVO(ComputerPageVO computerPageVO) {
		this.computerPageVO = computerPageVO;
	}

}
