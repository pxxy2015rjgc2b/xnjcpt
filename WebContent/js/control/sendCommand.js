/**
 * 
 */

$(function(){
	 $('#terminal').bind('keyup', function(event) {
	        if (event.keyCode == "13") {
	            //回车执行查询
	        	sendCommand();
	        }
	    });
})

function sendCommand(){
	var content = $('#terminal').val();
	var location_  = content.lastIndexOf('$：');
	var comm = content.substring(location_+2);
	$.ajax({
		url:'/xnjcpt/computer/computer_execCommand',
		type:'POST',
		data:{
			'id':getId(),
			'command':comm
		},
		success:function(data){
			if(data!='noLogin'){
				 $('#terminal').val($('#terminal').val()+data);	 
			}else{
				loginIntercptor();
			}
			document.getElementById("terminal").scrollTop = document.getElementById("terminal").scrollHeight;
		}
	})
}
function cleanContent(){
	$('#terminal').val('$：');
}