package com.xnjcpt.service.impl.receive;

import com.xnjcpt.dao.receive.ReceiveDao;
import com.xnjcpt.service.receive.ReceiveService;

public class ReceiveServiceImpl implements ReceiveService {
	//注入dao层的类
	private ReceiveDao receiveDao;

	public void setReceiveDao(ReceiveDao receiveDao) {
		this.receiveDao = receiveDao;
	}
	

}
