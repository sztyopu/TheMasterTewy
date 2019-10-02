package com.idomsoft.DTO;

import java.util.ArrayList;
import java.util.List;

public class SzemelyServiceResp {

	private SzemelyDTO szemelyDTO;
	private List<String> errorsSzemelyLista;
	private ArrayList<String> errorsOkmanyLista;
	
	
	public SzemelyDTO getSzemelyDTO() {
		return szemelyDTO;
	}
	public List<String> getErrorsSzemelyLista() {
		return errorsSzemelyLista;
	}
	public ArrayList<String> getErrorsOkmanyLista() {
		return errorsOkmanyLista;
	}
	public void setSzemelyDTO(SzemelyDTO szemelyDTO) {
		this.szemelyDTO = szemelyDTO;
	}
	public void setErrorsSzemelyLista(List<String> errorsSzemelyLista) {
		this.errorsSzemelyLista = errorsSzemelyLista;
	}
	public void setErrorsOkmanyLista(ArrayList<String> errorsOkmanyLista) {
		this.errorsOkmanyLista = errorsOkmanyLista;
	}
	@Override
	public String toString() {
		return "SzemelyServiceResp [szemelyDTO=" + szemelyDTO + ", errorsSzemelyLista=" + errorsSzemelyLista
				+ ", errorsOkmanyLista=" + errorsOkmanyLista + "]";
	}
	
	
	

	
	
	
	
}

