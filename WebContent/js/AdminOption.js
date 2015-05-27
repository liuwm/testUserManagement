$(document).ready(function() {
	/**
	 * 重置信息
	 */
	$("#btn_reset").click(function() {
		$("#user1").val("");
		$("#pwd2").val("");
		$("#pwd3").val("");
		$("#sex1").val("");
		$("#age1").val("");
	});

	/**
	 * 取消
	 */
	$("#btn_cancle").click(function() {
		window.location = "#option";
	});

	/**
	 * 新增用户
	 */
	$("#btn_submit").click(function() {
		$.ajax({
			type : "post",
			url : "AddUserServlet",
			data : {
				name : $("#name").val(),
				pwd : $("#pwd").val(),
				pwd1 : $("#pwd1").val(),
				sex : $("#sex").val(),
				age : $("#age").val()
			},
			datatype : "text",
			success : function(data) {
				$("#addMsg").html(data);
			}
		});
	});
});