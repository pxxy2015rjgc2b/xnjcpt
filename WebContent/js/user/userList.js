var user_paginationQuery={
		"currPage" :'1',
		"totalPage" :'4',
		"pageCount" :'10',
		"totalCount ":'',
}
window.onload=function(){
	console.log("list");
	var userPage=new Vue({
		el:'#userVue',
		data:{
			"currPage" :'1',
			"totalPage" :'4',
			"pageCount" :'6',
			"totalCount":"",
			"users":""
		
		}
	})
    show_userList();
}
//show_userList_ajax
function show_userList(){
	console.log("list_ajax");
	 $.ajax({
		    url: "/xnjcpt/userManager/userManager_getUserlist",
	        type: "post",
	        data:user_paginationQuery,
	        dataType:"json",
	        //报错请加入以下三行，则ajax提交无问题
	        cache: false,  
	        processData: false,  
	        contentType: false,
	        success: function(data){
	        	console.log(data);
	        	var result=JSON.parse(data);
	        	//存入vue对象
	        	userPage.users=result.list;
	        	console.log(userPage.users);
	        	userPage.currPage=result.currPage;
	        	userPage.totalPage=result.totalPage;
	        	userPage.pageCount=result.pageCount;
	        	userPage.totalCount=result.totalCount;
	        	//存入分页查询
	        	user_paginationQuery.currPage=result.currPage;
	        	user_paginationQuery.totalPage=result.totalPage;
	        	user_paginationQuery.pageCount=result.pageCount;
	        	user_paginationQuery.totalCount=result.totalCount;
	        }
	    });
}
//分页
//首页
function firstPage(){
	console.log("首页");
	if(user_paginationQuery.currPage=1){
		toastr.error("已经是第一页了哦!");
	}else{
	    user_paginationQuery.currPage="1";
	    show_userList();
	}
} 
//上一页
function prePage(){
	console.log("上一页");
	if(user_paginationQuery.currPage<=1){
		toastr.error("已经是第一页了哦!");
	}else{
     	user_paginationQuery.currPage=--user_paginationQuery.currPage;
	    show_userList();
	}
}
//下一页
function nextPage(){
	console.log("下一页");
	if(user_paginationQuery.currPage>=user_paginationQuery.totalPage){
		toastr.error("没有下一页了哦!");
	}else{
     	user_paginationQuery.currPage=++user_paginationQuery.currPage;
	    show_userList();
	}
}
//尾页
function lastPage(){
	console.log("尾页");
	if(user_paginationQuery.currPage=user_paginationQuery.totalPage){
		toastr.error("没有下一页了哦!");
	}else{
	user_paginationQuery.currPage=user_paginationQuery.totalPage;
	show_userList();
	}
}
