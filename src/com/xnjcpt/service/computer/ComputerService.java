package com.xnjcpt.service.computer;



import com.xnjcpt.domain.DO.xnjcpt_computer;

import com.xnjcpt.domain.DO.xnjcpt_user;
import com.xnjcpt.domain.DO.xnjcpt_user_computer;
import com.xnjcpt.domain.VO.page_list_computerVO;
import com.xnjcpt.domain.VO.page_list_user_computerVO;



public interface ComputerService {

	public void addComputer(xnjcpt_computer xc,xnjcpt_user user,xnjcpt_user_computer xuc);

	public void deleteComputer(String user_computer_id);

	public void updateComputer(String user_computer_id, xnjcpt_computer xc);

	


	public void getUser_computerById(String user_computer_id);

	

	public page_list_user_computerVO getUserComputerByPage(String queryString, int currPage);

	public page_list_computerVO getComputerByPage(String queryString, int currPage);

	

	
	

}
