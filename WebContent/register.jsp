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
<script type="text/javascript" src="js/FormUtil.js"></script>
</head>
<body onload="show()">
	<div id="msg" class="msg">
		<p><%=msg%></p>
	</div>
	<div class="register">
		<p align="center">
			<font size="20" color="#FF3300">用户注册</font>
		</p>
		<!-- <form id="form_register" name="form_register" method="post"
			action="RegisterServlet" onsubmit="return inputCheck(this)"> -->
		<form id="form_register" name="form_register">
			<table width="500px" border="0" align="center">
				<tr>
					<td>用户名：</td>
					<td><input id="name" type="text" name="name" value="" oninput="changeText(this);" />
						<div id="name_isEmpty" class="tip" input="name" check="regex /^\S+$/gi">用户名不能为空</div>
					</td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input id="pwd" type="password" name="pwd" value="" oninput="changeText(this);" />
						<div id="pwd_isEmpty" class="tip" input="pwd" check="regex /^\S+$/gi">密码不能为空</div>
						<!-- <div id="pwd_pwd" class="tip" input="pwd" check="compare pwd1">两次密码不同</div>  -->
					</td>
				</tr>
				<tr>
					<td>重复密码：</td>
					<td><input id="pwd1" type="password" name="pwd1" value="" oninput="changeText(this);" />
						<div id="pwd1_isEmpty" class="tip" input="pwd1" check="regex /^\S+$/gi">密码不能为空</div>
						<div id="pwd1_pwd" class="tip" input="pwd1" check="compare pwd">两次密码不同</div>
					</td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><select id="sex" name="sex">
							<option value="男" selected="selected">男</option>
							<option value="女">女</option>
					</select></td>
				</tr>
				<tr>
					<td>年龄：</td>
					<td><input id="age" type="text" name="age" value="" oninput="changeText(this);" />
						<div id="age_isEmpty" class="tip" input="age" check="regex /^\S+$/gi">年龄不能为空</div>
						<div id="age_isNum" class="tip" input="age" check="regex /^[0-9]+$/">年龄必须为数字</div>
					</td>
				</tr>
				<tr>
					<td><input id="btn_register" type="button" value="注册" /></td>
					<!-- <td><input id="btn_register" type="submit" name="submit"
						value="注册" /></td> -->
					<td><input id="btn_canregister" type="button" value="取消" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>