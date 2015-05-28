package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

		PrintWriter out = response.getWriter();
		String data = request.getParameter("data");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String pwd1 = request.getParameter("pwd1");
		String sex = request.getParameter("sex");

		int age;
		if (name == null || "".equals(name) || pwd == null || "".equals(pwd)
				|| pwd1 == null || "".equals(pwd1)) {
			out.println("Error:请输入完整信息");
		} else {
			LoginDao ld = new LoginDao();
			try {
				if (ld.isExist(name)) {
					out.println("Error：该用户名已被注册，请重新输入");
				} else {
					if (!pwd.equals(pwd1)) {
						out.println("Error:两次密码不同，请重新输入");
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
								out.println("Error:数据库插入失败");
							}
							out.println("Success:注册成功");
						} else {
							out.println("Error:年龄有误，请输入合适的年龄");
						}
					}
				}
			} catch (SQLException e) {
				out.println("Error:数据库插入失败");
			} catch (ClassNotFoundException e) {
				out.println("Error:数据库连接失败");
			}
		}
	}

	/**
	 * 判断年龄是否符合规范
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
