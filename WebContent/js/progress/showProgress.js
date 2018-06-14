/**
 * 
 */

var progressVue;
var queryTemp={
		currPage:'1'
}
$(function(){
	progressVue = new Vue({
		el:'#allContent',
		data:{
			progressPageVO:''
		}
	})
	loadData();
})
function loadData(){
	$('#showContent').hide();
	$('#loadingLayer').show();
	var queryData = {
			'progressPageVO.currPage':queryTemp.currPage,
			'computer_id':getId()
	}
	$.ajax({
		url:'/xnjcpt/computer/computer_getProgressByPage',
		type:'POST',
		data:queryData,
		success:function(data){
			if(data!='noLoign'){
				progressVue.progressPageVO = JSON.parse(data);
			}else{
				loginIntercptor();
			}
			$('#loadingLayer').hide();
			$('#showContent').show();

		}
	})
}
//首页
function skipToIndexPage(){
	if(progressVue.progressPageVO.currPage == '1'){
		toastr.error("已经是首页");
	}
	else{
		queryTemp.currPage='1'
		loadData();
	}
}
//上一页
function skipToPrimaryPage(){
	if(progressVue.progressPageVO.currPage <='1'){
		toastr.error("没有上一页了哦");
	}
	else{
		queryTemp.currPage = --progressVue.progressPageVO.currPage;
		loadData();
	}
}
//下一页
function skipToNextPage(){
	if(progressVue.progressPageVO.currPage>=progressVue.progressPageVO.totalPage){
		toastr.error("没有下一页了哦");
	}
	else{
		queryTemp.currPage = ++progressVue.progressPageVO.currPage;
		loadData()
	}
}
//末页
function skipToLastPage(){
	if(progressVue.progressPageVO.currPage==progressVue.progressPageVO.totalPage)
		{
			toastr.error("已经是第一页了哦");
		}
	else{
		queryTemp.currPage = progressVue.progressPageVO.totalPage;
		loadData();
	}
}
//跳页
function skipToArbitrarilyPage(){
	if($('#skipPage').val()<'1'||$('#skipPage').val()>progressVue.progressPageVO.totalPage){
		toastr.error("不存在此页");
	}
	else{
		queryTemp.currPage = $('#skipPage').val();
		loadData();
	}
}
function clossProgress(event){
	var sendData = {
			'id':getId(),
			'pid':event.id
	}
	$.ajax({
		url:'/xnjcpt/computer/computer_stopProgress',
		type:'POST',
		data:sendData,
		success:function(data){
			if(data!='noLogin'){
				if(data =='closeSuccess'){
					toastr.success("关闭成功");
					loadData();
				}else{
					toastr.error("关闭失败");
				}
			}else{
				loginIntercptor();
			}
		}
	})
}