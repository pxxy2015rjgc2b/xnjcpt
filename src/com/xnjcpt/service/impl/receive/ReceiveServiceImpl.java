package com.xnjcpt.service.impl.receive;

import com.xnjcpt.dao.receive.ReceiveDao;
import com.xnjcpt.domain.DO.xnjcpt_computer;
import com.xnjcpt.domain.DO.xnjcpt_cpu;
import com.xnjcpt.domain.DO.xnjcpt_cpu_state;
import com.xnjcpt.domain.DO.xnjcpt_disk;
import com.xnjcpt.domain.DO.xnjcpt_disk_state;
import com.xnjcpt.domain.DO.xnjcpt_io_state;
import com.xnjcpt.domain.DO.xnjcpt_memory;
import com.xnjcpt.domain.DO.xnjcpt_memory_state;
import com.xnjcpt.domain.DO.xnjcpt_net;
import com.xnjcpt.domain.DO.xnjcpt_net_state;
import com.xnjcpt.service.receive.ReceiveService;

public class ReceiveServiceImpl implements ReceiveService {
	//注入dao层的类
	private ReceiveDao receiveDao;

	public void setReceiveDao(ReceiveDao receiveDao) {
		this.receiveDao = receiveDao;
	}
	
	/**
	 * service层更改主机信息的方法
	 */
	@Override
	public void updateComputerInfor(xnjcpt_computer xnjcpt_computer) {
		// TODO Auto-generated method stub
		receiveDao.updateComputerInfor(xnjcpt_computer);
	}
	
	/**
	 * service层更改cpu信息的方法
	 */
	@Override
	public void updateCpuInfor(String ip,xnjcpt_cpu xnjcpt_cpu) {
		// TODO Auto-generated method stub
		receiveDao.updateCpuInfo(ip,xnjcpt_cpu);
	}
	
	/**
	 * service层更改内存信息的方法
	 */
	@Override
	public void updateMemoryInfor(String ip, xnjcpt_memory xnjcpt_memory) {
		// TODO Auto-generated method stub
		receiveDao.updateMemoryInfor(ip,xnjcpt_memory);
	}

	/**
	 * service层更改磁盘信息的方法
	 */
	@Override
	public void updateDiskInfor(String ip, xnjcpt_disk xnjcpt_disk) {
		// TODO Auto-generated method stub
		receiveDao.updateDiskInfor(ip,xnjcpt_disk);
	}

	/**
	 * service层更改网络信息的方法
	 */
	@Override
	public void updateNetInfor(String ip, xnjcpt_net xnjcpt_net) {
		// TODO Auto-generated method stub
		receiveDao.updateNetInfor(ip,xnjcpt_net);
	}

	/**
	 * service层保存cpu状态的方法
	 */
	@Override
	public void saveCpuStateInfor(String ip, xnjcpt_cpu_state xnjcpt_cpu_state) {
		// TODO Auto-generated method stub
		receiveDao.saveCpuStateInfor(ip,xnjcpt_cpu_state);
	}

	/**
	 * service层保存内存状态的方法
	 */
	@Override
	public void saveMemoryStateInfor(String ip, xnjcpt_memory_state xnjcpt_memory_state) {
		// TODO Auto-generated method stub
		receiveDao.saveMemoryStateInfor(ip,xnjcpt_memory_state);
	}

	/**
	 * service层保存io状态的方法
	 */
	@Override
	public void saveIoStateInfor(String ip, xnjcpt_io_state xnjcpt_io_state) {
		// TODO Auto-generated method stub
		receiveDao.saveIoStateInfor(ip,xnjcpt_io_state);
	}

	/**
	 * service层保存磁盘状态信息的方法
	 */
	@Override
	public void saveDiskInfor(String ip, xnjcpt_disk_state xnjcpt_disk_state) {
		// TODO Auto-generated method stub
		receiveDao.saveDiskInfor(ip,xnjcpt_disk_state);
	}

	/**
	 * service层保存网络状态信息的方法
	 */
	@Override
	public void saveNetStateInfor(String ip, xnjcpt_net_state xnjcpt_net_state) {
		// TODO Auto-generated method stub
		receiveDao.saveNetInfor(ip,xnjcpt_net_state);
	}

	

	
	
	
	

}
