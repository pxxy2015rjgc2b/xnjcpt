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
