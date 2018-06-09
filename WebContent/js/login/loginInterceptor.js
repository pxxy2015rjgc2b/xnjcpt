/**
 * 
 */
function loginIntercptor() {
	$.confirm({
		title : "请重新登录",
		content : "登录验证不通过，可能是未操作时间太久或者为登录造成",
		buttons : {
			reLogin : {
				text : "重新登录",
				btnClass : "btn-blue",
				action : function() {
					window.location = "/xnjcpt/index.jsp";
				}
			}
		}
	});
}