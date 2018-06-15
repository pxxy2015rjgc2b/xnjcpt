function add_alarm() {
	$.confirm({
		title: '添加警报',
		content: '<div class="comfirm_box"><input placeholder="要添加的主机IP" class="comfirm_input oldPassword" type="text"/></div><div class="comfirm_box"><select class="comfirm_select newPassword"  placeholder="警报类型"><option>CPU利用率</option><option>CPU利用率</option><option>内存利用率</option><option>出带宽</option><option>入带宽</option><option>出包量</option><option>入包量</option></select></div><div class="comfirm_box"><input class="comfirm_input newPassword"  placeholder="警报阈值" type="text"/></div><div class="comfirm_box"><select class="comfirm_select newPassword"  placeholder="是否启用"><option>启用</option><option>不启用</option></select></div>',
		type: 'yellow',
		buttons: {
			确认: {
				btnClass: ' btn-blue',
				type: "blue",
				action: function() {}
			},
			取消: {
				btnClass: 'btn-red',
				type: "red",
				
			}
		}
	});
}
function edit_alarm(){
	$.confirm({
		title: '编辑警报',
		content: '<div class="comfirm_box"><input placeholder="要添加的主机IP" class="comfirm_input oldPassword" type="text"/></div><div class="comfirm_box"><select class="comfirm_select newPassword"  placeholder="警报类型"><option>CPU利用率</option><option>CPU利用率</option><option>内存利用率</option><option>出带宽</option><option>入带宽</option><option>出包量</option><option>入包量</option></select></div><div class="comfirm_box"><input class="comfirm_input newPassword"  placeholder="警报阈值" type="text"/></div><div class="comfirm_box"><select class="comfirm_select newPassword"  placeholder="是否启用"><option>启用</option><option>不启用</option></select></div>',
		type: 'yellow',
		buttons: {
			确认: {
				btnClass: ' btn-blue',
				type: "blue",
				action: function() {}
			},
			取消: {
				btnClass: 'btn-red',
				type: "red",
			}
		}
	});
}

