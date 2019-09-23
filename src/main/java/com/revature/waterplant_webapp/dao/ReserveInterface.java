package com.revature.waterplant_webapp.dao;

import com.revature.waterplant_webapp.exception.DBException;
import com.revature.waterplant_webapp.model.Reserve;

public interface ReserveInterface {

	void addReserve(Reserve reserve, int reservedCans) throws DBException ;
	Reserve findById(int id);
	void updateReserve(Reserve u, int reservedCans) throws DBException ;
	Reserve findByReserveId(int id);
	void updateStatus(Reserve u,int orderedCans);
	
}
