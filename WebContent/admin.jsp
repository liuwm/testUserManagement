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
<title>管理员</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/UserOption.js"></script>
<script type="text/javascript" src="js/AdminOption.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		window.onhashchange = function(){
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
			case "#option":
				$.ajax({
					type : "get",
					url : "AllUserInfoServlet",
					datatype : "json",
					success : function(data) {
						var length = data.length;
						var i = 0;
						var result = "<div id=\"msg\"></div><div><a href=\"#option_add\" class=\"addUser\">新增用户</a><table><tr><td>姓名</td><td>性别</td><td>年龄</td><td>操作</td></tr>";
						for (i = 0; i < length; i++) {
							result += "<tr><td>"+data[i].u_name+"</td><td>"+data[i].u_sex+"</td><td>"+data[i].u_age+"</td><td><a href=\"#option_delete\" class=\"delete\" id="+data[i].u_id+">删除</a><a href=\"#option_update\" class=\"update\" id="+data[i].u_id+">修改</a></td></tr>";
						}
						result += "</table></div>";
						
						$("#content").html(result);
						
						/**
						 * 新增用户
						 */
						$(".addUser").on("click",function(){
							$("#content").load("addUser.jsp");
						});
						
						/**
						 * 删除用户
						 */
						$(".delete").on('click',function(){
							$.ajax({
								type:"post",
								url:"DeleteUserServlet",
								data:{id:$(this).attr("id")},
								datatype:"text",
								success:function(data){
									window.location="#option";
								}
							});
						});
						
						/**
						 * 修改用户
						 */
						$(".update").on("click",function(){
							$.ajax({
								type:"post",
								url:"SelectAdminServlet",
								data:{id:$(this).attr("id")},
								datatype:"json",
								success:function(data){
									$("#content").load("updateUserInfo.jsp", {
										name : data[0].u_name,
										pwd : data[0].u_pwd,
										sex : data[0].u_sex,
										age : data[0].u_age
									});
								}
							});
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
				<li><a href="#option">用户操作</a></li>
				<li><a href="#logout">注销</a></li>
			</ul>
		</div>
		<div id="content">
			<div id="resultMsg"></div>
			<div id="userInfo" style="display: none"></div>
			<div id="allUserInfo" style="display: none"></div>
			<div id="updateUserInfo" style="display: none;">
				<table>
					<tr>
						<td>用户名：</td>
						<td><input id="user" type="text" name="user" value=""
							readonly="readonly" />
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
						<td><input type="button" id="btn_update" value="保存" /></td>
						<td></td>
					</tr>
				</table>
			</div>
			<div id="addUserInfo" style="display: none">
				<table>
					<tr>
						<td>用户名：</td>
						<td><input id="user1" type="text" name="user" value="" />
					</tr>
					<tr>
						<td>密码：</td>
						<td><input id="pwd2" type="password" name="pwd" value="" />
					</tr>
					<tr>
						<td>重复密码：</td>
						<td><input id="pwd3" type="password" name="pwd1" value="" />
					</tr>
					<tr>
						<td>性别：</td>
						<td><input id="sex1" type="text" name="sex" value="" />
					</tr>
					<tr>
						<td>年龄：</td>
						<td><input id="age1" type="text" name="age" value="" />
					</tr>
					<tr>
						<td><input type="button" id="btn_add" value="提交" /></td>
						<td><input type="button" id="btn_reset" value="重置" /></td>
					</tr>
				</table>
			</div>
		</div>
		<div id="footer">页脚</div>
	</div>
</body>
</html>