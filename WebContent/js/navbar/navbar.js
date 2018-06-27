function enter_userAjax(){
	$.ajax({
		url: "/xnjcpt/userManager/userManager_getUserById",
		type:"POST",
		success:function(data){
			console.log(data);
			var user=JSON.parse(data);
			var user_id=user.user_id;
			console.log("跳转到用户"+user_id);
			window.location.href="/xnjcpt/skip/skip_intoUserInfo?user_id="+user_id;
		}
	});
}
$(".usre_info,.user_infoBox").mouseover(function(){
	$(".user_infoBox").css("display","block");
});
$(".usre_info,.user_infoBox").mouseout(function(){
	$(".user_infoBox").css("display","none");
});
function login_out(){
		console.log("loginout_ajax");
		$.ajax({
			    url: "/xnjcpt/user/user_logout",
		        type: "post",
		        success: function(){
		        	location.href="/xnjcpt/index.jsp";
 
		        }
		    });
}