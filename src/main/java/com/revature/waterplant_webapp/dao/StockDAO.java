package com.revature.waterplant_webapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.waterplant_webapp.exception.DBException;
import com.revature.waterplant_webapp.model.Stock;
import com.revature.waterplant_webapp.util.ConnectionUtil;



public class StockDAO implements StockInterface {

public Stock findStock() throws DBException {
		
		Connection con =null;
		PreparedStatement pst = null;
		con = ConnectionUtil.getConnection();
		String sql = "select * from stockdetails";
		Stock stock=null;
		try {
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				
				stock = new Stock();
				stock.setAvailableCans(rs.getInt("Available_cans"));
				Date date = rs.getDate("Date_time");
				stock.setDate(date.toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to find available Stock",e);
			
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
		
		return stock;
	}

	
public List<Stock> viewStock() throws DBException{
		
		Connection con =null;
		PreparedStatement pst = null;
		List<Stock> list = new ArrayList<Stock>();
		try {
			con = ConnectionUtil.getConnection();
			String sql = "select * from stockdetails";
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				
				Stock stock = new Stock();
				stock.setAvailableCans(rs.getInt("Available_cans"));
				Date date = rs.getDate("Date_time");
				stock.setDate(date.toLocalDate());
				list.add(stock);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to View Stock",e);
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
		
		return list;
	}
	public void updateStock(int totalCans) throws DBException {
		
		Connection con =null;
		PreparedStatement pst = null;
		con = ConnectionUtil.getConnection();
		String sql = "update stockdetails set Available_cans=?,Date_time=current_timestamp()";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,totalCans );
			pst.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new DBException("Unable to update stock",e);
		}
		finally {
			ConnectionUtil.close(con, pst);
		}
		
		
		
	}
}
