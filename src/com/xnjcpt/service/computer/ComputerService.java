package com.xnjcpt.service.computer;

import com.xnjcpt.domain.DO.xnjcpt_computer;

import com.xnjcpt.domain.VO.computerInformationVO;
public interface ComputerService {
	public boolean addComputer(xnjcpt_computer xc);
	public void getComputerByPage(computerInformationVO cv);
	
	public void deleteComputerById(String[] strComputerIds);
}