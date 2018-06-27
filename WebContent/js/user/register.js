//全局变量验证码
var verifyCode;
/*
 * window.onload=function(){ $(".register_button").click(function(){
 * console.log("click"); register_ajax(); }); }
 */
// 点击发送激活链接
$(".show_emailA").click(function() {

	register_ajax();
});
// 点击发送链接后不能修改的特效
$("input").click(function() {
	var readonly = $("input[type='text']").attr("readonly");
	if (readonly == "readonly") {
		toastr.error("发送激活链接后不能修改");
	}
});
// 点击注册按钮,判断是否激活，成功跳转页面
$(".register_button").click(function() {
	active_user();
});
// 注册ajax
function register_ajax() {
	console.log("ajax");
	var user_username = $("input[name='user_username']").val();
	var user_phone = $("input[name='user_phone']").val();
	var user_name = $("input[name='user_name']").val();
	var user_password = $("input[name='user_password']").val();
	var user_email = $("input[name='user_email']").val();
	var user_confirmPassword = $("[name='user_confirmPassword']").val();
	if (user_username != "" && user_phone != "" && user_name != ""
			&& user_password != "" && user_email != ""
			&& user_confirmPassword != "") {
		var formData = new FormData();
		formData.append("user.user_username", user_username);
		formData.append("user.user_phone", user_phone);
		formData.append("user.user_name", user_name);
		formData.append("user.user_password", user_password);
		formData.append("user.user_email", user_email);
		$.ajax({
			url : "/xnjcpt/user/user_register",
			type : "post",
			data : formData,
			// 报错请加入以下三行，则ajax提交无问题
			cache : false,
			processData : false,
			contentType : false,
			success : function(result) {
				if (result == "register_success") {
					toastr.success("注册成功！");

					send_activeEmail();
				} else if (result == "name_error") {
					toastr.error("用户名已存在");
				} else if (result == "email_error") {
					toastr.error("该邮箱已注册，请重新输入");
				}
			}
		});
	} else {
		toastr.error("所有项都为必填项，不能为空，请填写完整！");
	}

}
// 激活用户发送邮件
function send_activeEmail() {
	console.log("激活用户邮箱发送！");
	var data = {
		"user.user_email" : $("input[name='user_email']").val(),
	}
	$.ajax({
		url : "user/user_sendEmail",
		type : "post",
		data : data,
		success : function(result) {
			if (result == "激活邮件发送成功") {
				toastr.success("激活邮件发送成功，请注意查收！");
				// 邮箱正确发送成功后，不能修改资料
				$("input[type='text']").attr("readonly", "readonly");
				$("input[type='password']").attr("readonly", "readonly");
			} else {
				toastr.error("邮件发送失败,请检查邮箱正确性！");
			}

		}
	});
}
// 判断是否激活帐户
function active_user() {
	var user_email = $("input[name='user_email']").val();
	var formData = new FormData();
	formData.append("user.user_email", user_email);
	$.ajax({
		url : "user/user_judgeactivate",
		type : "post",
		data : formData,
		// 报错请加入以下三行，则ajax提交无问题
		cache : false,
		processData : false,
		contentType : false,
		success : function(result) {
			if (result == "activate_1") {
				toastr.success("恭喜您!,帐户已被成功激活，完成注册！2s钟后跳转登录页面！");
				setTimeout(function() {
					location.href = "/xnjcpt/index.jsp";
				}, 2000);
			} else {
				toastr.error("未点击激活链接，不能注册成功！，请前往邮箱进行激活！");
			}
		}
	});
}
// 通过邮箱发送验证码
function sendEmail() {
	console.log($("input[name='user_email']").val());
	var formData = new FormData();
	formData.append("user.user_email", $("input[name='user_email']").val());
	$.ajax({
		url : "user/user_sendEmailtoUpdatePassword",
		type : "post",
		data : formData,
		// 报错请加入以下三行，则ajax提交无问题
		cache : false,
		processData : false,
		contentType : false,
		success : function(result) {
			console.log("发送邮箱");
			console.log("邮箱发送" + result);
			if (result != "验证码发送失败") {
				toastr.success("验证码发送成功!");
				verifyCode = result;
				console.log(verifyCode);
			} else {
				toastr.error("验证码发送失败，请检查邮箱是否填写正确！");
				verifyCode = result;
				console.log(verifyCode);
			}
		}
	});
}

// 找回密码
function forgetPassword() {
	console.log("邮箱发送的" + verifyCode);
	console.log($(".identify_codeInput").val());
	if ($(".identify_codeInput").val() == verifyCode) {
		var formData = new FormData();
		formData.append("user_email", $("input[name='user_email']").val());
		formData.append("newPassword", $("input[name='user_password']").val());
		$.ajax({
			url : "/xnjcpt/user/user_updatePasswordbyverifyCode",
			type : "post",
			data : formData,
			// 报错请加入以下三行，则ajax提交无问题
			cache : false,
			processData : false,
			contentType : false,
			success : function(result) {
				if (result == "updatesuccess") {
					toastr.success("修改密码成功！2s后自动跳转登录界面！");
					// 注册完后跳到首页
					setTimeout(function() {
						window.location.href = "/xnjcpt/index.jsp";
					}, 2000)

				} else {
					toastr.error("验证码错误！");
				}
			}
		});
	} else {
		toastr.error("验证码填写错误，请重新填写！");
	}

}
// 表单验证
// 验证特效
// 用户名
$("[name='user_username']").blur(function() {
	var reg = /^[a-z][a-z0-9]{5}$/i;
	console.log($("[name='user_username']").val());
	if (reg.test($("input[name='user_username']").val())) {
		$("[name='user_usernameHint']").attr("class", "form_spanSucessCheck");
		$("[name='user_username']").attr("class", "form_inputSuccessCheck");
	} else {
		$("[name='user_usernameHint']").attr("class", "form_spanErrorCheck");
		$("[name='user_username']").attr("class", "form_inputErrorCheck");
		$("[name='user_username']").val("");
	}
});
$("[name='user_username']").focus(function() {
	$("[name='user_username']").attr("class", "form_inputFocus");
});
// 用户姓名
$("[name='user_name']").blur(function() {
	console.log($("input[name='user_name']").val());
	if (($("input[name='user_name']").val()) != "") {
		$("[name='user_nameHint']").attr("class", "form_spanSucessCheck");
		$("[name='user_name']").attr("class", "form_inputSuccessCheck");
	} else {
		$("[name='user_nameHint']").attr("class", "form_spanErrorCheck");
		$("[name='user_name']").attr("class", "form_inputErrorCheck");
		$("[name='user_name']").val("");
	}
});
$("[name='user_name']").focus(function() {
	$("[name='user_name']").attr("class", "form_inputFocus");
});
// 用户手机号码
$("[name='user_phone']").blur(function() {
	var reg = /(^1[3|4|5|7|8]\d{9}$)|(^09\d{8}$)/;
	if (reg.test($("input[name='user_phone']").val())) {
		$("[name='user_phoneHint']").attr("class", "form_spanSucessCheck");
		$("[name='user_phone']").attr("class", "form_inputSuccessCheck");
	} else {
		$("[name='user_phoneHint']").attr("class", "form_spanErrorCheck");
		$("[name='user_phone']").attr("class", "form_inputErrorCheck");
		$("[name='user_phone']").val("");
	}
});
$("[name='user_phone']").focus(function() {
	$("[name='user_phone']").attr("class", "form_inputFocus");
});
// 邮箱
$("[name='user_email']").blur(function() {
	var reg = /^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/;
	;
	if (reg.test($("input[name='user_email']").val())) {
		$("[name='user_emailHint']").attr("class", "form_spanSucessCheck");
		$(".show_emailA").css("display", "inline-block");
		$("[name='user_email']").attr("class", "form_inputSuccessCheck");
	} else {
		$(".show_emailA").css("display", "none");
		$("[name='user_emailHint']").attr("class", "form_spanErrorCheck");
		$("[name='user_email']").attr("class", "form_inputErrorCheck");
		$("[name='user_email']").val("");
	}
});
$("[name='user_email']").focus(function() {
	$("[name='user_email']").attr("class", "form_inputFocus");
});
// 用户密码
$("[name='user_password']").blur(function() {
	var user_password = $("input[name='user_password']").val()
	if (user_password.length >= 2 && user_password.length <= 11) {
		$("[name='user_passwordHint']").attr("class", "form_spanSucessCheck");
		$("[name='user_password']").attr("class", "form_inputSuccessCheck");
	} else {
		$("[name='user_passwordHint']").attr("class", "form_spanErrorCheck");
		$("[name='user_password']").attr("class", "form_inputErrorCheck");
		$("[name='user_password']").val("");
	}
});
$("[name='user_password']").focus(function() {
	$("[name='user_password']").attr("class", "form_inputFocus");
});
// 确认密码
$("[name='user_confirmPassword']")
		.blur(
				function() {
					var user_password = $("[name='user_password']").val();
					var user_confirmPassword = $(
							"[name='user_confirmPassword']").val();
					if (user_confirmPassword == user_password) {
						$("[name='user_confirmPasswordHint']").attr("class",
								"form_spanSucessCheck");
						$("[name='user_confirmPassword']").attr("class",
								"form_inputSuccessCheck");
					} else {
						$("[name='user_confirmPasswordHint']").attr("class",
								"form_spanErrorCheck");
						$("[name='user_confirmPassword']").attr("class",
								"form_inputErrorCheck");
						$("[name='user_confirmPassword']").val("");
					}
				});
$("[name='user_confirmPassword']").focus(function() {
	$("[name='user_confirmPassword']").attr("class", "form_inputFocus");
});