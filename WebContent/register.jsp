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
<script language="javascript">
	function show() {
		document.getElementById("msg").style.display = "block";
		setTimeout("hide()", 1000);
	}

	function hide() {
		document.getElementById("msg").style.display = "none";
	}
	
	$(document).ready(function(){
		
	});
</script>
</head>
<body onload="show()">
	<div id="msg" class="msg">
		<p><%=msg%></p>
	</div>
	<div class="register">
		<p align="center">
			<font size="20" color="#FF3300">用户注册</font>
		</p>
		<form id="form_register" name="form_register" method="post"
			action="RegisterServlet">
			<table width="340" border="0" align="center">
				<tr>
					<td width="141">用户名：</td>
					<td width="189"><label> <input name="user" type="text"
							id="user" />
					</label></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><label> <input name="pwd" type="password" id="pwd" />
					</label></td>
				</tr>
				<tr>
					<td>重输密码：</td>
					<td><label> <input name="pwd1" type="password"
							id="pwd1" />
					</label></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><label> <input id="sex" name="sex" type="radio" value="男"
							checked="checked" />男 <input type="radio" name="sex" value="女" />女
					</label></td>
				</tr>
				<tr>
					<td>年龄：</td>
					<td><label> <input id="age" name="age" type="text" id="age" />
					</label></td>
				</tr>
				<tr>
					<td><label> <input id="btn_register" type="submit" name="Submit"
							value="提交" />
					</label></td>
					<td><a href="SkipLoginServlet">取消</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>