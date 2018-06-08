package com.xnjcpt.dao.receive;

import com.xnjcpt.domain.DO.xnjcpt_computer;
import com.xnjcpt.domain.DO.xnjcpt_cpu;
import com.xnjcpt.domain.DO.xnjcpt_cpu_state;
import com.xnjcpt.domain.DO.xnjcpt_disk;
import com.xnjcpt.domain.DO.xnjcpt_disk_state;
import com.xnjcpt.domain.DO.xnjcpt_io_state;
import com.xnjcpt.domain.DO.xnjcpt_memory;
import com.xnjcpt.domain.DO.xnjcpt_memory_state;
import com.xnjcpt.domain.DO.xnjcpt_net;
import com.xnjcpt.domain.DO.xnjcpt_net_state;

public interface ReceiveDao {

	void updateComputerInfor(xnjcpt_computer xnjcpt_computer);

	void updateCpuInfo(String ip, xnjcpt_cpu xnjcpt_cpu);

	void updateMemoryInfor(String ip, xnjcpt_memory xnjcpt_memory);

	void updateDiskInfor(String ip, xnjcpt_disk xnjcpt_disk);

	void updateNetInfor(String ip, xnjcpt_net xnjcpt_net);

	void saveCpuStateInfor(String ip, xnjcpt_cpu_state xnjcpt_cpu_state);

	void saveMemoryStateInfor(String ip, xnjcpt_memory_state xnjcpt_memory_state);

	void saveIoStateInfor(String ip, xnjcpt_io_state xnjcpt_io_state);

	void saveDiskInfor(String ip, xnjcpt_disk_state xnjcpt_disk_state);

	void saveNetInfor(String ip, xnjcpt_net_state xnjcpt_net_state);

	

}
