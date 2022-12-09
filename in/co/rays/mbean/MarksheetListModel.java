package in.co.rays.mbean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class MarksheetListModel {
	public List<MarksheetBean> getList() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement ps = conn.prepareStatement("Select * from student");

		ResultSet rs = ps.executeQuery();

		MarksheetBean bean = null;

		List<MarksheetBean> list = new ArrayList<MarksheetBean>();

		while (rs.next()) {

			bean = new MarksheetBean();

			
			bean.setFname(rs.getString(2));
			bean.setLname(rs.getString(3));
			bean.setMarks(rs.getInt(4));
			bean.setPhoneno(rs.getString(5));
			

			list.add(bean);

		}

		ps.close();
		conn.close();
		return list;

	}
	
	public List<MarksheetBean> getByName(String fname) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		PreparedStatement ps = conn.prepareStatement("Select * from student where fname=?");

		ps.setString(1, fname);
		ResultSet rs = ps.executeQuery();

		MarksheetBean bean = null;

		List<MarksheetBean> list = new ArrayList<MarksheetBean>();

		while (rs.next()) {

			bean = new MarksheetBean();

			
			bean.setFname(rs.getString(2));
			bean.setLname(rs.getString(3));
			bean.setMarks(rs.getInt(4));
			bean.setPhoneno(rs.getString(5));
			

			list.add(bean);

		}

		ps.close();
		conn.close();
		return list;

	}
}
