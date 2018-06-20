/**
 * 
 */

var computerManangerVue;

var queryTemp={
		'currPage':'1',
		'searchContent':'',
		'searchStatus':''
}

$(function(){
	computerManangerVue = new Vue({
		el:'#computerManangerVue',
		data:{
			computerManangerVO:''
		}
	});
	loadData();
})

function loadData(){
	$('#showTable').hide();
	$('#loadingLayer').show();
	var queryContent = {
			'computerManagerVO.currPage':queryTemp.currPage,
			'computerManagerVO.searchContent':queryTemp.searchContent,
			'computerManagerVO.searchStatus':queryTemp.searchStatus
	}
	$.ajax({
		url:'/xnjcpt/computer/computer_getComputerByConditionAndPage',
		type:'POST',
		data:queryContent,
		success:function(data){
			if(data!="noLogin"){
				computerManangerVue.computerManangerVO = JSON.parse(data);	
			}else{
				loginIntercptor();
			}
			$('#loadingLayer').hide();
			$('#showTable').show();
		}
	});
}

//首页
function skipToIndexPage(){
	if(computerManangerVue.computerManangerVO.currPage == '1'){
		toastr.error("已经是首页");
	}
	else{
		queryTemp.currPage='1'
		loadData();
	}
}
//上一页
function skipToPrimaryPage(){
	if(computerManangerVue.computerManangerVO.currPage <='1'){
		toastr.error("没有上一页了哦");
	}
	else{
		queryTemp.currPage = --computerManangerVue.computerManangerVO.currPage;
		loadData();
	}
}
//下一页
function skipToNextPage(){
	if(computerManangerVue.computerManangerVO.currPage>=computerManangerVue.computerManangerVO.totalPage){
		toastr.error("没有下一页了哦");
	}
	else{
		queryTemp.currPage = ++computerManangerVue.computerManangerVO.currPage;
		loadData()
	}
}
//末页
function skipToLastPage(){
	if(computerManangerVue.computerManangerVO.currPage==computerManangerVue.computerManangerVO.totalPage)
		{
			toastr.error("已经是第一页了哦");
		}
	else{
		queryTemp.currPage = computerManangerVue.computerManangerVO.totalPage;
		loadData();
	}
}
//跳页
function skipToArbitrarilyPage(){
	if($('#skipPage').val()<'1'||$('#skipPage').val()>computerManangerVue.computerManangerVO.totalPage){
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
	queryTemp.searchStatus = $('#computer_status').val();
	queryTemp.currPage = '1';
	loadData();
}

