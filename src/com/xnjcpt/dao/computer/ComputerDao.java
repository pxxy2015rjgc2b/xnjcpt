package com.xnjcpt.dao.computer;

import java.util.List;

import com.xnjcpt.domain.DO.xnjcpt_computer;
import com.xnjcpt.domain.DO.xnjcpt_cpu;
import com.xnjcpt.domain.DO.xnjcpt_disk;
import com.xnjcpt.domain.DO.xnjcpt_memory;
import com.xnjcpt.domain.DO.xnjcpt_progress;
import com.xnjcpt.domain.DO.xnjcpt_user_computer;
import com.xnjcpt.domain.VO.ComputerManagerVO;
import com.xnjcpt.domain.VO.ComputerPageVO;
import com.xnjcpt.domain.VO.ProgressPageVO;

public interface ComputerDao {

	List<xnjcpt_computer> getComputerByUserId(String user_id);

	List<com.xnjcpt.domain.DO.xnjcpt_computer> verifyIp(xnjcpt_computer xnjcpt_computer);

	boolean saveComputer(xnjcpt_computer xnjcpt_computer);

	boolean saveUserComputer(xnjcpt_user_computer xuc);

	int getCountByPage(ComputerPageVO computerPageVO);

	void getComputerByPage(ComputerPageVO computerPageVO);

	boolean saveCPUInfo(xnjcpt_cpu xc);

	boolean saveDiskInfo(xnjcpt_disk xd);

	boolean saveMemoryInfo(xnjcpt_memory xc);

	boolean deleteComputerById(String computer_id);

	boolean deleteUserComputerById(String computer_id);

	boolean deleteCpu(String computer_id);

	boolean deleteDisk(String computer_id);

	boolean deleteMemory(String computer_id);

	boolean deleteNet(String computer_id);

	boolean deleteCpuState(String computer_id);

	boolean deleteDiskState(String computer_id);

	boolean deleteMemoryState(String computer_id);

	boolean deleteNetState(String computer_id);

	boolean deletIOState(String computer_id);

	boolean deleteAlarm(String computer_id);

	xnjcpt_computer getComputerById(String id);

	void deleteProgress(String id, String pid);

	int getProgressCount(String computer_id);

	List<xnjcpt_progress> getProgressByPage(String computer_id, ProgressPageVO progressPageVO);

	boolean deleteProgress(String computer_id);

	void cleanData();

	int getComputerCount(ComputerManagerVO computerManagerVO);

	void getComputerByConditionAndPage(ComputerManagerVO computerManagerVO);

}
