package com.revature.waterplant_webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.waterplant_webapp.exception.DBException;
import com.revature.waterplant_webapp.model.Order;
import com.revature.waterplant_webapp.util.ConnectionUtil;

public class OrderDAO implements OrderInterface{
	
public void addOrder(Order order, int noOfCans) throws DBException {
		
		Connection con =null;
		PreparedStatement pst = null;
		con = ConnectionUtil.getConnection();
		String sql = "insert into orderdetails(User_id,User_name,Mobile_no,Address,Ordered_cans) values"
				+ "(?,?,?,?,?) ";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, order.getUserId());
			pst.setString(2, order.getName());
			pst.setLong(3,order.getMobileNo());
			pst.setString(4,order.getAddress());
			pst.setInt(5,noOfCans);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to order Cans", e);
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
		
}

	public  void addReserveOrder(Order order,int orderedCans, String Address) throws DBException {
		
		Connection con =null;
		PreparedStatement pst = null;
		con = ConnectionUtil.getConnection();
		String sql = "insert into orderdetails(User_id,Reserve_id,User_name,Mobile_no,Address,Ordered_cans) values"
				+ "(?,?,?,?,?,?) ";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, order.getUserId());
			pst.setInt(2, order.getReserveId());
			pst.setString(3,order.getName());
			pst.setLong(4,order.getMobileNo());
			pst.setString(5, Address);
			pst.setInt(6,orderedCans);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to order Reserved Cans",e);
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
	}
	
public int findByOrderID(int id){
	
	Connection con =null;
	PreparedStatement pst = null;
	con = ConnectionUtil.getConnection();
	String sql = "select * from orderdetails where Order_id=? and Order_status='Ordered'";
	int orderedCans=0;
	try {
		pst = con.prepareStatement(sql);
		pst.setInt(1,id );
		ResultSet rs=pst.executeQuery();
		if(rs.next()) 
		{
			orderedCans=rs.getInt("Ordered_cans");
			
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	finally {
		ConnectionUtil.close(con, pst);
	}
	
	return orderedCans;
}

public void updateOrderStatus(int id) {

	Connection con =null;
	PreparedStatement pst = null;
	con = ConnectionUtil.getConnection();
	String sql = "update orderdetails set Order_status='Order Cancelled' where Order_id=?";
	try {
		pst = con.prepareStatement(sql);
		pst.setInt(1,id );
		pst.executeUpdate();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
}


}
