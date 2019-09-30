package com.idomsoft.repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idomsoft.DTO.Allampolgarsag;
import com.idomsoft.DTO.OkmanyDTO;
import com.idomsoft.DTO.SzemelyDTO;
import com.idomsoft.service.SzemelyService;

@Component
public class ReadJson implements CommandLineRunner {
    
	@Override
    public void run(String[] args) throws IOException {
		
/*============================================Szemely_1.json===========================================================*/		
		try {
//			create ObjectMapper instance
	        ObjectMapper objectMapper = new ObjectMapper();
	        
 //         json fajl beolvasasa es szemelyDto objektumba konvertalasa
	        SzemelyDTO szemelyDTO = objectMapper.readValue(new File("src/main/resources/static/JSON/Szemely_1.json"), SzemelyDTO.class);     	  
	        System.out.println(szemelyDTO);
//	        OkmanyDTO okmany = new OkmanyDTO();
//	        System.out.println(okmany.getLejarDat());
	           
//	        FUGGVENY TESZT:
		    SzemelyService szemelyService = new SzemelyService();
	        System.out.println(szemelyService.szemelyServiceValidacio(szemelyDTO));
	        	        
		} catch (Exception e) {
			 System.out.println(e);
		  }
      
/*================================================kodszotar21_allampolg.json================================================*/		
        try {
//    		create ObjectMapper instance
            ObjectMapper objectMapper2 = new ObjectMapper();
            
//          read json file (kodszotar21_allampolg.json) and convert to Allampolgarsag object 
        	Allampolgarsag[] allampolgarsag = objectMapper2.readValue(new File("src/main/resources/static/JSON/kodszotar21_allampolg.json"), Allampolgarsag[].class);
/*            System.out.println("JSON array to Array objects...");
            for (Allampolgarsag allam : allampolgarsag) {
                System.out.println(allam);
            }
*/           
        	
//          read json file (kodszotar21_allampolg.json) and convert to List      	
        	List<Allampolgarsag> allampolgarsagList = objectMapper2.readValue(new File("src/main/resources/static/JSON/kodszotar21_allampolg.json"), new TypeReference<List<Allampolgarsag>>(){});
/*        	System.out.println("\nJSON array to List of objects");
        	allampolgarsagList.stream().forEach(x -> System.out.println(x));
*/        	
 //       	System.out.println(allampolgarsagList.get(0));
        
        	//Vissza adja azt az objektumot ahol a kod:"HUN"
        	List<Allampolgarsag> result = allampolgarsagList.stream()
        		     .filter(item -> item.getKod().equals("HUN"))
        		     .collect(Collectors.toList());
        	System.out.println("result: " +result);
        	//nem tudom, hogy ezt hogy keressem meg?!?!?!
        	System.out.println("result allampolgarsag: " );
        } catch (Exception e) {
        	System.out.println(e);
          }
		
		
		
    }
	
	public void teszt() {
		System.out.println("Teszt ReadJson class.");
	}
}
