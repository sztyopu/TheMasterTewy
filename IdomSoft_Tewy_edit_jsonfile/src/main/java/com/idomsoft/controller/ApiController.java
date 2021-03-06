package com.idomsoft.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idomsoft.DTO.OkmanyDTO;
import com.idomsoft.DTO.SzemelyDTO;
import com.idomsoft.service.OkmanyService;
import com.idomsoft.service.SzemelyService;

@RestController
public class ApiController {

    @Autowired
    SzemelyService szemelyServiece;

    @Autowired
    OkmanyService okmanyServiece;

    @RequestMapping(value = "/szemely", method = RequestMethod.POST)
    public SzemelyDTO szemelyValidation(@RequestBody SzemelyDTO szemelyDTO) {
        // itt meghívhatod a személy szervízben megírt validációs metódust, ami visszad
        // valamilyen értéket
//        szemelyServiece.szemelyServiceValidacio(szemelyDTO);
    	szemelyDTO.setAllampKod("UAH");
    	szemelyDTO.setaNev("Tony Stark");
    	szemelyDTO.setAllampDekod("Ukrán");
        
    	return szemelyDTO;
    }

    @RequestMapping(value = "/okmany", method = RequestMethod.POST)
    public String okmanyValidation(@RequestBody OkmanyDTO okmany) {
        // itt meghívhatod a személy szervízben megírt validációs metódust, ami visszad
        // valamilyen értéket
        //	szemelyServiece.osszeg(null);
        return "reply message";
    }

}