package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.RegisterDao;
import dao.SelectInfo;

/**
 * Servlet implementation class Init
 */
public class Init extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public Init(){
		super();
		 SelectInfo si = new SelectInfo();
			RegisterDao rd = new RegisterDao();
			try {
				User user = si.selectInfoByName("admin");
				if(user == null || user.getU_id() < 1){
					User admin = new User();
					admin.setU_age(17);
					admin.setU_name("admin");
					admin.setU_pwd("admin");
					admin.setU_sex("ÄÐ");
					admin.setU_type(1);
					rd.register(admin);
					System.out.println("add admin success");
				}
				System.out.println("init success");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
