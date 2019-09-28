package com.idomsoft;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
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

	        //read json file and convert to szemelyDto object
	        SzemelyDTO szemelyDTO = objectMapper.readValue(new File("Szemely_1.json"), SzemelyDTO.class);

//	        print szemelyDTO details
//	        String nev =szemelyDTO.getVisNev();
//	        System.out.println(nev);

//	        Kiprobalom megtudom-e hivni a SzemelyService-t
	        SzemelyService szemelyService = new SzemelyService();
	        System.out.println(szemelyService.osszeg(szemelyDTO));
	        
	        szemelyService.szemelyServiceValidacio(szemelyDTO);
	        
//	        fuggveny teszt
//	        System.out.println(szemelyService.isStringOnlyAlphabet("Varga-Csetneki Éva"));
	        System.out.println(szemelyService.isStringBiggerTwoWord("Varga Dr."));
	        
	        
	        
		} catch (Exception e) {
			 System.out.println(e);
		}
        
    }
	
	
}
