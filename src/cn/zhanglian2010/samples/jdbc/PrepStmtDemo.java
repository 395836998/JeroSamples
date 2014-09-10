package cn.zhanglian2010.samples.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.zhanglian2010.util.JdbcUtil;

public class PrepStmtDemo {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = JdbcUtil.getConn();
			String sql = "insert into blog(categoryid,title,content,created_time) values(?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, 1);
			pst.setString(2, "Java vs C#");
			pst.setString(3, "Java is better than C#");
			pst.setDate(4, new Date(System.currentTimeMillis()));
			pst.executeUpdate();

			System.out.println("id\ttitle\tcreateTime");
			pst = con.prepareStatement("select id,title,created_time from blog where id = ?");
			pst.setInt(1, 1);
			rs = pst.executeQuery();
			if (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2).trim() + "\t" + rs.getDate(3));
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			JdbcUtil.close(con, pst, rs);
		}
	}

}
