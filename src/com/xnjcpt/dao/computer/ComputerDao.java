package com.xnjcpt.dao.computer;

import com.xnjcpt.domain.DO.xnjcpt_computer;

import com.xnjcpt.domain.VO.computerInformationVO;
public interface ComputerDao {
public	boolean addComputer(xnjcpt_computer xc);
public int getCountComputer(computerInformationVO cv);
public void getComputerByPage(computerInformationVO cv);
public void deleteComputerById(String[] strComputerIds);
}