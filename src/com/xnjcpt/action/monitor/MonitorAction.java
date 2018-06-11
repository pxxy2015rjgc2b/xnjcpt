package com.xnjcpt.action.monitor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.xnjcpt.domain.DTO.CpuUserStateRadioDTO;
import com.xnjcpt.domain.VO.MonitorPageVO;
import com.xnjcpt.service.monitor.MonitorService;

public class MonitorAction {
	private MonitorService monitorService;
	private MonitorPageVO monitorPageVO;
	// 时间区间内所有CPU状态

	public void getCpuUserState() {
		List<CpuUserStateRadioDTO> list = monitorService.getCputState(monitorPageVO);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(new Gson().toJson(list));
			pw.flush();
			pw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 时间区间内所有Cpu中system状态
	public void getCpuSystemState() {
		List<CpuUserStateRadioDTO> list = monitorService.getCpuSystemState(monitorPageVO);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(new Gson().toJson(list));
			pw.flush();
			pw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 时间区间内CPU中idle状态
	public void getCpuIdleState() {
		List<CpuUserStateRadioDTO> list = monitorService.getCpuIdleState(monitorPageVO);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(new Gson().toJson(list));
			pw.flush();
			pw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 获得CPU所有iowait状态
	public void getCpuIowaitState() {
		List<CpuUserStateRadioDTO> list = monitorService.getCpuIowaitState(monitorPageVO);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(new Gson().toJson(list));
			pw.flush();
			pw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 获得内存使用情况
	public void getMemoryState() {
		List<CpuUserStateRadioDTO> list = monitorService.getMemoryState(monitorPageVO);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(new Gson().toJson(list));
			pw.flush();
			pw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 获得出带宽使用情况
	public void getOutBandwidthState() {
		List<CpuUserStateRadioDTO> list = monitorService.getOutBandwidthState(monitorPageVO);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(new Gson().toJson(list));
			pw.flush();
			pw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 获得入带宽使用情况
	public void getInBandwidthState() {
		List<CpuUserStateRadioDTO> list = monitorService.getInBandwidthState(monitorPageVO);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(new Gson().toJson(list));
			pw.flush();
			pw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 获得出包量
	public void getOutPackageState() {
		List<CpuUserStateRadioDTO> list = monitorService.getOutPackageState(monitorPageVO);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(new Gson().toJson(list));
			pw.flush();
			pw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 获得入包量
	public void getInPackageState() {
		List<CpuUserStateRadioDTO> list = monitorService.getInPackageState(monitorPageVO);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(new Gson().toJson(list));
			pw.flush();
			pw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 获得tcp连接个数
	public void getTcpNumber() {
		List<CpuUserStateRadioDTO> list = monitorService.getTcpNumber(monitorPageVO);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(new Gson().toJson(list));
			pw.flush();
			pw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 获得出流量
	public void getOutTraffic() {
		List<CpuUserStateRadioDTO> list = monitorService.getOutTraffic(monitorPageVO);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(new Gson().toJson(list));
			pw.flush();
			pw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 获得磁盘使用情况
	public void getDiskUse() {
		List<Map<String, String>> list = monitorService.getDiskUse(monitorPageVO);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(new Gson().toJson(list));
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 获得io处理时间百分比

	public void getIoDealTime() {
		List<CpuUserStateRadioDTO> list = monitorService.getIoDealTime(monitorPageVO);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		try {
			PrintWriter pw = response.getWriter();
			pw.write(new Gson().toJson(list));
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setMonitorService(MonitorService monitorService) {
		this.monitorService = monitorService;
	}

	public MonitorService getMonitorService() {
		return monitorService;
	}

	public MonitorPageVO getMonitorPageVO() {
		return monitorPageVO;
	}

	public void setMonitorPageVO(MonitorPageVO monitorPageVO) {
		this.monitorPageVO = monitorPageVO;
	}

}
