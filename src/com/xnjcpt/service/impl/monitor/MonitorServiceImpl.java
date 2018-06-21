package com.xnjcpt.service.impl.monitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xnjcpt.dao.monitor.MonitorDao;
import com.xnjcpt.domain.DTO.CpuUserStateRadioDTO;
import com.xnjcpt.domain.VO.MonitorPageVO;
import com.xnjcpt.service.monitor.MonitorService;

public class MonitorServiceImpl implements MonitorService {
	private MonitorDao monitorDao;

	public void setMonitorDao(MonitorDao monitorDao) {
		this.monitorDao = monitorDao;
	}

	@Override
	public List<CpuUserStateRadioDTO> getCputState(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub

		return monitorDao.getCputState(monitorPageVO);
	}

	@Override
	public List<CpuUserStateRadioDTO> getCpuSystemState(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub
		return monitorDao.getCpuSystemState(monitorPageVO);
	}

	@Override
	public List<CpuUserStateRadioDTO> getCpuIdleState(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub
		return monitorDao.getCpuIdleState(monitorPageVO);
	}

	@Override
	public List<CpuUserStateRadioDTO> getCpuIowaitState(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub
		return monitorDao.getCpuIowaitState(monitorPageVO);
	}

	@Override
	public List<CpuUserStateRadioDTO> getMemoryState(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub
		return monitorDao.getMemoryState(monitorPageVO);
	}

	@Override
	public List<CpuUserStateRadioDTO> getOutBandwidthState(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub
		return monitorDao.getOutBandwidthState(monitorPageVO);
	}

	@Override
	public List<CpuUserStateRadioDTO> getInBandwidthState(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub
		return monitorDao.getInBandwidthState(monitorPageVO);
	}

	@Override
	public List<CpuUserStateRadioDTO> getOutPackageState(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub
		return monitorDao.getOutPackageState(monitorPageVO);
	}

	@Override
	public List<CpuUserStateRadioDTO> getInPackageState(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub
		return monitorDao.getInPackageState(monitorPageVO);
	}

	@Override
	public List<CpuUserStateRadioDTO> getTcpNumber(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub
		return monitorDao.getTcpNumber(monitorPageVO);
	}

	@Override
	public List<CpuUserStateRadioDTO> getOutTraffic(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub
		return monitorDao.getOutTraffic(monitorPageVO);
	}

	@Override
	public List<Map<String, String>> getDiskUse(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub

		String use = monitorDao.getDiskUse(monitorPageVO);
		String total = monitorDao.getDiskTotal(monitorPageVO);
		Map<String, String> mapUse = new HashMap<String, String>();
		mapUse.put("value", use);
		mapUse.put("name", "已经使用的");
		Map<String, String> mapTotal = new HashMap<String, String>();
		float noUse = Float.parseFloat(total) - Float.parseFloat(use);
		mapTotal.put("value", "" + noUse);
		mapTotal.put("name", "未使用的");
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		list.add(mapUse);
		list.add(mapTotal);
		return list;
	}

	@Override
	public List<CpuUserStateRadioDTO> getIoDealTime(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub
		return monitorDao.getIoDealTime(monitorPageVO);
	}

	@Override
	public List<CpuUserStateRadioDTO> getMysqlQPSData(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub
		return monitorDao.getMysqlQPSData(monitorPageVO);
	}

	@Override
	public List<CpuUserStateRadioDTO> getMysqlTPSData(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub
		return monitorDao.getMysqlTPSData(monitorPageVO);
	}

}
