package com.devchal.controllers;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devchal.constants.ProjectConstants;
import com.devchal.contentdata.ContentData;
import com.devchal.pojo.data.GiffySearchResults;
import com.devchal.pojo.data.Languages;
import com.devchal.responseobjects.responseObject;
import com.devchal.workers.systemProcessor;



@RestController
public class ProcessorController {
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = ProjectConstants.CREATE_USER, method=RequestMethod.POST )
	public responseObject addUser(HttpEntity<String> httpEntity){
		
		String responseData = null;
		
   	 	String fullJson = httpEntity.getBody(); // yeah we finally got the plain json string
   	 	System.out.println("<----------------------------------------------------------------------->");
        System.out.println( String.format("JSON INFORMATION ----->" + fullJson));
        responseObject myResponse = systemProcessor.addUser(fullJson);
        
        System.out.println("<----------------------------------------------------------------------->");
   	
		
		return myResponse;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getContentData")
    @ResponseBody
	public ContentData getContentData(){
		ContentData userContentData = new ContentData();
		List<String> catgList = new ArrayList<String>();
		catgList.add("Dogs");
		catgList.add("Funny");
		
		String[] stockArr = new String[catgList.size()];
		stockArr = catgList.toArray(stockArr);
		
		userContentData.setContentLocation("https://media3.giphy.com/media/DTXugNB5Jt6Ra/200_d.gif");
		userContentData.setId("123456");
		userContentData.setCategory(stockArr);
		userContentData.setUserid("12345678");
		userContentData.setObjectType("ContentData");
		
		
		
		return userContentData;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value="/getLanguages", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Languages getLanguages(){
		
		List<String> langList = new ArrayList<String>();
		langList.add("English");
		langList.add("French");
		langList.add("Russian");
		langList.add("Spanish");
		langList.add("Chinnese");
		langList.add("Portuguesse");
		langList.add("Hindi");
		
		String[] stockArr = new String[langList.size()];
		stockArr = langList.toArray(stockArr);
		
		Languages myLang = new Languages();
		myLang.setLanguages(stockArr);
		
		return myLang;
	}
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping(value = ProjectConstants.SEARCH_BYTOPIC, method=RequestMethod.POST )
	public GiffySearchResults searchByTopic(HttpEntity<String> httpEntity){
		
		String responseData = null;
		
   	 	String fullJson = httpEntity.getBody(); // yeah we finally got the plain json string
   	 	System.out.println("<----------------------------------------------------------------------->");
        System.out.println( String.format("JSON INFORMATION ----->" + fullJson));
        responseObject myResponse = systemProcessor.addUser(fullJson);
        
        System.out.println("<----------------------------------------------------------------------->");
   	
		
		return null;
	}
	

}
