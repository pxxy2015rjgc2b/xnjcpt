window.onload=function(){

	console.log("register");
	$(".register_button").click(function(){
		console.log("click");
		register_ajax();
	});
}
//注册ajax
function register_ajax(){
	var user_username=$("input[name='user_username']").val();
	var user_password=$("input[name='user_password']").val();
	var user_email=$("input[name='user_email']").val();
	var formData=new FormData();
	formData.append("user.user_username",user_username);
	formData.append("user.user_password",user_password);
	formData.append("user.user_email",user_email);
	 $.ajax({
		    url: "user/user_register",
	        type: "post",
	        data:formData,
	        dataType:"json",
	        //报错请加入以下三行，则ajax提交无问题
	        cache: false,  
	        processData: false,  
	        contentType: false,
	        success: function(result){
	        	 if(result=="register_success"){
	  			   toastr.success("注册成功！");
	  		   }else if(result=="name_error"){
	  			   toastr.error("用户名已存在！");
	  		   }else if(result=="email_error"){
	  			   toastr.error("该邮箱已注册，请重新输入");
	  		   }
	        }
	    });
}
 
