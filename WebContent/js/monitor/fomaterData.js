/**
 * 
 */

function fomatterDataLine(data){
	var arrAll = [];
	for (var int = 0; int < data.length; int++) {
		var arr = []
		for ( var i in data[int]) {
			arr.push(data[int][i]);
		}
		arrAll.push(arr);
	}
	for (var int2 = 0; int2 < data.length; int2++) {
		data[int2].value = arrAll[int2];
	}
	return data;
}
function getId(){
	var url = window.location.href
	var computer_id = url.substring(url.indexOf("=")+1);
	return computer_id;
}

function getSevenStartTime(){
    var today = new Date();    
    var targetday_milliseconds=today.getTime() - 1000*60*60*24*6;            
    today.setTime(targetday_milliseconds); //注意，这行是关键代码  
    var tYear = today.getFullYear();    
    var tMonth = today.getMonth();    
    var tDate = today.getDate();    
    tMonth = doHandleMonth(tMonth + 1);    
    tDate = doHandleMonth(tDate);    
    return tYear+"-"+tMonth+"-"+tDate+' 00:00:00';  
}

function doHandleMonth(month){    
    var m = month;    
    if(month.toString().length == 1){    
       m = "0" + month;    
    }    
    return m;    
}  

function getStartTime(){
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth();
	month++;
	if(month<=9)
	{
		month= '0'+month;
	}
	var day = date.getDate();
	return year+'-'+month+'-'+day+' 00:00:00'
}
function getEndTime(){
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth();
	month++;
	if(month<=9)
	{
		month= '0'+month;
	}
	var day = date.getDate();
	return year+'-'+month+'-'+day+' 23:59:59'
}