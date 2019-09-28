package com.idomsoft;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idomsoft.DTO.Kod21Allampolg;
import com.idomsoft.DTO.SzemelyDTO;
import com.idomsoft.service.SzemelyService;

@SpringBootApplication
public class IdomSoftApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(IdomSoftApplication.class, args);
	}

	@Override
    public void run(String[] args) throws IOException {
		try {
//			create ObjectMapper instance
	        ObjectMapper objectMapper = new ObjectMapper();

	        //json fajl beolvasasa es szemelyDto objektumba konvertalas
	        SzemelyDTO szemelyDTO = objectMapper.readValue(new File("Szemely_1.json"), SzemelyDTO.class);
	                
       
	        //read json file and convert to kod21Allampolg object
		    //   Kod21Allampolg[]  kod21Allampolg = objectMapper.readValue(new File("src/main/resources/static/JSON/kodszotar21_allampolg.json"), Kod21Allampolg[].class);
			   
		    //   for (Kod21Allampolg kodAllampolg : kod21Allampolg) {
	        //      System.out.println(kodAllampolg);
	        //    }
	        
//		        print kod21Allampolg details
//		        String nev =kod21Allampolg.getAllampolgarsag();
//		        System.out.println(kod21Allampolg);
	        
//	       FUGGVENY TESZT:
		    SzemelyService szemelyService = new SzemelyService();
	        System.out.println(szemelyService.szemelyServiceValidacio(szemelyDTO));
	        
	        
		} catch (Exception e) {
			 System.out.println(e);
		}
        
    }
	
	
}
