<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String msg;
	if (session.getAttribute("Msg").toString() == null
			|| "".equals(session.getAttribute("Msg").toString())) {
		msg = "";
	} else {
		msg = session.getAttribute("Msg").toString();
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/UserOption.js"></script>
</head>
<body onload="show()">
	<div id="msg" class="msg">
		<p><%=msg%></p>
	</div>
	<div class="register">
		<p align="center">
			<font size="20" color="#FF3300">用户注册</font>
		</p>
		<table width="340" border="0" align="center">
			<tr>
				<td>用户名：</td>
				<td><input id="name" type="text" name="user" value="" />
			</tr>
			<tr>
				<td>密码：</td>
				<td><input id="pwd" type="password" name="pwd" value="" />
			</tr>
			<tr>
				<td>重复密码：</td>
				<td><input id="pwd1" type="password" name="pwd1" value="" />
			</tr>
			<tr>
				<td>性别：</td>
				<td><input id="sex" type="text" name="sex" value="" />
			</tr>
			<tr>
				<td>年龄：</td>
				<td><input id="age" type="text" name="age" value="" />
			</tr>
			<tr>
				<td><input id="btn_register" type="button" value="注册" /></td>
				<td><input id="btn_canregister" type="button" value="取消" /></td>
			</tr>
		</table>
	</div>
</body>
</html>