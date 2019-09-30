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
import com.idomsoft.repository.ReadJson;
import com.idomsoft.DTO.Allampolgarsag;
import com.idomsoft.service.SzemelyService;

@SpringBootApplication
public class IdomSoftApplication  {

	public static void main(String[] args) {
		SpringApplication.run(IdomSoftApplication.class, args);
		
		
//		SzemelyService szemelyService = new SzemelyService();
//		szemelyService.strNev("Varga Éva");
		
		
//		ReadJson readJson = new ReadJson();
//		readJson.teszt();
	}

	

	
	
}
