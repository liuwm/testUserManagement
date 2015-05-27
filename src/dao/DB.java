package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	/**
	 * 获得连接
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException 
	 */
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/usermanage?characterEncoding=utf-8";
		Connection conn = null;
		try {
			Class.forName(driver);
			try {
				conn = DriverManager.getConnection(url, "root", "root");
			} catch (SQLException e) {
				throw new SQLException();
			}
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException();
		}

		return conn;
	}
}
