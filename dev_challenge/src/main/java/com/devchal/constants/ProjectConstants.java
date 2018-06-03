package com.devchal.constants;

public class ProjectConstants {

	
	private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/customerdatabase";
	private static final String USERNAME = "app_service";
	private static final String PASSWORD = "467046WvCv";
	private static final String MAX_POOL = "250"; // set your own limit
	private static final String TEMP_SPACE = "/Users/gv91ig/devChallengeFolder/";
	
	
	//pathing constants
	public static final String CREATE_USER = "/createUser";
	public static final String SEARCH_BYTOPIC = "/searchByTopic";
	public static final String SEARCH_BYID = "/searchByID";
	
	//constants for favorites
	public static final String SAVE_FAV = "/savefav";
	public static final String GET_FAV = "/getfav";
	public static final String FAV_DETAILS = "/getfavdetails";
	//login constant
	public static final String LOGIN = "/login";
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
