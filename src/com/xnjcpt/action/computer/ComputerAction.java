package com.xnjcpt.action.computer;

import com.xnjcpt.service.computer.ComputerService;




import util.TeamUtil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.xnjcpt.domain.DO.xnjcpt_computer;
import com.xnjcpt.domain.DO.xnjcpt_user;
import com.xnjcpt.domain.DO.xnjcpt_user_computer;
import com.xnjcpt.domain.VO.page_list_user_computerVO;
public class ComputerAction {
	private xnjcpt_computer xc;
	private xnjcpt_user_computer xuc;
	private ComputerService computerService;
	private xnjcpt_user user;
	private String user_computer_id;
	private String computer_id;
	public void setComputerService(ComputerService computerService) {
		this.computerService = computerService;
	}
	//新建主机
	public void addComputer() {
		computerService.addComputer(xc,user,xuc);
		
	}
	//删除主机
	public void deleteComputer()  {
		computerService.deleteComputer(user_computer_id);
	}
	//修改主机
	public void updateComputer() {
		
		computerService.updateComputer(user_computer_id, xc);
	}	
	//查询主机
	public void getComputerById()  {
		 xuc = computerService.getUser_computerById(user_computer_id);
		
}
	
	/*分页显示数据
	public void getComputerByPage() {
		computerService.getUser_computerByPage(ComputerVO);	
}*/
}