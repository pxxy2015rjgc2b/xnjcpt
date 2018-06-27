var alarm_editVue;//编辑显示vue
var alarm_paginationQuery = {
		"currPage":'1',
		"totalPage" : '',
		"pageCount" : '',
		"totalCount " : ''
	}

window.onload=function(){
	console.log("显示");
	//警告显示的vue
	alarmVue=new Vue({
		el:".alarmList",
		data:{
			"currPage" : '1',
			"totalPage" : '1',
			"pageCount" : '0',
			"totalCount" : '0',
			"alarms" : ""
		},
	});
	show_alarmList();
}

//添加警报
function add_alarm() {
	$.confirm({
		title: '添加警报',
		content: '<div class="comfirm_box"><input placeholder="要添加的主机IP" name="alarm_computer" class="comfirm_input alarm_computer" type="text"/></div><div class="comfirm_box"><select class="comfirm_select alarm_type" name="alarm_type"  placeholder="警报类型"><option>CPU利用率</option><option>CPU利用率</option><option>内存利用率</option><option>出带宽</option><option>入带宽</option><option>出包量</option><option>入包量</option></select></div><div class="comfirm_box"><input class="comfirm_input alarm_threshold_value"  placeholder="警报阈值" name="alarm_threshold_value" type="text"/></div><div class="comfirm_box"><select class="comfirm_select alarm_state" name="alarm_state"  placeholder="是否启用"><option value="0">启用</option><option value="1">不启用</option></select></div>',
		type: 'blue',
		buttons: {
			确认: {
				btnClass: ' btn-blue',
				type: "blue",
				action: function() {
					var reg = /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/
					if($("input[name='alarm_computer']").val()!=""&&$(".alarm_type option:selected").text()!=""&&$(".alarm_state option:selected").val()!=""&&$("input[name='alarm_threshold_value']").val()!=""){
						if(reg.test($("input[name='alarm_computer']").val())){
							add_alarmAjax();
						}else{
							$.alert("ip地址格式不正确，请重新输入！");
							return false;
						}
						
					}else{
						$.alert("所有项为必填项，请完整填写！");
						return false;
					}
					
				}
			},
			取消: {
				btnClass: 'btn-red',
				type: "red",
				
			}
		}
	});
}
//添加警告ajax
function add_alarmAjax(){
	var formData=new FormData();
	formData.append("alarm_computer",$("input[name='alarm_computer']").val());
	formData.append("alarm_state",$(".alarm_state option:selected").val());
	formData.append("alarm_type",$(".alarm_type option:selected").text());
	formData.append("alarm_threshold_value",$("input[name='alarm_threshold_value']").val());	
	$.ajax({
		    url: "/xnjcpt/alarm/alarm_saveAlarmInfor",
	        type: "post",
	        data:formData,
	        //报错请加入以下三行，则ajax提交无问题
	        cache: false,  
	        processData: false,  
	        contentType: false,
	        success: function(result){
	        	if(result=="警报信息存储成功"){
	        		toastr.success("警报信息存储成功");
	        		show_alarmList();
	        	}
	        }
	});
}
//点击修改按钮
$(document).on('click',".edit_alarm",function(event){
	 var input_id=$(event.target).parent().siblings('.alarm_id').attr('id'); 
	 var formData=new FormData();
	 formData.append("alarm_id",input_id);
	 //获取要修改的数据
	 $.ajax({
		    url: "/xnjcpt/alarm/alarm_getAlarmInforById",
	        type: "post",
	        data:formData,
	        //报错请加入以下三行，则ajax提交无问题
	        cache: false,  
	        processData: false,  
	        contentType: false,
	        success: function(result){
	        	var result=JSON.parse(result);
	        	$("input[name='alarm_computer']").val(result.alarm_computer);
	        	$("input[name='alarm_threshold_value']").val(result.alarm_threshold_value);
	        	$(".alarm_type").val(result.alarm_type);
	        	$(".alarm_state").val(result.alarm_state);
	        }
	});
	 $.confirm({
			title: '编辑警报',
			content:'<div class="comfirm_box"><input placeholder="要添加的主机IP" disabled="true" name="alarm_computer" class="comfirm_input alarm_computer" type="text"/></div><div class="comfirm_box"><select class="comfirm_select alarm_type" name="alarm_type"  placeholder="警报类型"><option>CPU利用率</option><option>CPU利用率</option><option>内存利用率</option><option>出带宽</option><option>入带宽</option><option>出包量</option><option>入包量</option></select></div><div class="comfirm_box"><input class="comfirm_input alarm_threshold_value"  placeholder="警报阈值" name="alarm_threshold_value" type="text"/></div><div class="comfirm_box"><select class="comfirm_select alarm_state" name="alarm_state"  placeholder="是否启用"><option value="0">启用</option><option value="1">不启用</option></select></div>',
			type: 'orange',
			buttons: {
				确认: {
					/*btnClass: ' btn-blue',
					type: "blue",*/
					action: function() {
						edit_alarmAjax(input_id);
					}
				},
				取消: {
					/*btnClass: 'btn-red',
					type: "red",*/
				}
			}
	 });
});
//编辑警告Ajax
function edit_alarmAjax(input_id){
	var formData=new FormData();
	formData.append("xnjcpt_alarm.alarm_computer",$("input[name='alarm_computer']").val());
	formData.append("xnjcpt_alarm.alarm_state",$(".alarm_state").val());
	formData.append("xnjcpt_alarm.alarm_type",$(".alarm_type").val());
	formData.append("xnjcpt_alarm.alarm_threshold_value",$("input[name='alarm_threshold_value']").val());
	formData.append("xnjcpt_alarm.alarm_id",input_id);
	$.ajax({
	    url: "/xnjcpt/alarm/alarm_updateAlarmInfor",
        type: "post",
        data:formData,
        //报错请加入以下三行，则ajax提交无问题
        cache: false,  
        processData: false,  
        contentType: false,
        success: function(result){
        	if(result=="警报信息修改成功"){
        		toastr.success("警报信息更改成功");
        		show_alarmList();
        	}
        }
});
}
//多选删除警告
function delete_alarm() {
	$.confirm({
		content: '确认要删除么？',
		type: 'red',
		buttons: {
			确认: {
				btnClass: ' btn-blue',
				type: "blue",
				action: function() {
					console.log("多选删除");
					var formData = new FormData;
					var HaveDate = false;
					var index = 0;
					$('.alarmList_table tbody').find(
						'input[name="delete_check"]').each(
						function(i) {
							if ($(this).is(':checked')) {
								formData.append(
									'alarm_id', $(this)
										.attr('id'));
								console.log( "要删除的id"+$(this)
										.attr('id'));
								HaveDate = true;
								index++;
							}
						});
					if (HaveDate) {
						$.ajax({
								url : "/xnjcpt/alarm/alarm_deleteAlarmInfors",
								type : "POST",
								contentType : false,
								processData : false,
								data : formData,
								dataType : 'text',
								success : function(data) {
									console.log(data);
									if (data == '警报信息删除成功') {
										toastr.success('警报信息删除成功');
										show_alarmList();
									} else {
										toastr.error('警报删除失败');
									}
								}
							});
					} else {
						toastr.info('未选择数据');
					}
				}
			},
			取消: {
				btnClass: 'btn-red',
				type: "red",
				
			}
		}
	});
	
	
}

//全选，取消全选
function allcheck() {
	console.log("全选");
	var check_allStatus = $("#checkAll").prop("checked");
	console.log(check_allStatus);
	var check = $("input[name='delete_check']");
	for (var i = 0; i <= check.length; i++) {
		check[i].checked = check_allStatus;
	}
}
function cancle_all() {
	console.log("点击多选框");
	var $subs = $("input[name='delete_check']");
	$("#checkAll").prop("checked", $subs.length == $subs.filter(":checked").length ? true : false);
}
//显示警告列表
function show_alarmList(){
    console.log(alarm_paginationQuery);
	var alarm_data={
			"currPage":alarm_paginationQuery.currPage,
			"totalPage":alarm_paginationQuery.totalPage,
			"count":alarm_paginationQuery.totalCount,
			"pageSize":alarm_paginationQuery.pageCount,
	}
	$.ajax({
	    url: "/xnjcpt/alarm/alarm_getAlarmInfor",
        type: "post",
        data:alarm_data,
        success: function(result){
        	var result=JSON.parse(result);
			//存入vue对象
        	alarmVue.alarms = result.alarm_list;
        	alarmVue.currPage = result.currPage;
			alarmVue.totalPage = result.totalPage;
			alarmVue.pageCount = result.pageSize;
			alarmVue.totalCount = result.count;
			//存入分页查询
			alarm_paginationQuery.currPage = result.currPage;
			alarm_paginationQuery.totalPage = result.totalPage;
			alarm_paginationQuery.pageCount = result.pageSize;
			alarm_paginationQuery.totalCount = result.count;
        }
});
}

//按关键字搜索列表
function iquery_alarmList() {
	var keyword = $(".search_input").val();
	console.log("按关键字搜索");
	var iquery_keyword = {
		"queryString" : keyword,
	}
	$.ajax({
		url : "/xnjcpt/alarm/alarm_getAlarmInfor",
		type : "post",
		data : iquery_keyword,
		//报错请加入以下三行，则ajax提交无问题
		success : function(result) {
			var result=JSON.parse(result);
			//存入vue对象
        	alarmVue.alarms = result.alarm_list;
        	alarmVue.currPage = result.currPage;
			alarmVue.totalPage = result.totalPage;
			alarmVue.pageCount = result.pageSize;
			alarmVue.totalCount = result.count;
			//存入分页查询
			alarm_paginationQuery.currPage = result.currentPage;
			alarm_paginationQuery.totalPage = result.totalPage;
			alarm_paginationQuery.pageCount = result.pageSize;
			alarm_paginationQuery.totalCount = result.count;
		}
	});
}
//分页
//分页
//首页
function firstPage() {
	console.log("首页");
	console.log(alarm_paginationQuery);
	if (alarm_paginationQuery.currPage <= 1) {
		toastr.error("已经是第一页了哦!");
	} else {
		alarm_paginationQuery.currPage = "1";
		show_alarmList();
	}
}

//上一页
function prePage() {
	console.log("上一页");
	console.log(alarm_paginationQuery.currPage);
	if (alarm_paginationQuery.currPage <= 1) {
		toastr.error("已经是第一页了哦!");
	} else {
		alarm_paginationQuery.currPage = --alarm_paginationQuery.currPage;
		console.log("当前页" + alarm_paginationQuery.currPage);
		show_alarmList();
	}
}
//下一页
function nextPage() {
	console.log("下一页");
	if (alarm_paginationQuery.currPage >= alarm_paginationQuery.totalPage) {
		toastr.error("没有下一页了哦!");
	} else {
		alarm_paginationQuery.currPage = ++alarm_paginationQuery.currPage;
		console.log(alarm_paginationQuery);
		console.log("当前页" + alarm_paginationQuery.currPage);
		show_alarmList();
	}
}
//跳页
function goPage() {
	console.log("跳页");
	console.log($("#goInput").val());
	if ($("#goInput").val() <= alarm_paginationQuery.totalPage && $("#goInput").val() >= 1) {

		alarm_paginationQuery.currPage = $("#goInput").val();
		show_alarmList();
	} else {
		toastr.error("不存在这一页！");
	}
}
//尾页
function lastPage() {
	console.log("尾页");
	if (alarm_paginationQuery.currPage >= alarm_paginationQuery.totalPage) {
		toastr.error("没有下一页了哦!");
	} else {
		alarm_paginationQuery.currPage = alarm_paginationQuery.totalPage;
		show_alarmList();
	}
}
