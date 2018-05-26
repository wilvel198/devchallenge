package com.devchal.workers;

import org.apache.log4j.Logger;

import com.devchal.pojo.user.USERACCOUNT;
import com.devchal.responseobjects.responseObject;
import com.google.gson.Gson;

public class systemProcessor {

	final static Logger logger = Logger.getLogger(systemProcessor.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static responseObject addUser(String fullJson){
		logger.info("--------------> ADDING USER TO DATABASE <---------------");
		responseObject responseInfo = new responseObject();
		
		//create an user object from JSON post using GSON
		
		Gson gson = new Gson();
		USERACCOUNT userAccountItem = gson.fromJson(fullJson, USERACCOUNT.class);
		
		String userEmail = userAccountItem.getEmailaddress();
		
		//check for user in database 
		
		
		
		
		
		//build database insert statement
		
		
		//call insert 
		
		
		return responseInfo;
	}
	

}
