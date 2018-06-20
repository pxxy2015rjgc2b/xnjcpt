package com.xnjcpt.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 
 * @author 作者孙毅 创建监听器用于清理七天前过期数据
 */
public class CleanOutTimeDataListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		Thread thread = new Thread(new CleanDataRunnable());
		thread.start();
	}

}
