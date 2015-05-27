
/**
 * 修改用户信息
 */
$("#btn_save").click(function() {
	$.ajax({
		type : "post",
		url : "UpdateUserServlet",
		data : {
			name : $("#name").val(),
			pwd : $("#pwd").val(),
			pwd1 : $("#pwd1").val(),
			sex : $("#sex").val(),
			age : $("#age").val()
		},
		datatype : "text",
		success : function(data) {
			$("#msg").html(data);
			$("#msg").show();
			setTimeout("$('#msg').hide();", 1000);
		}
	});
});

/**
 * 注销
 */
$("#logout").click(function() {
	window.location = "LogoutServlet";
});

/**
 * 返回登陆界面
 */
$("#btn_relogin").click(function() {
	window.location = "login.jsp";
})
