package com.xnjcpt.action.computer;

import com.xnjcpt.service.computer.ComputerService;

public class ComputerAction {
	//注入业务层的类
	private ComputerService computerService;

	public void setComputerService(ComputerService computerService) {
		this.computerService = computerService;
	}
	

}
