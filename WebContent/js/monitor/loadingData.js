/**
 * 
 */
$(function(){
	today();
})
function today(){
	var startTime  = getStartTime();
	var endTime = getEndTime();
	CpuIdleInfor(startTime, endTime);
	CpuIowaitInfor(startTime, endTime);
	CpuSystemInfor(startTime, endTime);
	CpuUserInfor(startTime, endTime);
	DiskSize();
	InBandwidth(startTime, endTime);
	InPackage(startTime, endTime);
	IoUtil(startTime, endTime);
	MemoryInfor(startTime, endTime);
	OutBandwidth(startTime, endTime);
	OutPackage(startTime, endTime);
	OutTraffic(startTime, endTime);
	TcpNumber(startTime, endTime);
}
function sevenDay(){
	var startTime = getSevenStartTime();
	var endTime = getEndTime();
	CpuIdleInfor(startTime, endTime);
	CpuIowaitInfor(startTime, endTime);
	CpuSystemInfor(startTime, endTime);
	CpuUserInfor(startTime, endTime);
	DiskSize();
	InBandwidth(startTime, endTime);
	InPackage(startTime, endTime);
	IoUtil(startTime, endTime);
	MemoryInfor(startTime, endTime);
	OutBandwidth(startTime, endTime);
	OutPackage(startTime, endTime);
	OutTraffic(startTime, endTime);
	TcpNumber(startTime, endTime);
}