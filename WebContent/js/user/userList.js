var user_paginationQuery = {
	"currPage" : "1",
	"totalPage" : '',
	"pageCount" : '',
	"totalCount " : ''
}
var userPage;
window.onload = function() {
	console.log("list");
	userPage = new Vue({
		el : '#userVue',
		data : {
			"currPage" : '1',
			"totalPage" : '1',
			"pageCount" : '0',
			"totalCount" : '0',
			"users" : ""
		}
	})
	show_userList();
	$(".search_button").click(function() {
		var keyword = $(".search_input").val();
		console.log(keyword);
		iquery_userList(keyword);
	});
}
//show_userList_ajax
function show_userList() {
	var user_paginationQueryAjax = {
		"pb.currentPage" : user_paginationQuery.currPage,
		"pb.totalPage" : user_paginationQuery.totalPage,
		"pb.pageSize" : user_paginationQuery.pageCount,
		"pb.count" : user_paginationQuery.totalCount,
	}
	console.log(user_paginationQueryAjax);
	$.ajax({
		url : "/xnjcpt/userManager/userManager_getUserlist",
		type : "post",
		data : user_paginationQueryAjax,
		success : function(data) {
			//console.log(data);
			var result = JSON.parse(data);
			console.log(data);
			//存入vue对象
			userPage.users = result.list;
			
			userPage.currPage = result.currentPage;
			console.log(userPage.currPage);
			userPage.totalPage = result.totalPage;
			userPage.pageCount = result.pageSize;
			userPage.totalCount = result.count;
			//存入分页查询
			user_paginationQuery.currPage = result.currentPage;
			console.log(user_paginationQuery.currPage);
			console.log(user_paginationQuery.currPage);
			user_paginationQuery.totalPage = result.totalPage;
			user_paginationQuery.pageCount = result.pageSize;
			user_paginationQuery.totalCount = result.count;
		}
	});
}
//封禁
function cloSure(obj){
	console.log("封禁操作");
	var formData=new FormData();
	var id= obj.id;
	formData.append("user_id",id);
	$.ajax({
		url : "/xnjcpt/userManager/userManager_banUser",
		type : "post",
		data : formData,
		processData: false,
		contentType: false,
		success:function(data){
			console.log(data);
			toastr.success("封禁用户成功！");
			show_userList();
		}
	});
}
//解禁
function openSure(obj){
	//console.log("解禁操作");
	var formData=new FormData();
	var id= obj.id;
	
	formData.append("user_id",id);
	$.ajax({
		url : "/xnjcpt/userManager/userManager_liftUser",
		type : "post",
		data : formData,
		processData: false,
		contentType: false,
		success:function(data){
			console.log(data);
			toastr.success("解禁用户成功！");
			show_userList();
		}
	});
}
//增加用户
function add_user() {
	$.confirm({
		title: '添加用户',
		content: '<div class="comfirm_box"><input placeholder="用户名" name="user_username" class="comfirm_input computer_ip" type="text"/></div><div class="comfirm_box"><input placeholder="用户姓名" name="user_name" class="comfirm_input computer_ip" type="text"/></div><div class="comfirm_box"><input placeholder="邮箱地址" name="user_email" class="comfirm_input computer_ip" type="text"/></div><div class="comfirm_box"><input placeholder="用户密码" name="user_password" class="comfirm_input computer_ip" type="text"/></div><div class="comfirm_box"><input placeholder="确认密码" name="comfirm_password" class="comfirm_input computer_ip" type="text"/></div>',
		type: 'blue',
		buttons: {
			确认: {
				btnClass: ' btn-blue',
				type: "blue",
				action: function() {
					  var reg_username = /^[a-z][a-z0-9]{5}$/i;
					  var reg_email = /^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;;  
					if(reg_username.test($("input[name='user_username']").val())==true&& $("input[name='user_name']").val()!=""&&reg_email.test($("input[name='user_email']").val())==true&& $("input[name='user_password']").val()!="" && $("input[name='comfirm_password']").val()!=""){
						if($("input[name='user_password']").val()==$("input[name='comfirm_password']").val()){
							add_computerAjax();
						}else{
							$.alert("二次输入的密码不一致，请重新输入！");
							return false;
						}
						
					}else{
						$.alert("有选项格式不正确，请正确填写！");
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
//添加用户ajax
function add_computerAjax(){
	var formData=new FormData();
	formData.append("user.user_username",$("input[name='user_username']").val());
	formData.append("user.user_name",$("input[name='user_name']").val());
	formData.append("user.user_password",$("input[name='user_password']").val());
	formData.append("user.user_email",$("input[name='user_email']").val());
	
		$.ajax({
		    url: "/xnjcpt/user/user_addmanager",
	        type: "post",
	        data:formData,
	        //报错请加入以下三行，则ajax提交无问题
	        cache: false,  
	        processData: false,  
	        contentType: false,
	        success: function(result){
	        	if(result=="register_success"){
	        		toastr.success("添加管理员成功！");
	        		show_userList();
	        	}else{
	        		toastr.error("添加管理员失败！");
	        	}
	        }
	});
	
}
//按关键字搜索列表
function iquery_userList(keyword) {
	console.log("按关键字搜索");
	var iquery_keyword = {
		"keyword" : keyword,
	}
	$.ajax({
		url : "/xnjcpt/userManager/userManager_getUsers",
		type : "post",
		data : iquery_keyword,

		//报错请加入以下三行，则ajax提交无问题
		success : function(data) {
			console.log(data);
			var result = JSON.parse(data);
			console.log(result);
			//存入vue对象
			userPage.users = result.list;
			console.log(userPage.users);
			userPage.currPage = result.currentPage;
			userPage.totalPage =  result.totalPage;
			userPage.pageCount = result.pageSize;
			userPage.totalCount = result.count;
			//存入分页查询
			user_paginationQuery.currPage = result.currentPage;
			user_paginationQuery.totalPage = result.totalPage;
			user_paginationQuery.pageCount = result.pageSize;
			user_paginationQuery.totalCount = result.count;
		}
	});
}
//多选删除用户
function delete_user() {
	$.confirm({
		content:"确认要进行删除么？",
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
					$('.cloudList_tabel tbody').find(
						'input[name="delete_check"]').each(
						function(i) {
							if ($(this).is(':checked')) {
								formData.append(
									'user_id', $(this)
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
								url : "/xnjcpt/userManager/userManager_deleteUser",
								type : "POST",
								contentType : false,
								processData : false,
								data : formData,
								dataType : 'text',
								success : function(data) {
									console.log(data);
									if (data == '删除用户') {
										toastr.success('删除成功');
										show_userList();
									} else {
										toastr.error('删除失败');
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
	if (user_paginationQuery.currPage <= 1) {
		toastr.error("已经是第一页了哦!");
	} else {
		user_paginationQuery.currPage = --user_paginationQuery.currPage;
		console.log("当前页" + user_paginationQuery.currPage);
		show_userList();
	}
}
//下一页
function nextPage() {
	console.log("下一页");
	if (user_paginationQuery.currPage >= user_paginationQuery.totalPage) {
		toastr.error("没有下一页了哦!");
	} else {
		user_paginationQuery.currPage = ++user_paginationQuery.currPage;
		console.log("当前页" + user_paginationQuery.currPage);
		show_userList();
	}
}
//跳页
function goPage() {
	console.log("跳页");
	console.log($("#goInput").val());
	if ($("#goInput").val() <= user_paginationQuery.totalPage && $("#goInput").val() >= 1) {

		user_paginationQuery.currPage = $("#goInput").val();
		show_userList();
	} else {
		toastr.error("不存在这一页！");
	}
}
//尾页
function lastPage() {
	console.log("尾页");
	if (user_paginationQuery.currPage >= user_paginationQuery.totalPage) {
		toastr.error("没有下一页了哦!");
	} else {
		user_paginationQuery.currPage = user_paginationQuery.totalPage;
		show_userList();
	}
}