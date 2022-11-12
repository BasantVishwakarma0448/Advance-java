package com.rays.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MarksheetDAO {
	public Long nextPK() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		long pk=0;
		PreparedStatement ps = conn.prepareStatement("Select max(id) from marksheet");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			pk=rs.getLong(1);
			
		}
		return pk+1;
	}

	public void testAdd(MarksheetBean b) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		
		conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?, ?, ?, ?, ?, ?, ?)");
		
		ps.setLong(1, nextPK() );
		ps.setString(2, b.getRollno());
		ps.setString(3, b.getFname());
		ps.setString(4, b.getLname());
		ps.setInt(5, b.getPhysics());
		ps.setInt(6, b.getChemistry());
		ps.setInt(7, b.getMaths());
		
		ps.executeUpdate();
		conn.commit();
		conn.close();
		ps.close();
		
		
	}
	
	public void Update(MarksheetBean b) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		
		conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement("Update marksheet set lname=? where rollno=?");
		
		ps.setString(1, b.getLname());
		ps.setString(2, b.getRollno());
		
		
		ps.executeUpdate();
		conn.commit();
		ps.close();
		conn.close();
		
	}
	public static void Delete(MarksheetBean b) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		
		conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement("Delete from marksheet where rollno=?");
		
		
		ps.setString(1, b.getRollno());
		
		ps.executeUpdate();
		
		conn.commit();
		
		ps.close();
		conn.close();
	}


	public static MarksheetBean Get(MarksheetBean b) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("Select* from marksheet where rollno=?");
		//MarksheetBean b = new MarksheetBean();
		ps.setNString(1, b.getRollno());
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			//System.out.print(rs.getString(1));
			System.out.print("\t"+rs.getString(2));
			System.out.print("\t"+rs.getString(3));
			System.out.print("\t"+rs.getString(4));
			System.out.print("\t"+rs.getString(5));
			System.out.print("\t"+rs.getString(6));
			System.out.print("\t"+rs.getString(7));
			//System.out.print("\t"+rs.getString(2));
		}
		
		
		
		conn.commit();
		ps.close();
		conn.close();
		return b;
		
	}
}
