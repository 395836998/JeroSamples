package cn.zhanglian2010.samples.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import cn.zhanglian2010.util.JdbcUtil;

public class JdbcDemo {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select id, title from blog");
			while (rs.next()) {
				System.out.println(rs.getInt("id")+":"+rs.getString("title"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}

	}

}
