package com.revature.waterplant_webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.waterplant_webapp.exception.DBException;
import com.revature.waterplant_webapp.model.Reserve;
import com.revature.waterplant_webapp.util.ConnectionUtil;


public class ReserveDAO implements ReserveInterface{
	
public  void addReserve(Reserve reserve, int reservedCans) throws DBException {
		
		Connection con =null;
		PreparedStatement pst = null;
		con= ConnectionUtil.getConnection();
		String sql = "insert into reservedetails(User_id,User_name,Mobile_no,Reserved_cans,Reserved_status) values"
				+ "(?,?,?,?,?) ";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,reserve.getUserId());
			pst.setString(2,reserve.getName());
			pst.setLong(3,reserve.getMobileNo());
			pst.setInt(4,reservedCans);
			pst.setString(5,"Order Pending");
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to reserve",e);
		}
		
		finally {
			ConnectionUtil.close(con, pst);
		}
	}

	public Reserve findById(int id) {
		
		Connection con =null;
		PreparedStatement pst = null;
	    con = ConnectionUtil.getConnection();
		String sql = "select * from reservedetails where User_id=? and Reserved_status='Order Pending' ";
		Reserve reserve=null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,id);
			ResultSet rs = pst.executeQuery();
		
			if(rs.next()) {
				reserve = new Reserve();
				reserve.setReserveId(rs.getInt("Reserve_id"));
				reserve.setName(rs.getString("User_name"));
				reserve.setMobileNo(rs.getLong("Mobile_no"));
				reserve.setReserveCans(rs.getInt("Reserved_cans"));
			
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
		
		return reserve;
	}

	public  void updateReserve(Reserve u, int reservedCans) throws DBException {
		
		Connection con =null;
		PreparedStatement pst = null;
		con = ConnectionUtil.getConnection();
		String sql = "update reservedetails set Reserved_cans = ? where Reserve_id= ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,reservedCans);
			pst.setInt(2, u.getReserveId());
			pst.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new DBException("Unable to reserve",e);
		}
		
		finally {
			ConnectionUtil.close(con, pst);
		}
	}

	public  Reserve findByReserveId(int id) {
		
		Connection con =null;
		PreparedStatement pst = null;
		con = ConnectionUtil.getConnection();
		String sql = "select * from reservedetails where Reserve_id= ? and Reserved_status='Order Pending'";
		Reserve reserve=null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,id);
			ResultSet rs = pst.executeQuery();
		
			if(rs.next()) {
			    reserve = new Reserve();
			    reserve.setUserId(rs.getInt("User_id"));
			    reserve.setReserveId(rs.getInt("Reserve_id"));
			    reserve.setName(rs.getString("User_name"));
			    reserve.setMobileNo(rs.getLong("Mobile_no"));
				reserve.setReserveCans(rs.getInt("Reserved_cans"));
				reserve.setReserveStatus(rs.getString("Reserved_status"));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
		
		return reserve;
	}

public  void updateStatus(Reserve u,int orderedCans) {
	
	    Connection con =null;
	    PreparedStatement pst = null;
		con = ConnectionUtil.getConnection();
		String sql = "update reservedetails set Reserved_status ='Ordered',Ordered_cans=? where Reserve_id= ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,orderedCans);
			pst.setInt(2,u.getReserveId());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		finally {
			ConnectionUtil.close(con, pst);
		}
	}

	

}
