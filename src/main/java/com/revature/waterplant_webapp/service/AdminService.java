package com.revature.waterplant_webapp.service;

import java.util.List;

import com.revature.waterplant_webapp.dao.StockDAO;
import com.revature.waterplant_webapp.dao.StockInterface;
import com.revature.waterplant_webapp.exception.DBException;
import com.revature.waterplant_webapp.exception.ServiceException;
import com.revature.waterplant_webapp.model.Stock;

public class AdminService {
	
	private static StockInterface sdao=new StockDAO();

	public List<Stock> viewstock() throws ServiceException {
		
		List<Stock> list=null;
		
		try {
			list=sdao.viewStock();
		} catch (DBException e) {
			
			e.printStackTrace();
			throw new ServiceException("Unable to View Stock");
		}
		return list;
	}

	public  void updateStock(int addCans) throws ServiceException {
		
		Stock stock=null;
		try {
			
		stock = sdao.findStock();
		int availableCans=stock.getAvailableCans();
		int updateCans=availableCans+addCans;
	    sdao.updateStock(updateCans);
	    
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		
	}

}
