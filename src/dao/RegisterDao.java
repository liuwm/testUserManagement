package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.User;

public class RegisterDao {
	private Connection conn;
	private PreparedStatement ps;
	String sql = "";
	
	/**
	 * ÓÃ»§×¢²á
	 * @param user
	 * @throws SQLException 
	 */
	public void register(User user) throws SQLException{
		conn = DB.getConnection();
		sql = "insert into users(u_name,u_pwd,u_sex,u_age,u_type) values(?,?,?,?,?)";
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getU_name());
			ps.setString(2, user.getU_pwd());
			ps.setString(3, user.getU_sex());
			ps.setInt(4, user.getU_age());
			ps.setInt(5, user.getU_type());
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(conn != null){
				conn.close();
			}
			if(ps != null){
				ps.close();
			}
		}
	}
}