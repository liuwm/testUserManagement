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
<script type="text/javascript" src="js/userHashChange.js"></script>
</head>
<body>
	<div id="container" class="container">
		<div id="header" class="header">
			<h1>
				欢迎您，<%=name%></h1>
		</div>
		<div id="menu" class="menu">
			<ul>
				<li><a id="select" href="#select">查看个人信息</a></li>
				<li><a id="update" href="#update">修改个人信息</a></li>
				<li><a id="logout" href="#logout">注销</a></li>
			</ul>
		</div>
		<div id="content" class="content"></div>
	</div>
</body>
</html>