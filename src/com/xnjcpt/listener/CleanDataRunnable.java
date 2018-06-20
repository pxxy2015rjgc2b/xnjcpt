package com.xnjcpt.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xnjcpt.service.computer.ComputerService;

public class CleanDataRunnable implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			ApplicationContext ctx = new ClassPathXmlApplicationContext(
					new String[] { "applicationContext.xml", "spring/computer.xml" });// 手动创建spring
																						// //
																						// bean工厂
			ComputerService computerService = (ComputerService) ctx.getBean("computerService");
			computerService.cleanData();
			System.out.println(computerService);
			System.out.println("执行了删除");
			try {
				Thread.sleep(24 * 60 * 60 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
