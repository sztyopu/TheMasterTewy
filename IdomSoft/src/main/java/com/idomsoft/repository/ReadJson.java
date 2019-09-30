package com.idomsoft.repository;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	        
//          json fajl beolvasasa es szemelyDTO objektumba konvertalasa
	        SzemelyDTO szemelyDTO = objectMapper.readValue(new File("src/main/resources/static/JSON/Szemely_1.json"), SzemelyDTO.class);     	  
	        System.out.println(szemelyDTO);
	        System.out.println();
	        
//			OkmanyDTO kiiratasa
	        System.out.println("okmany: " + szemelyDTO.getOkmLista());
	        System.out.println();
//	        System.out.println("okmany: " + szemelyDTO.getOkmLista().get(0).getOkmanySzam() + " : "
//					           + szemelyDTO.getOkmLista().get(0).getOkmTipus());   

//	        	        FUGGVENY TESZT:
		    SzemelyService szemelyService = new SzemelyService();
	        System.out.println(szemelyService.szemelyServiceValidacio(szemelyDTO));
	        	        
		} catch (Exception e) {
			 System.out.println(e);
		  }
      
/*================================================kodszotar21_allampolg.json================================================*/		
        try {
//    		create ObjectMapper instance
            ObjectMapper objectMapper2 = new ObjectMapper();
                 	
//          read json file (kodszotar21_allampolg.json) and convert to List      	
        	List<Allampolgarsag> allampolgarsagList = objectMapper2.readValue(new File("src/main/resources/static/JSON/kodszotar21_allampolg.json"), new TypeReference<List<Allampolgarsag>>(){});
                  	
//			creat Map(kod,allampolgarsag) 
        	Map<String, String> hasMap = allampolgarsagList.stream()
        			.collect(Collectors.toMap(Allampolgarsag::getKod, Allampolgarsag::getAllampolgarsag));

        	 
        
      
        } catch (Exception e) {
        	System.out.println(e);
          }
		
		
		
    }
	
	
}
