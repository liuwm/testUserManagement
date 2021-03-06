package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.User;

public class UpdateDao {
	private Connection conn;
	private PreparedStatement ps;
	String sql = "";
	
	/**
	 * 更新用户信息
	 * @param user
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public void UpdateUserInfo(User user) throws SQLException, ClassNotFoundException{
		conn = DB.getConnection();
		sql = "update users set u_pwd = ? , u_sex = ? , u_age = ? where u_name = ?";
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getU_pwd());
			ps.setString(2, user.getU_sex());
			ps.setInt(3, user.getU_age());
			ps.setString(4, user.getU_name());
			ps.executeUpdate();
		}catch(SQLException e){
			throw new SQLException();
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
