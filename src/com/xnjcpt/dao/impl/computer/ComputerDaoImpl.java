package com.xnjcpt.dao.impl.computer;
import java.util.List;
import org.apache.poi.ss.formula.functions.T;
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
		for(int i=0;i<strComputerIds.length;i++){
		Query query=this.getSession().createQuery("delete from xnjcpt_computer where computer_id in  ('"+strComputerIds[i]+"')");
		query.executeUpdate();
		Query query1=this.getSession().createQuery("delete from xnjcpt_user_computer where user_computer_computer in  ('"+strComputerIds[i]+"')");
		query1.executeUpdate();
		Query query2=this.getSession().createQuery("delete from xnjcpt_cpu where cpu_computer in  ('"+strComputerIds[i]+"')");
		query2.executeUpdate();
		Query query3=this.getSession().createQuery("delete from xnjcpt_cpu_state where cpu_state_computer in  ('"+strComputerIds[i]+"')");
		query3.executeUpdate();
		Query query4=this.getSession().createQuery("delete from xnjcpt_disk where disk_computer in  ('"+strComputerIds[i]+"')");
		query4.executeUpdate();
		Query query5=this.getSession().createQuery("delete from xnjcpt_disk_state where disk_state_computer in  ('"+strComputerIds[i]+"')");
		query5.executeUpdate();
		Query query6=this.getSession().createQuery("delete from xnjcpt_memory where memory_computer in  ('"+strComputerIds[i]+"')");
		query6.executeUpdate();
		Query query7=this.getSession().createQuery("delete from xnjcpt_memory_state where memory_state_computer in  ('"+strComputerIds[i]+"')");
		query7.executeUpdate();
		Query query8=this.getSession().createQuery("delete from xnjcpt_net where net_computer in  ('"+strComputerIds[i]+"')");
		query8.executeUpdate();
		Query query9=this.getSession().createQuery("delete from xnjcpt_net_state where disk_state_computer in  ('"+strComputerIds[i]+"')");
		query9.executeUpdate();
		Query query10=this.getSession().createQuery("delete from xnjcpt_io_state where io_state_computer in  ('"+strComputerIds[i]+"')");
		query10.executeUpdate();
		}}
	@Override
	public int getComputerCount() {
		String user_id = (String) ActionContext.getContext().getSession().get("user_id");
		String hql = "select user_computer_computer from xnjcpt_user_computer where user_computer_user ='"+user_id+"'";
		System.out.println(hql+"我");
		List<T>  list = getSession().createQuery(hql).list();
		int count=list.size();
		return count;
		}
	@Override
	public computerInformationVO getComputerInformation(computerInformationVO cv) {
		String user_id = (String) ActionContext.getContext().getSession().get("user_id");
		String hql = "select xc.computer_name,xc.computer_ip,cpu.cpu_model,memory.memory_size,disk.disk_size "
				+ "from xnjcpt_cpu as cpu,xnjcpt_memory as memory,xnjcpt_disk as disk,xnjcpt_user_computer as xuc,xnjcpt_computer as xc "
				+ "where cpu.cpu_computer = xc.computer_id "
				+ "and memory.memory_computer= xc.computer_id"
				+ " and disk.disk_computer=xc.computer_id"
				+ " and xc.computer_id=xuc.user_computer_computer"
				+ " and xuc.user_computer_user='"+user_id+"'"; 
		List<UserComputerPageDTO> result=getSession().createQuery(hql).setFirstResult((cv.getCurrPage() - 1) * cv.getPageSize()).setMaxResults(cv.getPageSize()).list();
		 cv.setList(result);
		 return cv;
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