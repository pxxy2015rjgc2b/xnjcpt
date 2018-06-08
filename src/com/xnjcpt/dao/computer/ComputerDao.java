package com.xnjcpt.dao.computer;

import java.util.List;




import com.xnjcpt.domain.DO.xnjcpt_computer;
import com.xnjcpt.domain.DO.xnjcpt_user;
import com.xnjcpt.domain.DO.xnjcpt_user_computer;
import com.xnjcpt.domain.VO.page_list_user_computerVO;



public interface ComputerDao {

	public void addComputer(xnjcpt_computer xc,xnjcpt_user user,xnjcpt_user_computer xuc);

	public void deleteComputer(String user_computer_id);

	

	void updateComputer(String user_computer_id, xnjcpt_computer xc);


	

	public  xnjcpt_user_computer  getUser_computerById(String user_computer_id);

	public int getUserComputerCount(String queryString, int currPage);

	public List<xnjcpt_user_computer> getUserComputerByPage(String queryString, int currPage);

	public int getComputerCount(String queryString, int currPage);

	public List<xnjcpt_computer> getComputerByPage(String queryString, int currPage);

	
	
	
	

	
}
