package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;

public class SelectInfo {
	private Connection conn;
	private PreparedStatement ps;
	String sql = "";
	
	/**
	 * 根据name获取用户信息
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public User selectInfoByName(String name) throws SQLException{
		conn = DB.getConnection();
		sql = "select * from users where u_name = ?";
		User user = new User();
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet rs = (ResultSet)ps.executeQuery();
			if(rs.next()){
				user.setU_name(name);
				user.setU_pwd(rs.getString("u_pwd").toString());
				user.setU_sex(rs.getString("u_sex").toString());
				user.setU_age(Integer.parseInt(rs.getString("u_age")));
			}
			conn.close();
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
		return user;
	}
}
