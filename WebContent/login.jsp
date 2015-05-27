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
<title>用户登录</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript" src="js/UserOption.js"></script>
</head>
<body onload="show()">
	<div id="msg" class="msg">
		<p><%=msg%></p>
	</div>
	<div class="login">
		<div align="center">
			<font size="20" color="#FF6633">用户登录</font>
		</div>
		<div class="form_login">
			<form id="form_login" name="form_login" method="post"
				action="LoginServlet">
				<table width="357" border="0" align="center">
					<tr>
						<td width="128">用户名：</td>
						<td width="219"><label> <input name="user"
								type="text" id="user" />
						</label></td>
					</tr>
					<tr>
						<td>密 码：</td>
						<td><label> <input name="pwd" type="password"
								id="pwd" />
						</label></td>
					</tr>
					<tr>
						<td><label> <input type="submit" name="Submit"
								value="登录" />
						</label></td>
						<td><a href="SkipServlet">注册</a></td>
					</tr>
				</table>
				<p>&nbsp;</p>
			</form>
		</div>
	</div>
</body>
</html>