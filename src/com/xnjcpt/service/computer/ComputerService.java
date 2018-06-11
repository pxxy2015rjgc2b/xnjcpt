package com.xnjcpt.service.computer;

import java.util.List;

import com.xnjcpt.domain.DO.xnjcpt_computer;
import com.xnjcpt.domain.VO.ComputerPageVO;

public interface ComputerService {

	List<xnjcpt_computer> getComputerByUserId(String user_id);

	boolean verifyIp(com.xnjcpt.domain.DO.xnjcpt_computer xnjcpt_computer);

	boolean saveComputer(com.xnjcpt.domain.DO.xnjcpt_computer xnjcpt_computer);

	void getComputerByPage(ComputerPageVO computerPageVO);

	boolean deleteComputerById(String computer_id);

}
