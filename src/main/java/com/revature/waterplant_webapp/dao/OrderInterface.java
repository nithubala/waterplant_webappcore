package com.revature.waterplant_webapp.dao;

import com.revature.waterplant_webapp.exception.DBException;
import com.revature.waterplant_webapp.model.Order;

public interface OrderInterface {
	
	void addOrder(Order order, int noOfCans) throws DBException;
	void addReserveOrder(Order order,int orderedCans, String Address) throws DBException;
	int findByOrderID(int id);
	void updateOrderStatus(int id);
	
}
