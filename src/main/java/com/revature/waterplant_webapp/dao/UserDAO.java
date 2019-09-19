package com.revature.waterplant_webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.waterplant_webapp.exception.DBException;
import com.revature.waterplant_webapp.model.User;
import com.revature.waterplant_webapp.util.ConnectionUtil;



public class UserDAO implements UserInterface {
public void register(User user) throws DBException {
		
		Connection con =null;
		PreparedStatement pst = null;
		con=ConnectionUtil.getConnection();
			String sql="insert into userdetails (User_name,Email_id,Password,Address,Mobile_no) values( ?,?,?,?,?)";
		
			try {
				pst = con.prepareStatement(sql);
				pst.setString(1,user.getName());
				pst.setString(2, user.getEmailId());
				pst.setString(3, user.getPassword());
				pst.setString(4, user.getAddress());
				pst.setLong(5, user.getMobileNo());
				
				pst.executeUpdate();
			} catch (SQLException e) {
				
				e.printStackTrace();
				throw new DBException("Unable to register",e);
			}
			finally {
				ConnectionUtil.close(con, pst);
			}
			
	}
	
	public User login(String emailId, String password) throws DBException {

		Connection con =null;
		PreparedStatement pst = null;
		con = ConnectionUtil.getConnection();
		String sql = "select * from userdetails where Email_id=? and Password=?";
		 User user= null;	        
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, emailId);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
        
			if (rs.next()) {
				user =  new User();
                user.setId(rs.getInt("User_id"));
				user.setName(rs.getString("User_name"));
				user.setEmailId(rs.getString("Email_id"));
				user.setPassword(rs.getString("Password"));
				user.setAddress(rs.getString("Address"));
				user.setMobileNo(rs.getLong("Mobile_no"));
				user.setRole(rs.getString("Role"));
			} 

		} catch (SQLException e) {
			throw new DBException("Unable to login",e);
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
		
		return user;
		

	}
	
	public User adminLogin(String emailId, String password) throws DBException {

		Connection con =null;
		PreparedStatement pst = null;
		con = ConnectionUtil.getConnection();
		String sql = "select * from userdetails where Email_id=? and Password=? and Role='A'";
		 User user= null;	        
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, emailId);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
        
			if (rs.next()) {
				user =  new User();
                user.setId(rs.getInt("User_id"));
				user.setName(rs.getString("User_name"));
				user.setEmailId(rs.getString("Email_id"));
				user.setPassword(rs.getString("Password"));
				user.setAddress(rs.getString("Address"));
				user.setMobileNo(rs.getLong("Mobile_no"));
				user.setRole(rs.getString("Role"));
			} 

		} catch (SQLException e) {
			throw new DBException("Unable to login",e);
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
		
		return user;
		

	}
	
	public User getUserID(String emailId) {
		Connection con =null;
		PreparedStatement pst = null;
		con = ConnectionUtil.getConnection();
		String sql = "select * from userdetails where Email_id=?";
		User user=null;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, emailId);
			ResultSet rs = pst.executeQuery();
            if (rs.next()) {
				
				user = new User();
				user.setId(rs.getInt("User_id"));
				user.setName(rs.getString("User_name"));
				user.setEmailId(rs.getString("Email_id"));
				user.setPassword(rs.getString("Password"));
				user.setAddress(rs.getString("Address"));
				user.setMobileNo(rs.getLong("Mobile_no"));
				
				}
         } catch (SQLException e) {

			e.printStackTrace();
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
        return user;

	}
	

}
