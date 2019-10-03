package com.idomsoft.repository;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idomsoft.DTO.Allampolgarsag;
import com.idomsoft.DTO.Okmanytipus;

@Component
public class ReadJson  {
    
/*================================================kodszotar21_allampolg.json================================================*/		
	public Map<String, String>  readJson21(){
		Map<String, String> hasMap = new HashMap();
        try {

            ObjectMapper objectMapper2 = new ObjectMapper();
                 	   	
        	List<Allampolgarsag> allampolgarsagList = objectMapper2.readValue(
        			new File("src/main/resources/static/JSON/kodszotar21_allampolg.json"), new TypeReference<List<Allampolgarsag>>(){});
                  	 
        	hasMap = allampolgarsagList.stream()
        			.collect(Collectors.toMap(Allampolgarsag::getKod, Allampolgarsag::getAllampolgarsag));
      
        } catch (Exception e) {
        	System.out.println(e);
          }
        return hasMap;
	}	
	/*================================================kodszotar46_okmanytipus.json================================================*/		
	public List<String> readJson46(){
		List<String> okmTipusKodList = new ArrayList<String>();
        try {
            ObjectMapper objectMapper1 = new ObjectMapper();
                 	      	
        	List<Okmanytipus> okmanyTipusList = objectMapper1.readValue(
        			new File("src/main/resources/static/JSON/kodszotar46_okmanytipus.json"), new TypeReference<List<Okmanytipus>>(){});
            
        	okmTipusKodList = okmanyTipusList.stream().map(x -> x.getKod()).collect(Collectors.toList());
        	      
        } catch (Exception e) {
        	System.out.println(e);
          }
        return okmTipusKodList;
	}	

	
	
}
