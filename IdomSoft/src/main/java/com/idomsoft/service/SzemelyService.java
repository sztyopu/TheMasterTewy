package com.idomsoft.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.idomsoft.DTO.SzemelyDTO;

@Service
public class SzemelyService  {
	
//	itt kezdodik a validacio
	public ArrayList<String> szemelyServiceValidacio(SzemelyDTO szemelyDTO) {
		ArrayList<String> err = new ArrayList<String>();
	  //  cars.add("Volvo");
	 
//	megvizsgaljuk a viselt nevet	
	if (strNev(szemelyDTO.getVisNev()) == false) {
		err.add("visNev: " + szemelyDTO.getVisNev() +" - hibás!");
	}
	
//	megvizsgaljuk a szuletesi nevet	
	if (strNev(szemelyDTO.getSzulNev()) == false) {
		err.add("szulNev: " + szemelyDTO.getSzulNev() +" - hibás!");
	}
	
//	megvizsgaljuk a annya nevet	
	if (strNev(szemelyDTO.getaNev()) == false) {
		err.add("aNev: " + szemelyDTO.getaNev() +" - hibás!");
	}
	
//	megvizsgaljuk a szuletesi datumot
	if (vizsgalSzulDat(szemelyDTO.getSzulDat()) == false) {
		err.add("SzulDat: " + szemelyDTO.getSzulDat() +" - hibás!");
	}
	
//	megvizsgaljuk a felhasznalo nemet	
	if (felNeme(szemelyDTO.getNeme()) == false) {
		err.add("neme: " + szemelyDTO.getNeme() +" - hibás!");
	}
	
	
	return err;
	}
	
	//Nevek tesztelése
	public static boolean  strNev(String str) {
		return (strValosNev(str) && strLegalabbKetNev(str));
	}
	
	
	
//	Fugveny teszteli a Stringet: csak magyar ABC plussz Ä, pont, perjel, aposztróf, kötőjel és szóköz max 80
    public static boolean strValosNev(String str) { 
        return ((str != null) 
                && (!str.equals("")) 
                && (!str.equals(" ") 
                && (str.matches("^[a-zA-ZÁáÉéÍíÓóÖöŐőÚúÜüŰűÄ ///./'/-]*$")))
        		&& str.length()<81); 
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
    
//  Fugveny teszteli a Stringet: vagy "F" vagy "N" leht
    public static boolean felNeme(String str) { 
        return (str.equals("N") || str.equals("F")); 
    }
    
    
//  Fuggveny teszteli a szulDat-t es true-t add ha 120 és 18 kozott van
    public static boolean vizsgalSzulDat(Date dateToConvert) {
        LocalDate szulDat = dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    	LocalDate maiDatum = LocalDate.now();
 //   	System.out.println(maiDatum.compareTo(date)); 	
    	return (maiDatum.compareTo(szulDat) >=18 && maiDatum.compareTo(szulDat) <=120 );
    }

    
}
