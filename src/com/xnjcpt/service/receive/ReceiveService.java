package com.xnjcpt.service.receive;

import com.xnjcpt.domain.DO.xnjcpt_computer;

public interface ReceiveService {

	void updateComputerInfor(com.xnjcpt.domain.DO.xnjcpt_computer xnjcpt_computer);

	void updateCpuInfor(String ip, com.xnjcpt.domain.DO.xnjcpt_cpu xnjcpt_cpu);

	void updateMemoryInfor(String ip, com.xnjcpt.domain.DO.xnjcpt_memory xnjcpt_memory);

	void updateDiskInfor(String ip, com.xnjcpt.domain.DO.xnjcpt_disk xnjcpt_disk);

	void updateNetInfor(String ip, com.xnjcpt.domain.DO.xnjcpt_net xnjcpt_net);

	void saveCpuStateInfor(String ip, com.xnjcpt.domain.DO.xnjcpt_cpu_state xnjcpt_cpu_state);

	void saveMemoryStateInfor(String ip, com.xnjcpt.domain.DO.xnjcpt_memory_state xnjcpt_memory_state);

	void saveIoStateInfor(String ip, com.xnjcpt.domain.DO.xnjcpt_io_state xnjcpt_io_state);

	void saveDiskInfor(String ip, com.xnjcpt.domain.DO.xnjcpt_disk_state xnjcpt_disk_state);

	void saveNetStateInfor(String ip, com.xnjcpt.domain.DO.xnjcpt_net_state xnjcpt_net_state);

	


}
