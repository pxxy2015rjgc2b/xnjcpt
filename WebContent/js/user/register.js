//全局变量验证码
var verifyCode;
window.onload=function(){
	$(".register_button").click(function(){
		console.log("click");
		register_ajax();
	});
}
//注册ajax
function register_ajax(){
	console.log("ajax");
	var user_username=$("input[name='user_username']").val();
	var user_phone=$("input[name='user_phone']").val();
	var user_name=$("input[name='user_name']").val();
	var user_password=$("input[name='user_password']").val();
	var user_email=$("input[name='user_email']").val();
	var formData=new FormData();
	formData.append("user.user_username",user_username);
	formData.append("user.user_phone",user_phone);
	formData.append("user.user_name",user_name);
	formData.append("user.user_password",user_password);
	formData.append("user.user_email",user_email);
	var emailVerify = /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/;
	if(user_email!=""&&user_username!=""&&user_phone!=""&&user_name!=null&&user_password!=null){
		if(emailVerify.test(user_email)){
			 $.ajax({
				    url: "/xnjcpt/user/user_register",
			        type: "post",
			        data:formData,
			        //报错请加入以下三行，则ajax提交无问题
			        cache: false,  
			        processData: false,  
			        contentType: false,
			        success: function(result){
			        	console.log(result);
			        	 if(result=="register_success"){
			        		 toastr.success("注册成功");
			  			   //toastr.success("注册成功！");
			        		 send_activeEmail();
			  			  
			  		   }else if(result=="name_error"){
			  			 toastr.error("用户名已存在");
			  		   }else if(result=="email_error"){
			  			toastr.error("该邮箱已注册，请重新输入");
			  		   }
			        }
			    });
		}else{
			toastr.error("邮箱格式错误");
		}
	}
	else{
		toastr.error("不能有空项");
	}
	
	
}
//激活用户发送邮件
function send_activeEmail(){
	toastr.success("激活用户邮箱发送！");
	var data={
		"user.user_email":$("input[name='user_email']").val(),
	}
	$.ajax({
		url:"user/user_sendEmail",
		type:"post",
		data:data,
		success:function(result){
			if(result=="激活邮件发送成功"){
				active_user();
			}else{
				toastr.error("邮件发送失败！");
			}
			
		}
	});
}
//点击邮件链接激活帐户
function active_user(){
	console.log("激活用户");
	$.ajax({
		url:"user/user_activate",
		type:"post",
		success:function(result){
			toastr.success("注册成功，请到邮箱查看并点击激活链接，激活帐户！");
		}
	});
}
//通过邮箱发送验证码
function sendEmail(){
	console.log($("input[name='user_email']").val());
	var formData=new FormData();
	formData.append("user.user_email",$("input[name='user_email']").val());
	 $.ajax({
		    url: "/xnjcpt/user/user_sendEmailtoUpdatePassword",
	        type: "post",
	        data:formData,
	        //报错请加入以下三行，则ajax提交无问题
	        cache: false,  
	        processData: false,  
	        contentType: false,
	        success: function(result){	
	       	 if(result!="验证码发送失败"){
	            	toastr.success("验证码发送成功!");
	  			    verifyCode=result;
	  		   }else{
	  			    toastr.error("验证码发送失败，请检查邮箱是否填写正确！");
	  			    verifyCode=result;
	  		   }
	        }
	    });
}
//验证验证码
function check_verifyCode(){
}
//找回密码
function forgetPassword(){
	console.log("邮箱发送的"+verifyCode);
	console.log($(".identify_codeInput").val());
	if($(".identify_codeInput").val()==verifyCode){
		var formData=new FormData();
		formData.append("user_email",$("input[name='user_email']").val());
		formData.append("newPassword",$("input[name='user_password']").val());
		 $.ajax({
			    url: "/xnjcpt/user/user_updatePasswordbyverifyCode",
		        type: "post",
		        data:formData,
		        //报错请加入以下三行，则ajax提交无问题
		        cache: false,  
		        processData: false,  
		        contentType: false,
		        success: function(result){
		        
		        if(result=="updatesuccess"){
		  			toastr.success("修改密码成功！");
		  			   //注册完后跳到首页
	                 window.location.href="/xnjcpt/index.jsp"
		  		   }else{
		  			 toastr.error("验证码错误！");
		  		   }
		        }
		    });
	}else{
		toastr.error("验证码填写错误，请重新填写！");
	}
	
}
