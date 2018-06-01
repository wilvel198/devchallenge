package com.devchal.workers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.devchal.databaseutils.DatabaseUtil;
import com.devchal.giphytools.giphyUtils;
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
		int userCount = 0;
		String msgResult = null;
		String firstName = null;
		String lastName = null;
		String username = null;
		
		
		//create an user object from JSON post using GSON
		
		Gson gson = new Gson();
		USERACCOUNT userAccountItem = gson.fromJson(fullJson, USERACCOUNT.class);
		
		String userEmail = userAccountItem.getEmailaddress();
		
		//check for user in database 
		logger.info("----------- CHECK IF USER EXISTS IN DB");
		
		userCount = DatabaseUtil.verifyUser(userEmail);
		
		if(userCount < 1){
			logger.info("USER WAS NOT FOUND CREATE THE USER --->");
			msgResult = "USER ADDED SUCCESFULLY";
			
			
		}else{
			logger.info("USER ALREADY EXISTS ");
			msgResult = "USER ALREADY EXISTS";
		}
		
		
		
		//build database insert statement
		
		
		//call insert 
		
		
		//set response results
		
		
		responseInfo.setStatus("Ok");
		responseInfo.setMsg(msgResult);
		responseInfo.setObjectType("CREATEUSER");
		return responseInfo;
	}
	
	
	public static List<String> getGiffySearchByTopic(String searchJson){
		System.out.println("SEARCH FROM SERVER CALL ------>" + searchJson);
		
		List<String> searchResultList = new ArrayList<String>();
		searchResultList.add("dogs_jumprope_GIF##cLcxtL1z8t8oo");
		searchResultList.add("star wars dogs GIF##fItgT774J3nWw");
		String searchType = null;
		String searchBase = "dogs";
		
		logger.info("-----> Extract Search Base <------");
		searchBase = giphyUtils.getSearchTopic(searchJson);
		
		searchType = "fullSearch";
		
		
		searchResultList = giphyUtils.baseSearch(searchBase, searchType);
		
		return searchResultList;
	}

}
