package com.shopping.mail;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Validate {
	
	public static boolean validateMail(String email)
	{
		
		boolean isValid=false;
		try {
			InternetAddress internetAddress=new InternetAddress(email);
			internetAddress.validate();
			isValid=true;
		} catch (AddressException e) {
           
			e.printStackTrace();
		}
		return isValid;
				
	}

}
