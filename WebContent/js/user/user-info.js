var user;
window.onload=function(){
	//得到user_id
	var url = window.location.href;
	var user_id = url.substring(url.indexOf("=") + 1);
	console.log(user_id);
	userShow_ajax(user_id);
	userEdit_ajax(user_id);
	user=new Vue({
		el:"#user_info",
		data:{
		    "userInfo":""
		}
	})
}
//显示用户资料
function userShow_ajax(user_id){
	$.ajax({
		url:"/xnjcpt/userManager/userManager_getUserById",
		type:"POST",
		data:user_id,
		success:function(data){
			console.log("用户列表显示");
			console.log(data);
			var userData= JSON.parse(data);
			user.userInfo=userData;
			
			
		}
	});
}
//修改用户资料
function userEdit_ajax(user_id){
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