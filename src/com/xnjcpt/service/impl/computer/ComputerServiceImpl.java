package com.xnjcpt.service.impl.computer;

import com.xnjcpt.dao.computer.ComputerDao;
import com.xnjcpt.service.computer.ComputerService;

public class ComputerServiceImpl implements ComputerService {
	//ע��dao�����
	private ComputerDao computerDao;

	public void setComputerDao(ComputerDao computerDao) {
		this.computerDao = computerDao;
	}
	
}
