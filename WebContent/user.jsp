<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>普通用户</title>
<style type="text/css">
div#container {
	width: 500px
}

div#header {
	background-color: #99bbbb;
}

div#menu {
	background-color: #ffff99;
	height: 200px;
	width: 150px;
	float: left;
}

div#content {
	background-color: #EEEEEE;
	height: 200px;
	width: 350px;
	float: left;
}

div#footer {
	background-color: #99bbbb;
	clear: both;
	text-align: center;
}

h1 {
	margin-bottom: 0;
}

h2 {
	margin-bottom: 0;
	font-size: 18px;
}

ul {
	margin: 0;
}

li {
	list-style: none;
}
</style>

<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>普通用户</h1>
		</div>
		<div id="menu">
			<h2>信息</h2>
			<ul>
				<li><a href="SelectServlet" target="content">查看信息</a></li>
				<li><a href="index.jsp">注销</a></li>
			</ul>
		</div>
		<div id="content">
			<iframe name="content" src="welcome.jsp" width=340 height=200
				frameborder="no" border="0" marginwidth="0" marginheight="0"
				scrolling="no" allowtransparency="yes"> </iframe>
		</div>
		<div id="footer">页脚</div>
	</div>
</body>
</html>