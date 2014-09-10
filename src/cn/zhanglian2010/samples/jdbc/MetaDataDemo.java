package cn.zhanglian2010.samples.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import cn.zhanglian2010.util.JdbcUtil;

public class MetaDataDemo {
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = JdbcUtil.getConn();
			
			//打印数据库的meta信息
			DatabaseMetaData dmd = conn.getMetaData(); 
			if (dmd == null) {
				System.out.println ("No Meta available"); 
			} else {
				System.out.println ("数据库名称:" + dmd.getDatabaseProductName()); 
				System.out.println ("数据库版本:" + dmd.getDatabaseProductVersion()); 
				System.out.println ("数据库驱动程序：" + dmd.getDriverName()); 
				System.out.println ("驱动程序版本号：" + dmd.getDriverVersion()); 
				System.out.println ("并发访问的用户个数" + dmd.getMaxConnections()); 
				System.out.println ("数据类型列表：" ); 
				rs = dmd.getTypeInfo();
				while(rs.next()){
					System.out.println("\t" + rs.getString(1));    
				}
				rs.close();
			}
			
			//表的meta信息
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from dept");                        
			ResultSetMetaData rsm = rs.getMetaData();
			int columnCount = rsm.getColumnCount();
			
			System.out.println("数据表dept结构信息：");
			System.out.println("列序号\t列名\t数据类型");
			for(int i=1; i<=columnCount; i++){
				System.out.println(" " + i + " \t" + 
						rsm.getColumnName(i) + "\t" + 
						rsm.getColumnTypeName(i));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, stmt, rs);
		}
	}

}
