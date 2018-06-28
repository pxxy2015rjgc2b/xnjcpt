var user;
window.onload=function(){
	//得到user_id
	var url = window.location.href;
	var user_id = url.substring(url.indexOf("=") + 1);
	console.log(user_id);
	userShow_ajax(user_id);
	user=new Vue({
		el:"#user_info",
		data:{
		    "userInfo":""
		}
	})
}
//显示用户资料
function userShow_ajax(){
	$.ajax({
		url:"/xnjcpt/userManager/userManager_getUserById",
		type:"POST",
		success:function(data){
			var userData= JSON.parse(data);
			var user_password=userData.user_password;
			//把密码星号显示
			var re = /1|2|3|4|5|6|7|8|9|0/gi;
			userData.user_password =user_password.replace(re, function(sMatch){
			 return sMatch.replace(/./g,"*");
			});
			user.userInfo=userData;
			
			
			
		}
	});
}
//点击修改按钮
function editName(){
	console.log("点击编辑name");
	$(".user_name").css("display","none");
	$(".editName").css("display","none");
	$(".edit_nameBox").css("display","inline");
}
function editPhoto(){
	console.log("点击编辑photo");
	$(".user_photo").css("display","none");
	$(".editPhoto").css("display","none");
	$(".edit_photoBox").css("display","inline");
}
//修改用户资料
//修改用户姓名
function editName_ajax(){
	var formData=new FormData();
	formData.append("user_name",$("input[name=user_name]").val());
	if($("input[name=user_name]").val()!=""){
		$.ajax({
			url:"/xnjcpt/userManager/userManager_updateUser",
			type:"POST",
			data:formData,
			 cache: false,  
		       processData: false,  
		       contentType: false,
			success:function(data){
				console.log(data);
				console.log("修改用户姓名");
				if(data=="修改用户姓名成功"){
					toastr.success("修改用户姓名成功");
					user_nameCancle();
					userShow_ajax();
				}else{
					toastr.error("修改用户姓名失败");
				}		
			}
		});
	}else{
		toastr.error("用户名不能为空，修改用户姓名失败!");
	}
	
	
}
//修改用户号码
function editPhoto_ajax(){
	var formData=new FormData();
	formData.append("user_phone",$("input[name=user_photo]").val());
	var reg = /(^1[3|4|5|7|8]\d{9}$)|(^09\d{8}$)/;  
	if(reg.test($("input[name=user_photo]").val())){
		$.ajax({
			url:"/xnjcpt/userManager/userManager_updateUser",
			type:"POST",
			data:formData,
			 cache: false,  
		       processData: false,  
		       contentType: false,
			success:function(data){
				console.log(data);
				console.log("修改用户号码");
				if(data=="修改用户电话成功"){
					toastr.success("修改用户电话成功");
					user_photoCancle();
					userShow_ajax();
				}else{
					toastr.error("修改用户号码失败");
				}		
			}
		});
	}else{
		toastr.error("手机号码格式不正确,修改用户号码失败！");
	}
	
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
//通过旧密码修改新密码
function editPassword(){
    $.confirm({
        title: '是否修改密码',
        content: '是否通过旧密码修改密码',
        type: 'red',
        buttons:{
            确认:{
            	btnClass: ' btn-blue',
				action: function() {
					$.confirm({
						title: '修改密码',
						content: '<div class="comfirm_box"><input placeholder="旧密码" class="comfirm_input oldPassword" type="text"/></div><div class="comfirm_box"><input class="comfirm_input newPassword"  placeholder="新密码" type="text"/></div><div class="comfirm_box"><input class="comfirm_input confirmPassword"  placeholder="确认密码" type="text"/></div>',
		                type: "blue",
						buttons: {
							确认: {
								btnClass: ' btn-green',
								action:function(){
								  if(user_password.length>=2&&user_password.length<=11){
									  if($(".newPassword").val()==$(".confirmPassword").val()&&$(".oldPassword").val()!=""){
											editPassword_ajax();
										}else if($(".oldPassword").val()==""||$(".newPassword").val()==""){
											$.alert('有选项为空，请完整输入！');
											  return false;
										}else{
										  $.alert('二次密码不一致，请重新输入！');
										  return false;
										}
								  }else{
									  $.alert('密码为2-11位，请正确输入！');
								  }
									
								}
							},
							取消: {
								btnClass: ' btn-red',

							}
						}
					});
				}
            },
            取消:{
            	btnClass: 'btn-red',
                text: '取消修改!', // With spaces and symbols
                action: function () {
                    $.alert('取消修改！');
                }
            }
        }
    });
}
function editPassword_ajax(){
	var formData=new FormData();
	formData.append("oldPassword",$(".oldPassword").val());
	formData.append("newPassword",$(".newPassword").val());
	$.ajax({
		url:"/xnjcpt/userManager/userManager_updatePassword",
		type:"POST",
		data:formData,
		 cache: false,  
	       processData: false,  
	       contentType: false,
		success:function(data){
			console.log(data);
			if(data=="updateSuccess"){
				userShow_ajax();
				toastr.success("修改密码成功!");
			}		
			else{
				toastr.error("修改密码失败！");
			}
		}
	});
}