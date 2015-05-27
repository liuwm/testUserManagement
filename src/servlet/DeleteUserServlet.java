package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeleteDao;

/**
 * Servlet implementation class DeleteUserServlet
 */
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteUserServlet() {
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
		int id;
		if (request.getParameter("id") == null
				|| "".equals(request.getParameter("id"))) {
			out.println("Error:É¾³ýÊ§°Ü");
		} else {
			id = Integer.parseInt(request.getParameter("id"));
			DeleteDao dd = new DeleteDao();
			try {
				dd.DeleteUserInfo(id);
			} catch (SQLException e) {
				out.println("Error:Êý¾Ý¿âÉ¾³ýÊ§°Ü");
			} catch (ClassNotFoundException e) {
				out.println("Error:Êý¾Ý¿âÁ¬½ÓÊ§°Ü");
			}
			out.println("Success:É¾³ý³É¹¦");
		}
	}
}
