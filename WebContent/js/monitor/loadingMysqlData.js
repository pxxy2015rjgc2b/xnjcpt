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
			text : 'user利用率',
			textStyle: {
		        fontSize: 18,
		        fontWeight: 'bolder',
		        color: '#008acd'          // 主标题文字颜色
		    },
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
			splitLine:{show: false},//去除网格线
            //splitArea : {show : true},//保留网格区域
			axisLine: {
                lineStyle: {
                    type: 'solid',
                    color: '#008acd',//左边线的颜色
                    width:'2'//坐标线的宽度
                }
            },
            axisLabel: {
                textStyle: {
                    color: '#333333',//坐标值得具体的颜色

                }
            }
		},
		yAxis : {
			type : 'value',
			boundaryGap : [ 0, '100%' ],
			splitLine:{show: true},//去除网格线
            //splitArea : {show : true},//保留网格区域
			axisLine: {
                 lineStyle: {
                     type: 'solid',
                     color: '#008acd',//左边线的颜色
                     width:'2'//坐标线的宽度
                 }
             },
             axisLabel: {
                 textStyle: {
                     color: '#333333',//坐标值得具体的颜色

                 }
             }
		},
		dataZoom: [
            {
                type: 'slider',
                show: true,
                xAxisIndex: [0],
                handleSize: 20,//滑动条的 左右2个滑动条的大小
                height: 8,//组件高度
                left: 30, //左边的距离
                right: 40,//右边的距离
                bottom: 10,//右边的距离
                handleColor: '#ddd',//h滑动图标的颜色
                handleStyle: {
                    borderColor: "#cacaca",
                    borderWidth: "1",
                    shadowBlur: 2,
                    background: "#ddd",
                    shadowColor: "#ddd",
                },
                fillerColor: new echarts.graphic.LinearGradient(1, 0, 0, 0, [{
                    //给颜色设置渐变色 前面4个参数，给第一个设置1，第四个设置0 ，就是水平渐变
                    //给第一个设置0，第四个设置1，就是垂直渐变
                    offset: 0,
                    color: '#b1e7e8'
                }, {
                    offset: 1,
                    color: '#b1e7e8'
                }]),
                backgroundColor: '#ddd',//两边未选中的滑动条区域的颜色
                showDataShadow: false,//是否显示数据阴影 默认auto
                showDetail: false,//即拖拽时候是否显示详细数值信息 默认true
                handleIcon: 'M-292,322.2c-3.2,0-6.4-0.6-9.3-1.9c-2.9-1.2-5.4-2.9-7.6-5.1s-3.9-4.8-5.1-7.6c-1.3-3-1.9-6.1-1.9-9.3c0-3.2,0.6-6.4,1.9-9.3c1.2-2.9,2.9-5.4,5.1-7.6s4.8-3.9,7.6-5.1c3-1.3,6.1-1.9,9.3-1.9c3.2,0,6.4,0.6,9.3,1.9c2.9,1.2,5.4,2.9,7.6,5.1s3.9,4.8,5.1,7.6c1.3,3,1.9,6.1,1.9,9.3c0,3.2-0.6,6.4-1.9,9.3c-1.2,2.9-2.9,5.4-5.1,7.6s-4.8,3.9-7.6,5.1C-285.6,321.5-288.8,322.2-292,322.2z',
                filterMode: 'filter',
            },
            //下面这个属性是里面拖到
            {
                type: 'inside',
                show: true,
                xAxisIndex: [0],
                start: 1,
                end: 100
            }
        ],
		series : [ {
			name : '模拟数据uerinfo',
			type : 'line',
			showSymbol :false,
			areaStyle: {
	                normal: {
	                	color:"#8fdcdd",
	                }  //面积图
	            },
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
					color : '#34c8ca' // 0% 处的颜色
				}, {
					offset : 1,
					color : '#34c8ca' // 100% 处的颜色
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
			text : '数据库',
			textStyle: {
		        fontSize: 18,
		        fontWeight: 'bolder',
		        color: '#008acd'          // 主标题文字颜色
		    },
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
			splitLine:{show: false},//去除网格线
            //splitArea : {show : true},//保留网格区域
			axisLine: {
                lineStyle: {
                    type: 'solid',
                    color: '#008acd',//左边线的颜色
                    width:'2'//坐标线的宽度
                }
            },
            axisLabel: {
                textStyle: {
                    color: '#333333',//坐标值得具体的颜色

                }
            }
		},
		yAxis : {
			type : 'value',
			boundaryGap : [ 0, '100%' ],
			splitLine:{show: true},//去除网格线
            //splitArea : {show : true},//保留网格区域
			axisLine: {
                 lineStyle: {
                     type: 'solid',
                     color: '#008acd',//左边线的颜色
                     width:'2'//坐标线的宽度
                 }
             },
             axisLabel: {
                 textStyle: {
                     color: '#333333',//坐标值得具体的颜色

                 }
             }
		},
		dataZoom: [
            {
                type: 'slider',
                show: true,
                xAxisIndex: [0],
                handleSize: 20,//滑动条的 左右2个滑动条的大小
                height: 8,//组件高度
                left: 30, //左边的距离
                right: 40,//右边的距离
                bottom: 10,//右边的距离
                handleColor: '#ddd',//h滑动图标的颜色
                handleStyle: {
                    borderColor: "#cacaca",
                    borderWidth: "1",
                    shadowBlur: 2,
                    background: "#ddd",
                    shadowColor: "#ddd",
                },
                fillerColor: new echarts.graphic.LinearGradient(1, 0, 0, 0, [{
                    //给颜色设置渐变色 前面4个参数，给第一个设置1，第四个设置0 ，就是水平渐变
                    //给第一个设置0，第四个设置1，就是垂直渐变
                    offset: 0,
                    color: '#b1e7e8'
                }, {
                    offset: 1,
                    color: '#b1e7e8'
                }]),
                backgroundColor: '#ddd',//两边未选中的滑动条区域的颜色
                showDataShadow: false,//是否显示数据阴影 默认auto
                showDetail: false,//即拖拽时候是否显示详细数值信息 默认true
                handleIcon: 'M-292,322.2c-3.2,0-6.4-0.6-9.3-1.9c-2.9-1.2-5.4-2.9-7.6-5.1s-3.9-4.8-5.1-7.6c-1.3-3-1.9-6.1-1.9-9.3c0-3.2,0.6-6.4,1.9-9.3c1.2-2.9,2.9-5.4,5.1-7.6s4.8-3.9,7.6-5.1c3-1.3,6.1-1.9,9.3-1.9c3.2,0,6.4,0.6,9.3,1.9c2.9,1.2,5.4,2.9,7.6,5.1s3.9,4.8,5.1,7.6c1.3,3,1.9,6.1,1.9,9.3c0,3.2-0.6,6.4-1.9,9.3c-1.2,2.9-2.9,5.4-5.1,7.6s-4.8,3.9-7.6,5.1C-285.6,321.5-288.8,322.2-292,322.2z',
                filterMode: 'filter',
            },
            //下面这个属性是里面拖到
            {
                type: 'inside',
                show: true,
                xAxisIndex: [0],
                start: 1,
                end: 100
            }
        ],
		series : [ {
			name : '模拟数据uerinfo',
			type : 'line',
			smooth:true, 
			showSymbol :false,
			areaStyle: {
	                normal: {
	                	color:"#8fdcdd",
	                }  //面积图
	            },
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
					color : '#34c8ca' // 0% 处的颜色
				}, {
					offset : 1,
					color : '#34c8ca' // 100% 处的颜色
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