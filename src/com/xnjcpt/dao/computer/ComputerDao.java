package com.xnjcpt.dao.computer;

import java.util.List;

import com.xnjcpt.domain.DO.xnjcpt_computer;

public interface ComputerDao {

	List<xnjcpt_computer> getComputerByUserId(String user_id);

}
