package com.idomsoft;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.idomsoft.DTO.Allampolgarsag;
import com.idomsoft.DTO.SzemelyDTO;
import com.idomsoft.repository.ReadJson2;

@SpringBootApplication
public class IdomSoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdomSoftApplication.class, args);

//		SzemelyService szemelyService = new SzemelyService();
//		szemelyService.strNev("Varga Éva");

//		ReadJson readJson = new ReadJson();
//		readJson.teszt();
//		List<Allampolgarsag> allampolgarsag = ReadJson2
//				.readJSONList("src/main/resources/static/JSON/kodszotar21_allampolg.json");
//		System.out.println("allampolgarsag: " + allampolgarsag);
		

//		SzemelyDTO szemely = ReadJson2.readJSON("src/main/resources/static/JSON/Szemely_1.json", SzemelyDTO.class);

//		System.out.println("szemely: " + szemely);
	}

}
