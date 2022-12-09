package webApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.co.rays.Bean.UserRegistrationBean;
import in.co.rays.Model.UserRegistrationModel;

public class TestUserRegistration {
	public static void main(String[] args) throws Exception {
		testadd();
	}
	public static int nextPK() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		int pk = 0;
		PreparedStatement ps = conn.prepareStatement("Select max(id) from userregistration");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);

		}
		return pk + 1;
	}

	private static void testadd() throws Exception {
		UserRegistrationBean bean = new UserRegistrationBean();
		
		bean.setId(nextPK());
		bean.setFname("Basant");
		bean.setLname("Vish");
		bean.setEmail("@gmail.com");
		bean.setPwd("1223654");
		bean.setGender("male");
		bean.setDob("20/12/1999");
		
		UserRegistrationModel urm = new UserRegistrationModel();
		
		urm.add(bean);
		
	}
}
