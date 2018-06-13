package com.xnjcpt.action.receive;

import com.xnjcpt.service.receive.ReceiveService;

public class ReceiveAction {
	//注入业务层的类
	private ReceiveService receiveService;

	public void setReceiveService(ReceiveService receiveService) {
		this.receiveService = receiveService;
	}
	

}
