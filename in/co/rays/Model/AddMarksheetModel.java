package in.co.rays.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DCP.Pool;
import in.co.rays.Bean.AddMarksheetBean;

public class AddMarksheetModel {
	public int nextPk() throws Exception {
		
		Connection conn = Pool.getconnection();
		
		PreparedStatement ps = conn.prepareStatement("select max(id) from marksheet");
		
		int pk = 0;
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			pk = rs.getInt(1);
		}
		
		return pk+1;
		
	}
	
	public void addmarksheet(AddMarksheetBean bean) throws Exception {
		
		Connection conn = Pool.getconnection();
		
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?, ?, ?, ?, ?, ?, ?)");
		conn.setAutoCommit(false);
		
		
		 
		
		ps.setInt(1, nextPk());
		ps.setString(2, bean.getRollno());
		ps.setString(3, bean.getFname());
		ps.setString(4, bean.getLname());
		ps.setString(5, bean.getPhysics());
		ps.setString(6, bean.getChemistry());
		ps.setString(7, bean.getMaths());
		
		
		ps.executeUpdate();
		conn.commit();
		ps.close();
		conn.close();
		
	}
}
