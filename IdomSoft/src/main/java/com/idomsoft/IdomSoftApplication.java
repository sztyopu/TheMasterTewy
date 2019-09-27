package com.idomsoft;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idomsoft.DTO.SzemelyDTO;

@SpringBootApplication
public class IdomSoftApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(IdomSoftApplication.class, args);
	}

	@Override
    public void run(String[] args) throws IOException {

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //read json file and convert to szemelyDto object
        SzemelyDTO szemelyDTO = objectMapper.readValue(new File("Szemely_1.json"), SzemelyDTO.class);

        //print szemelyDTO details
        System.out.println(szemelyDTO);
    }
	
	
}
