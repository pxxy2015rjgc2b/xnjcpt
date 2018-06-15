var alarmVue;
var alarm_paginationQuery = {
		"currPage" : "1",
		"totalPage" : '',
		"pageCount" : '',
		"totalCount " : ''
	}

window.onload=function(){
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
}
//添加警报
function add_alarm() {
	$.confirm({
		title: '添加警报',
		content: '<div class="comfirm_box"><input placeholder="要添加的主机IP" name="alarm_computer" class="comfirm_input alarm_computer" type="text"/></div><div class="comfirm_box"><select class="comfirm_select alarm_type" name="alarm_type"  placeholder="警报类型"><option>CPU利用率</option><option>CPU利用率</option><option>内存利用率</option><option>出带宽</option><option>入带宽</option><option>出包量</option><option>入包量</option></select></div><div class="comfirm_box"><input class="comfirm_input alarm_threshold_value"  placeholder="警报阈值" name="alarm_threshold_value" type="text"/></div><div class="comfirm_box"><select class="comfirm_select alarm_state" name="alarm_state"  placeholder="是否启用"><option>启用</option><option>不启用</option></select></div>',
		type: 'yellow',
		buttons: {
			确认: {
				btnClass: ' btn-blue',
				type: "blue",
				action: function() {}
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
	formData.append("alarm_state",$("input[name='alarm_state']").val());
	formData.append("alarm_type",$("input[name='alarm_type']").val());
	formData.append("alarm_threshold_value",$("input[name='alarm_threshold_value']").val());
	
	$.ajax({
		    url: "/xnjcpt/receive/receive_saveAlarmInfor",
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
function edit_alarm(){
	$.confirm({
		title: '编辑警报',
		content: '<div class="comfirm_box"><input placeholder="要添加的主机IP" name="alarm_computer" class="comfirm_input alarm_computer" type="text"/></div><div class="comfirm_box"><select class="comfirm_select alarm_type" name="alarm_type"  placeholder="警报类型"><option>CPU利用率</option><option>CPU利用率</option><option>内存利用率</option><option>出带宽</option><option>入带宽</option><option>出包量</option><option>入包量</option></select></div><div class="comfirm_box"><input class="comfirm_input alarm_threshold_value"  placeholder="警报阈值" name="alarm_threshold_value" type="text"/></div><div class="comfirm_box"><select class="comfirm_select alarm_state" name="alarm_state"  placeholder="是否启用"><option>启用</option><option>不启用</option></select></div>',
		type: 'yellow',
		buttons: {
			确认: {
				btnClass: ' btn-blue',
				type: "blue",
				action: function() {}
			},
			取消: {
				btnClass: 'btn-red',
				type: "red",
			}
		}
	});
}
//编辑警告Ajax
function edit_alarmAjax(){
	var formData=new FormData();
	formData.append("alarm_computer",$("input[name='alarm_computer']").val());
	formData.append("alarm_state",$("input[name='alarm_state']").val());
	formData.append("alarm_type",$("input[name='alarm_type']").val());
	formData.append("alarm_threshold_value",$("input[name='alarm_threshold_value']").val());
	$.ajax({
	    url: "/xnjcpt/receive/receive_updateAlarmInfor",
        type: "post",
        data:formData,
        //报错请加入以下三行，则ajax提交无问题
        cache: false,  
        processData: false,  
        contentType: false,
        success: function(result){
        	if(result=="警报信息更改成功"){
        		toastr.success("警报信息更改成功");
        		show_alarmList();
        	}
        }
});
}
//多选删除警告
function delete_alarm() {
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
		$
			.ajax({
				url : "/xnjcpt/receive/receive_deleteAlarmInfors",
				type : "POST",
				contentType : false,
				processData : false,
				data : formData,
				dataType : 'text',
				success : function(data) {
					console.log(data);
					if (data == '警报删除成功') {
						toastr.info('警报删除成功');
						show_userList();
					} else {
						toastr.error('警报删除失败');
					}
				}
			});
	} else {
		toastr.info('未选择数据');
	}
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
	var alarm_data={
			"saiv.currPage":alarm_paginationQuery.currPage,
			"saiv.totalPage":alarm_paginationQuery.totalPage,
			"saiv.count":alarm_paginationQuery.totalCount,
			"saiv.pageSize":alarm_paginationQuery.pageCount,
	}
	$.ajax({
	    url: "/xnjcpt/receive/receive_getAlarmInfor",
        type: "post",
        data:alarm_data,
        success: function(result){
        	var alarm=JSON.parse(result);
        	console.log(data);
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
	if (user_paginationQuery.currPage <= 1) {
		toastr.error("已经是第一页了哦!");
	} else {
		user_paginationQuery.currPage = "1";
		show_userList();
	}
}

//上一页
function prePage() {
	console.log("上一页");
	if (alarm_paginationQuery.currPage <= 1) {
		toastr.error("已经是第一页了哦!");
	} else {
		alarm_paginationQuery.currPage = --alarm_paginationQuery.currPage;
		console.log("当前页" + alarm_paginationQuery.currPage);
		show_userList();
	}
}
//下一页
function nextPage() {
	console.log("下一页");
	if (alarm_paginationQuery.currPage >= alarm_paginationQuery.totalPage) {
		toastr.error("没有下一页了哦!");
	} else {
		alarm_paginationQuery.currPage = ++alarm_paginationQuery.currPage;
		console.log("当前页" + alarm_paginationQuery.currPage);
		show_userList();
	}
}
//跳页
function goPage() {
	console.log("跳页");
	console.log($("#goInput").val());
	if ($("#goInput").val() <= alarm_paginationQuery.totalPage && $("#goInput").val() >= 1) {

		alarm_paginationQuery.currPage = $("#goInput").val();
		show_userList();
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
		show_userList();
	}
}
