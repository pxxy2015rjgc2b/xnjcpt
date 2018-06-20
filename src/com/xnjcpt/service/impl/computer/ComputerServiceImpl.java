package com.xnjcpt.service.impl.computer;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.xnjcpt.dao.computer.ComputerDao;
import com.xnjcpt.domain.DO.xnjcpt_computer;
import com.xnjcpt.domain.DO.xnjcpt_cpu;
import com.xnjcpt.domain.DO.xnjcpt_disk;
import com.xnjcpt.domain.DO.xnjcpt_memory;
import com.xnjcpt.domain.DO.xnjcpt_progress;
import com.xnjcpt.domain.DO.xnjcpt_user_computer;
import com.xnjcpt.domain.DTO.ComputerPageDTO;
import com.xnjcpt.domain.VO.ComputerPageVO;
import com.xnjcpt.domain.VO.ProgressPageVO;
import com.xnjcpt.service.computer.ComputerService;

import util.TeamUtil;

public class ComputerServiceImpl implements ComputerService {
	private ComputerDao computerDao;

	public void setComputerDao(ComputerDao computerDao) {
		this.computerDao = computerDao;
	}

	@Override
	public List<xnjcpt_computer> getComputerByUserId(String user_id) {
		// TODO Auto-generated method stub
		return computerDao.getComputerByUserId(user_id);
	}

	@Override
	public boolean verifyIp(xnjcpt_computer xnjcpt_computer) {
		// TODO Auto-generated method stub

		List<xnjcpt_computer> list = computerDao.verifyIp(xnjcpt_computer);
		if (list != null && list.size() > 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean saveComputer(xnjcpt_computer xnjcpt_computer) {
		// TODO Auto-generated method stub
		String user_id = (String) ActionContext.getContext().getSession().get("user_id");
		xnjcpt_computer.setComputer_id(TeamUtil.getUuid());
		xnjcpt_computer.setComputer_gmt_create(TeamUtil.getStringSecond());
		xnjcpt_computer.setComputer_gmt_modified(TeamUtil.getStringSecond());
		boolean flag = false;
		xnjcpt_user_computer xuc = new xnjcpt_user_computer();
		xuc.setUser_computer_id(TeamUtil.getUuid());
		xuc.setUser_computer_computer(xnjcpt_computer.getComputer_id());
		xuc.setUser_computer_user(user_id);
		xuc.setUser_computer_gmt_create(TeamUtil.getStringSecond());
		xuc.setUser_computer_gmt_modified(TeamUtil.getStringSecond());
		xnjcpt_cpu xc = new xnjcpt_cpu();
		xc.setCpu_id(TeamUtil.getUuid());
		xc.setCpu_computer(xnjcpt_computer.getComputer_id());
		flag = computerDao.saveCPUInfo(xc); // 保存cpu信息
		xnjcpt_disk xd = new xnjcpt_disk();
		xd.setDisk_id(TeamUtil.getUuid());
		xd.setDisk_computer(xnjcpt_computer.getComputer_id());
		flag = computerDao.saveDiskInfo(xd); // 保存硬盘信息
		xnjcpt_memory xm = new xnjcpt_memory();
		xm.setMemory_id(TeamUtil.getUuid());
		xm.setMemory_computer(xnjcpt_computer.getComputer_id());
		flag = computerDao.saveMemoryInfo(xm); // 保存内存信息

		flag = computerDao.saveComputer(xnjcpt_computer); // 保存主机
		flag = computerDao.saveUserComputer(xuc); // 保存用户主机关系
		return flag;
	}

	@Override
	public void getComputerByPage(ComputerPageVO computerPageVO) {
		// TODO Auto-generated method stub
		int count = computerDao.getCountByPage(computerPageVO);
		computerPageVO.setPageSize(10);
		computerPageVO.setTotalCount(count);
		computerPageVO.setTotalPage((int) Math.ceil((double) count / computerPageVO.getPageSize()));
		computerDao.getComputerByPage(computerPageVO);
		if (computerPageVO.getList() != null && computerPageVO.getList().size() > 0)
			for (ComputerPageDTO computerPageDTO : computerPageVO.getList()) {
				if (computerPageDTO.getComputer_cpu_model() == null
						|| computerPageDTO.getComputer_cpu_model().length() <= 0) {
					computerPageDTO.setComputer_status("0");// 未安装客户端
				} else {
					computerPageDTO.setComputer_status("1");// 已经安装客户端
				}
			}
	}

	@Override
	public boolean deleteComputerById(String computer_id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = computerDao.deleteComputerById(computer_id);// 删除主机
		flag = computerDao.deleteUserComputerById(computer_id);// 删除关系
		flag = computerDao.deleteCpu(computer_id);// 删除cpu
		flag = computerDao.deleteDisk(computer_id);// 删除磁盘
		flag = computerDao.deleteMemory(computer_id);// 删除内存
		flag = computerDao.deleteNet(computer_id);// 删除网络
		flag = computerDao.deleteCpuState(computer_id);// 删除cpu状态
		flag = computerDao.deleteDiskState(computer_id);// 删除磁盘状态
		flag = computerDao.deleteMemoryState(computer_id);// 删除内存状态
		flag = computerDao.deleteNetState(computer_id);// 删除网络状态
		flag = computerDao.deletIOState(computer_id);// 删除IO状态
		flag = computerDao.deleteAlarm(computer_id);// 删除警报
		flag = computerDao.deleteProgress(computer_id);// 删除警报
		return flag;
	}

	@Override
	public xnjcpt_computer getComputerById(String id) {
		// TODO Auto-generated method stub
		return computerDao.getComputerById(id);
	}

	@Override
	public void deleteProgressByIdAndPid(String id, String pid) {
		// TODO Auto-generated method stub
		computerDao.deleteProgress(id, pid);
	}

	@Override
	public void getProgressByPage(String computer_id, ProgressPageVO progressPageVO) {
		// TODO Auto-generated method stub
		int count = computerDao.getProgressCount(computer_id);
		progressPageVO.setPageSize(10);
		progressPageVO.setTotalCount(count);
		progressPageVO.setTotalPage((int) Math.ceil((double) count / (double) progressPageVO.getPageSize()));
		List<xnjcpt_progress> list = computerDao.getProgressByPage(computer_id, progressPageVO);
		progressPageVO.setList(list);
	}

	@Override
	public void cleanData() {
		// TODO Auto-generated method stub
		computerDao.cleanData();
	}

}
