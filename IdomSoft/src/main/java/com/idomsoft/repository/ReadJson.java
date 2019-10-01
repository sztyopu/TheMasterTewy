package com.idomsoft.repository;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idomsoft.DTO.Allampolgarsag;

@Component
public class ReadJson  {
    
/*================================================kodszotar21_allampolg.json================================================*/		
	public Map<String, String>  readJson21(){
		Map<String, String> hasMap = new HashMap();
        try {
//    		create ObjectMapper instance
            ObjectMapper objectMapper2 = new ObjectMapper();
                 	
//          read json file (kodszotar21_allampolg.json) and convert to List      	
        	List<Allampolgarsag> allampolgarsagList = objectMapper2.readValue(new File("src/main/resources/static/JSON/kodszotar21_allampolg.json"), new TypeReference<List<Allampolgarsag>>(){});
                  	
//			creat Map(kod,allampolgarsag) 
        	hasMap = allampolgarsagList.stream()
        			.collect(Collectors.toMap(Allampolgarsag::getKod, Allampolgarsag::getAllampolgarsag));
      
        } catch (Exception e) {
        	System.out.println(e);
          }
        return hasMap;
	}	

	
	
}
