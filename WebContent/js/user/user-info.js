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
function editName(){
	console.log("点击编辑name");
	$(".user_name").css("display","none");
	$(".editName").css("display","none");
	$(".edit_nameBox").css("display","inline");
	var user_username=$("input[name=user_username]").val();
	$.ajax({
		url:"/xnjcpt/userManager/userManager_updateUser",
		type:"POST",
		data:user_username,
		success:function(data){
			console.log(data);
			console.log("修改用户姓名");
			if(data=="修改用户姓名成功"){
				toastr.suceess("修改用户姓名成功");
				userShow_ajax();
			}else{
				toastr.error("修改用户姓名失败");
			}		
		}
	});
	
}
function editPhoto(){
	console.log("点击编辑photo");
	$(".user_photo").css("display","none");
	$(".editPhoto").css("display","none");
	$(".edit_photoBox").css("display","inline");
	var user_photo=$("input[name=user_photo]").val();
	$.ajax({
		url:"/xnjcpt/userManager/userManager_updateUser",
		type:"POST",
		data:user_photo,
		success:function(data){
			console.log(data);
			if(data=="修改用户电话成功"){
				toastr.suceess("修改用户电话成功");
			}else{
				toastr.error("修改用户电话失败");
			}		
		}
	});
}
/*点击保存或取消显示用户信息*/
function user_nameCancle(){
	$(".user_name").css("display","inline");
	$(".editName").css("display","inline");
	$(".edit_nameBox").css("display","none");
}
function user_photoCancle(){
	$(".user_photo").css("display","inline");
	$(".editPhoto").css("display","inline");
	$(".edit_photoBox").css("display","none");
}
function userEdit_ajax(user_id){
	console.log("修改用户资料");
	
	$.ajax({
		url: "",
		type:"post",
		data:"",
		success:function(){
			
		}
	});
	
}