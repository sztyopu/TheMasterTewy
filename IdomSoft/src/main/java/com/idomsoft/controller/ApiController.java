package com.idomsoft.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.idomsoft.DTO.OkmanyDTO;
import com.idomsoft.DTO.OkmanyServiceResp;
import com.idomsoft.DTO.SzemelyDTO;
import com.idomsoft.DTO.SzemelyServiceResp;
import com.idomsoft.service.OkmanyService;
import com.idomsoft.service.SzemelyService;

@RestController
public class ApiController {

	@Autowired
    SzemelyService szemelyServiece;

    @Autowired
    OkmanyService okmanyServiece;

    @RequestMapping(value = "/szemely", method = RequestMethod.POST)
    public SzemelyServiceResp szemelyValidation(@RequestBody SzemelyDTO szemelyDTO) {
        //szemelyServiceResp egyszerre tudja tárolni a módosított szemelyDTO-t és a hiba listát
    	SzemelyServiceResp szemelyServiceResp = new SzemelyServiceResp();
    	
    	// itt meghíjuk a SemelyService-ben megírt validációs metódust, ami visszad egy hiba listát 
    	List<String> errorList = szemelyServiece.szemelyServiceValidacio(szemelyDTO);
        // 2. microservice meghivása
    	final String uri = "http://localhost:8080/okmany";
    	RestTemplate restTemplate = new RestTemplate();
    	OkmanyServiceResp okmanyServiceResp = restTemplate.getForObject(uri, OkmanyServiceResp.class);
    	
    	szemelyServiceResp.setLista(errorList);
    	szemelyServiceResp.setSzemely(szemelyDTO);
    	return szemelyServiceResp;
    }

    @RequestMapping(value = "/okmany", method = RequestMethod.POST)
    public OkmanyServiceResp okmanyValidation(@RequestBody SzemelyDTO szemelyDTO) {
    	 //okmanyServiceResp egyszerre tudja tárolni a módosított okmLista-t és a hiba listát
    	OkmanyServiceResp okmanyServiceResp = new OkmanyServiceResp();
    	
    	// itt meghíjuk a OkmanyService-ben megírt validációs metódust, ami visszad egy hiba listát 
    	ArrayList<String> errorsOkmanyLista = okmanyServiece.okmanyServiceValidacio(szemelyDTO.getOkmLista());
    	
    	okmanyServiceResp.setErrorsOkmanyLista(errorsOkmanyLista);
    	okmanyServiceResp.setOkmLista(szemelyDTO.getOkmLista());
        
        return okmanyServiceResp;
    }
}