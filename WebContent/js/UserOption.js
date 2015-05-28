function show() {
	document.getElementById("msg").style.display = "block";
	setTimeout("hide()", 1000);
}

function hide() {
	document.getElementById("msg").style.display = "none";
}

/**
 * 输入框改变事件
 * @param element
 */
function changeText(element) {
	var divs = $("[input=" + element.id + "]");
	var elements = new Array();
	for (var i = 0; i < divs.length; i++) {
		elements.push(divs[i]);
		var bool = FormUtil.checkTag(elements);
		if (bool) {
			$("#" + divs[i].id).hide();
			$("#msg").hide();
		}else{
			$("#" + divs[i].id).show();
		}
		elements.pop();
	}
}

$(document).ready(function() {
	/**
	 * 注册按钮点击事件
	 */
	$("#btn_register").click(function() {
		var elements = FormUtil.inputCheck("form_register");
		var bool = FormUtil.checkTag(elements);
		if (bool) {
			var data = FormUtil.getValue(elements);
			$.ajax({
				type : "post",
				url : "RegisterServlet",
				data : {
					data : data
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
