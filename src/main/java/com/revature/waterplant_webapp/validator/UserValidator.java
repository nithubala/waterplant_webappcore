package com.revature.waterplant_webapp.validator;

import org.apache.commons.validator.routines.EmailValidator;

import com.revature.waterplant_webapp.exception.ValidatorException;
import com.revature.waterplant_webapp.model.User;

public class UserValidator {
	
public static void ValidationBeforeRegistration(User user) throws ValidatorException {
		
	    // name validation
	    String name=user.getName();
		if ( name == null || "".equals(name.trim())) {
			
			throw new ValidatorException("Invalid Name");
			}
		String numbers = "(.*[0-9].*)";
        if (name.matches(numbers ))
        {
                throw new ValidatorException("Name should not contain atleast one number.");
        }
	
        // email validation
		String email=user.getEmailId();
		email = email.trim();
		EmailValidator eValidator = EmailValidator.getInstance();
		if(eValidator.isValid(email)){
			
			System.out.println("Valid email address");
		}else{
			
			throw new ValidatorException("Invalid email address");
			
		}
		
		 // address validation
		String address=user.getAddress();
		if(address==null || "".equals(address.trim())) {
			throw new ValidatorException("Invalid Address");
		}
		
		
		// mobile number validation
		 long mobnum=user.getMobileNo();
		 String num = String.valueOf(mobnum);
		    if (num.length() != 10)
		        throw new ValidatorException("Invalid Mobile Number,Enter 10 digit number");
		
	}
	
public static void passwordValidation(String password) throws ValidatorException
{
	   if(password==null || "".equals(password.trim()))
	    {
	     throw new ValidatorException("Invalid Password");
        }

        if (password.length() > 15 || password.length() < 8)
        {
                throw new ValidatorException("Password should be less than 15 and more than 8 characters in length.");
        }
        String upperCaseChars = "(.*[A-Z].*)";
        if (!password.matches(upperCaseChars ))
        {
                System.out.println("Password should contain atleast one upper case alphabet");
               
        }
        
        String specialChars = "(.*[,~,!,@,#,$,%,^,&,,(,),-,*,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
        if (!password.matches(specialChars ))
        {
                throw new ValidatorException("Password should contain atleast one special character");
        }
}


}
