package com.xnjcpt.service.impl.computer;
import java.util.List;



import com.xnjcpt.dao.computer.ComputerDao;
import com.xnjcpt.domain.DO.xnjcpt_computer;
import com.xnjcpt.domain.DTO.UserComputerPageDTO;
import com.xnjcpt.domain.VO.ComputerInformationVO;
import com.xnjcpt.service.computer.ComputerService;
public class ComputerServiceImpl implements ComputerService {
	//注入dao层的类
	private ComputerDao computerDao;
	private	String user_id;
	public void setComputerDao(ComputerDao computerDao) {
		this.computerDao = computerDao;
	}
	@Override
	public boolean saveComputer(xnjcpt_computer xc) {
	boolean result=	computerDao.saveComputer(xc);
	return result;
	}
	@Override
	public void removeComputerById(String[] strComputerIds) {
		computerDao.removeComputerById(strComputerIds);	
	}
	public ComputerInformationVO getComputerInformationByPage(ComputerInformationVO cv) {
		int count = computerDao.getComputerCount();
		cv.setPageSize(1);
		cv.setCount(count);
		cv.setTotalPage((int) Math.ceil((double) count / cv.getPageSize()));
		return computerDao.getComputerInformationByPage(cv);
	}
	@Override
	public List<UserComputerPageDTO> getComputerDetials(xnjcpt_computer xc) {
		return computerDao.getComputerDetials(xc);
		
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	}