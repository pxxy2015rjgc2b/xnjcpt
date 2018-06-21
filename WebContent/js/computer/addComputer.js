var computer_editVue;//编辑显示vue
var computer_paginationQuery = {
		"currPage":'1',
		"totalPage" : '',
		"pageCount" : '',
		"totalCount " : ''
	}

window.onload=function(){
	console.log("显示");
	//主机显示的vue
	computerVue=new Vue({
		el:".computerList",
		data:{
			"currPage" : '1',
			"totalPage" : '1',
			"pageCount" : '0',
			"totalCount" : '0',
			"computers" : ""
		},
	});
	show_computerList();
}

//添加警报
function add_computer() {
	$.confirm({
		title: '添加主机',
		content: '<div class="comfirm_box"><input placeholder="要添加的主机IP" name="computer_ip" class="comfirm_input computer_ip" type="text"/></div>',
		type: 'yellow',
		buttons: {
			确认: {
				btnClass: ' btn-blue',
				type: "blue",
				action: function() {
					add_computerAjax();
				}
			},
			取消: {
				btnClass: 'btn-red',
				type: "red",
				
			}
		}
	});
}
//添加主机ajax
function add_computerAjax(){
	var formData=new FormData();
	formData.append("computer_ip",$("input[name='computer_ip']").val());
	$.ajax({
		    url: "/xnjcpt/computer/computer_addComputer",
	        type: "post",
	        data:formData,
	        //报错请加入以下三行，则ajax提交无问题
	        cache: false,  
	        processData: false,  
	        contentType: false,
	        success: function(result){
	        	if(result=="增加成功"){
	        		toastr.success("主机添加成功！");
	        		show_computerList();
	        	}
	        }
	});
}
//点击修改按钮
$(document).on('click',".edit_computer",function(event){
	 var input_id=$(event.target).parent().siblings('.computer_id').attr('id'); 
	 var formData=new FormData();
	 formData.append("computer_id",input_id);
	 //获取要修改的数据
	 $.ajax({
		    url: "/xnjcpt/computer/computer_getcomputerInforById",
	        type: "post",
	        data:formData,
	        //报错请加入以下三行，则ajax提交无问题
	        cache: false,  
	        processData: false,  
	        contentType: false,
	        success: function(result){
	        	var result=JSON.parse(result);
	        	$("input[name='computer_computer']").val(result.computer_computer);
	        	$("input[name='computer_threshold_value']").val(result.computer_threshold_value);
	        	$(".computer_type").val(result.computer_type);
	        	$(".computer_state").val(result.computer_state);
	        }
	});
	 $.confirm({
			title: '编辑警报',
			content:'<div class="comfirm_box"><input placeholder="要添加的主机IP" disabled="true" name="computer_computer" class="comfirm_input computer_computer" type="text"/></div><div class="comfirm_box"><select class="comfirm_select computer_type" name="computer_type"  placeholder="警报类型"><option>CPU利用率</option><option>CPU利用率</option><option>内存利用率</option><option>出带宽</option><option>入带宽</option><option>出包量</option><option>入包量</option></select></div><div class="comfirm_box"><input class="comfirm_input computer_threshold_value"  placeholder="警报阈值" name="computer_threshold_value" type="text"/></div><div class="comfirm_box"><select class="comfirm_select computer_state" name="computer_state"  placeholder="是否启用"><option value="0">启用</option><option value="1">不启用</option></select></div>',
			type: 'yellow',
			buttons: {
				确认: {
					btnClass: ' btn-blue',
					type: "blue",
					action: function() {
						edit_computerAjax(input_id);
					}
				},
				取消: {
					btnClass: 'btn-red',
					type: "red",
				}
			}
	 });
});
//编辑主机Ajax
function edit_computerAjax(input_id){
	var formData=new FormData();
	formData.append("xnjcpt_computer.computer_computer",$("input[name='computer_computer']").val());
	formData.append("xnjcpt_computer.computer_state",$(".computer_state").val());
	formData.append("xnjcpt_computer.computer_type",$(".computer_type").val());
	formData.append("xnjcpt_computer.computer_threshold_value",$("input[name='computer_threshold_value']").val());
	formData.append("xnjcpt_computer.computer_id",input_id);
	$.ajax({
	    url: "/xnjcpt/computer/computer_updatecomputerInfor",
        type: "post",
        data:formData,
        //报错请加入以下三行，则ajax提交无问题
        cache: false,  
        processData: false,  
        contentType: false,
        success: function(result){
        	if(result=="警报信息更改成功"){
        		toastr.success("警报信息更改成功");
        		show_computerList();
        	}
        }
});
}
//多选删除主机
function delete_computer() {
	console.log("多选删除");
	var formData = new FormData;
	var HaveDate = false;
	var index = 0;
	$('.computerList_table tbody').find(
		'input[name="delete_check"]').each(
		function(i) {
			if ($(this).is(':checked')) {
				formData.append(
					'computer_id', $(this)
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
				url : "/xnjcpt/computer/computer_deleteComputerById",
				type : "POST",
				contentType : false,
				processData : false,
				data : formData,
				dataType : 'text',
				success : function(data) {
					console.log(data);
					if (data == '删除成功') {
						toastr.info('主机删除成功');
						show_userList();
					} else {
						toastr.error('主机删除失败');
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
//显示主机列表
function show_computerList(){
    console.log(computer_paginationQuery);
	var computer_data={
			"currPage":computer_paginationQuery.currPage,
			"totalPage":computer_paginationQuery.totalPage,
			"count":computer_paginationQuery.totalCount,
			"pageSize":computer_paginationQuery.pageCount,
	}
	$.ajax({
	    url: "/xnjcpt/computer/computer_getComputerIds",
        type: "post",
        data:computer_data,
        success: function(result){
        	var result=JSON.parse(result);
			//存入vue对象
        	computerVue.computers = result.computer_list;
        	computerVue.currPage = result.currPage;
			computerVue.totalPage = result.totalPage;
			computerVue.pageCount = result.pageSize;
			computerVue.totalCount = result.count;
			//存入分页查询
			computer_paginationQuery.currPage = result.currPage;
			computer_paginationQuery.totalPage = result.totalPage;
			computer_paginationQuery.pageCount = result.pageSize;
			computer_paginationQuery.totalCount = result.count;
        }
});
}

//按关键字搜索列表
function iquery_computerList() {
	var keyword = $(".search_input").val();
	console.log("按关键字搜索");
	var iquery_keyword = {
		"queryString" : keyword,
	}
	$.ajax({
		url : "/xnjcpt/computer/computer_getcomputerInfor",
		type : "post",
		data : iquery_keyword,
		//报错请加入以下三行，则ajax提交无问题
		success : function(result) {
			var result=JSON.parse(result);
			//存入vue对象
        	computerVue.computers = result.computer_list;
        	computerVue.currPage = result.currPage;
			computerVue.totalPage = result.totalPage;
			computerVue.pageCount = result.pageSize;
			computerVue.totalCount = result.count;
			//存入分页查询
			computer_paginationQuery.currPage = result.currentPage;
			computer_paginationQuery.totalPage = result.totalPage;
			computer_paginationQuery.pageCount = result.pageSize;
			computer_paginationQuery.totalCount = result.count;
		}
	});
}
//分页
//分页
//首页
function firstPage() {
	console.log("首页");
	console.log(computer_paginationQuery);
	if (computer_paginationQuery.currPage <= 1) {
		toastr.error("已经是第一页了哦!");
	} else {
		computer_paginationQuery.currPage = "1";
		show_computerList();
	}
}

//上一页
function prePage() {
	console.log("上一页");
	console.log(computer_paginationQuery.currPage);
	if (computer_paginationQuery.currPage <= 1) {
		toastr.error("已经是第一页了哦!");
	} else {
		computer_paginationQuery.currPage = --computer_paginationQuery.currPage;
		console.log("当前页" + computer_paginationQuery.currPage);
		show_computerList();
	}
}
//下一页
function nextPage() {
	console.log("下一页");
	if (computer_paginationQuery.currPage >= computer_paginationQuery.totalPage) {
		toastr.error("没有下一页了哦!");
	} else {
		computer_paginationQuery.currPage = ++computer_paginationQuery.currPage;
		console.log(computer_paginationQuery);
		console.log("当前页" + computer_paginationQuery.currPage);
		show_computerList();
	}
}
//跳页
function goPage() {
	console.log("跳页");
	console.log($("#goInput").val());
	if ($("#goInput").val() <= computer_paginationQuery.totalPage && $("#goInput").val() >= 1) {

		computer_paginationQuery.currPage = $("#goInput").val();
		show_computerList();
	} else {
		toastr.error("不存在这一页！");
	}
}
//尾页
function lastPage() {
	console.log("尾页");
	if (computer_paginationQuery.currPage >= computer_paginationQuery.totalPage) {
		toastr.error("没有下一页了哦!");
	} else {
		computer_paginationQuery.currPage = computer_paginationQuery.totalPage;
		show_computerList();
	}
}
