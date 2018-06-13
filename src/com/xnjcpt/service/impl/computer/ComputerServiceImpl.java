package com.xnjcpt.service.impl.computer;
import com.xnjcpt.dao.computer.ComputerDao;
import com.xnjcpt.domain.DO.xnjcpt_computer;
import com.xnjcpt.domain.DTO.UserComputerPageDTO;
import com.xnjcpt.domain.VO.computerInformationVO;
import com.xnjcpt.service.computer.ComputerService;
public class ComputerServiceImpl implements ComputerService {
	//注入dao层的类
	private ComputerDao computerDao;
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
	@Override
	public void getComputerByPage(computerInformationVO cv) {
		int count = computerDao.getCountComputer(cv);
		cv.setPageSize(10);
		cv.setCount(count);
		cv.setTotalPage((int) Math.ceil((double) count / cv.getPageSize()));
		computerDao.getComputerByPage(cv);
		if (cv.getList() != null && cv.getList().size() > 0)
			for (UserComputerPageDTO computerPageDTO : cv.getList()) {
				if (computerPageDTO.getComputer_cpu_model() == null
						|| computerPageDTO.getComputer_cpu_model().length() <= 0) {
					computerPageDTO.setComputer_status("0");// 未安装客户端
				} else {
					computerPageDTO.setComputer_status("1");// 已经安装客户端
				}
			}
	}
	}