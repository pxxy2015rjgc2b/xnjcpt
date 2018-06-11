package com.xnjcpt.dao.impl.monitor;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xnjcpt.dao.monitor.MonitorDao;
import com.xnjcpt.domain.DO.xnjcpt_disk;
import com.xnjcpt.domain.DO.xnjcpt_disk_state;
import com.xnjcpt.domain.DTO.CpuUserStateRadioDTO;
import com.xnjcpt.domain.VO.MonitorPageVO;

public class MonitorDaoImpl implements MonitorDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<CpuUserStateRadioDTO> getCputState(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub
		String hql = "select new com.xnjcpt.domain.DTO.CpuUserStateRadioDTO(cpu_state_time,cpu_state_user) from xnjcpt_cpu_state where cpu_state_computer = '"
				+ monitorPageVO.getComputer_id() + "' and cpu_state_time >= '" + monitorPageVO.getTime_start()
				+ "' and cpu_state_time <= '" + monitorPageVO.getTime_end() + "' order by cpu_state_time asc";
		List<CpuUserStateRadioDTO> list = this.getSession().createQuery(hql).list();
		return list;
	}

	@Override
	public List<CpuUserStateRadioDTO> getCpuSystemState(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub
		String hql = "select new com.xnjcpt.domain.DTO.CpuUserStateRadioDTO(cpu_state_time,cpu_state_system) from xnjcpt_cpu_state where cpu_state_computer = '"
				+ monitorPageVO.getComputer_id() + "' and cpu_state_time >= '" + monitorPageVO.getTime_start()
				+ "' and cpu_state_time <= '" + monitorPageVO.getTime_end() + "' order by cpu_state_time asc";
		List<CpuUserStateRadioDTO> list = this.getSession().createQuery(hql).list();
		return list;
	}

	@Override
	public List<CpuUserStateRadioDTO> getCpuIdleState(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub
		String hql = "select new com.xnjcpt.domain.DTO.CpuUserStateRadioDTO(cpu_state_time,cpu_state_idle) from xnjcpt_cpu_state where cpu_state_computer = '"
				+ monitorPageVO.getComputer_id() + "' and cpu_state_time >= '" + monitorPageVO.getTime_start()
				+ "' and cpu_state_time <= '" + monitorPageVO.getTime_end() + "' order by cpu_state_time asc";
		List<CpuUserStateRadioDTO> list = this.getSession().createQuery(hql).list();
		return list;
	}

	@Override
	public List<CpuUserStateRadioDTO> getCpuIowaitState(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub
		String hql = "select new com.xnjcpt.domain.DTO.CpuUserStateRadioDTO(cpu_state_time,cpu_state_iowait) from xnjcpt_cpu_state where cpu_state_computer = '"
				+ monitorPageVO.getComputer_id() + "' and cpu_state_time >= '" + monitorPageVO.getTime_start()
				+ "' and cpu_state_time <= '" + monitorPageVO.getTime_end() + "' order by cpu_state_time asc";
		List<CpuUserStateRadioDTO> list = this.getSession().createQuery(hql).list();
		return list;
	}

	@Override
	public List<CpuUserStateRadioDTO> getMemoryState(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub
		String hql = "select new com.xnjcpt.domain.DTO.CpuUserStateRadioDTO(memory_state_time,memory_state_mem_rate) from xnjcpt_memory_state where memory_state_computer = '"
				+ monitorPageVO.getComputer_id() + "' and memory_state_time >= '" + monitorPageVO.getTime_start()
				+ "' and memory_state_time <= '" + monitorPageVO.getTime_end() + "' order by memory_state_time asc";
		List<CpuUserStateRadioDTO> list = this.getSession().createQuery(hql).list();
		return list;
	}

	@Override
	public List<CpuUserStateRadioDTO> getOutBandwidthState(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub
		String hql = "select new com.xnjcpt.domain.DTO.CpuUserStateRadioDTO(disk_state_time,net_state_obandwidth) from xnjcpt_net_state where disk_state_computer = '"
				+ monitorPageVO.getComputer_id() + "' and disk_state_time >= '" + monitorPageVO.getTime_start()
				+ "' and disk_state_time <= '" + monitorPageVO.getTime_end() + "' order by disk_state_time asc";
		List<CpuUserStateRadioDTO> list = this.getSession().createQuery(hql).list();
		return list;
	}

	@Override
	public List<CpuUserStateRadioDTO> getInBandwidthState(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub
		String hql = "select new com.xnjcpt.domain.DTO.CpuUserStateRadioDTO(disk_state_time,net_state_ibandwidth) from xnjcpt_net_state where disk_state_computer = '"
				+ monitorPageVO.getComputer_id() + "' and disk_state_time >= '" + monitorPageVO.getTime_start()
				+ "' and disk_state_time <= '" + monitorPageVO.getTime_end() + "' order by disk_state_time asc";
		List<CpuUserStateRadioDTO> list = this.getSession().createQuery(hql).list();
		return list;
	}

	@Override
	public List<CpuUserStateRadioDTO> getOutPackageState(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub
		String hql = "select new com.xnjcpt.domain.DTO.CpuUserStateRadioDTO(disk_state_time,net_state_opackage) from xnjcpt_net_state where disk_state_computer = '"
				+ monitorPageVO.getComputer_id() + "' and disk_state_time >= '" + monitorPageVO.getTime_start()
				+ "' and disk_state_time <= '" + monitorPageVO.getTime_end() + "' order by disk_state_time asc";
		List<CpuUserStateRadioDTO> list = this.getSession().createQuery(hql).list();
		return list;
	}

	@Override
	public List<CpuUserStateRadioDTO> getInPackageState(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub
		String hql = "select new com.xnjcpt.domain.DTO.CpuUserStateRadioDTO(disk_state_time,net_state_ipackage) from xnjcpt_net_state where disk_state_computer = '"
				+ monitorPageVO.getComputer_id() + "' and disk_state_time >= '" + monitorPageVO.getTime_start()
				+ "' and disk_state_time <= '" + monitorPageVO.getTime_end() + "' order by disk_state_time asc";
		List<CpuUserStateRadioDTO> list = this.getSession().createQuery(hql).list();
		return list;
	}

	@Override
	public List<CpuUserStateRadioDTO> getTcpNumber(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub
		String hql = "select new com.xnjcpt.domain.DTO.CpuUserStateRadioDTO(disk_state_time,net_state_tcp_number) from xnjcpt_net_state where disk_state_computer = '"
				+ monitorPageVO.getComputer_id() + "' and disk_state_time >= '" + monitorPageVO.getTime_start()
				+ "' and disk_state_time <= '" + monitorPageVO.getTime_end() + "' order by disk_state_time asc";
		List<CpuUserStateRadioDTO> list = this.getSession().createQuery(hql).list();
		return list;
	}

	@Override
	public List<CpuUserStateRadioDTO> getOutTraffic(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub
		String hql = "select new com.xnjcpt.domain.DTO.CpuUserStateRadioDTO(disk_state_time,net_state_otraffic) from xnjcpt_net_state where disk_state_computer = '"
				+ monitorPageVO.getComputer_id() + "' and disk_state_time >= '" + monitorPageVO.getTime_start()
				+ "' and disk_state_time <= '" + monitorPageVO.getTime_end() + "' order by disk_state_time asc";
		List<CpuUserStateRadioDTO> list = this.getSession().createQuery(hql).list();
		return list;
	}

	@Override
	public String getDiskUse(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub

		String hql = "from xnjcpt_disk_state where disk_state_computer = '" + monitorPageVO.getComputer_id()
				+ "' order by disk_state_time desc ";
		List<xnjcpt_disk_state> xs = this.getSession().createQuery(hql).setFirstResult(0).setMaxResults(1).list();
		if (xs != null && xs.size() > 0) {
			return xs.get(0).getDisk_state_use_size().substring(0, xs.get(0).getDisk_state_use_size().length() - 1);
		} else {
			return "";
		}

	}

	@Override
	public String getDiskTotal(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub
		String hql = "from xnjcpt_disk where disk_computer = '" + monitorPageVO.getComputer_id() + "'";
		List<xnjcpt_disk> xs = this.getSession().createQuery(hql).list();
		if (xs != null && xs.size() > 0) {
			return xs.get(0).getDisk_size().substring(0, xs.get(0).getDisk_size().length() - 1);
		} else {
			return "";
		}
	}

	@Override
	public List<CpuUserStateRadioDTO> getIoDealTime(MonitorPageVO monitorPageVO) {
		// TODO Auto-generated method stub
		String hql = "select new com.xnjcpt.domain.DTO.CpuUserStateRadioDTO(io_state_time,io_state_util) from xnjcpt_io_state where io_state_computer = '"
				+ monitorPageVO.getComputer_id() + "' and io_state_time >= '" + monitorPageVO.getTime_start()
				+ "' and io_state_time <= '" + monitorPageVO.getTime_end() + "' order by io_state_time asc";
		List<CpuUserStateRadioDTO> list = this.getSession().createQuery(hql).list();
		return list;
	}
}
