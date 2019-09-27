package com.idomsoft.service;

import org.springframework.stereotype.Service;

import com.idomsoft.DTO.SzemelyDTO;

@Service
public class SzemelyService  {
	
	SzemelyDTO szemelyDTO = new SzemelyDTO();
	// ez egy proba fuggveny, hogy meglehet-e hivni a SzemelyService-t
	public String osszeg(SzemelyDTO szemelyDTO) {		
	return szemelyDTO.getVisNev() + ' ' +szemelyDTO.getAllampKod();
	}
	
}
