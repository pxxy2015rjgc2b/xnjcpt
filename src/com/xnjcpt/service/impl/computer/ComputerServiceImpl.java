package com.xnjcpt.service.impl.computer;

import java.util.List;



import com.xnjcpt.dao.computer.ComputerDao;

import com.xnjcpt.domain.DO.xnjcpt_computer;
import com.xnjcpt.domain.DO.xnjcpt_user;
import com.xnjcpt.domain.DO.xnjcpt_user_computer;
import com.xnjcpt.domain.VO.page_list_user_computerVO;
import com.xnjcpt.service.computer.ComputerService;


import util.TeamUtil;

public class ComputerServiceImpl implements ComputerService {
	//ע��dao�����
	private ComputerDao computerDao;

	public void setComputerDao(ComputerDao computerDao) {
		this.computerDao = computerDao;
	}

	@Override
	public void addComputer(xnjcpt_computer xc,xnjcpt_user user,xnjcpt_user_computer xuc) {
		computerDao.addComputer(xc,user,xuc);
		
	}

	@Override
	public void deleteComputer(String user_computer_id) {
		computerDao.deleteComputer(user_computer_id);
		
	}

	@Override
	public void updateComputer(String user_computer_id, xnjcpt_computer xc) {
		computerDao.updateComputer(user_computer_id,xc);
		
	}
	@Override
	public xnjcpt_user_computer getUser_computerById(String user_computer_id)  {
		// TODO Auto-generated method stub
		return computerDao.getUser_computerById(user_computer_id);
	}

	

	
	

	
	
	/*
	@Override
	public void getUser_computerByPage(page_list_user_computerVO computerVO) {
		int count = computerDao.getCountByCondition(computerVO);
		computerVO.setPageSize(10);
		computerVO.setTotalRecords(count);
		computerVO.setTotalPages((int) Math.ceil((double) count /computerVO.getPageSize()));
		computerDao.getComputerByPage(computerVO);
	}
*/
	
	
	
}
