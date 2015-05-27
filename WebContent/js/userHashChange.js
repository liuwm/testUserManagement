$(document).ready(
		function() {
			window.onhashchange = function() {
				var type = window.location.hash;
				switch (type) {
				case "#select":
					$("#select").css("color","black");
					$("#update").css("color","#ffffff");
					$.ajax({
						type : "get",
						url : "SelectServlet",
						datatype : "json",
						success : function(data) {
							var result = "<table class='tbl'><tr><td>用户名:</td><td>"
									+ data[0].u_name
									+ "</td></tr><tr><td>性别:</td><td>"
									+ data[0].u_sex
									+ "</td></tr><tr><td>年龄:</td><td>"
									+ data[0].u_age + "</td></tr><table>";
							$("#content").html(result);
						}
					});
					break;
				case "#update":
					$("#select").css("color","#ffffff");
					$("#update").css("color","black");
					$.ajax({
						type : "get",
						url : "SelectServlet",
						datatype : "json",
						success : function(data) {
							$("#content").load("updateUserInfo.jsp", {
								name : data[0].u_name,
								pwd : data[0].u_pwd,
								sex : data[0].u_sex,
								age : data[0].u_age
							});
						}
					});
					break;
				case "#logout":
					window.location = "LogoutServlet";
					break;
				default:
					break;
				}
			}
		});