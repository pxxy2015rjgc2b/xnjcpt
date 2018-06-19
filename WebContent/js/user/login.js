window.onload=function(){
	$(".login_button").click(function(){
		console.log("login");
		login_ajax();
	});
}
function login_ajax(){
	console.log("login_ajax");
	var user_username=$("input[name='user_username']").val();
	var user_password=$("input[name='user_password']").val();
	var formData=new FormData();
	formData.append("user.user_username",user_username);
	formData.append("user.user_password",user_password);
	$.ajax({
		    url: "/xnjcpt/user/user_login",
	        type: "post",
	        data:formData,
	        //报错请加入以下三行，则ajax提交无问题
	        cache: false,  
	        processData: false,  
	        contentType: false,
	        success: function(result){
	        	 if(result=="该账户已被封禁"){
	        		 toastr.error("该账户已被封禁，请到邮箱点击激活链接!");
	        	 }else{
	        	    if(result=="user_success"){
	  			     toastr.success("用户登录成功！");
	  			        //登录成功跳到云主机页面
	  			        setTimeout(function() {
	  			        	location.href="/xnjcpt/skip/skip_intoComputer";
	  			        }, 1000);
	  		         }else if(result=="manage_success"){
	  		        	toastr.success("管理员成功!");
	  		        	setTimeout(function(){
		                  location.href="/xnjcpt/skip/skip_intoComputer"
						}, 1000);
	  		         }else if(result=="manage_success"){
	  		        	 toastr.error("密码输入错误！");
	  		         }else if(result=="password_error"){
	  		        	toastr.error("用户名或邮箱账户输入错误！");
	  		         }
	             }
	        }
	    });
}