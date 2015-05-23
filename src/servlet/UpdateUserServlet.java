package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UpdateDao;

/**
 * Servlet implementation class UpdateUserServlet
 */
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		String name = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		String pwd1 = request.getParameter("pwd1");
		String sex = request.getParameter("sex");
		int age;
		if (request.getParameter("age") == "") {
			age = 0;
		} else {
			age = Integer.parseInt(request.getParameter("age"));
		}
		if (name == "" || pwd == "" || pwd1 == "") {
			out.println("<script>alert('请输入完整信息');window.location='userInfo.jsp';</script>");
			out.flush();
			out.close();
		} else {
			if (!pwd.equals(pwd1)) {
				out.println("<script>alert('两次输入密码不同，请重新输入');window.location='register.jsp';</script>");
				out.flush();
				out.close();
			} else {
				User user = new User();
				user.setU_name(name);
				user.setU_pwd(pwd);
				user.setU_sex(sex);
				user.setU_age(age);
				user.setU_type(2);

				UpdateDao ud = new UpdateDao();
				try {
					ud.UpdateUserInfo(user);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				out.println("<script>alert('修改成功');window.location='index.jsp';</script>");
				out.flush();
				out.close();
			}
		}
	}

}
