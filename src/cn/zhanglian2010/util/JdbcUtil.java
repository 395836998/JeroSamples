package cn.zhanglian2010.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {

	private static String driver;
	
	private static String url;
	
	private static String username;
	
	private static String password;
	
	static {
		init();
	}
	
	private static void init(){
		Properties prop = new Properties();
		try {
			//加载JDBC配置文件
			prop.load(JdbcUtil.class.getResourceAsStream("jdbc.properties"));
			
			//读取JDBC配置
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			
			//加载驱动类
			Class.forName(driver);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public static Connection getConn() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn){
		close(conn, null);
	}
	
	public static void close(Connection conn, Statement stmt){
		close(conn, stmt, null);
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
