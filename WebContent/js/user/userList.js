var user_paginationQuery={
		"currPage" :"1",
		"totalPage" :'',
		"pageCount" :'',
		"totalCount ":''
}
var userPage;
window.onload=function(){
	console.log("list");
    userPage=new Vue({
		el:'#userVue',
		data:{
			"currPage" :'1',
			"totalPage" :'1',
			"pageCount" :'0',
			"totalCount":'0',
			"users":""
		
		}
	})
    show_userList();
    $(".search_button").click(function(){
    	var keyword=$(".search_input").val();
    	console.log(keyword);
    	iquery_userList(keyword);
    });
}
//show_userList_ajax
function show_userList(){
	var user_paginationQueryAjax={
			"pb.currentPage" :user_paginationQuery.currPage,
			"pb.totalPage" :user_paginationQuery.totalPage,
			"pb.pageSize" :user_paginationQuery.pageCount,
			"pb.count":user_paginationQuery.totalCount,
	}
	console.log(user_paginationQueryAjax);
	 $.ajax({
		    url: "/xnjcpt/userManager/userManager_getUserlist",
	        type: "post",
	        data:user_paginationQueryAjax,
	        success: function(data){
	        	//console.log(data);
	        	var result=JSON.parse(data);
	        	//存入vue对象
	        	userPage.users=result.list;
	        	userPage.currPage=result.currentPage;
	        	console.log(userPage.currPage);
	        	userPage.totalPage=result.totalPage;
	        	userPage.pageCount=result.pageSize;
	        	userPage.totalCount=result.count;
	        	//存入分页查询
	        	user_paginationQuery.currPage=result.currentPage;
	        	console.log(user_paginationQuery.currPage);
	        	console.log(user_paginationQuery.currPage);
	        	user_paginationQuery.totalPage=result.totalPage;
	        	user_paginationQuery.pageCount=result.pageSize;
	        	user_paginationQuery.totalCount=result.count;
	        }
	    });
}
//按关键字搜索列表
function iquery_userList(keyword){
	console.log("按关键字搜索");
	var iquery_keyword={
			"keyword":keyword,
	}
	 $.ajax({
		    url: "/xnjcpt/userManager/userManager_getUser",
	        type: "post",
	        data:iquery_keyword,
	        
	        //报错请加入以下三行，则ajax提交无问题
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
	        	user_paginationQuery.currPage=result.currentPage;
	        	user_paginationQuery.totalPage=result.totalPage;
	        	user_paginationQuery.pageCount=result.pageSize;
	        	user_paginationQuery.totalCount=result.count;
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
     	console.log("当前页"+user_paginationQuery.currPage);
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
     	console.log("当前页"+user_paginationQuery.currPage);
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
