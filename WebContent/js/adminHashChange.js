$(document).ready(function(){
		window.onhashchange = function(){
			var type = window.location.hash;
			switch (type) {
			case "#select":
				$("#select").css("color","black");
				$("#update").css("color","#ffffff");
				$("#option").css("color","#ffffff");
				$.ajax({
					type : "get",
					url : "SelectServlet",
					datatype : "json",
					success : function(data) {
						var result = "<div class='msg' id='msg'></div><table class='tbl'><tr><td>用户名:</td><td>"
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
				$("#select").css("color","#ffffff");
				$("#update").css("color","black");
				$("#option").css("color","#ffffff");
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
				$("#select").css("color","#ffffff");
				$("#update").css("color","#ffffff");
				$("#option").css("color","black");
				$.ajax({
					type : "get",
					url : "AllUserInfoServlet",
					datatype : "json",
					success : function(data) {
						var length = data.length;
						var i = 0;
						var result = "<div class='msg' id='msg'></div><div><a href=\"#option_add\" class=\"addUser\">新增用户</a><table class='tbl'><tr><td>姓名</td><td>性别</td><td>年龄</td><td>操作</td></tr>";
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