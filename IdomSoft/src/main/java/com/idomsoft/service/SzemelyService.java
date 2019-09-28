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
	
//	itt kezdodik a validacio
	public String szemelyServiceValidacio(SzemelyDTO szemelyDTO) {
//	megvizsgaljuk a viselt nevet	
	//if ( szemelyDTO.getVisNev() != null && szemelyDTO.getVisNev().length()<=80) {}
	if (isStringOnlyAlphabet(szemelyDTO.getVisNev()) == false) {
		
		System.out.println("Viseltnév: " +szemelyDTO.getVisNev()+" hibás!");
	}
	
	return "";
	}
	
//	Fugveny teszteli a Stringet: csak magyar ABC plussz Ä, pont, perjel, aposztróf, kötőjel és szóköz max 80
    public static boolean isStringOnlyAlphabet(String str) { 
        return ((str != null) 
                && (!str.equals("")) 
                && (!str.equals(" ") 
                && (str.matches("^[a-zA-ZÁáÉéÍíÓóÖöŐőÚúÜüŰűÄ ///./'/-]*$")))
        		&& str.length()<81); 
    } 
    
//  Fugveny teszteli a Stringet: Legalább két névelemnek kell lennie, a kezdő vagy befejező Dr.-on kívül  
    public static boolean isStringBiggerTwoWord(String str) { 
    	boolean bool = false;
    	String[] arrOfStr = str.split(" ", 0); 
    	System.out.println(arrOfStr.length);
    	System.out.println(arrOfStr[0]);
    	System.out.println(arrOfStr[arrOfStr.length-1]);
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
    public static boolean gender(String str) { 
        return (str.equals("N") || str.equals("F")); 
    }
}
