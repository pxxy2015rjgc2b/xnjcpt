/**
 * 
 */

function intoMonitor(event , flag){
	if(flag=="1"){
		window.location.href="/xnjcpt/skip/skip_intoMonitor?computer_id="+event.id;
	}
	else{
		toastr.error("请等待安装客户端");
	}
}

function deleteComputer(event) {
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
										url : '/xnjcpt/computer/computer_deleteComputerById',
										type : 'POST',
										data : {
											'xnjcpt_computer.computer_id' : event.id
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