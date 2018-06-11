package com.xnjcpt.service.impl.computer;

import java.util.List;

import com.xnjcpt.dao.computer.ComputerDao;
import com.xnjcpt.domain.DO.xnjcpt_computer;
import com.xnjcpt.service.computer.ComputerService;

public class ComputerServiceImpl implements ComputerService {
	//×¢Èëdao²ãµÄÀà
	private ComputerDao computerDao;

	public void setComputerDao(ComputerDao computerDao) {
		this.computerDao = computerDao;
	}

	@Override
	public List<xnjcpt_computer> getComputerByUserId(String user_id) {
		// TODO Auto-generated method stub
		return computerDao.getComputerByUserId(user_id);
	}
	
}
