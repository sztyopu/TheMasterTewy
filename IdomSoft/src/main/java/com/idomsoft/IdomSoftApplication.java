package com.idomsoft;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.idomsoft.DTO.OkmanyDTO;
import com.idomsoft.DTO.SzemelyDTO;
import com.idomsoft.DTO.Allampolgarsag;
import com.idomsoft.service.SzemelyService;

@SpringBootApplication
public class IdomSoftApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(IdomSoftApplication.class, args);
	}

	@Override
    public void run(String[] args) throws IOException {
		
/*============================================Szemely_1.json===========================================================*/		
		try {
//			create ObjectMapper instance
	        ObjectMapper objectMapper = new ObjectMapper();
	        
 //         json fajl beolvasasa es szemelyDto objektumba konvertalasa
	        SzemelyDTO szemelyDTO = objectMapper.readValue(new File("src/main/resources/static/JSON/Szemely_1.json"), SzemelyDTO.class);     	  
//	        System.out.println(szemelyDTO);
	           
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
        } catch (Exception e) {
        	System.out.println(e);
          }
		
		
		
    }
	
	
}
