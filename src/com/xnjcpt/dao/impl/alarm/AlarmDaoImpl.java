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
	 * ���澯����Ϣ��ʵ�ַ���
	 */
	@Override
	public void saveAlarmInfor(xnjcpt_alarm xnjcpt_alarm) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(xnjcpt_alarm);
	}

	/**
	 * ��������id��ѯ��Ӧ������Ϣ��ʵ�ַ���
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
	 * ����״̬��Ϣ��ʵ�ַ���
	 */
	@Override
	public void updateAlarmState(String alarm_id, String alarm_state) {
		// TODO Auto-generated method stub
		String hql="update xnjcpt_alarm set alarm_state='"+alarm_state+"' where alarm_id='"+alarm_id+"'";
		getSession().createQuery(hql).executeUpdate();
	}

	/**
	 * ɾ��������Ϣ��ʵ�ַ���
	 */
	@Override
	public void deleteAlarmInfor(String alarm_id) {
		// TODO Auto-generated method stub
		String hql="delete from xnjcpt_alarm where alarm_id='"+alarm_id+"'";
		getSession().createQuery(hql).executeUpdate();
	}

	/**
	 * ��ȡ�ܵļ�¼����
	 */
	@Override
	public int getAlarmInforCount(String queryString) {
		// TODO Auto-generated method stub
		System.out.println("query������ֵ��"+queryString);
		String hql;
		if(queryString==""||queryString==null){
			hql="select count(*)from xnjcpt_alarm";
		}else{
			String query ="%"+queryString+"%";
			hql="select count(*)from xnjcpt_alarm where (alarm_computer like '"+query+
				"' or alarm_threshold_value like '"+query+"' or alarm_type like '"+
					query+"' or alarm_state like '"+query+"')";
		}
		System.out.println("��ȡ�ܵļ�¼������"+hql);
		int count = ((Number) getSession().createQuery(hql).uniqueResult()).intValue();	
		return count;
	}

	/**
	 * ��ȡ��Ҫ��ʾ����Ϣ����
	 */
	@Override
	public List<xnjcpt_alarm> getAlarmInforList(String queryString, int currPage) {
		// TODO Auto-generated method stub
		String hql;
		if(queryString==""||queryString==null){
			//System.out.println("query��ֵ�ǣ�"+queryString);
			hql="from xnjcpt_alarm";
		}else{
			String query="%"+queryString+"%";
			hql="from xnjcpt_alarm where (alarm_computer like '"+query+
					"' or alarm_threshold_value like '"+query+"' or alarm_type like '"+
					query+"' or alarm_state like '"+query+"')";
		}
		//System.out.println("query��ֵ�ǣ�"+query);
		//System.out.println(hql);
		List<xnjcpt_alarm> list = getSession().createQuery(hql).setFirstResult((currPage - 1) * 6).setMaxResults(6)
				.list();
		System.out.println("��õļ�����"+list);
		return list;
	}

	/**
	 * �����ϸ��Ϣ��ȡ��Ӧ�ľ�����Ϣ
	 */
	@Override
	public xnjcpt_alarm getAlarmInforById(String alarm_id) {
		// TODO Auto-generated method stub
		xnjcpt_alarm xnjcpt_alarm=(xnjcpt_alarm)this.getSession().get(xnjcpt_alarm.class, alarm_id);
		this.getSession().clear();
		return xnjcpt_alarm;
	}

	/**
	 * ���ľ�����Ϣ
	 */
	@Override
	public void updateAlarmInfor(xnjcpt_alarm xnjcpt_alarm) {
		// TODO Auto-generated method stub
		this.getSession().saveOrUpdate(xnjcpt_alarm);
	}

	/**
	 * ����ɾ��������Ϣ
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
