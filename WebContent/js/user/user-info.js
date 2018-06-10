window.onload=function(){
	userInfo_ajax();
	//这是得到user_id
	var user_id="";
	var user=new Vue({
		el:"#user_info",
		data:{
		    "userInfo":"",
		}
	});
}
function userInfo_ajax(){
	$.ajax({
		url:"",
		type:"POST",
		data:user_id,
		success:function(data){
			var userData=JSON.parse(data);
			userInfo.userInfo=userData;
			
			
		}
	});
}