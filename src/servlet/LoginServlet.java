package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;
import bean.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		super.destroy();
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

		int type;
		String name = request.getParameter("user");
		String pwd = request.getParameter("pwd");

		User user = new User();
		user.setU_name(name);
		user.setU_pwd(pwd);

		LoginDao ld = new LoginDao();
		try {
			type = ld.login(user);
			if (type == 1) {
				HttpSession session = request.getSession();
				session.setAttribute("name", name);
				session.setAttribute("Msg", "���¼");
				response.sendRedirect("admin.jsp");
			} else if (type == 2) {
				HttpSession session = request.getSession();
				session.setAttribute("name", name);
				session.setAttribute("Msg", "���¼");
				response.sendRedirect("user.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("Msg", "Error���û�����������������������");
				response.sendRedirect("login.jsp");
			}
		} catch (SQLException e) {
			HttpSession session = request.getSession();
			session.setAttribute("Msg", "Error�����ݿ��ѯʧ��");
			response.sendRedirect("login.jsp");
		} catch (ClassNotFoundException e) {
			HttpSession session = request.getSession();
			session.setAttribute("Msg", "Error�����ݿ�����ʧ��");
			response.sendRedirect("login.jsp");
		}
	}
}
