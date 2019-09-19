package com.revature.waterplant_webapp.service;

import com.revature.waterplant_webapp.dao.OrderDAO;
import com.revature.waterplant_webapp.dao.OrderInterface;
import com.revature.waterplant_webapp.dao.StockDAO;
import com.revature.waterplant_webapp.dao.StockInterface;
import com.revature.waterplant_webapp.dao.UserDAO;
import com.revature.waterplant_webapp.dao.UserInterface;
import com.revature.waterplant_webapp.exception.DBException;
import com.revature.waterplant_webapp.exception.ServiceException;
import com.revature.waterplant_webapp.exception.ValidatorException;
import com.revature.waterplant_webapp.model.Order;
import com.revature.waterplant_webapp.model.Stock;
import com.revature.waterplant_webapp.model.User;
import com.revature.waterplant_webapp.validator.UserValidator;

public class UserService {
	
	 private static UserInterface udao=new UserDAO();
	 private static OrderInterface odao=new OrderDAO();
	 private static StockInterface sdao=new StockDAO();

	public User login(String email, String password) throws ServiceException {
		
		
		User user=null;
		try {
			user=udao.login(email, password);
		} catch (DBException e) {
			
			e.printStackTrace();
			throw new ServiceException("Unable to login");
		}
		return user;
		
		
	}

public User adminLogin(String email, String password) throws ServiceException {
		
		
		User user=null;
		try {
			user=udao.adminLogin(email, password);
		} catch (DBException e) {
			
			e.printStackTrace();
			throw new ServiceException("Unable to login");
		}
		return user;
		
		
	}
	public void register(User user) throws ServiceException {
		
      try {
		UserValidator.ValidationBeforeRegistration(user);
		udao.register(user);
	} catch (ValidatorException e) {
		
		e.printStackTrace();
		throw new ServiceException(e.getMessage());
	}
      catch (DBException e) {
		
		e.printStackTrace();
		throw new ServiceException(e.getMessage());
	}
      }

	public void orderCans(Order order, int orderedCans) throws ServiceException {
		Stock stock=null;
		try {
			odao.addOrder(order, orderedCans);
			stock=sdao.findStock();
			int availableCans=stock.getAvailableCans();
			int updateCans=availableCans-orderedCans;
			sdao.updateStock(updateCans);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
		
		
	}		
		


}
