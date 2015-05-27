package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import dao.SelectInfo;
import bean.User;

/**
 * Servlet implementation class SelectServlet
 */
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectServlet() {
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
		response.setContentType("text/json;charset=utf-8");
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
		response.setContentType("text/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String username = session.getAttribute("name").toString();
		User user = new User();
		PrintWriter out = response.getWriter();
		SelectInfo si = new SelectInfo();
		try {
			user = si.selectInfoByName(username);
			JSONArray ja = JSONArray.fromObject(user);
			out.println(ja);
		} catch (SQLException e) {
			out.println("Error:数据库插入失败");
		} catch (ClassNotFoundException e) {
			out.println("Error:数据库连接失败");
		}
	}
}
