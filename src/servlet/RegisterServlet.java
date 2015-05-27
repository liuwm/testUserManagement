package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		int age;
		if (name == null || "".equals(name) || pwd == null || "".equals(pwd)
				|| pwd1 == null || "".equals(pwd1)) {
			session.setAttribute("Msg", "Error��������������Ϣ");
			response.sendRedirect("register.jsp");
		} else {
			LoginDao ld = new LoginDao();
			try {
				if (ld.isExist(name)) {
					session.setAttribute("Msg", "Error�����û����ѱ�ע�ᣬ����������");
					response.sendRedirect("register.jsp");
				} else {
					if (!pwd.equals(pwd1)) {
						session.setAttribute("Msg", "Error�������������벻ͬ������������");
						response.sendRedirect("register.jsp");
					} else {
						if (isAge(request.getParameter("age"))) {
							age = Integer.parseInt(request.getParameter("age"));
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
								session.setAttribute("Msg", "Error�����ݿ����ʧ��");
								response.sendRedirect("register.jsp");
							}
							session.setAttribute("Msg", "Success��ע��ɹ������¼");
							response.sendRedirect("login.jsp");
						} else {
							session.setAttribute("Msg", "Error������������������ʵ�����");
							response.sendRedirect("register.jsp");
						}
					}
				}
			} catch (SQLException e) {
				session.setAttribute("Msg", "Error�����ݿ����ʧ��");
				response.sendRedirect("register.jsp");
			} catch (ClassNotFoundException e) {
				session.setAttribute("Msg", "Error�����ݿ�����ʧ��");
				response.sendRedirect("register.jsp");
			}
		}
	}

	/**
	 * �ж������Ƿ���Ϲ淶
	 * 
	 * @param strAge
	 * @return
	 */
	protected boolean isAge(String strAge) {
		if (strAge == null || "".equals(strAge)) {
			return false;
		} else {
			int i;
			for (i = 0; i < strAge.length(); i++) {
				if (!Character.isDigit(strAge.charAt(i))) {
					return false;
				}
			}
		}
		return true;
	}

}
