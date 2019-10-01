package com.idomsoft.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.idomsoft.DTO.OkmanyDTO;
import com.idomsoft.DTO.SzemelyDTO;
import com.idomsoft.repository.ReadJson;

@Service
public class OkmanyService {

	
//	itt kezdodik a validacio
	public ArrayList<String> okmanyServiceValidacio(ArrayList<OkmanyDTO> okmLista) {
		
	    //A hibakat tartalmazo lista
		ArrayList<String> errorsOkmanyLista = new ArrayList<String>();
	 
		//megvizsgaljuk a okmTipus-sokat	
		for (int i=0; i < okmLista.size(); i++ ) {
			if (tesztOkmTipus(okmLista.get(i).getOkmTipus()) == false) {
				errorsOkmanyLista.add("okmTipus["+ (i+1) +"]: " + okmLista.get(i).getOkmTipus()+ " - hibás");
			}
		}

		//megvizsgaljuk a okmanySzam-okat	
		for (int i=0; i < okmLista.size(); i++ ) {
			if (tesztOkmanySzam(okmLista.get(i).getOkmTipus(), okmLista.get(i).getOkmanySzam()) == false) {
				errorsOkmanyLista.add("okmanySzam["+ (i+1) +"]: " + okmLista.get(i).getOkmanySzam()+ " - hibás");
			}
		}
		
		//megvizsgaljuk az okmany ervenyesseget 	
		for (int i=0; i < okmLista.size(); i++ ) {
			if (ervenyes(okmLista.get(i).getLejarDat()) == true) {
				okmLista.get(i).setErvenyes(true);
			}
		}
				
	return errorsOkmanyLista;
	}

	
	//Fuggveny teszteli a okmanySzam-ot
    public boolean tesztOkmanySzam(String OkmTipus, String okmanySzam) {    	
    	boolean bool = false;
    	switch (Integer.parseInt(OkmTipus)) {
    	  case 1:    		  
    	    bool = okmanySzam.matches("^\\d{6}[a-zA-Z]{2}$"); //1: szig: 6 szám + 2 betű
    	    break;
    	  case 2:
    		bool = okmanySzam.matches("^[a-zA-Z]{2}\\d{7}$"); // 2: utl 2 betű + 7 szám;
    	    break;
    	  case 3:
    	    bool = true; // a dokumentacióból: "3: ven: nemtom"
    	    break;
    	  case 4:
    		bool = okmanySzam.matches("^.{0,10}$"); //egyéb bármi max 10
    	    break;
    	  case 5:
    		bool = okmanySzam.matches("^.{0,10}$"); //egyéb bármi max 10
    	    break;
    	  case 6:
    		bool = okmanySzam.matches("^.{0,10}$"); //egyéb bármi max 10
    	    break;
    	  default:
    		bool = false;  
    		break;  
    	}
     	return bool;
    }
    
	//Fuggveny teszteli a okmTipus-t
    public boolean tesztOkmTipus(String str) {    	
    	ReadJson readJson = new ReadJson();
    	List<String> okmTipusKodList = readJson.readJson46(); 	
    	boolean bool = (str.length() == 1 && okmTipusKodList.contains(str)) ? true :  false;
     	return bool;
    }

    //Fuggveny teszteli az ervenyesseget
    public static boolean ervenyes(Date dateToConvert) {
        LocalDate lejarDat = dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    	LocalDate maiDatum = LocalDate.now();
    	return (lejarDat.compareTo(maiDatum) >=1);
    }

    
}
