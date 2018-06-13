package com.xnjcpt.dao.impl.computer;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.opensymphony.xwork2.ActionContext;
import com.xnjcpt.dao.computer.ComputerDao;
import com.xnjcpt.domain.DO.xnjcpt_computer;
import com.xnjcpt.domain.DO.xnjcpt_user_computer;
import com.xnjcpt.domain.DTO.UserComputerPageDTO;
import com.xnjcpt.domain.VO.computerInformationVO;
import util.TeamUtil;
public class ComputerDaoImpl implements ComputerDao {
	private SessionFactory sessionFactory;
	private xnjcpt_computer xc;
	private xnjcpt_user_computer xuc;
	private  String user_id;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public boolean addComputer(xnjcpt_computer xc) {
		String hql = "from xnjcpt_computer where computer_ip like '" + xc.getComputer_ip() + "'";
		System.out.println(hql);
		List<xnjcpt_computer> list = getSession().createQuery(hql).list();
		if(list.size()>0){
		System.out.println("ip已存在，添加失败！");
		return false;}else{	
xc.setComputer_id(TeamUtil.getUuid());
xc.setComputer_gmt_create(TeamUtil.getStringSecond());
xc.setComputer_gmt_modified(TeamUtil.getStringSecond());
getSession().save(xc);
xnjcpt_user_computer xuc=new xnjcpt_user_computer();
String user_id = (String) ActionContext.getContext().getSession().get("user_id");
xuc.setUser_computer_id(TeamUtil.getUuid());
xuc.setUser_computer_user(user_id);
xuc.setUser_computer_computer(xc.getComputer_id());
xuc.setUser_computer_gmt_create(TeamUtil.getStringSecond());
xuc.setUser_computer_gmt_modified(TeamUtil.getStringSecond());
getSession().save(xuc);	
return true;}
	}
	@Override
	public void deleteComputerById(String[] strComputerIds) {
		String hql="";
		for(int i=0;i<strComputerIds.length;i++){
			if(i==0){hql="computer_id='"+strComputerIds[i]+"'";}
			else{hql=hql+"or computer_id='"+strComputerIds[i]+"'";}
			String hql1="delete from xnjcpt_computer where "+hql;
		Query query=this.getSession().createQuery(hql1);
		query.executeUpdate();}
		String hql1="";
		for(int i=0;i<strComputerIds.length;i++){
			if(i==0){hql1="user_computer_computer='"+strComputerIds[i]+"'";}
			else{hql1=hql1+"or user_computer_computer='"+strComputerIds[i]+"'";}
			String hql2="delete from xnjcpt_user_computer where "+hql1;
		Query query=this.getSession().createQuery(hql2);
		query.executeUpdate();}
		String hql2="";
		for(int i=0;i<strComputerIds.length;i++){
			if(i==0){hql2="cpu_computer='"+strComputerIds[i]+"'";}
			else{hql2=hql2+"or cpu_computer='"+strComputerIds[i]+"'";}
			String hql3="delete from xnjcpt_cpu where "+hql2;
		Query query=this.getSession().createQuery(hql3);
		query.executeUpdate();}
		String hql3="";
		for(int i=0;i<strComputerIds.length;i++){
			if(i==0){hql3="cpu_state_computer='"+strComputerIds[i]+"'";}
			else{hql3=hql3+"or cpu_state_computer='"+strComputerIds[i]+"'";}
			String hql4="delete from xnjcpt_cpu_state where "+hql3;
		Query query=this.getSession().createQuery(hql4);
		query.executeUpdate();}
		String hql4="";
		for(int i=0;i<strComputerIds.length;i++){
			if(i==0){hql4="disk_computer='"+strComputerIds[i]+"'";}
			else{hql4=hql4+"or disk_computer='"+strComputerIds[i]+"'";}
			String hql5="delete from xnjcpt_disk where "+hql4;
		Query query=this.getSession().createQuery(hql5);
		query.executeUpdate();}
		String hql5="";
		for(int i=0;i<strComputerIds.length;i++){
			if(i==0){hql5="disk_state_computer='"+strComputerIds[i]+"'";}
			else{hql5=hql5+"or disk_state_computer='"+strComputerIds[i]+"'";}
			String hql6="delete from xnjcpt_disk_state where "+hql5;
		Query query=this.getSession().createQuery(hql6);
		query.executeUpdate();}
		String hql6="";
		for(int i=0;i<strComputerIds.length;i++){
			if(i==0){hql6="memory_computer='"+strComputerIds[i]+"'";}
			else{hql6=hql6+"or memory_computer='"+strComputerIds[i]+"'";}
			String hql7="delete from xnjcpt_memory where "+hql6;
		Query query=this.getSession().createQuery(hql7);
		query.executeUpdate();}
		String hql7="";
		for(int i=0;i<strComputerIds.length;i++){
			if(i==0){hql7="memory_state_computer='"+strComputerIds[i]+"'";}
			else{hql7=hql7+"or memory_state_computer='"+strComputerIds[i]+"'";}
			String hql8="delete from xnjcpt_memory_state where "+hql7;
		Query query=this.getSession().createQuery(hql8);
		query.executeUpdate();}
		String hql8="";
		for(int i=0;i<strComputerIds.length;i++){
			if(i==0){hql8="net_computer='"+strComputerIds[i]+"'";}
			else{hql8=hql8+"or net_computer='"+strComputerIds[i]+"'";}
			String hql9="delete from xnjcpt_net where "+hql8;
		Query query=this.getSession().createQuery(hql9);
		query.executeUpdate();}
		String hql9="";
		for(int i=0;i<strComputerIds.length;i++){
			if(i==0){hql9="disk_state_computer='"+strComputerIds[i]+"'";}
			else{hql9=hql9+"or disk_state_computer='"+strComputerIds[i]+"'";}
			String hql10="delete from xnjcpt_net_state where "+hql9;
		Query query=this.getSession().createQuery(hql10);
		query.executeUpdate();}
		String hql10="";
		for(int i=0;i<strComputerIds.length;i++){
			if(i==0){hql10="io_state_computer='"+strComputerIds[i]+"'";}
			else{hql10=hql10+"or io_state_computer='"+strComputerIds[i]+"'";}
			String hql11="delete from xnjcpt_io_state where "+hql10;
		Query query=this.getSession().createQuery(hql11);
		query.executeUpdate();}
		}
	@Override
	public int getCountComputer(computerInformationVO cv) {
		String user_id = (String) ActionContext.getContext().getSession().get("user_id");
		String hql = "select count(*) from xnjcpt_computer as xc ,xnjcpt_user_computer as xuc , "
				+ "xnjcpt_disk as disk , xnjcpt_cpu as cpu , xnjcpt_memory as memory "
				+ "where xc.computer_id = xuc.user_computer_computer"
				+ " and xc.computer_id = disk.disk_computer and xc.computer_id = cpu.cpu_computer and xc.computer_id=memory.memory_computer"
				+ " and xuc.user_computer_user ='"+user_id+"'";
		System.out.println(hql);
		if (cv.getSearchContent() != null && !"".equals(cv.getSearchContent().trim())) {
			hql = hql + " and xc.computer_ip like '%" + cv.getSearchContent().trim() + "%'";
		}
		
		Query query = this.getSession().createQuery(hql);
		long count = (long) query.uniqueResult();
		return (int) count;
	}
	@Override
	public void getComputerByPage(computerInformationVO cv) {
		String user_id = (String) ActionContext.getContext().getSession().get("user_id");
		String hql = "select new com.xnjcpt.domain.DTO.UserComputerPageDTO(xc.computer_id,xc.computer_ip,xc.computer_name,cpu.cpu_model,disk.disk_size,memory.memory_size) from xnjcpt_computer as xc ,xnjcpt_user_computer as xuc , "
				+ "xnjcpt_disk as disk , xnjcpt_cpu as cpu , xnjcpt_memory as memory "
				+ "where xc.computer_id = xuc.user_computer_computer"
				+ " and xc.computer_id = disk.disk_computer and xc.computer_id = cpu.cpu_computer and xc.computer_id=memory.memory_computer"
				+ " and xuc.user_computer_user = '"+user_id+"'";
		if (cv.getSearchContent() != null && !"".equals(cv.getSearchContent().trim())) {
			hql = hql + " and xc.computer_ip like '%" + cv.getSearchContent().trim() + "%'";
		}
		hql = hql + " order by xc.computer_gmt_create desc";
		Query query = this.getSession().createQuery(hql)
				.setFirstResult((cv.getCurrPage() - 1) * cv.getPageSize())
				.setMaxResults(cv.getPageSize());
		System.out.println(hql);
		List<UserComputerPageDTO> list = query.list();
		cv.setList(list);
	}
	public xnjcpt_computer getXc() {
		return xc;
	}
	public void setXc(xnjcpt_computer xc) {
		this.xc = xc;
	}
	public xnjcpt_user_computer getXuc() {
		return xuc;
	}
	public void setXuc(xnjcpt_user_computer xuc) {
		this.xuc = xuc;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}	
}