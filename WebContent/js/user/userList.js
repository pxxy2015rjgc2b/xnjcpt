var user_paginationQuery={
		"currPage" :'1',
		"totalPage" :'',
		"pageCount" :'10',
		"totalCount ":'',
}
window.onload=function(){
	console.log("list");
	var userPage=new Vue({
		el:'#userVue',
		data:{
			"currPage" :'1',
			"totalPage" :'1',
			"pageCount" :'6',
			"totalCount ":'1',
			"users":""
		
		}
	})
    show_userList();
}
//show_userList_ajax
function show_userList(){
	console.log("list_ajax");
	 $.ajax({
		    url: "xnjcpt/user/user_getUser",
	        type: "post",
	        data:user_paginationQuery,
	        dataType:"json",
	        //报错请加入以下三行，则ajax提交无问题
	        cache: false,  
	        processData: false,  
	        contentType: false,
	        success: function(data){
	        	var result=JSON.parse(data);
	        	//存入vue对象
	        	userPage.users=result.list;
	        	/*userPage.currPage=result.currPage;
	        	userPage.totalPage=result.totalPage;
	        	userPage.pageCount=result.pageCount;
	        	userPage.totalCount=result.totalCount;*/
	        	userPage.currPage=3;
	        	userPage.totalPage=5;
	        	userPage.pageCount=6;
	        	userPage.totalCount=55;
	        	//存入分页查询
	        	user_paginationQuery.currPage=3;
	        	user_paginationQuery.totalPage=5;
	        	user_paginationQuery.pageCount=6;
	        	user_paginationQuery.totalCount =55 ;
	        }
	    });
}
//分页
//首页
function firstPage(){
	    user_paginationQuery.currPage="1";
	    show_userList();
} 
//上一页
function perPage(){
	if(user_paginationQuery.currPage<=1){
		toastr.error("已经是第一页了哦!");
	}else{
     	user_paginationQuery.currPage=--user_paginationQuery.currPage;
	    show_userList();
	}
}
//下一页
function nextPage(){
	if(user_paginationQuery.currPage>=user_paginationQuery.totalPage){
		toastr.error("没有下一页了哦!");
	}else{
     	user_paginationQuery.currPage=++user_paginationQuery.currPage;
	    show_userList();
	}
}
//尾页
function lastPage(){
	user_paginationQuery.currPage=user_paginationQuery.totalPage;
	show_userList();
}
