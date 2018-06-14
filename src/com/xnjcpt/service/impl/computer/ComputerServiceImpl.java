package com.xnjcpt.service.impl.computer;
import com.xnjcpt.dao.computer.ComputerDao;
import com.xnjcpt.domain.DO.xnjcpt_computer;
import com.xnjcpt.domain.VO.computerInformationVO;
import com.xnjcpt.service.computer.ComputerService;
public class ComputerServiceImpl implements ComputerService {
	//注入dao层的类
	private ComputerDao computerDao;
	private	String user_id;
	public void setComputerDao(ComputerDao computerDao) {
		this.computerDao = computerDao;
	}
	@Override
	public boolean addComputer(xnjcpt_computer xc) {
	boolean result=	computerDao.addComputer(xc);
	return result;
	}
	@Override
	public void deleteComputerById(String[] strComputerIds) {
		computerDao.deleteComputerById(strComputerIds);	
	}
	public computerInformationVO getComputerInformation(computerInformationVO cv) {
		int count = computerDao.getComputerCount();
		cv.setPageSize(10);
		cv.setCount(count);
		cv.setTotalPage((int) Math.ceil((double) count / cv.getPageSize()));
		return computerDao.getComputerInformation(cv);
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	}