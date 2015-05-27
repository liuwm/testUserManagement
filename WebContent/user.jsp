<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.User"%>
<%
	String name = session.getAttribute("name").toString();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>普通用户</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/UserOption.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				window.onhashchange = function() {
					var type = window.location.hash;
					switch (type) {
					case "#select":
						$.ajax({
							type : "get",
							url : "SelectServlet",
							datatype : "json",
							success : function(data) {
								var result = "<table><tr><td>用户名:</td><td>"
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
</script>
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>
				欢迎您，<%=name%></h1>
		</div>
		<div id="menu">
			<h2>信息</h2>
			<ul>
				<li><a href="#select">查看个人信息</a></li>
				<li><a href="#update">修改个人信息</a></li>
				<li><a href="#logout">注销</a></li>
			</ul>
		</div>
		<div id="content"></div>
		<div id="footer">页脚</div>
	</div>
</body>
</html>