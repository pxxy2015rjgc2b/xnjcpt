window.onload=function(){
	userEdit_ajax();
	var user=new Vue({
		el:"#user_info",
		data:{
		    "userInfo":"",
		}
	});
}
//修改用户资料
function userEdit_ajax(){
	/*点击编辑按钮，显示输入框*/
	$(".editName").click(function(){
		$(".user_name").css("display","none");
		$(".editName").css("display","none");
		$(".edit_nameBox").css("display","inline");
	});
	$(".editPhoto").click(function(){
		$(".user_photo").css("display","none");
		$(".editPhoto").css("display","none");
		$(".edit_photoBox").css("display","inline");
	});
	/*点击保存或取消显示用户信息*/
	$(".user_nameCancle").click(function(){
		$(".user_name").css("display","inline");
		$(".editName").css("display","inline");
		$(".edit_nameBox").css("display","none");
	});
	$(".user_photoCancle").click(function(){
		$(".user_photo").css("display","inline");
		$(".editPhoto").css("display","inline");
		$(".edit_photoBox").css("display","none");
	});
	$.ajax({
		url: "",
		type:"post",
		data:"",
		success:function(){
			
		}
	});
	
}