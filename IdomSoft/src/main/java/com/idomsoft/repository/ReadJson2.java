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
import com.idomsoft.service.OkmanyService;
import com.idomsoft.service.SzemelyService;
@Component
public class ReadJson2 implements CommandLineRunner  {
	
	@Override
    public void run(String[] args) throws IOException {

/*============================================Szemely_1.json===========================================================*/		
		try {
//			create ObjectMapper instance
	        ObjectMapper objectMapper = new ObjectMapper();

 //         json fajl beolvasasa es szemelyDto objektumba konvertalasa
	        SzemelyDTO szemelyDTO = objectMapper.readValue(new File("src/main/resources/static/JSON/Szemely_1.json"), SzemelyDTO.class);     	  
//	        System.out.println(szemelyDTO);
//	        System.out.println();
//	        OkmanyDTO okmanyDTO = new OkmanyDTO();
//	        System.out.println(szemelyDTO.getOkmLista());
//	        System.out.println("okmany: " + szemelyDTO.getOkmLista().get + " : "+ szemelyDTO.getOkmLista().getOkmTipus());

//	        FUGGVENY TESZT:
	        
//		    SzemelyService szemelyService = new SzemelyService();
//	        System.out.println(szemelyService.szemelyServiceValidacio(szemelyDTO));
	       
//	        ReadJson readJson = new ReadJson();
//	        readJson.readJson46();
	        
	        OkmanyService okmanyService = new OkmanyService();
//	        System.out.println();
//	        System.out.println("Hiba lista: "+okmanyService.okmanyServiceValidacio(szemelyDTO.getOkmLista()));
//	        System.out.println();
//	        System.out.println("Uj OkmLista: "+szemelyDTO.getOkmLista());
	        

		} catch (Exception e) {
			 System.out.println(e);
		  }
		
		
		
}
	
}