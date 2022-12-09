package DCP;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Pool {
	private static Pool dcp = null;
	private static ComboPooledDataSource ds = null;
	
	private Pool () throws Exception {
		
		ds = new ComboPooledDataSource();
		
		ResourceBundle rb = ResourceBundle.getBundle("ResourceBundle.app");
		
		ds.setDriverClass(rb.getString("driver"));
		ds.setJdbcUrl(rb.getString("url"));
		ds.setUser(rb.getString("user"));
		ds.setPassword(rb.getString("pwd"));
		
		ds.setInitialPoolSize(3);
		ds.setAcquireIncrement(5);
		ds.setMaxPoolSize(50);
	}
	public static Pool getInstance() throws Exception {
		
		if(dcp==null) {
			dcp=new Pool();
		}
		return dcp;
	}
	
	public static Connection getconnection() {
		try {
			return getInstance().ds.getConnection();
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void CloseConnection(Connection conn, Statement stmt, ResultSet rs) throws Exception  {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	public static void CloseConnection(Connection conn) throws Exception {
//		CloseConnection(conn, null, null);
//	}
}
