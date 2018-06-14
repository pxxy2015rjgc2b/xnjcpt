package com.xnjcpt.service.computer;

import java.util.List;

import com.xnjcpt.domain.DO.xnjcpt_computer;
import com.xnjcpt.domain.VO.ComputerPageVO;
import com.xnjcpt.domain.VO.ProgressPageVO;

public interface ComputerService {

	List<xnjcpt_computer> getComputerByUserId(String user_id);

	boolean verifyIp(com.xnjcpt.domain.DO.xnjcpt_computer xnjcpt_computer);

	boolean saveComputer(com.xnjcpt.domain.DO.xnjcpt_computer xnjcpt_computer);

	void getComputerByPage(ComputerPageVO computerPageVO);

	boolean deleteComputerById(String computer_id);

	com.xnjcpt.domain.DO.xnjcpt_computer getComputerById(String id);

	void deleteProgressByIdAndPid(String id, String pid);

	void getProgressByPage(String computer_id, ProgressPageVO progresPageVO);

}
