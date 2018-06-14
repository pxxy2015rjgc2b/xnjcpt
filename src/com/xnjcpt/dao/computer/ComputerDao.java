package com.xnjcpt.dao.computer;
import com.xnjcpt.domain.DO.xnjcpt_computer;
import com.xnjcpt.domain.VO.computerInformationVO;
public interface ComputerDao {
public	boolean addComputer(xnjcpt_computer xc);
public void deleteComputerById(String[] strComputerIds);
public int getComputerCount();
computerInformationVO getComputerInformation(computerInformationVO cv);
}