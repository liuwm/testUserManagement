function show() {
	document.getElementById("msg").style.display = "block";
	setTimeout("hide()", 1000);
}

function hide() {
	document.getElementById("msg").style.display = "none";
}

function isNum(num) {
	var reNum = /^[0-9]+$/;
	return (reNum.test(num));
}

$(document).ready(function() {
	/**
	 * 注册
	 */
	$("#btn_register").click(function() {
		var name = $("#name").val();
		var pwd = $("#pwd").val();
		var pwd1 = $("#pwd1").val();
		var sex = $("#sex").val();
		var age = $("#age").val();
		if (name == "") {
			$("#msg").html("Error:用户名不能为空");
			$("#msg").show();
			setTimeout("$('#msg').hide();", 1000);
		} else if (pwd == "") {
			$("#msg").html("Error:密码不能为空");
			$("#msg").show();
			setTimeout("$('#msg').hide();", 1000);
		} else if (pwd1 == "") {
			$("#msg").html("Error:重复密码不能为空");
			$("#msg").show();
			setTimeout("$('#msg').hide();", 1000);
		} else if (sex == "") {
			$("#msg").html("Error:性别不能为空");
			$("#msg").show();
			setTimeout("$('#msg').hide();", 1000);
		} else if (age == "") {
			$("#msg").html("Error:年龄不能为空");
			$("#msg").show();
			setTimeout("$('#msg').hide();", 1000);
		} else if (!isNum(age)) {
			$("#msg").html("Error:请输入合适的年龄");
			$("#msg").show();
			setTimeout("$('#msg').hide();", 1000);
		} else {
			$.ajax({
				type : "post",
				url : "RegisterServlet",
				data : {
					name : name,
					pwd : pwd,
					pwd1 : pwd1,
					sex : sex,
					age : age
				},
				datatype : "text",
				success : function(data) {
					$("#msg").html(data);
					$("#msg").show();
					setTimeout("$('#msg').hide();", 1000);
				}
			});
		}
	});
	/**
	 * 返回登陆界面
	 */
	$("#btn_canregister").click(function() {
		window.location = "SkipLoginServlet";
	});

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
	});

})
