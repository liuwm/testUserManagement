package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.User;

public class SelectInfo {
	private Connection conn;
	private PreparedStatement ps;
	String sql = "";
	
	/**
	 * ����name��ȡ�û���Ϣ
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
				user.setU_id(Integer.parseInt(rs.getString("u_id")));
				user.setU_name(name);
				user.setU_pwd(rs.getString("u_pwd").toString());
				user.setU_sex(rs.getString("u_sex").toString());
				user.setU_age(Integer.parseInt(rs.getString("u_age")));
				user.setU_type(Integer.parseInt(rs.getString("u_type")));
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
	
	/**
	 * ����������ͨ�û�
	 * @return
	 * @throws SQLException
	 */
	public List<User> selectInfo() throws SQLException{
		conn = DB.getConnection();
		sql = "select * from users where u_type = ?";
		
		List<User> list = new ArrayList<User>();
		try{
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 2);
			ResultSet rs = (ResultSet)ps.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setU_id(Integer.parseInt(rs.getString("u_id")));
				user.setU_name(rs.getString("u_name"));
				user.setU_pwd(rs.getString("u_pwd"));
				user.setU_sex(rs.getString("u_sex"));
				user.setU_age(Integer.parseInt(rs.getString("u_age")));
				user.setU_type(Integer.parseInt(rs.getString("u_type")));
				list.add(user);
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
		return list;
	}
	
	/**
	 * ����id��ȡ�û���Ϣ
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public User selectInfoByID(int id) throws SQLException{
		conn = DB.getConnection();
		sql = "select * from users where u_id = ?";
		User user = new User();
		try{
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = (ResultSet)ps.executeQuery();
			if(rs.next()){
				user.setU_id(id);
				user.setU_name(rs.getString("u_name").toString());
				user.setU_pwd(rs.getString("u_pwd").toString());
				user.setU_sex(rs.getString("u_sex").toString());
				user.setU_age(Integer.parseInt(rs.getString("u_age")));
				user.setU_type(Integer.parseInt(rs.getString("u_type")));
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
