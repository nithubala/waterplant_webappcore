package com.revature.waterplant_webapp.dao;

import com.revature.waterplant_webapp.exception.DBException;
import com.revature.waterplant_webapp.model.User;

public interface UserInterface {

	void register(User user) throws DBException;
	
	User login(String emailId, String password) throws DBException;
	
	User adminLogin(String emailId, String password) throws DBException;
	
	User getUserID(String emailId);
}
