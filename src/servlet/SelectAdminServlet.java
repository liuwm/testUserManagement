package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import bean.User;
import dao.SelectInfo;

/**
 * Servlet implementation class SelectAdminServlet
 */
public class SelectAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectAdminServlet() {
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

		int id;
		PrintWriter out = response.getWriter();
		User user = new User();
		if (request.getParameter("id") == null
				|| "".equals(request.getParameter("id"))) {
			id = 0;
		} else {
			id = Integer.parseInt(request.getParameter("id"));
		}
		SelectInfo si = new SelectInfo();
		try {
			user = si.selectInfoByID(id);
			JSONArray ja = JSONArray.fromObject(user);
			out.println(ja);
		} catch (SQLException e) {
			out.println("Error:数据库插入失败");
		} catch (ClassNotFoundException e) {
			out.println("Error:数据库连接失败");
		}
	}

}
