/**
 * 
 */

var computerVue;
var queryTemp  = {
		currPage:'1',
		searchContent:''
}


$(function(){
	computerVue = new Vue({
		el:'#show_content',
		data:{
			computerVO:''
		}
	})
	loadData();
});

//首页
function skipToIndexPage(){
	if(computerVue.computerVO.currPage == '1'){
		toastr.error("已经是首页");
	}
	else{
		queryTemp.currPage='1'
		loadData();
	}
}
//上一页
function skipToPrimaryPage(){
	if(computerVue.computerVO.currPage <='1'){
		toastr.error("没有上一页了哦");
	}
	else{
		queryTemp.currPage = --computerVue.computerVO.currPage;
		loadData();
	}
}
//下一页
function skipToNextPage(){
	if(computerVue.computerVO.currPage>=computerVue.computerVO.totalPage){
		toastr.error("没有下一页了哦");
	}
	else{
		queryTemp.currPage = ++computerVue.computerVO.currPage;
		loadData()
	}
}
//末页
function skipToLastPage(){
	if(computerVue.computerVO.currPage==computerVue.computerVO.totalPage)
		{
			toastr.error("已经是第一页了哦");
		}
	else{
		queryTemp.currPage = computerVue.computerVO.totalPage;
		loadData();
	}
}
//跳页
function skipToArbitrarilyPage(){
	if($('#skipPage').val()<'1'||$('#skipPage').val()>computerVue.computerVO.totalPage){
		toastr.error("不存在此页");
	}
	else{
		queryTemp.currPage = $('#skipPage').val();
		loadData();
	}
}

//切换搜索条件
function changeQuery(){
	queryTemp.searchContent = $('#searchContentSort').val();
	queryTemp.currPage = '1';
	loadData();
}


function loadData(){
	$('#showContent').hide();
	$('#loadingLayer').show();
	var queryData = {
			'computerPageVO.currPage':queryTemp.currPage,
			'computerPageVO.searchContent':queryTemp.searchContent
	};
	$.ajax({
		url:'/xnjcpt/computer/computer_getComputerByPage',
		type:'POST',
		data:queryData,
		success:function(data){
			if(data!='noLogin'){
				computerVue.computerVO = JSON.parse(data);
			}else{
				loginIntercptor();
			}
			$('#loadingLayer').hide();
			$('#showContent').show();
		}
	})
}