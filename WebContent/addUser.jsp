<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/UserOption.js"></script>
<script type="text/javascript" src="js/AdminOption.js"></script>
</head>
<body>
	<div id="msg"></div>
	<div>

		<table width="340" border="0" align="center" class="tbl">
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
				<td><input type="button" id="btn_submit" value="保存" /></td>
				<td><input type="button" id="btn_cancle" value="取消" /></td>
			</tr>
		</table>
	</div>
</body>
</html>