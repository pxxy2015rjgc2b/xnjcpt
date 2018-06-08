/**
 * 
 */

function createAlarm(){
	$.confirm({
		title:'<i class="fa fa-edit"></i>新增警报',
		content:'',
		type:'blue',
		buttons:{
			save:{
				text:'保存',
				btnClass:'btn-blue'
			},
			cancle:{
				text:'关闭',
				btnClass:'btn-red'
			}
		}
	});
}