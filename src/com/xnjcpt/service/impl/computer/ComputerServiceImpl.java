package com.xnjcpt.service.impl.computer;

import java.util.List;




import com.xnjcpt.dao.computer.ComputerDao;

import com.xnjcpt.domain.DO.xnjcpt_computer;
import com.xnjcpt.domain.DO.xnjcpt_user;
import com.xnjcpt.domain.DO.xnjcpt_user_computer;
import com.xnjcpt.domain.VO.page_list_computerVO;
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
	public   void getUser_computerById(String user_computer_id)  {
		// TODO Auto-generated method stub
	 computerDao.getUser_computerById(user_computer_id);
	}

	@Override
	public page_list_user_computerVO getUserComputerByPage(String queryString, int currPage) {
		page_list_user_computerVO cuv = new page_list_user_computerVO();

		cuv.setCurrPage(currPage);
		cuv.setQueryString(queryString);
		cuv.setPageSize(10);

		int count = computerDao.getUserComputerCount(queryString, currPage);

		cuv.setCount(count);
		double c = count;
		int totalPage = (int) Math.ceil(c / 10);
		cuv.setTotalPage(totalPage);

		List<xnjcpt_user_computer> list = computerDao.getUserComputerByPage(queryString, currPage);
		cuv.setList(list);
		return cuv;
	}

	@Override
	public page_list_computerVO getComputerByPage(String queryString, int currPage) {
		page_list_computerVO cv = new page_list_computerVO();

		cv.setCurrPage(currPage);
		cv.setQueryString(queryString);
		cv.setPageSize(10);

		int count = computerDao.getComputerCount(queryString, currPage);

		cv.setCount(count);
		double c = count;
		int totalPage = (int) Math.ceil(c / 10);
		cv.setTotalPage(totalPage);

		List<xnjcpt_computer> list = computerDao.getComputerByPage(queryString, currPage);
		cv.setList(list);
		return cv;
	}

	

	
	

	
	
	
	
	
	
	
}
