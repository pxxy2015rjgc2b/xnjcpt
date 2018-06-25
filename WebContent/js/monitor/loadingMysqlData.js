/**
 * 
 */
$(function(){
	today();
})
function today(){
	var startTime  = getStartTime();
	var endTime = getEndTime();
	dps(startTime,endTime);
	tps(startTime,endTime);
}
function sevenDay(){
	var startTime = getSevenStartTime();
	var endTime = getEndTime();
	dps(startTime,endTime);
	tps(startTime,endTime);
}
function dps(startTime,endTime) {
	$('#dps').hide();
	$('#dpsLoading').show();
	var computer_id = getId();
	var myChart = echarts.init(document.getElementById('dps'));
	var data;
	$
			.ajax({
				url : '/xnjcpt/monitor/monitor_getMysqlQPSData?monitorPageVO.computer_id='
						+ computer_id
						+ '&monitorPageVO.time_start='
						+ startTime
						+ '&monitorPageVO.time_end='
						+ endTime,
				type : 'GET',
				async : false,
				success : function(datas) {
					if (data != "noLogin") {
						data = JSON.parse(datas);
						data = fomatterDataLine(data);
						$('#dpsLoading').hide();
						$('#dps').show();
					} else {
						loginIntercptor();
					}
				}
			})
	option = {
		title : {
			text : '每秒查询量'
		},
		// 用来显示鼠标浮停内容
		tooltip : {
			trigger : 'axis',
			formatter : function(params) {
				params = params[0];
				return params.name + ' : ' + params.value[1] + "<br>粒度：10秒";
			},
			axisPointer : {
				animation : false
			}
		},
		xAxis : {
			type : 'time',
			splitLine : {
				show : false
			}
		},
		yAxis : {
			type : 'value',
			boundaryGap : [ 0, '100%' ],
			splitLine : {
				show : false
			}
		},
		series : [ {
			name : '模拟数据',
			type : 'line',
			showSymbol : false,
			hoverAnimation : false,
			data : data
		} ],
		lineStyle : {
			color : {
				type : 'linear',
				x : 0,
				y : 0,
				x2 : 0,
				y2 : 1,
				colorStops : [ {
					offset : 0,
					color : 'red' // 0% 处的颜色
				}, {
					offset : 1,
					color : 'blue' // 100% 处的颜色
				} ],
				globalCoord : false
			// 缺省为 false
			}
		}
	};
	/*
	 * setInterval(function () {
	 * 
	 * for (var i = 0; i < 5; i++) { data.shift(); data.push(randomData()); }
	 * 
	 * myChart.setOption({ series: [{ data: data }] }); }, 1000);
	 */// 实时动态改变数据
	myChart.setOption(option);
}
function tps(startTime,endTime) {
	$('#tps').hide();
	$('#tpsLoading').show();
	var computer_id = getId();
	var myChart = echarts.init(document.getElementById('tps'));
	var data;
	$
			.ajax({
				url : '/xnjcpt/monitor/monitor_getMysqlTPSData?monitorPageVO.computer_id='
						+ computer_id
						+ '&monitorPageVO.time_start='
						+ startTime
						+ '&monitorPageVO.time_end='
						+ endTime,
				type : 'GET',
				async : false,
				success : function(datas) {
					if (data != "noLogin") {
						data = JSON.parse(datas);
						data = fomatterDataLine(data);
						$('#tpsLoading').hide();
						$('#tps').show();
					} else {
						loginIntercptor();
					}
				}
			})
	option = {
		title : {
			text : '每秒事物量'
		},
		// 用来显示鼠标浮停内容
		tooltip : {
			trigger : 'axis',
			formatter : function(params) {
				params = params[0];
				return params.name + ' : ' + params.value[1] + "<br>粒度：10秒";
			},
			axisPointer : {
				animation : false
			}
		},
		xAxis : {
			type : 'time',
			splitLine : {
				show : false
			}
		},
		yAxis : {
			type : 'value',
			boundaryGap : [ 0, '100%' ],
			splitLine : {
				show : false
			}
		},
		series : [ {
			name : '模拟数据',
			type : 'line',
			showSymbol : false,
			hoverAnimation : false,
			data : data
		} ],
		lineStyle : {
			color : {
				type : 'linear',
				x : 0,
				y : 0,
				x2 : 0,
				y2 : 1,
				colorStops : [ {
					offset : 0,
					color : 'red' // 0% 处的颜色
				}, {
					offset : 1,
					color : 'blue' // 100% 处的颜色
				} ],
				globalCoord : false
			// 缺省为 false
			}
		}
	};
	/*
	 * setInterval(function () {
	 * 
	 * for (var i = 0; i < 5; i++) { data.shift(); data.push(randomData()); }
	 * 
	 * myChart.setOption({ series: [{ data: data }] }); }, 1000);
	 */// 实时动态改变数据
	myChart.setOption(option);
}