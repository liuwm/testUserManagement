package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.User;

public class LoginDao {

	private Connection conn;
	private PreparedStatement ps;
	String sql = "";
	
	/**
	 * 登陆验证
	 * @param user
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public int login(User user) throws SQLException, ClassNotFoundException{
		conn = DB.getConnection();
		int type = 0;
		sql = "select * from users where u_name = ? and u_pwd = ?";
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getU_name());
			ps.setString(2, user.getU_pwd());
			
			ResultSet rs = (ResultSet)ps.executeQuery();
			if(rs.next()){
				type = Integer.parseInt(rs.getString("u_type"));
			}
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
		return type;
	}
	
	/**
	 * 判断用户是否已存在
	 * @param name
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public boolean isExist(String name) throws SQLException, ClassNotFoundException{
		conn = DB.getConnection();
		boolean bool = false;
		sql = "select * from users where u_name = ?";
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet rs = (ResultSet)ps.executeQuery();
			if(rs.next()){
				bool = true;
			}else{
				bool = false;
			}
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
		return bool;
	}
	
	
}
