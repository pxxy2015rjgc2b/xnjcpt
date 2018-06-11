window.onload=function(){
	var vm=new Vue({
		el:'#userVue',
		data:{
			"currPage" :'1',
			"totalPage" :'',
			"pageCount" :'10',
			"totalCount ":'',
			"users":"",
		}
	})
    show_userList();
}
//show_userList_ajax
function show_userList(){
	 $.ajax({
		    url: "user/user_register",
	        type: "post",
	        data:formData,
	        dataType:"json",
	        //报错请加入以下三行，则ajax提交无问题
	        cache: false,  
	        processData: false,  
	        contentType: false,
	        success: function(data){
	        	var result=JSON.parse(data);
	        	userVue.users=result.users;
	        }
	    });
}
 
