package com.xnjcpt.dao.computer;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;

import com.xnjcpt.domain.DO.xnjcpt_computer;
import com.xnjcpt.domain.DTO.UserComputerPageDTO;
import com.xnjcpt.domain.VO.ComputerInformationVO;
public interface ComputerDao {
public	boolean saveComputer(xnjcpt_computer xc);
public void removeComputerById(String[] strComputerIds);
public int getComputerCount();
ComputerInformationVO getComputerInformationByPage(ComputerInformationVO cv);
public List<UserComputerPageDTO> getComputerDetials(xnjcpt_computer xc);
}