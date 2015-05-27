package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDao {
	private Connection conn;
	private PreparedStatement ps;
	String sql = "";
	
	/**
	 * 删除用户信息
	 * @param id
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public void DeleteUserInfo(int id) throws SQLException, ClassNotFoundException{
		conn = DB.getConnection();
		sql = "delete from users where u_id = ?";
		try{
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
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
