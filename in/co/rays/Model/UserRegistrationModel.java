package in.co.rays.Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DCP.Pool;
import in.co.rays.Bean.UserRegistrationBean;

public class UserRegistrationModel {

	public void add(UserRegistrationBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement("insert into userregistration values(?,?,?,?,?,?,?)");

		ps.setLong(1, bean.getId());
		ps.setString(2, bean.getFname());
		ps.setString(3, bean.getLname());
		ps.setString(4, bean.getEmail());
		ps.setString(5, bean.getPwd());
		ps.setString(6, bean.getGender());
		ps.setString(7, bean.getDob());

		ps.executeUpdate();

		conn.commit();
		ps.close();
		conn.close();
	}

	public UserRegistrationBean Authenticate(String email, String pwd) throws Exception {

		Connection conn = Pool.getconnection();

		PreparedStatement ps = conn.prepareStatement("Select * from userregistration where email=? and pwd=?");

		ps.setString(1, email);
		ps.setString(2, pwd);
		ResultSet rs = ps.executeQuery();
		UserRegistrationBean bean = new UserRegistrationBean();
		while (rs.next()) {

			bean.setFname(rs.getString(2));
			bean.setLname(rs.getString(3));
			bean.setEmail(rs.getString(4));
			bean.setPwd(rs.getString(5));
			bean.setGender(rs.getString(6));
			bean.setDob(rs.getString(7));

		}
		ps.close();
		conn.close();
		return bean;
	}

	public UserRegistrationBean ForgetPassword(String email) throws Exception {
		Connection conn = Pool.getconnection();

		PreparedStatement ps = conn.prepareStatement("Select * from userregistration where email=?");

		ps.setString(1, email);

		ResultSet rs = ps.executeQuery();

		UserRegistrationBean bean = null;

		while (rs.next()) {
			bean = new UserRegistrationBean();
			bean.setFname(rs.getString(2));
			bean.setLname(rs.getString(3));
			bean.setEmail(rs.getString(4));
			bean.setPwd(rs.getString(5));
			bean.setGender(rs.getString(6));
			bean.setDob(rs.getString(7));

		}
		ps.close();
		conn.close();
		return bean;

	}
}
