<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.User"%>
<%
	User user = (User) request.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function show() {
		document.getElementById("userInfo").style.display = "none";
		document.getElementById("updateInfo").style.display = "block";
	}
</script>
</head>
<body>
	<div id="updateInfo" style="display: none;">
		<form id="form1" name="form1" method="post" action="UpdateUserServlet">
			<table>
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="user"
						value="<%=user.getU_name()%>" readonly="readonly" />
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="pwd"
						value="<%=user.getU_pwd()%>" />
				</tr>
				<tr>
					<td>重复密码：</td>
					<td><input type="password" name="pwd1"
						value="<%=user.getU_pwd()%>" />
				</tr>
				<tr>
					<td>性别：</td>
					<td><input type="text" name="sex" value="<%=user.getU_sex()%>" />
				</tr>
				<tr>
					<td>年龄：</td>
					<td><input type="text" name="age" value="<%=user.getU_age()%>" />
				</tr>
				<tr>
					<td><input type="submit" name="submit" value="保存" /></td>
					<td></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="userInfo">
		<table>
			<tr>
				<td>用户名：</td>
				<td><%=user.getU_name()%></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><%=user.getU_sex()%></td>
			</tr>
			<tr>
				<td>年龄：</td>
				<td><%=user.getU_age()%></td>
			</tr>
			<tr>
				<td><input type="button" id="btn_update" onclick="show();"
					value="修改个人信息" /></td>
				<td></td>
			</tr>
		</table>
	</div>
</body>
</html>