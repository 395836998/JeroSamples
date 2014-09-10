package cn.zhanglian2010.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {

	private static DataSource ds = null;
	
	static {
        load();
    }
	
	private ConnectionFactory(){
    }
 
	/**
	 * 获取连接
	 * @return
	 */
    public static Connection getConn() {
        Connection con = null;
        try {
            con = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
     
    private static void load() {
        try {
            Context ctx = new InitialContext();
            ds = (DataSource)ctx.lookup("java:comp/env/jdbc/myproject");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    
}
