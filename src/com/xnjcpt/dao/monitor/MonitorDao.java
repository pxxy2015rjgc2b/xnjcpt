package com.xnjcpt.dao.monitor;

import java.util.List;

import com.xnjcpt.domain.DTO.CpuUserStateRadioDTO;
import com.xnjcpt.domain.VO.MonitorPageVO;

public interface MonitorDao {

	List<CpuUserStateRadioDTO> getCputState(MonitorPageVO monitorPageVO);

	List<CpuUserStateRadioDTO> getCpuSystemState(MonitorPageVO monitorPageVO);

	List<CpuUserStateRadioDTO> getCpuIdleState(MonitorPageVO monitorPageVO);

	List<CpuUserStateRadioDTO> getCpuIowaitState(MonitorPageVO monitorPageVO);

	List<CpuUserStateRadioDTO> getMemoryState(MonitorPageVO monitorPageVO);

	List<CpuUserStateRadioDTO> getOutBandwidthState(MonitorPageVO monitorPageVO);

	List<CpuUserStateRadioDTO> getInBandwidthState(MonitorPageVO monitorPageVO);

	List<CpuUserStateRadioDTO> getOutPackageState(MonitorPageVO monitorPageVO);

	List<CpuUserStateRadioDTO> getInPackageState(MonitorPageVO monitorPageVO);

	List<CpuUserStateRadioDTO> getTcpNumber(MonitorPageVO monitorPageVO);

	List<CpuUserStateRadioDTO> getOutTraffic(MonitorPageVO monitorPageVO);

	String getDiskUse(MonitorPageVO monitorPageVO);

	String getDiskTotal(MonitorPageVO monitorPageVO);

	List<CpuUserStateRadioDTO> getIoDealTime(MonitorPageVO monitorPageVO);

}
