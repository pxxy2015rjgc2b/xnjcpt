package com.xnjcpt.dao.impl.computer;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.ActionContext;
import com.xnjcpt.dao.computer.ComputerDao;
import com.xnjcpt.domain.DO.xnjcpt_computer;
import com.xnjcpt.domain.DO.xnjcpt_cpu;
import com.xnjcpt.domain.DO.xnjcpt_disk;
import com.xnjcpt.domain.DO.xnjcpt_memory;
import com.xnjcpt.domain.DO.xnjcpt_user_computer;
import com.xnjcpt.domain.DTO.ComputerPageDTO;
import com.xnjcpt.domain.VO.ComputerPageVO;

public class ComputerDaoImpl implements ComputerDao {
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
	public List<xnjcpt_computer> getComputerByUserId(String user_id) {
		// TODO Auto-generated method stub

		String hql = "select new com.xnjcpt.domain.DTO.ChooseComputerDTO(c.computer_id , c.computer_ip) from xnjcpt_computer as c,xnjcpt_user_computer as uc where uc.user_computer_computer = computer_id and uc.user_computer_user = '"
				+ user_id + "'";
		Query query = this.getSession().createQuery(hql);
		System.out.println(hql);
		return query.list();
	}

	@Override
	public List<xnjcpt_computer> verifyIp(xnjcpt_computer xnjcpt_computer) {
		// TODO Auto-generated method stub

		String hql = "from xnjcpt_computer where computer_ip ='" + xnjcpt_computer.getComputer_ip().trim() + "'";
		return this.getSession().createQuery(hql).list();
	}

	@Override
	public boolean saveComputer(xnjcpt_computer xnjcpt_computer) {
		// TODO Auto-generated method stub
		try {
			this.getSession().save(xnjcpt_computer);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}

	}

	@Override
	public boolean saveUserComputer(xnjcpt_user_computer xuc) {
		// TODO Auto-generated method stub
		try {
			this.getSession().save(xuc);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public int getCountByPage(ComputerPageVO computerPageVO) {
		// TODO Auto-generated method stub
		String user_id = (String) ActionContext.getContext().getSession().get("user_id");
		String hql = "select count(*) from xnjcpt_computer as c ,xnjcpt_user_computer as xuc , "
				+ "xnjcpt_disk as xd , xnjcpt_cpu as xc , xnjcpt_memory as xm "
				+ "where c.computer_id = xuc.user_computer_computer"
				+ " and c.computer_id = xd.disk_computer and c.computer_id = xc.cpu_computer and c.computer_id=xm.memory_computer"
				+ " and xuc.user_computer_user = '" + user_id + "'";
		//
		// String hql = "select count(*) from xnjcpt_computer as c"
		// + " left join xnjcpt_user_computer as xuc on c.computer_id =
		// xuc.user_computer_computer "
		// + "left join xnjcpt_disk as xd on c.computer_id = xd.disk_computer"
		// + " left join xnjcpt_cpu as xc on c.computer_id = xc.cpu_computer"
		// + " left join xnjcpt_memory as xm on
		// c.computer_id=xm.memory_computer"
		// + " where xuc.user_computer_user = '" + user_id + "'";
		if (computerPageVO.getSearchContent() != null && !"".equals(computerPageVO.getSearchContent().trim())) {
			hql = hql + " and c.computer_ip like '%" + computerPageVO.getSearchContent().trim() + "%'";
		}
		System.out.println(hql);
		Query query = this.getSession().createQuery(hql);
		long count = (long) query.uniqueResult();
		return (int) count;
	}

	@Override
	public void getComputerByPage(ComputerPageVO computerPageVO) {
		// TODO Auto-generated method stub
		String user_id = (String) ActionContext.getContext().getSession().get("user_id");
		String hql = "select new com.xnjcpt.domain.DTO.ComputerPageDTO(c.computer_id,c.computer_ip,xc.cpu_model,xd.disk_size,xm.memory_size) from xnjcpt_computer as c ,xnjcpt_user_computer as xuc , "
				+ "xnjcpt_disk as xd , xnjcpt_cpu as xc , xnjcpt_memory as xm "
				+ "where c.computer_id = xuc.user_computer_computer"
				+ " and c.computer_id = xd.disk_computer and c.computer_id = xc.cpu_computer and c.computer_id=xm.memory_computer"
				+ " and xuc.user_computer_user = '" + user_id + "'";
		//
		// String hql = "select new
		// com.xnjcpt.domain.DTO.ComputerPageDTO(c.computer_id,c.computer_ip,xc.cpu_model,xd.disk_size,xm.memory_size)
		// from xnjcpt_computer as c"
		// + " left join xnjcpt_user_computer as xuc on c.computer_id =
		// xuc.user_computer_computer "
		// + "left join xnjcpt_disk as xd on c.computer_id = xd.disk_computer"
		// + " left join xnjcpt_cpu as xc on c.computer_id = xc.cpu_computer"
		// + " left join xnjcpt_memory as xm on
		// c.computer_id=xm.memory_computer"
		// + " where xuc.user_computer_user = '" + user_id + "'";
		if (computerPageVO.getSearchContent() != null && !"".equals(computerPageVO.getSearchContent().trim())) {
			hql = hql + " and c.computer_ip like '%" + computerPageVO.getSearchContent().trim() + "%'";
		}
		hql = hql + " order by c.computer_gmt_create desc";
		Query query = this.getSession().createQuery(hql)
				.setFirstResult((computerPageVO.getCurrPage() - 1) * computerPageVO.getPageSize())
				.setMaxResults(computerPageVO.getPageSize());
		System.out.println(hql);
		List<ComputerPageDTO> list = query.list();
		computerPageVO.setList(list);
	}

	@Override
	public boolean saveCPUInfo(xnjcpt_cpu xc) {
		// TODO Auto-generated method stub
		try {
			this.getSession().save(xc);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean saveDiskInfo(xnjcpt_disk xd) {
		// TODO Auto-generated method stub
		try {
			this.getSession().save(xd);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean saveMemoryInfo(xnjcpt_memory xm) {
		// TODO Auto-generated method stub
		try {
			this.getSession().save(xm);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteComputerById(String computer_id) {
		// TODO Auto-generated method stub

		try {
			xnjcpt_computer xc = new xnjcpt_computer();
			xc.setComputer_id(computer_id);
			this.getSession().delete(xc);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}

	}

	@Override
	public boolean deleteUserComputerById(String computer_id) {
		// TODO Auto-generated method stub
		String hql = "delete from xnjcpt_user_computer where user_computer_computer ='" + computer_id + "'";
		try {
			this.getSession().createQuery(hql).executeUpdate();
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteCpu(String computer_id) {
		// TODO Auto-generated method stub
		String hql = "delete from xnjcpt_cpu where cpu_computer ='" + computer_id + "'";
		try {
			this.getSession().createQuery(hql).executeUpdate();
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteDisk(String computer_id) {
		// TODO Auto-generated method stub
		String hql = "delete from xnjcpt_disk where disk_computer ='" + computer_id + "'";
		try {
			this.getSession().createQuery(hql).executeUpdate();
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteMemory(String computer_id) {
		// TODO Auto-generated method stub
		String hql = "delete from xnjcpt_memory where memory_computer ='" + computer_id + "'";
		try {
			this.getSession().createQuery(hql).executeUpdate();
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteNet(String computer_id) {
		// TODO Auto-generated method stub
		String hql = "delete from xnjcpt_net where net_computer ='" + computer_id + "'";
		try {
			this.getSession().createQuery(hql).executeUpdate();
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteCpuState(String computer_id) {
		// TODO Auto-generated method stub
		String hql = "delete from xnjcpt_cpu_state where cpu_state_computer ='" + computer_id + "'";
		try {
			this.getSession().createQuery(hql).executeUpdate();
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteDiskState(String computer_id) {
		// TODO Auto-generated method stub
		String hql = "delete from xnjcpt_disk_state where disk_state_computer ='" + computer_id + "'";
		try {
			this.getSession().createQuery(hql).executeUpdate();
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteMemoryState(String computer_id) {
		// TODO Auto-generated method stub
		String hql = "delete from xnjcpt_memory_state where memory_state_computer ='" + computer_id + "'";
		try {
			this.getSession().createQuery(hql).executeUpdate();
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteNetState(String computer_id) {
		// TODO Auto-generated method stub
		String hql = "delete from xnjcpt_net_state where disk_state_computer ='" + computer_id + "'";
		try {
			this.getSession().createQuery(hql).executeUpdate();
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deletIOState(String computer_id) {
		// TODO Auto-generated method stub
		String hql = "delete from xnjcpt_io_state where io_state_computer ='" + computer_id + "'";
		try {
			this.getSession().createQuery(hql).executeUpdate();
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deleteAlarm(String computer_id) {
		// TODO Auto-generated method stub
		String hql = "delete from xnjcpt_alarm where alarm_computer ='" + computer_id + "'";
		try {
			this.getSession().createQuery(hql).executeUpdate();
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public xnjcpt_computer getComputerById(String id) {
		// TODO Auto-generated method stub
		return (xnjcpt_computer) this.getSession().get(xnjcpt_computer.class, id);
	}

	@Override
	public void deleteProgress(String id, String pid) {
		// TODO Auto-generated method stub
		String hql = "delete from xnjcpt_progress where progress_computer = '" + id + "' and progress_pid = '" + pid
				+ "'";
		this.getSession().createQuery(hql).executeUpdate();
	}
}
