window.onload=function(){

	console.log("register");
	$(".register_button").click(function(){
		console.log("click");
		register_ajax();
	});
}
//注册ajax
function register_ajax(){
	console.log("ajax");
	var user_name=$("input[name='user_name']").val();
	var user_password=$("input[name='user_password']").val();
	var user_email=$("input[name='user_email']").val();
	var formData=new FormData();
	formData.append("user.user_name",user_name);
	formData.append("user.user_password",user_password);
	formData.append("user.user_email",user_email);
	 $.ajax({
		    url: "user/user_register",
	        type: "post",
	        data:formData,
	        //报错请加入以下三行，则ajax提交无问题
	        cache: false,  
	        processData: false,  
	        contentType: false,
	        success: function(result){
	        	console.log(result);
	        	 if(result=="register_success"){
	        		 console.log("注册成功");
	  			   //toastr.success("注册成功！");
	  			   //注册完后跳到首页
                   window.location.href="/xnjcpt/index.jsp"
	  		   }else if(result=="name_error"){
	  			 console.log("用户名已存在");
	  		   }else if(result=="email_error"){
	  			 console.log("该邮箱已注册，请重新输入");
	  		   }
	        }
	    });
}
//通过邮箱找回密码
function forgetPassword(){
	var user_email=$("input[name='user_email]").val();
	 $.ajax({
		    url: "user/user_sendEmailtoUpdatePassword",
	        type: "post",
	        data:formData,
	        //报错请加入以下三行，则ajax提交无问题
	        cache: false,  
	        processData: false,  
	        contentType: false,
	        success: function(result){
	        console.log(result);
	        	 if(result=="register_success"){
	        		 console.log("注册成功");
	  			   //toastr.success("注册成功！");
	  			   //注册完后跳到首页
             window.location.href="/xnjcpt/index.jsp"
	  		   }else if(result=="name_error"){
	  			 console.log("用户名已存在");
	  		   }else if(result=="email_error"){
	  			 console.log("该邮箱已注册，请重新输入");
	  		   }
	        }
	    });
}
$(".identify_code").click(function(){
	var user_name=$("input[name='user_name']").val();
	var user_password=$("input[name='user_password']").val();
	var user_email=$("input[name='user_email']").val();
	var identifyCode_input=$("input[name='identifyCode_input']").val();
	var formData=new FormData();
	formData.append("user.user_name",user_name);
	formData.append("user.user_password",user_password);
	formData.append("user.user_email",user_email);
	 $.ajax({
		    url: "/xnjcpt/userManager/userManager_updatePassword",
	        type: "post",
	        data:formData,
	        //报错请加入以下三行，则ajax提交无问题
	        cache: false,  
	        processData: false,  
	        contentType: false,
	        success: function(result){
	        	console.log(result);
	        	 if(result=="register_success"){
	        		 console.log("注册成功");
	  			   //toastr.success("注册成功！");
	  			   //注册完后跳到首页
                window.location.href="/xnjcpt/index.jsp"
	  		   }else if(result=="name_error"){
	  			 console.log("用户名已存在");
	  		   }else if(result=="email_error"){
	  			 console.log("该邮箱已注册，请重新输入");
	  		   }
	        }
	    });
});
