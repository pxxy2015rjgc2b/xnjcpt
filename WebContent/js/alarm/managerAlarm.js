/**
 * 
 */

function updateAlarm(event){
	$
	.confirm({
		title : '修改警报',
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
						formData.append("xnjcpt_alarm.alarm_id",event.id);
						$.ajax({
							url : '/xnjcpt/alarm/alarm_updateAlarmById',
							type : 'POST',
							data : formData,
							contentType : false, // 注意这里应设为false
							processData : false,
							success : function(data) {
								if (data != "noLOgin") {
									if(data=="updateSuccess"){
										toastr.success("保存成功！");
										queryTemp.currPage = "1";
										loadData();
									}else{
										toastr.error("保存失败！请联系管理员");
									}
								} else {
									// 登录验证
									loginIntercptor();
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
								$.ajax({
									type : 'GET',
									url : '/xnjcpt/alarm/alarm_getAlarmById?alarm_id='+event.id,
									success:function(data){
										if(data!="noLogin"){
											var returnData = JSON.parse(data);
											$('#threshold_').val(returnData.alarm_threshold_value);
											$('#type_').val(returnData.alarm_type);
											$('#use_').val(returnData.alarm_state);
											$('#computer_').val(returnData.alarm_computer);
											$('#type_').change();
										}
										else{
											// 做登录判断
											loginIntercptor();
										}
									}
								})
							} else {
								// 做登录判断
								loginIntercptor();
							}
						}
					})
		}
	});
}


function deleteAlarm(event) {
	$
			.confirm({
				title : "<i class='fa fa-exclamation-triangle' style='color:red;' aria-hidden='true'></i>是否确定删除",
				type : "red",
				content : "",
				autoClose : "close|10000",
				buttons : {
					sure : {
						text : '确定',
						btnClass : 'btn-blue',
						action : function() {
							$
									.ajax({
										url : '/xnjcpt/alarm/alarm_deleteAlarm',
										type : 'POST',
										data : {
											'xnjcpt_alarm.alarm_id' : event.id
										},
										success : function(data) {
											if (data != "noLogin") {
												if (data == 'deleteSuccess') {
													toastr.success("删除成功");
													queryTemp.currPage == 1;
													loadData();
												} else {
													toastr.error("删除失败");
												}
											} else {
												loginIntercptor();
											}
										}
									});
						}
					},
					close : {
						text : '关闭',
						btnClass : 'btn-red',
						action : function() {

						}
					}
				}
			});
}