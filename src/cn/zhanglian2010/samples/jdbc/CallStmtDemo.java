package cn.zhanglian2010.samples.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;

import cn.zhanglian2010.util.JdbcUtil;

public class CallStmtDemo {

	public static void main(String[] args){
		Connection con = null;
		CallableStatement cst = null;
		try{
			con = JdbcUtil.getConn();
			cst = con.prepareCall("{call MyProcedure(?,?,?)}");
			cst.setInt(1,1001);
			cst.setString(2,"Jenny");
			cst.setInt(3,48);

			cst.execute();

		}catch(Exception e){
			System.err.println(e);
		}finally{
			JdbcUtil.close(con, cst);
		}
	}
}
