package com.xnjcpt.action.monitor;

import com.xnjcpt.service.monitor.MonitorService;

public class MonitorAction {
	//注入业务层的类
	private MonitorService monitorService;

	public void setMonitorService(MonitorService monitorService) {
		this.monitorService = monitorService;
	}
	

}
