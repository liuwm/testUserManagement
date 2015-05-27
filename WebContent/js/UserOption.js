$(document).ready(function() {
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
			}
		});
	});

	/**
	 * 注销
	 */
	$("#logout").click(function() {
		window.location = "LogoutServlet";
	});
});