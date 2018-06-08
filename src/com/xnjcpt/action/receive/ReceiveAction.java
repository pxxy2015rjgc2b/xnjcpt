package com.xnjcpt.action.receive;

import com.xnjcpt.domain.DO.*;
import com.xnjcpt.service.receive.ReceiveService;

public class ReceiveAction {
	//注入业务层的类
	private ReceiveService receiveService;

	public void setReceiveService(ReceiveService receiveService) {
		this.receiveService = receiveService;
	}
	
	private xnjcpt_computer xnjcpt_computer;
	private xnjcpt_cpu xnjcpt_cpu;
	private xnjcpt_memory xnjcpt_memory;
	private xnjcpt_disk xnjcpt_disk;
	private xnjcpt_net xnjcpt_net;
	private xnjcpt_cpu_state xnjcpt_cpu_state;
	private xnjcpt_memory_state xnjcpt_memory_state;
	private xnjcpt_io_state xnjcpt_io_state;
	private xnjcpt_disk_state xnjcpt_disk_state;
	private xnjcpt_net_state xnjcpt_net_state;
	
	
	/**
	 * 获取主机信息，存入数据库
	 */
	public void getComputerInfor(){
		System.out.println(xnjcpt_computer.getComputer_name()+"sunyi");
		receiveService.updateComputerInfor(xnjcpt_computer);
	}
	
	/**
	 * 
	 * 获取CPU信息，更改或存储cpu信息
	 */
	public void getCpuInfo(){
		System.out.println("getCpuInfo执行！");
		String ip = xnjcpt_computer.getComputer_ip();
		receiveService.updateCpuInfor(ip,xnjcpt_cpu);
		
	}
	
	/**
	 * 获取内存信息，更改或存储内存信息
	 * @return
	 */
	public void getMemoryInfor(){
		System.out.println("getMemoryInfo执行！");
		String ip = xnjcpt_computer.getComputer_ip();
		receiveService.updateMemoryInfor(ip,xnjcpt_memory);
	}
	
	/**
	 * 获取磁盘信息，更改或存储磁盘信息
	 * @return
	 */
	public void getDiskInfor(){
		System.out.println("getDiskInfor执行！");
		String ip = xnjcpt_computer.getComputer_ip();
		receiveService.updateDiskInfor(ip,xnjcpt_disk);
	}
	
	/**
	 * 获取网络信息，更改或存储网络信息
	 * @return
	 */
	public void getNetInfor(){
		System.out.println("getNetInfor执行！");
		String ip = xnjcpt_computer.getComputer_ip();
		receiveService.updateNetInfor(ip,xnjcpt_net);
	}
	
	/**
	 * 获取cpu的状态信息，存储cpu状态信息
	 * @return
	 */
	public void getCpuStateInfor(){
		System.out.println("getCpuStateInfor执行！");
		String ip=xnjcpt_computer.getComputer_ip();
		receiveService.saveCpuStateInfor(ip,xnjcpt_cpu_state);
	}
	/**
	 * 获取内存信息状态，存储内存状态信息
	 * @return
	 */
	public void getMemoryStateInfor(){
		System.out.println("getMemoryInfor执行！");
		String ip=xnjcpt_computer.getComputer_ip();
		receiveService.saveMemoryStateInfor(ip,xnjcpt_memory_state);
	}
	/**
	 * 获取io状态信息，存储io状态信息
	 * @return
	 */
	public void getIoStateInfor(){
		System.out.println("getIoStateInfor执行！");
		String ip=xnjcpt_computer.getComputer_ip();
		receiveService.saveIoStateInfor(ip,xnjcpt_io_state);
	}
	/**
	 * 获取磁盘状态信息，存储磁盘状态信息
	 * @return
	 */
	public void getDiskStateInfor(){
		System.out.println("getDiskStateInfor执行！");
		String ip=xnjcpt_computer.getComputer_ip();
		receiveService.saveDiskInfor(ip,xnjcpt_disk_state);
	}
	
	/**
	 * 获取网络状态信息，保存网络状态信息
	 * @return
	 */
	public void getNetStateInfor(){
		System.out.println("getNetStateInfor执行！");
		String ip=xnjcpt_computer.getComputer_ip();
		receiveService.saveNetStateInfor(ip,xnjcpt_net_state);
	}
	public xnjcpt_computer getXnjcpt_computer() {
		return xnjcpt_computer;
	}

	public void setXnjcpt_computer(xnjcpt_computer xnjcpt_computer) {
		this.xnjcpt_computer = xnjcpt_computer;
	}

	public ReceiveService getReceiveService() {
		return receiveService;
	}

	public xnjcpt_cpu getXnjcpt_cpu() {
		return xnjcpt_cpu;
	}

	public void setXnjcpt_cpu(xnjcpt_cpu xnjcpt_cpu) {
		this.xnjcpt_cpu = xnjcpt_cpu;
	}

	public xnjcpt_memory getXnjcpt_memory() {
		return xnjcpt_memory;
	}

	public void setXnjcpt_memory(xnjcpt_memory xnjcpt_memory) {
		this.xnjcpt_memory = xnjcpt_memory;
	}

	public xnjcpt_disk getXnjcpt_disk() {
		return xnjcpt_disk;
	}
	

	public void setXnjcpt_disk(xnjcpt_disk xnjcpt_disk) {
		this.xnjcpt_disk = xnjcpt_disk;
	}

	public xnjcpt_net getXnjcpt_net() {
		return xnjcpt_net;
	}

	public void setXnjcpt_net(xnjcpt_net xnjcpt_net) {
		this.xnjcpt_net = xnjcpt_net;
	}

	public xnjcpt_cpu_state getXnjcpt_cpu_state() {
		return xnjcpt_cpu_state;
	}

	public void setXnjcpt_cpu_state(xnjcpt_cpu_state xnjcpt_cpu_state) {
		this.xnjcpt_cpu_state = xnjcpt_cpu_state;
	}

	public xnjcpt_memory_state getXnjcpt_memory_state() {
		return xnjcpt_memory_state;
	}

	public void setXnjcpt_memory_state(xnjcpt_memory_state xnjcpt_memory_state) {
		this.xnjcpt_memory_state = xnjcpt_memory_state;
	}

	public xnjcpt_io_state getXnjcpt_io_state() {
		return xnjcpt_io_state;
	}

	public void setXnjcpt_io_state(xnjcpt_io_state xnjcpt_io_state) {
		this.xnjcpt_io_state = xnjcpt_io_state;
	}

	public xnjcpt_disk_state getXnjcpt_disk_state() {
		return xnjcpt_disk_state;
	}

	public void setXnjcpt_disk_state(xnjcpt_disk_state xnjcpt_disk_state) {
		this.xnjcpt_disk_state = xnjcpt_disk_state;
	}

	public xnjcpt_net_state getXnjcpt_net_state() {
		return xnjcpt_net_state;
	}

	public void setXnjcpt_net_state(xnjcpt_net_state xnjcpt_net_state) {
		this.xnjcpt_net_state = xnjcpt_net_state;
	}
	
	
	
	
	

}
