package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDao;
import dao.RegisterDao;
import bean.User;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
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

		String name = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		String pwd1 = request.getParameter("pwd1");
		String sex = request.getParameter("sex");
		int age;
		if (request.getParameter("age") == null
				|| "".equals(request.getParameter("age"))) {
			age = 0;
		} else {
			age = Integer.parseInt(request.getParameter("age"));
		}
		if (name == null || "".equals(name) || pwd == null || "".equals(pwd)
				|| pwd1 == null || "".equals(pwd1)) {
			request.setAttribute("msg", "Error��������������Ϣ");
			request.getRequestDispatcher("register.jsp").forward(request,
					response);
		} else {
			LoginDao ld = new LoginDao();
			try {
				if (ld.isExist(name)) {
					request.setAttribute("msg", "Error�����û����ѱ�ע�ᣬ����������");
					request.getRequestDispatcher("register.jsp").forward(
							request, response);
				} else {
					if (!pwd.equals(pwd1)) {
						request.setAttribute("msg", "Error�������������벻ͬ������������");
						request.getRequestDispatcher("register.jsp").forward(
								request, response);
					} else {
						User user = new User();
						user.setU_name(name);
						user.setU_pwd(pwd);
						user.setU_sex(sex);
						user.setU_age(age);
						user.setU_type(2);

						RegisterDao rd = new RegisterDao();
						try {
							rd.register(user);
						} catch (SQLException e) {
							request.setAttribute("msg", "Error�����ݿ����ʧ��");
							request.getRequestDispatcher("register.jsp")
									.forward(request, response);
						}
						request.setAttribute("msg", "Success��ע��ɹ������¼");
						request.getRequestDispatcher("login.jsp").forward(
								request, response);
					}
				}
			} catch (SQLException e) {
				request.setAttribute("error", "Error�����ݿ����ʧ��");
				request.getRequestDispatcher("register.jsp").forward(request,
						response);
			} catch (ClassNotFoundException e) {
				request.setAttribute("error", "Error�����ݿ�����ʧ��");
				request.getRequestDispatcher("register.jsp").forward(request,
						response);
			}
		}
	}

}
