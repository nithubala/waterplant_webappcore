package com.revature.waterplant_webapp.dao;

import java.util.List;

import com.revature.waterplant_webapp.exception.DBException;
import com.revature.waterplant_webapp.model.Stock;

public interface StockInterface {
	Stock findStock() throws DBException;
	
	List<Stock> viewStock() throws DBException;
	 
	void updateStock(int totalCans) throws DBException; 

}
