var computerVue;//编辑显示vue
var computer_paginationQuery = {
		"currPage":'1',
		"totalPage" : '',
		"pageCount" : '',
		"totalCount" : ''
	}

window.onload=function(){
	console.log("显示");
	//主机显示的vue
	computerVue=new Vue({
		el:".computerList",
		data:{
			"currPage" : '1',
			"totalPage" : '1',
			"totalCount" : '0',
			"computers" : ""
		},
	});
	show_computerList();
}

//添加主机
function add_computer() {
	$.confirm({
		title: '添加管理员',
		content: '<div class="comfirm_box"><input placeholder="要添加的主机IP" name="computer_ip" class="comfirm_input computer_ip" type="text"/></div>',
		type: 'blue',
		buttons: {
			确认: {
				btnClass: ' btn-blue',
				type: "blue",
				action: function() {
					if($("input[name='computer_ip']").val()!=""){
						add_computerAjax();
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
//添加主机ajax
function add_computerAjax(){
	var formData=new FormData();
	formData.append("xc.computer_ip",$("input[name='computer_ip']").val());
	$.ajax({
		    url: "/xnjcpt/computer/computer_saveComputer",
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
//多选删除主机
function delete_computer() {
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
								url : "/xnjcpt/computer/computer_removeComputerById",
								type : "POST",
								contentType : false,
								processData : false,
								data : formData,
								dataType : 'text',
								success : function(data) {
									console.log(data);
									if (data == '删除成功') {
										toastr.info('主机删除成功');
										show_computerList();
									} else {
										toastr.error('主机删除失败');
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
//显示主机列表
function show_computerList(){
    console.log(computer_paginationQuery);
	var computer_data={
			"cv.currPage":computer_paginationQuery.currPage,
			"cv.totalPage":computer_paginationQuery.totalPage,
			"cv.count":computer_paginationQuery.totalCount,
			"cv.pageSize":computer_paginationQuery.pageCount,
	}
	$.ajax({
	    url: "/xnjcpt/computer/computer_getComputerInformationByPage",
        type: "post",
        data:computer_data,
        success: function(result){
        	var result=JSON.parse(result);
        	console.log(result);
			//存入vue对象
        	computerVue.computers = result.list;
        	computerVue.currPage = result.currPage;
			computerVue.totalPage = result.totalPage;
			computerVue.pageCount = result.pageSize;
			computerVue.totalCount = result.Count;
			//存入分页查询
			computer_paginationQuery.currPage = result.currPage;
			computer_paginationQuery.totalPage = result.totalPage;
			computer_paginationQuery.pageCount = result.pageSize;
			computer_paginationQuery.totalCount = result.Count;
			console.log(computer_paginationQuery);
        }
});
}

//按关键字搜索列表
function iquery_computerList() {
	var keyword = $(".search_input").val();
	console.log("按关键字搜索");
	var iquery_keyword = {
		"cv.searchContent" : keyword,
	}
	$.ajax({
		url : "/xnjcpt/computer/computer_getComputerInformationByPage",
		type : "post",
		data : iquery_keyword,
		//报错请加入以下三行，则ajax提交无问题
		success : function(result) {
			var result=JSON.parse(result);
			//存入vue对象
        	computerVue.computers = result.list;
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
