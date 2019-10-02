package com.idomsoft.DTO;

import java.util.ArrayList;

public class OkmanyServiceResp {

	private ArrayList<OkmanyDTO> okmLista;
	private ArrayList<String> errorsOkmanyLista;
	
	
	public ArrayList<OkmanyDTO> getOkmLista() {
		return okmLista;
	}
	public ArrayList<String> getErrorsOkmanyLista() {
		return errorsOkmanyLista;
	}
	public void setOkmLista(ArrayList<OkmanyDTO> okmLista) {
		this.okmLista = okmLista;
	}
	public void setErrorsOkmanyLista(ArrayList<String> errorsOkmanyLista) {
		this.errorsOkmanyLista = errorsOkmanyLista;
	}
	
	
	@Override
	public String toString() {
		return "OkmanyServiceResp [okmLista=" + okmLista + ", errorsOkmanyLista=" + errorsOkmanyLista + "]";
	}
	
	
	
	
	
	
	
}

