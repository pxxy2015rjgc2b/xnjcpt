window.onload=function(){
	$(".login_button").click(function(){
		console.log("login");
		login_ajax();
	});
}
function login_ajax(){
	var user_name=$("input[name='user_name']").val();
	var user_password=$("input[name='user_password']").val();
	var formData=new FormData();
	formData.append("user.user_name",user_name);
	formData.append("user.user_password",user_password);
	$.ajax({
		    url: "user/user_login",
	        type: "post",
	        data:formData,
	        dataType:"json",
	        //报错请加入以下三行，则ajax提交无问题
	        cache: false,  
	        processData: false,  
	        contentType: false,
	        success: function(result){
	        	 if(result=="success"){
	  			   toastr.success("登录成功！");
	  		   }else if(result=="password_error"){
	  			   toastr.error("密码输入错误！");
	  		   }else if(result=="password_error"){
	  			   toastr.error("用户名或邮箱账户输入错误！");
	  		   }
	        }
	    });
}