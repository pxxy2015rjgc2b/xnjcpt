package com.xnjcpt.service.impl.monitor;

import com.xnjcpt.dao.monitor.MonitorDao;
import com.xnjcpt.service.monitor.MonitorService;

public class MonitorServiceImpl implements MonitorService {
	private MonitorDao monitorDao;

	public void setMonitorDao(MonitorDao monitorDao) {
		this.monitorDao = monitorDao;
	}
	

}
