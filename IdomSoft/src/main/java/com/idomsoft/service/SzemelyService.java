package com.idomsoft.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.idomsoft.DTO.SzemelyDTO;
import com.idomsoft.repository.ReadJson;

@Service
public class SzemelyService  {

//	itt kezdodik a validacio
	public ArrayList<String> szemelyServiceValidacio(SzemelyDTO szemelyDTO) {
		
	    //A hibakat tartalmazo lista
		ArrayList<String> errorList = new ArrayList<String>();
	 
		//megvizsgaljuk a viselt nevet	
		if (strNev(szemelyDTO.getVisNev()) == false) {
			errorList.add("visNev: " + szemelyDTO.getVisNev() +" - hibás!");
		}
	
		//megvizsgaljuk a szuletesi nevet	
		if (strNev(szemelyDTO.getSzulNev()) == false) {
			errorList.add("szulNev: " + szemelyDTO.getSzulNev() +" - hibás!");
		}
	
		//megvizsgaljuk az annya nevet	
		if (strNev(szemelyDTO.getaNev()) == false) {
			errorList.add("aNev: " + szemelyDTO.getaNev() +" - hibás!");
		}
	
		//megvizsgaljuk a szuletesi datumot
		if (vizsgalSzulDat(szemelyDTO.getSzulDat()) == false) {
			errorList.add("SzulDat: " + szemelyDTO.getSzulDat() +" - hibás!");
		}
	
		//megvizsgaljuk a felhasznalo nemet	
		if (strFN(szemelyDTO.getNeme()) == false) {
			errorList.add("neme: " + szemelyDTO.getNeme() +" - hibás!");
		}
		
		//megvizsgaljuk a felhasznalo allamkodjat	
		if (tesztAllampKod(szemelyDTO.getAllampKod()) == false) {
			errorList.add("allamKod: " + szemelyDTO.getAllampKod() +" - hibás!");
		}else {
			
			szemelyDTO.setAllampDekod(allampolgDekod(szemelyDTO.getAllampKod()));
		}
		
	return errorList;
	}

	
	//Nevek tesztelése
	public static boolean  strNev(String str) {
		return (strValosNev(str) && strLegalabbKetNev(str));
	}
	
	
	
//	Fugveny teszteli a Stringet: csak magyar ABC plussz Ä, pont, perjel, aposztróf, kötőjel és szóköz max 80
    public static boolean strValosNev(String str) { 
        return ((str != null) 
                && (!str.equals("")) 
                && (!str.equals(" "))
                && (str.matches("^[a-zA-ZÁáÉéÍíÓóÖöŐőÚúÜüŰűÄ ///./'/-]*$"))
        		&& (str.length()<81)); 
    } 
    
//  Fugveny teszteli a Stringet: Legalább két névelemnek kell lennie, a kezdő vagy befejező Dr.-on kívül  
    public static boolean strLegalabbKetNev(String str) { 
    	boolean bool = false;
    	String[] arrOfStr = str.split(" ", 0); 
    	if (arrOfStr.length > 2) {
    		bool = true;
    	}else if(arrOfStr.length == 2 && !arrOfStr[0].equals("Dr.") && !arrOfStr[arrOfStr.length-1].equals("Dr.")){
    		bool = true;
    	}else {
    		bool = false;
    	}
     return bool; 
    }
    
//  Fugveny teszteli a Stringet: vagy "F"(ferfi) vagy "N"(no) lehet
    public static boolean strFN(String str) { 
        return (str.equals("N") || str.equals("F")); 
    }
    
    
//  Fuggveny teszteli a szulDat-t es true-t add ha 120 és 18 kozott van
    public static boolean vizsgalSzulDat(Date dateToConvert) {
    	if(dateToConvert == null){return false;}
        LocalDate szulDat = dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    	LocalDate maiDatum = LocalDate.now();
    	return (maiDatum.compareTo(szulDat) >=18 && maiDatum.compareTo(szulDat) <=120 );
    }
        
    //Fuggveny teszteli a allampKod-ot
    public boolean tesztAllampKod(String str) {    	
    	ReadJson readJson = new ReadJson();
    	Map<String, String> hasMap = readJson.readJson21(); 	
    	boolean bool = (str.length() == 3 && hasMap.containsKey(str)) ? true :  false;
     	return bool;
    }
    
    //Fuggveny visszadja az allampolgDekod-t
    public String allampolgDekod(String str) {    	
    	ReadJson readJson = new ReadJson();
    	Map<String, String> hasMap = readJson.readJson21(); 	
    	String result = hasMap.get(str);
     	return result;
    }
    
}
