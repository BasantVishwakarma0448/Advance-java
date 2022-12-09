package in.co.rays.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DCP.Pool;
import in.co.rays.Bean.LoginBean;
import in.co.rays.Bean.UserRegistrationBean;


public class LoginModel {
	public Long nextPK() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		long pk = 0;
		PreparedStatement ps = conn.prepareStatement("Select max(id) from marksheet");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			pk = rs.getLong(1);

		}
		return pk + 1;
	}

	public void testadd(LoginBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("insert into user values(?,?)");
		
		ps.setLong(1, nextPK());
		ps.setString(1, bean.getUser());
		ps.setString(2, bean.getPwd());

		ps.executeUpdate();

		conn.commit();
		ps.close();
		conn.close();
	}
	
	
//	public static boolean isNull(String val) {
//		if(val==null||val.trim().length()==0) {
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
	
//	public static boolean isNotNull(String val) {
//		return !isNotNull(val);
//	}
}
