/**
 * 
 */

// 创建主机
// 输入ip-->验证ip地址是否合法-->验证ip地址是否重复
function createComputer() {
	$
			.confirm({
				title : '<i class="fa fa-edit"></i>新增主机',
				type : 'blue',
				content : '<input id="ip_" class="form-control" placeholder="请输入您要添加的主机ip地址">',
				buttons : {
					cancle : {
						text : '关闭',
						btnClass : 'btn-red'
					},
					save : {
						text : '保存',
						btnClass : 'btn-blue',
						action : function() {
							var patt = /^[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}$/;
							var flag = true;
							if (patt.test($('#ip_').val())) {
								$
										.ajax({
											url : '/xnjcpt/computer/computer_verifyIp',
											type : 'POST',
											data : {
												'xnjcpt_computer.computer_ip' : $(
														'#ip_').val()
											},
											async : false,
											success : function(data) {
												if (data != "noLogin") {
													if (data == "ipIsOk") {
														// 当我写到这里的时候我感觉自己是一个傻子
														// 像个傻子一样
														$
																.ajax({
																	url : '/xnjcpt/computer/computer_saveComputer',
																	type : 'POST',
																	data : {
																		'xnjcpt_computer.computer_ip' : $(
																				'#ip_')
																				.val()
																	},
																	success : function(
																			data) {
																		if (data != "noLogin") {
																			if(data=="saveSuccess"){
																				toastr.success("保存成功！");
																				loadData();
																			}
																			else{
																				toastr.error("保存异常请联系管理员");
																			}
																		} else {
																			loginIntercptor();
																		}
																	}
																})
													} else {
														toastr.error("该IP已被使用");
														flag = false;
													}
												} else {
													loginIntercptor();
												}
											}
										});
								return flag;
							} else {
								toastr.error("您输入的ip地址不合法");
								return false;
							}
						}
					}
				}
			})
}