/**
 * 
 */
function CpuSystemInfor(startTime,endTime) {
	$('#cpuSystem').hide();
	$('#systemLoading').show();
	var computer_id = getId();
	getStartTime();
	var myChart = echarts.init(document.getElementById('cpuSystem'));

	var data;
	$
			.ajax({
				url : '/xnjcpt/monitor/monitor_getCpuSystemState?monitorPageVO.computer_id='
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
						$('#systemLoading').hide();
						$('#cpuSystem').show();
					} else {
						loginIntercptor();
					}
				}
			})
	option = {
		title : {
			text : 'system利用率'
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
