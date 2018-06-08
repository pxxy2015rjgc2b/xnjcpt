package com.xnjcpt.action.receive;

import com.xnjcpt.domain.DO.*;
import com.xnjcpt.service.receive.ReceiveService;

public class ReceiveAction {
	//ע��ҵ������
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
	 * ��ȡ������Ϣ���������ݿ�
	 */
	public void getComputerInfor(){
		System.out.println(xnjcpt_computer.getComputer_name()+"sunyi");
		receiveService.updateComputerInfor(xnjcpt_computer);
	}
	
	/**
	 * 
	 * ��ȡCPU��Ϣ�����Ļ�洢cpu��Ϣ
	 */
	public void getCpuInfo(){
		System.out.println("getCpuInfoִ�У�");
		String ip = xnjcpt_computer.getComputer_ip();
		receiveService.updateCpuInfor(ip,xnjcpt_cpu);
		
	}
	
	/**
	 * ��ȡ�ڴ���Ϣ�����Ļ�洢�ڴ���Ϣ
	 * @return
	 */
	public void getMemoryInfor(){
		System.out.println("getMemoryInfoִ�У�");
		String ip = xnjcpt_computer.getComputer_ip();
		receiveService.updateMemoryInfor(ip,xnjcpt_memory);
	}
	
	/**
	 * ��ȡ������Ϣ�����Ļ�洢������Ϣ
	 * @return
	 */
	public void getDiskInfor(){
		System.out.println("getDiskInforִ�У�");
		String ip = xnjcpt_computer.getComputer_ip();
		receiveService.updateDiskInfor(ip,xnjcpt_disk);
	}
	
	/**
	 * ��ȡ������Ϣ�����Ļ�洢������Ϣ
	 * @return
	 */
	public void getNetInfor(){
		System.out.println("getNetInforִ�У�");
		String ip = xnjcpt_computer.getComputer_ip();
		receiveService.updateNetInfor(ip,xnjcpt_net);
	}
	
	/**
	 * ��ȡcpu��״̬��Ϣ���洢cpu״̬��Ϣ
	 * @return
	 */
	public void getCpuStateInfor(){
		System.out.println("getCpuStateInforִ�У�");
		String ip=xnjcpt_computer.getComputer_ip();
		receiveService.saveCpuStateInfor(ip,xnjcpt_cpu_state);
	}
	/**
	 * ��ȡ�ڴ���Ϣ״̬���洢�ڴ�״̬��Ϣ
	 * @return
	 */
	public void getMemoryStateInfor(){
		System.out.println("getMemoryInforִ�У�");
		String ip=xnjcpt_computer.getComputer_ip();
		receiveService.saveMemoryStateInfor(ip,xnjcpt_memory_state);
	}
	/**
	 * ��ȡio״̬��Ϣ���洢io״̬��Ϣ
	 * @return
	 */
	public void getIoStateInfor(){
		System.out.println("getIoStateInforִ�У�");
		String ip=xnjcpt_computer.getComputer_ip();
		receiveService.saveIoStateInfor(ip,xnjcpt_io_state);
	}
	/**
	 * ��ȡ����״̬��Ϣ���洢����״̬��Ϣ
	 * @return
	 */
	public void getDiskStateInfor(){
		System.out.println("getDiskStateInforִ�У�");
		String ip=xnjcpt_computer.getComputer_ip();
		receiveService.saveDiskInfor(ip,xnjcpt_disk_state);
	}
	
	/**
	 * ��ȡ����״̬��Ϣ����������״̬��Ϣ
	 * @return
	 */
	public void getNetStateInfor(){
		System.out.println("getNetStateInforִ�У�");
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
