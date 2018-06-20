package com.xnjcpt.dao.impl.receive;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xnjcpt.dao.receive.ReceiveDao;
import com.xnjcpt.domain.DO.xnjcpt_computer;
import com.xnjcpt.domain.DO.xnjcpt_cpu;
import com.xnjcpt.domain.DO.xnjcpt_cpu_state;
import com.xnjcpt.domain.DO.xnjcpt_disk;
import com.xnjcpt.domain.DO.xnjcpt_disk_state;
import com.xnjcpt.domain.DO.xnjcpt_io_state;
import com.xnjcpt.domain.DO.xnjcpt_memory;
import com.xnjcpt.domain.DO.xnjcpt_memory_state;
import com.xnjcpt.domain.DO.xnjcpt_net;
import com.xnjcpt.domain.DO.xnjcpt_net_state;
import com.xnjcpt.domain.DO.xnjcpt_progress;

import util.TeamUtil;

public class ReceiveDaoImpl implements ReceiveDao {
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

	/**
	 * 主机信息保存、更新的执行方法
	 */
	@Override
	public void updateComputerInfor(xnjcpt_computer xnjcpt_computer) {
		// TODO Auto-generated method stub
		String hql = "from xnjcpt_computer where computer_ip='" + xnjcpt_computer.getComputer_ip() + "'";
		Query query = getSession().createQuery(hql);
		List<xnjcpt_computer> list = query.list();
		if (list.size() > 0) {
			String hql2 = "update xnjcpt_computer set computer_name ='" + xnjcpt_computer.getComputer_name()
					+ "',computer_gmt_modified='" + xnjcpt_computer.getComputer_gmt_modified()
					+ "'where computer_ip = '" + xnjcpt_computer.getComputer_ip() + "'";
			getSession().createQuery(hql2).executeUpdate();
		} else {
			System.out.println("没有该主机");
			// xnjcpt_computer.setComputer_gmt_create(TeamUtil.getStringSecond());
			// xnjcpt_computer.setComputer_gmt_modified(TeamUtil.getStringSecond());
			// xnjcpt_computer.setComputer_id(TeamUtil.getUuid());
			// this.getSession().save(xnjcpt_computer);
		}

	}

	/**
	 * cpu信息更新、保存的方法
	 */
	@Override
	public void updateCpuInfo(String ip, xnjcpt_cpu xnjcpt_cpu) {
		// TODO Auto-generated method stub
		/**
		 * 根据ip查找computer的list集合
		 */
		System.out.println(ip);
		String hql = "from xnjcpt_computer where computer_ip='" + ip + "'";
		Query query = getSession().createQuery(hql);
		List<xnjcpt_computer> computer_list = query.list();
		if (computer_list.size() > 0) {
			/**
			 * 根据computer_id查找cpu的信息集合，cpu_computer=computer_id
			 */
			String hql2 = "from xnjcpt_cpu where cpu_computer='" + computer_list.get(0).getComputer_id() + "'";
			query = getSession().createQuery(hql2);
			List<xnjcpt_cpu> cpu_list = query.list();

			if (cpu_list.size() > 0) {
				System.out.println(computer_list.get(0).getComputer_ip());
				String hql3 = "update xnjcpt_cpu set cpu_model='" + xnjcpt_cpu.getCpu_model()
						+ "',cpu_basic_frequency='" + xnjcpt_cpu.getCpu_basic_frequency() + "',cpu_catch_size='"
						+ xnjcpt_cpu.getCpu_catch_size() + "',cpu_cores='" + xnjcpt_cpu.getCpu_cores()
						+ "',cpu_gmt_modified='" + TeamUtil.getStringSecond() + "' where cpu_computer= '"
						+ computer_list.get(0).getComputer_id() + "'";
				System.out.println(hql3);
				getSession().createQuery(hql3).executeUpdate();

			} else {
				System.out.println("CPU执行保存！");
				xnjcpt_cpu.setCpu_gmt_create(TeamUtil.getStringSecond());
				xnjcpt_cpu.setCpu_gmt_modified(TeamUtil.getStringSecond());
				xnjcpt_cpu.setCpu_id(TeamUtil.getUuid());
				xnjcpt_cpu.setCpu_computer(computer_list.get(0).getComputer_id());
				this.getSession().save(xnjcpt_cpu);
			}
		} else {
			System.out.println("Error!");
		}

	}

	/**
	 * 内存信息保存、更新的方法
	 */
	@Override
	public void updateMemoryInfor(String ip, xnjcpt_memory xnjcpt_memory) {
		// TODO Auto-generated method stub
		/**
		 * 根据ip查找computer的list 集合
		 */
		String hql = "from xnjcpt_computer where computer_ip='" + ip + "'";
		Query query = getSession().createQuery(hql);
		List<xnjcpt_computer> computer_list = query.list();
		/**
		 * 根据computer_id查找内存信息的集合，computer_id=memory_computer
		 */
		if (computer_list.size() > 0) {
			String hql2 = "from xnjcpt_memory where memory_computer='" + computer_list.get(0).getComputer_id() + "'";
			query = getSession().createQuery(hql2);
			List<xnjcpt_memory> memory_list = query.list();
			if (memory_list.size() > 0) {
				String hql3 = "update xnjcpt_memory set memory_size='" + xnjcpt_memory.getMemory_size()
						+ "',memory_swap='" + xnjcpt_memory.getMemory_swap() + "',memory_gmt_modified='"
						+ TeamUtil.getStringSecond() + "' where memory_computer='"
						+ computer_list.get(0).getComputer_id() + "'";
				System.out.println(hql3);
				getSession().createQuery(hql3).executeUpdate();

			} else {
				System.out.println("内存执行保存！");
				xnjcpt_memory.setMemory_gmt_create(TeamUtil.getStringSecond());
				xnjcpt_memory.setMemory_gmt_modified(TeamUtil.getStringSecond());
				xnjcpt_memory.setMemory_id(TeamUtil.getUuid());
				xnjcpt_memory.setMemory_computer(computer_list.get(0).getComputer_id());
				this.getSession().save(xnjcpt_memory);
			}
		} else {
			System.out.println("Error!");
		}

	}

	/**
	 * 磁盘信息更改、保存的方法
	 */
	@Override
	public void updateDiskInfor(String ip, xnjcpt_disk xnjcpt_disk) {
		// TODO Auto-generated method stub
		/**
		 * 根据ip查找computer的list集合
		 */
		String hql = "from xnjcpt_computer where computer_ip='" + ip + "'";
		Query query = getSession().createQuery(hql);
		List<xnjcpt_computer> computer_list = query.list();
		/**
		 * 根据computer_id查找磁盘信息的集合，disk_computer=computer_id
		 */
		if (computer_list.size() > 0) {
			String hql2 = "from xnjcpt_disk where disk_computer='" + computer_list.get(0).getComputer_id() + "'";
			query = getSession().createQuery(hql2);
			List<xnjcpt_disk> disk_list = query.list();
			if (disk_list.size() > 0) {
				String hql3 = "update xnjcpt_disk set disk_size='" + xnjcpt_disk.getDisk_size()
						+ "',disk_gmt_modified='" + TeamUtil.getStringSecond() + "' where disk_computer='"
						+ computer_list.get(0).getComputer_id() + "'";
				getSession().createQuery(hql3).executeUpdate();
			} else {
				xnjcpt_disk.setDisk_gmt_create(TeamUtil.getStringSecond());
				xnjcpt_disk.setDisk_gmt_modified(TeamUtil.getStringSecond());
				xnjcpt_disk.setDisk_id(TeamUtil.getUuid());
				xnjcpt_disk.setDisk_computer(computer_list.get(0).getComputer_id());
				this.getSession().save(xnjcpt_disk);
			}

		} else {
			System.out.println("Error!");
		}

	}

	/**
	 * 网络信息更改、保存的方法
	 */
	@Override
	public void updateNetInfor(String ip, xnjcpt_net xnjcpt_net) {
		// TODO Auto-generated method stub
		/**
		 * 根据ip查找computer的list集合
		 */
		String hql = "from xnjcpt_computer where computer_ip='" + ip + "'";
		Query query = getSession().createQuery(hql);
		List<xnjcpt_computer> computer_list = query.list();
		/**
		 * 根据computer_id查找网络信息的集合，computer_id=net_computer
		 */
		if (computer_list.size() > 0) {
			String hql2 = "from xnjcpt_net where net_computer='" + computer_list.get(0).getComputer_id() + "'";
			query = getSession().createQuery(hql2);
			List<xnjcpt_net> net_list = query.list();
			if (net_list.size() > 0) {
				String hql3 = "update xnjcpt_net set net_mac='" + xnjcpt_net.getNet_mac() + "',net_ipv6='"
						+ xnjcpt_net.getNet_ipv6() + "',net_gmt_modified='" + TeamUtil.getStringSecond()
						+ "' where net_computer='" + computer_list.get(0).getComputer_id() + "'";
				getSession().createQuery(hql3).executeUpdate();

			} else {
				xnjcpt_net.setNet_gmt_create(TeamUtil.getStringSecond());
				xnjcpt_net.setNet_gmt_modified(TeamUtil.getStringSecond());
				xnjcpt_net.setNet_computer(computer_list.get(0).getComputer_id());
				xnjcpt_net.setNet_id(TeamUtil.getUuid());
				this.getSession().save(xnjcpt_net);
			}

		} else {
			System.out.println("Error!");
		}

	}

	/**
	 * cpu状态信息保存的实现方法
	 */
	@Override
	public void saveCpuStateInfor(String ip, xnjcpt_cpu_state xnjcpt_cpu_state) {
		// TODO Auto-generated method stub
		/**
		 * 根据ip查找computer的list集合
		 */
		String hql = "from xnjcpt_computer where computer_ip='" + ip + "'";
		Query query = getSession().createQuery(hql);
		List<xnjcpt_computer> computer_list = query.list();
		if (computer_list.size() > 0) {

			xnjcpt_cpu_state.setCpu_state_gmt_create(TeamUtil.getStringSecond());
			xnjcpt_cpu_state.setCpu_state_gmt_modified(TeamUtil.getStringSecond());
			xnjcpt_cpu_state.setCpu_state_computer(computer_list.get(0).getComputer_id());
			xnjcpt_cpu_state.setCpu_state_id(TeamUtil.getUuid());
			this.getSession().save(xnjcpt_cpu_state);

		} else {
			System.out.println("Error!");
		}
	}

	/**
	 * 内存状态信息保存的实现方法
	 */
	@Override
	public void saveMemoryStateInfor(String ip, xnjcpt_memory_state xnjcpt_memory_state) {
		// TODO Auto-generated method stub
		/**
		 * 根据ip查找computer的list集合
		 */
		String hql = "from xnjcpt_computer where computer_ip='" + ip + "'";
		Query query = getSession().createQuery(hql);
		List<xnjcpt_computer> computer_list = query.list();
		if (computer_list.size() > 0) {
			System.out.println("内存状态信息保存！");
			xnjcpt_memory_state.setMemory_state_computer(computer_list.get(0).getComputer_id());
			xnjcpt_memory_state.setMemory_state_gmt_create(TeamUtil.getStringSecond());
			xnjcpt_memory_state.setMemory_state_gmt_modified(TeamUtil.getStringSecond());
			xnjcpt_memory_state.setMemory_state_id(TeamUtil.getUuid());
			this.getSession().save(xnjcpt_memory_state);
		} else {
		}
	}

	/**
	 * io状态信息实保存的方法
	 */
	@Override
	public void saveIoStateInfor(String ip, xnjcpt_io_state xnjcpt_io_state) {
		// TODO Auto-generated method stub
		/**
		 * 根据ip查找compu_list的集合
		 */
		String hql = "from xnjcpt_computer where computer_ip='" + ip + "'";
		Query query = getSession().createQuery(hql);
		List<xnjcpt_computer> computer_list = query.list();
		if (computer_list.size() > 0) {
			System.out.println("io状态信息保存！");
			xnjcpt_io_state.setIo_state_computer(computer_list.get(0).getComputer_id());
			xnjcpt_io_state.setIo_state_gmt_create(TeamUtil.getStringSecond());
			xnjcpt_io_state.setIo_state_gmt_modified(TeamUtil.getStringSecond());
			xnjcpt_io_state.setIo_state_id(TeamUtil.getUuid());
			this.getSession().save(xnjcpt_io_state);
		} else {
		}
	}

	/**
	 * 磁盘状态信息保存的实现方法
	 */
	@Override
	public void saveDiskInfor(String ip, xnjcpt_disk_state xnjcpt_disk_state) {
		// TODO Auto-generated method stub
		String hql = "from xnjcpt_computer where computer_ip='" + ip + "'";
		Query query = getSession().createQuery(hql);
		List<xnjcpt_computer> computer_list = query.list();
		if (computer_list.size() > 0) {
			xnjcpt_disk_state.setDisk_state_computer(computer_list.get(0).getComputer_id());
			xnjcpt_disk_state.setDisk_state_gmt_create(TeamUtil.getStringSecond());
			xnjcpt_disk_state.setDisk_state_gmt_modified(TeamUtil.getStringSecond());
			xnjcpt_disk_state.setDisk_state_id(TeamUtil.getUuid());
			this.getSession().save(xnjcpt_disk_state);
		} else {
		}
	}

	/**
	 * 网络状态信息保存的实现方法
	 */
	@Override
	public void saveNetInfor(String ip, xnjcpt_net_state xnjcpt_net_state) {
		// TODO Auto-generated method stub
		String hql = "from xnjcpt_computer where computer_ip='" + ip + "'";
		Query query = getSession().createQuery(hql);
		List<xnjcpt_computer> computer_list = query.list();
		if (computer_list.size() > 0) {
			xnjcpt_net_state.setDisk_state_computer(computer_list.get(0).getComputer_id());
			xnjcpt_net_state.setNet_state_gmt_create(TeamUtil.getStringSecond());
			xnjcpt_net_state.setNet_state_gmt_modified(TeamUtil.getStringSecond());
			xnjcpt_net_state.setNet_state_id(TeamUtil.getUuid());
			this.getSession().save(xnjcpt_net_state);
		} else {
		}
	}

	@Override
	public xnjcpt_computer getComputerByIp(String ip) {
		// TODO Auto-generated method stub

		String hql = "from xnjcpt_computer where computer_ip = '" + ip + "'";
		System.out.println(hql);
		Query query = getSession().createQuery(hql);
		List<xnjcpt_computer> list = query.list();
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}

	}

	@Override
	public void deleteProgressByComputer(String id) {
		// TODO Auto-generated method stub
		String hql = "delete from xnjcpt_progress where  progress_computer  = '" + id + "'";
		this.getSession().createQuery(hql).executeUpdate();
	}

	@Override
	public void savePorgress(xnjcpt_progress xnjcpt_progress) {
		// TODO Auto-generated method stub
		this.getSession().save(xnjcpt_progress);
	}
}