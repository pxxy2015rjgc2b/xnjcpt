/**
 * 
 */
function updateStatus(event){
	$.ajax({
		url:'/xnjcpt/alarm/alarm_updateStatus?xnjcpt_alarm_message.message_id='+event.id,
		type:'GET',
		success:function(data){
			if(data!="noLogin"){
				if(data=="updateSuccess"){
					toastr.success("已读");
					loadData();
					getCountMessage();
				}else{
					toastr.error("已读操作失败");
				}
			}else{
				loginIntercptor();
			}
		}
	})
}
function deleteMessage(event){
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
					$.ajax({
						url:'/xnjcpt/alarm/alarm_deleteMessage?xnjcpt_alarm_message.message_id='+event.id,
						type:'GET',
						success:function(data){
							if(data!="noLogin"){
								if(data=="deleteSuccess"){
									toastr.success("删除成功！");
									loadData();
									getCountMessage();
								}else{
									toastr.error("删除操作失败");
								}
							}else{
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