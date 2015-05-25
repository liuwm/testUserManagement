<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.User"%>
<%@ page import="java.util.List"%>
<%
	List<User> list = (List<User>) request.getAttribute("list");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="addUser.jsp">新增用户</a>
	<div id="allUserInfo">
		<table border="1">
			<tr>
				<td>name</td>
				<td>sex</td>
				<td>age</td>
				<td>option</td>
			</tr>
			<%
				if (list != null) {
					for (int i = 0; i < list.size(); i++) {
						out.println("<tr><td>"
								+ list.get(i).getU_name()
								+ "</td><td>"
								+ list.get(i).getU_sex()
								+ "</td><td>"
								+ list.get(i).getU_age()
								+ "</td><td><a href='DeleteUserServlet?id="
								+ list.get(i).getU_id()
								+ "'>delete</a>&nbsp;&nbsp;<a href='SelectAdminServlet?id="
								+ list.get(i).getU_id() + "'>update</a></td></tr>");
					}
				} else {
					out.println("no user");
				}
			%>
		</table>
	</div>
</body>
</html>