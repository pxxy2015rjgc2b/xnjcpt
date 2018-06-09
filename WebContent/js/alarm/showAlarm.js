/**
 * 
 */

var alarmVue;
var queryTemp = {
		"currPage":1,
		"searchContent":'',
		"searchAlarmType":''
}
$(function(){
	alarmVue = new Vue({
		el:'#show_box',
		data:{
			alarmVO:''
		}
	});
	loadData();
})
//首页
function skipToIndexPage(){
	if(alarmVue.alarmVO.currPage == '1'){
		toastr.error("已经是首页");
	}
	else{
		queryTemp.currPage='1'
		loadData();
	}
}
//上一页
function skipToPrimaryPage(){
	if(alarmVue.alarmVO.currPage <='1'){
		toastr.error("没有上一页了哦");
	}
	else{
		queryTemp.currPage = --alarmVue.alarmVO.currPage;
		loadData();
	}
}
//下一页
function skipToNextPage(){
	if(alarmVue.alarmVO.currPage>=alarmVue.alarmVO.totalPage){
		toastr.error("没有下一页了哦");
	}
	else{
		queryTemp.currPage = ++alarmVue.alarmVO.currPage;
		loadData()
	}
}
//末页
function skipToLastPage(){
	if(alarmVue.alarmVO.currPage==alarmVue.alarmVO.totalPage)
		{
			toastr.error("已经是第一页了哦");
		}
	else{
		queryTemp.currPage = alarmVue.alarmVO.totalPage;
		loadData();
	}
}
//跳页
function skipToArbitrarilyPage(){
	if($('#skipPage').val()<'1'||$('#skipPage').val()>alarmVue.alarmVO.totalPage){
		toastr.error("不存在此页");
	}
	else{
		queryTemp.currPage = $('#skipPage').val();
		loadData();
	}
}

//切换搜索条件
function changeQuery(){
	queryTemp.searchAlarmType  = $('#searchType').val();
	queryTemp.searchContent = $('#searchContentSort').val();
	queryTemp.currPage = '1';
	loadData();
}

function loadData(){
	$('#showContent').hide();
	$('#loadingLayer').show();
	var query = {
			'alarmPageVO.currPage':queryTemp.currPage , 
			'alarmPageVO.searchContent':queryTemp.searchContent , 
			'alarmPageVO.searchAlarmType':queryTemp.searchAlarmType
	}
	$.ajax({
		url:'/xnjcpt/alarm/alarm_getAlarmByPage',
		type:'POST',
		data:query,
		success:function(data){
			if(data!="noLogin"){
				alarmVue.alarmVO  = JSON.parse(data);
			}else{
				//登录验证
				loginIntercptor();
			}
			$('#loadingLayer').hide();
			$('#showContent').show();
		}
	});
}