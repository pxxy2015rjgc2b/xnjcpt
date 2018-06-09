/**
 * 
 */

function createAlarm() {
	$
			.confirm({
				title : '<i class="fa fa-edit"></i>新增警报',
				boxWidth : '500px',
				useBootstrap : false,
				content : '<div style="margin:0 auto; width:400px;"><form id="alarmForm"><table>'
						+ '<tr><td>请选择主机：</td><td><select name="xnjcpt_alarm.alarm_computer" id="computer_" class="form-control"></select><td></tr>'
						+ '<tr><td>请选择警报类型：</td><td><select name="xnjcpt_alarm.alarm_type" id="type_" class="form-control" onchange="changeUnits(this)"><option value="CPU利用率">CPU利用率</option>'
						+ '<option value="内存利用率">内存利用率</option>'
						+ '<option value="出带宽">出带宽</option>'
						+ '<option value="入带宽">入带宽</option>'
						+ '<option value="出包量">出包量</option>'
						+ '<option value="入包量">入包量</option>'
						+ '</select></td></tr>'
						+ '<tr><td>请填写警报阈值：</td><td><input name="xnjcpt_alarm.alarm_threshold_value" id="threshold_" type="text" class="form-control" placeholder="大于某个值发出警报"><td id="units_">单位：%</td></tr>'
						+ '<tr><td>请选择是否启用：</td><td><select name="xnjcpt_alarm.alarm_state" id="use_" class="form-control"><option value="0">不启用</option><option value="1">启用</option></select></td></tr>'
						+ '</table></form></div>',
				type : 'blue',
				buttons : {
					cancle : {
						text : '关闭',
						btnClass : 'btn-red'
					},
					save : {
						text : '保存',
						btnClass : 'btn-blue',
						action : function() {
							var threshold_value = document
									.getElementById("threshold_").value;
							var patt = /^([0-9]|[\.])+$/;
							if (patt.test(threshold_value)) {
								var formData = new FormData(document
										.getElementById("alarmForm"));
								$.ajax({
									url : '/xnjcpt/alarm/alarm_saveAlarm',
									type : 'POST',
									data : formData,
									contentType : false, // 注意这里应设为false
									processData : false,
									success : function(data) {
										if (data != "noLOgin") {
											if(data=="saveSuccess"){
												toastr.success("保存成功！");
											}else{
												toastr.error("保存失败！请联系管理员");
											}
										} else {
											// 登录验证
										}
									}
								})
							} else {
								toastr.error("警报阈值填写不符合规范");
								return false;
							}
						}
					}
				},
				onContentReady : function() {
					$
							.ajax({
								type : 'GET',
								url : '/xnjcpt/computer/computer_getComputerByUserId',
								success : function(data) {
									if (data != "noLogin") {
										var returnData = JSON.parse(data);
										var str = "";
										for (var int = 0; int < returnData.length; int++) {
											str = str
													+ "<option value="
													+ returnData[int].computer_id
													+ ">"
													+ returnData[int].computer_ip
													+ "</option>";
										}
										document.getElementById("computer_").innerHTML = str;
									} else {
										// 做登录判断
										loginIntercptor();
									}
								}
							})
				}
			});
}
function changeUnits(event) {
	var v = event.value;
	switch (v) {
	case 'CPU利用率':
		document.getElementById("units_").innerHTML = "单位：%";
		break;
	case '内存利用率':
		document.getElementById("units_").innerHTML = "单位：%";
		break;
	case '出带宽':
		document.getElementById("units_").innerHTML = "单位：Mbs";
		break;
	case '入带宽':
		document.getElementById("units_").innerHTML = "单位：Mbs";
		break;
	case '出包量':
		document.getElementById("units_").innerHTML = "单位：个";
		break;
	case '入包量':
		document.getElementById("units_").innerHTML = "单位：个";
		break;
	default:
		break;
	}
}