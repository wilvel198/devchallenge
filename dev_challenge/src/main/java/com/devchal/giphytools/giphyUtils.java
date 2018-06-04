package com.devchal.giphytools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.devchal.pojo.data.SearchTopic;
import com.devchal.pojo.giffy.GiffyData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.minidev.json.JSONArray;

import java.lang.reflect.Type;

import com.google.gson.Gson;

public class giphyUtils {
	
	
	private final static String USER_AGENT = "Mozilla/5.0";
	final static Logger logger = Logger.getLogger(giphyUtils.class);
	/*
	 * This class is used to search Giphy site to return full search and Indivual items
	 * 
	 * 
	 */
	public static void main(String[] args){
	logger.info("--------------> Retrieving Giphy site Information<----------------");
	String searchBase = null;
	String searchType = null;
	String testID = "fItgT774J3nWw";
	
	// --- test for full search
	searchBase = "dogs";
	searchType = "fullSearch";
	// -- test for ID search
	//searchBase = testID;
	//searchType  ="id";
	
	baseSearch(searchBase, searchType);
		
	}
	
	
	public static String giffyBaseSearch(String searchTopic, String searchType) throws ClientProtocolException, IOException{
		logger.info("Testing generic json load -->" + searchType);
		String checkVal = "fullSearch";
		String searchURL = null;
		String returnJson = null;
		String line = "";
		
		//check the search type
		if (searchType.equals(checkVal) ){
			logger.info("---------- > PERFORM A FULL SEARCH <---------------");
			searchURL = "http://api.giphy.com/v1/gifs/search?api_key=Q1TTfATI6kOo38xfDRcqBazWCGRXu9VP&limit=20&offset=0&rating=G&lang=en&q="+  URLEncoder.encode( searchTopic, "UTF-8");
		}else
		{
			logger.info("---------- > PERFORM ID SEARCH <---------------");
			searchURL =  "http://api.giphy.com/v1/gifs?api_key=Q1TTfATI6kOo38xfDRcqBazWCGRXu9VP&ids=" + URLEncoder.encode( searchTopic, "UTF-8");
		}
		
		
		try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(searchURL);
            HttpResponse response = client.execute(request);
 
            int responseCode = response.getStatusLine().getStatusCode();
 
            logger.info("**GET** request Url: " + request.getURI());
            logger.info("Response Code: " + responseCode);
            logger.info("Content:-\n");
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
 
            
            while ((line = rd.readLine()) != null) {
                logger.info("here" + line.replace("\\", ""));
                returnJson = line;
            }
            
        
 
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		    logger.info("Returning --->" + returnJson);
			return returnJson;
	}
	
	
	public static List<String> parseJson(String jsonData, String searchType){
		logger.info("Parse objects out - >" + searchType);
		logger.info("JSON DATA -------->" + jsonData);
		
		String giffyId = null;
		String giffyURL = null;
		String giffyEmbeddedURL = null;
		String giffyTitle = null;
		String dataString = null;
		JSONObject giffyBaseURL = null;
		int returnSize = 0;
		String checkObj = null;
		checkObj = "fullSearch";
		List<String> list = new ArrayList<>();
		
	

		try {
			JSONObject jsonDataObject = new JSONObject(jsonData);
			
			org.json.JSONArray values = jsonDataObject.getJSONArray("data");
			
			returnSize = values.length();
			
			for(int x = 0 ; x < returnSize; x++ ){
				
				JSONObject giffyInfo = values.getJSONObject(x);
				
				giffyId = giffyInfo.getString("id");
				giffyTitle = giffyInfo.getString("title");
				giffyURL = giffyInfo.getString("url");
				
			
				logger.info("ID " + giffyId);
				logger.info(giffyInfo.getString("title"));
				
				if(checkObj.equals(searchType)){
					logger.info(" -----> FULL SEARCH RETURNS 2 FIELDS <---------------");
					dataString = giffyTitle  + "#####" + giffyId;
					list.add(dataString.replaceAll(" ", "_"));
					
				}else{
					logger.info(" -----> ID SEARCH RETURNS ALL FIELDS <---------------");
					giffyEmbeddedURL = giffyInfo.getString("embed_url");
					giffyBaseURL  = giffyInfo.getJSONObject("images");
					JSONObject giffyOriginal = giffyBaseURL.getJSONObject("fixed_height_still");
					logger.info("the base URL IS " + giffyOriginal.getString("url"));
					giffyURL = giffyOriginal.getString("url");
					
					String giffyItem = "{\"giffyTitle\":\""+ giffyTitle + "\" , \"giffyId\":\""+ giffyId + "\",\"giffyURL\":\" "+giffyURL +"  \",\"giffyEmbeddedURL\":\""+ giffyEmbeddedURL  +"\" }";
					
					dataString = giffyTitle + "####" + giffyId + "####"+ giffyURL + "####"+ giffyEmbeddedURL;
					list.add(giffyItem.replace(" ", "_"));
				}
				
					
				
			}
			
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public static List<String> baseSearch(String searchBase, String searchType){
		logger.info("-------------------> EXECUTING A BASE SEARCH FOR ITEM OR FULL SEARCH <---------------------------");
		List<String> list = new ArrayList<>();
		
		
		
		logger.info("THE SEARCH TYPE ---------->" + searchType);
		
	
		
		logger.info("-----------------> PERFORM A BASE SEARCH <---------------");
		
		try {
			String jsonVal = giffyBaseSearch(searchBase, searchType) ;
		logger.info("BASE SEARCH PROCESSING STRING --> " + jsonVal);
		list = parseJson(jsonVal, searchType);
		logger.info("SIZE OF RETURNED ITEMS " + list.size());
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//;
		return list;
		
	}

	public static String getSearchTopic(String json){
		logger.info(" SEARCH TOPIC JSON -->" + json);
		String searchTopic = null;
		searchTopic = "dogs";
		Gson gson = new Gson();
		
		SearchTopic myTopic = gson.fromJson(json,SearchTopic.class);
		searchTopic = myTopic.getSearchTopic();
		
		return searchTopic;
	}

}
