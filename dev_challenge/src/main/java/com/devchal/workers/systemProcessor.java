package com.devchal.workers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.devchal.databaseutils.DatabaseUtil;
import com.devchal.giphytools.giphyUtils;
import com.devchal.pojo.data.AuthObject;
import com.devchal.pojo.data.GiffyObject;
import com.devchal.pojo.data.USERDATA;
import com.devchal.pojo.user.USERACCOUNT;
import com.devchal.pojo.data.GiffySaveObject;
import com.devchal.responseobjects.responseObject;
import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.devchal.pojo.data.SearchTopic;

public class systemProcessor {

	final static Logger logger = Logger.getLogger(systemProcessor.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.info(" ------->  INSERT <------------");
		// test to load User Data
		String userData = "{\"firstName\":\"Darla\",\"lastName\":\"Smith\",\"address\":\"1234 Somewhere\",\"city\":\"Austin\",\"state\":\"Texas\",\"emailaddress\":\"w_velasquezcorp@yahoo.com\",\"zip\":\"78665\",\"phoneNumber\":\"512-555-5555\",\"username\":\"person198\",\"password\":\"password\"}";
		//test to load favorite 
		String favData = "{\"emailAddress\":\"w_velasquezcorp@yahoo.com\",\"categories\":\"happy,cats,interesting\",\"giffyEmeddedURL\":\"https://giphy.com/embed/9qIQcHFew1dAs\",\"giffyID\":\"9qIQcHFew1dAs\",\"giffyTitle\":\"bears hello GIF\",\"giffyURL\":\"https://media0.giphy.com/media/9qIQcHFew1dAs/200_s.gif\"}";
		String searchString = null;
		String loginData = "{\"type\": \"login\",\"username\":\"person198\",\"password\":\"password\"}";
		
		//authenticateLogin(loginData);
		
		//searchById(searchString);
		//addUser(userData);
		
		saveFavProcessor(favData);
		
	}
	
	
	public static responseObject authenticateLogin(String fullJson){
		
		logger.info("--------- > AUTHENTICATE <--------------");
		
		String userName = null;
		String password = null;
		String emailAddress = null;
		responseObject res = new responseObject();
		Connection conn  = null;
		PreparedStatement preparedStatement = null;
		int userCount = 0;
		
		Gson gson = new Gson();
		AuthObject myAuth = gson.fromJson(fullJson, AuthObject.class);
		userName = myAuth.getUsername();
		password = myAuth.getPassword();
		
		logger.info("user name " + userName);
		logger.info("password " + password);
		
		
		userCount = DatabaseUtil.verifyAccount(userName, password);
		
		logger.info("USER COUNT -->" + userCount);
		
		if(userCount > 0){
			logger.info("PRODUCE EMAIL FOR ACCOUNT TICKET");
			emailAddress = DatabaseUtil.getUserEmail(userName, password);
			logger.info("EMAIL ADDRESS = "+ emailAddress);
			res.setObjectType(emailAddress);
			res.setMsg("user successfully authenticated");
			res.setStatus("active");
			
			
		}else{
			res.setMsg("user account or password incorrect, please try again or create an account");
			res.setStatus("inactive");
			res.setObjectType("no account found or incorrect password");
		}
		
		
		return res;
	}
	
	public static responseObject saveFavProcessor(String fullJson){
		logger.info("Saving favorite information to DB");
		responseObject res = new responseObject();
		String emailAddress = null;
		String categories = null;
		String giffyEmeddedURL = null;
		String giffyID = null;
		String giffyTitle = null;
		String giffyURL = null;
		int itemCount = 0;
		String query = null;
		Connection conn  = null;
		
		Gson gson = new Gson();
		GiffySaveObject userAccountItem = gson.fromJson(fullJson, GiffySaveObject.class);
		
		logger.info("Email -->"+ userAccountItem.getEmailAddress());
		logger.info("ID -->" + userAccountItem.getGiffyID());
		
		emailAddress = userAccountItem.getEmailAddress();
		giffyID = userAccountItem.getGiffyID();
		categories = userAccountItem.getCategories();
		giffyEmeddedURL = userAccountItem.getGiffyEmbeddedURL();
		giffyTitle = userAccountItem.getGiffyTitle();
		giffyURL = userAccountItem.getGiffyURL();
		
		
		
		itemCount = DatabaseUtil.verifyFav(emailAddress, giffyID);
		
		if(itemCount > 0){
			logger.info(" ------> Update object <--------");
			
			query =  "update USER_DATA set categories = ? where emailAddress = ? and giffyID = ?";
			
			conn = DatabaseUtil.getConnection();
			
			  PreparedStatement preparedStmt;
			  
			try {
				preparedStmt = conn.prepareStatement(query);
				 preparedStmt.setString (1, categories);
			      preparedStmt.setString (2, emailAddress);
			      preparedStmt.setString (3, giffyID);
			      
			      preparedStmt.execute();
			      
			  
			      conn.close();
			 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		   
			res.setMsg("Item updated");	
			
			
		}else
		{
			
			logger.info(" ----------------> Insert favorite <---------------");
			
			query = " insert into USER_DATA (emailAddress, giffyEmbeddedURL, giffyTitle, giffyURL, giffyID, categories)"
			        + " values (?, ?, ?, ?, ?, ?)";
		conn = DatabaseUtil.getConnection();
			
			// create the mysql insert preparedstatement
		      PreparedStatement preparedStmt;
			try {
				preparedStmt = conn.prepareStatement(query);
				 preparedStmt.setString (1, emailAddress);
			      preparedStmt.setString (2, giffyEmeddedURL);
			      preparedStmt.setString   (3, giffyTitle);
			      preparedStmt.setString (4,  giffyURL);
			      preparedStmt.setString (5, giffyID);
			      preparedStmt.setString(6, categories); 
			      
			      preparedStmt.execute();
			      
			  
			      conn.close();
			      
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     
			
			
			
			res.setMsg("Item added to favorites");	
			
		}
		
		logger.info("ITEM COUNT IS " + itemCount);
		
		return res;
	}
	
	public static responseObject addUser(String fullJson){
		logger.info("--------------> ADDING USER TO DATABASE <---------------");
		logger.info(fullJson);
		responseObject responseInfo = new responseObject();
		int userCount = 0;
		String msgResult = null;
		String firstName = null;
		String lastName = null;
		String username = null;
		String password = null;
		String address = null;
		String city = null;
		String state = null;
		String zip = null;
		String phoneNumber = null;
		String userEmail = null;
		String query = null;
		
		//create an user object from JSON post using GSON
		
		Gson gson = new Gson();
		USERDATA userAccountItem = gson.fromJson(fullJson, USERDATA.class);
		
		userEmail = userAccountItem.getEmailaddress();
		firstName = userAccountItem.getFirstName();
		lastName = userAccountItem.getLastName();
		username = userAccountItem.getUsername();
		password = userAccountItem.getPassword();
		address = userAccountItem.getAddress();
		city = userAccountItem.getCity();
		state = userAccountItem.getState();
		zip = userAccountItem.getZip();
		phoneNumber = userAccountItem.getPhoneNumber();
		
		logger.info("firstName:" + firstName + " lastname:" + lastName);
		
		
		
		//check for user in database 
		logger.info("----------- CHECK IF USER EXISTS IN DB");
		
		userCount = DatabaseUtil.verifyUser(userEmail);
		
		if(userCount < 1){
			logger.info("USER WAS NOT FOUND CREATE THE USER --->");
			
			
			Connection conn = DatabaseUtil.getConnection();
			
			query = " insert into USER_ACCOUNTS (firstName, lastName, username, password, address, city, state, zip, phoneNumber, emailAddress)"
	        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			// create the mysql insert preparedstatement
		      PreparedStatement preparedStmt;
			try {
				preparedStmt = conn.prepareStatement(query);
				 preparedStmt.setString (1, firstName);
			      preparedStmt.setString (2, lastName);
			      preparedStmt.setString   (3, username);
			      preparedStmt.setString (4, password);
			      preparedStmt.setString (5, address);
			      preparedStmt.setString(6, city);
			      preparedStmt.setString(7, state);
			      preparedStmt.setString(8, zip);
			      preparedStmt.setString(9, phoneNumber);
			      preparedStmt.setString(10, userEmail);
			      

			      // execute the preparedstatement
			      preparedStmt.execute();
			      conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     
		      
		     
	
			
			
			
			
			
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
	
	
	public static List<String> getUserFavorite(String searchJson){
		List<String> searchResultList = new ArrayList<String>();
		logger.info("full JSON "+ searchJson);
		String userName = null;
		
		Gson gson = new Gson();
		SearchTopic mySearchObject = gson.fromJson(searchJson, SearchTopic.class);
		userName = mySearchObject.getSearchTopic();
		searchResultList.add("nba finals#####deNdwcvjXzTTTV7LXF");
		searchResultList.add("nba finals#####deNdwcvjXzTTTV7LXF");
		
		
		
		searchResultList = DatabaseUtil.getUserFavorites(userName);
		
		
		return searchResultList;
	}
	
	public static List<String> getGiffySearchByTopic(String searchJson){
		System.out.println("SEARCH FROM SERVER CALL ------>" + searchJson);
		
		List<String> searchResultList = new ArrayList<String>();
		
		String searchType = null;
		String searchBase = "dogs";
		
		logger.info("-----> Extract Search Base <------");
		searchBase = giphyUtils.getSearchTopic(searchJson);
		
		searchType = "fullSearch";
		
		
		searchResultList = giphyUtils.baseSearch(searchBase, searchType);
		
		return searchResultList;
	}
	
	
	public static GiffyObject getGiphyObjDetails(String searchJson){
		//GiffyObject giphyObj = new GiffyObject();
		logger.info("------------> GETTING OBJECT DETAILS <------------");
		
		
		String searchType = null;
		String searchBase = null;
		String resultJson = null;
		Gson gson = new Gson();
		
		searchType = "searchByID";
		
		logger.info("-----> Extract Search Base <------");
		searchBase = giphyUtils.getSearchTopic(searchJson);
		logger.info("SEARCH BASE --->" + searchBase);
		
		List<String> searchResultList = giphyUtils.baseSearch(searchBase, searchType );
		
		resultJson = searchResultList.get(0);
		logger.info("--------> GIPHY OBJECT JSON" + searchResultList.get(0));
		
		logger.info(searchResultList.size());
		
		
		//seup giphy Object details 
		
		GiffyObject giffyObj = gson.fromJson(resultJson, GiffyObject.class);
		
		
		
		return giffyObj;
		
	}

}
