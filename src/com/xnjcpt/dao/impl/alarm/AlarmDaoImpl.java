package com.xnjcpt.dao.impl.alarm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import java.util.List;

import com.xnjcpt.dao.alarm.AlarmDao;
import com.xnjcpt.domain.DO.*;



public class AlarmDaoImpl implements AlarmDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 保存警报信息的实现方法
	 */
	@Override
	public void saveAlarmInfor(xnjcpt_alarm xnjcpt_alarm) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(xnjcpt_alarm);
	}

	/**
	 * 根据主机id查询对应警报信息的实现方法
	 */
	@Override
	public xnjcpt_alarm getAlarmInforByAlarmInfor(String alarm_id) {
		// TODO Auto-generated method stub
		String hql="from xnjcpt_alarm where alarm_id='"+alarm_id+"'";
		Query query=getSession().createQuery(hql);
		List<xnjcpt_alarm> alarm_list=query.list();
		return alarm_list.get(0);
	}

	/**
	 * 更改状态信息的实现方法
	 */
	@Override
	public void updateAlarmState(String alarm_id, String alarm_state) {
		// TODO Auto-generated method stub
		String hql="update xnjcpt_alarm set alarm_state='"+alarm_state+"' where alarm_id='"+alarm_id+"'";
		getSession().createQuery(hql).executeUpdate();
	}

	/**
	 * 删除警报信息的实现方法
	 */
	@Override
	public void deleteAlarmInfor(String alarm_id) {
		// TODO Auto-generated method stub
		String hql="delete from xnjcpt_alarm where alarm_id='"+alarm_id+"'";
		getSession().createQuery(hql).executeUpdate();
	}

	/**
	 * 获取总的记录条数
	 */
	@Override
	public int getAlarmInforCount(String queryString) {
		// TODO Auto-generated method stub
		System.out.println("query参数的值是"+queryString);
		String hql;
		if(queryString==""||queryString==null){
			hql="select count(*)from xnjcpt_alarm";
		}else{
			String query ="%"+queryString+"%";
			hql="select count(*)from xnjcpt_alarm where (alarm_computer like '"+query+
				"' or alarm_threshold_value like '"+query+"' or alarm_type like '"+
					query+"' or alarm_state like '"+query+"')";
		}
		System.out.println("获取总的记录条数："+hql);
		int count = ((Number) getSession().createQuery(hql).uniqueResult()).intValue();	
		return count;
	}

	/**
	 * 获取需要显示的信息集合
	 */
	@Override
	public List<xnjcpt_alarm> getAlarmInforList(String queryString, int currPage) {
		// TODO Auto-generated method stub
		String hql;
		if(queryString==""||queryString==null){
			//System.out.println("query的值是："+queryString);
			hql="from xnjcpt_alarm";
		}else{
			String query="%"+queryString+"%";
			hql="from xnjcpt_alarm where (alarm_computer like '"+query+
					"' or alarm_threshold_value like '"+query+"' or alarm_type like '"+
					query+"' or alarm_state like '"+query+"')";
		}
		//System.out.println("query的值是："+query);
		//System.out.println(hql);
		List<xnjcpt_alarm> list = getSession().createQuery(hql).setFirstResult((currPage - 1) * 10).setMaxResults(10)
				.list();
		System.out.println("获得的集合是"+list);
		return list;
	}

	/**
	 * 点击详细信息获取相应的警报信息
	 */
	@Override
	public xnjcpt_alarm getAlarmInforById(String alarm_id) {
		// TODO Auto-generated method stub
		xnjcpt_alarm xnjcpt_alarm=(xnjcpt_alarm)this.getSession().get(xnjcpt_alarm.class, alarm_id);
		this.getSession().clear();
		return xnjcpt_alarm;
	}

	/**
	 * 更改警报信息
	 */
	@Override
	public void updateAlarmInfor(xnjcpt_alarm xnjcpt_alarm) {
		// TODO Auto-generated method stub
		this.getSession().saveOrUpdate(xnjcpt_alarm);
	}

	/**
	 * 批量删除警报信息
	 */
	@Override
	public void deleteAlarmInfors(String[] strAlarmIds) {
		// TODO Auto-generated method stub
		 String hql = "";
	        for(int i=0;i<strAlarmIds.length;i++) {
	            if(i==0) {
	                hql = "alarm_id ='"+strAlarmIds[i]+"'";
	            } else {
	                hql =hql + " or alarm_id ='"+strAlarmIds[i]+"'";
	            }
	        }   
	        Query query= this.getSession().createQuery("delete from xnjcpt_alarm where "+hql);
	        query.executeUpdate();
	}

	

	
	
}
