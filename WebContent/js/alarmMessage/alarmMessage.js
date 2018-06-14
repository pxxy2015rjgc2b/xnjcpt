/**
 * 
 */
var alarmMessageVue;
var queryTemp = {
	currPage:'1'
}
$(function(){
	alarmMessageVue = new Vue({
		el:'#allContent',
		data:{
			alarmMessagePageVO:''
		}
	})
	loadData();
});

//首页
function skipToIndexPage(){
	if(alarmMessageVue.alarmMessagePageVO.currPage == '1'){
		toastr.error("已经是首页");
	}
	else{
		queryTemp.currPage='1'
		loadData();
	}
}
//上一页
function skipToPrimaryPage(){
	if(alarmMessageVue.alarmMessagePageVO.currPage <='1'){
		toastr.error("没有上一页了哦");
	}
	else{
		queryTemp.currPage = --alarmMessageVue.alarmMessagePageVO.currPage;
		loadData();
	}
}
//下一页
function skipToNextPage(){
	if(alarmMessageVue.alarmMessagePageVO.currPage>=alarmMessageVue.alarmMessagePageVO.totalPage){
		toastr.error("没有下一页了哦");
	}
	else{
		queryTemp.currPage = ++alarmMessageVue.alarmMessagePageVO.currPage;
		loadData()
	}
}
//末页
function skipToLastPage(){
	if(alarmMessageVue.alarmMessagePageVO.currPage==alarmMessageVue.alarmMessagePageVO.totalPage)
		{
			toastr.error("已经是第一页了哦");
		}
	else{
		queryTemp.currPage = alarmMessageVue.alarmMessagePageVO.totalPage;
		loadData();
	}
}
//跳页
function skipToArbitrarilyPage(){
	if($('#skipPage').val()<'1'||$('#skipPage').val()>alarmMessageVue.alarmMessagePageVO.totalPage){
		toastr.error("不存在此页");
	}
	else{
		queryTemp.currPage = $('#skipPage').val();
		loadData();
	}
}
function loadData(){
	$('#showContent').hide();
	$('#loadingLayer').show();
	var queryContent = {
			'alarmMessageVO.currPage':queryTemp.currPage
	};
	$.ajax({
		url:'/xnjcpt/alarm/alarm_getAlarmMessageByPage',
		type:'POST',
		data:queryContent,
		success:function(data){
			if(data!='noLogin'){
			alarmMessageVue.alarmMessagePageVO =JSON.parse(data)
			}
			else{
				loginIntercptor();
			} 
			$('#loadingLayer').hide();
			$('#showContent').show();
		}
	})
}