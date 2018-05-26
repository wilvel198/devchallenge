package com.devchal.controllers;


import java.util.HashMap;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devchal.constants.ProjectConstants;
import com.devchal.responseobjects.responseObject;
import com.devchal.workers.systemProcessor;



@RestController
public class ProcessorController {
	
	
	
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
	
	
	

}
