package com.idomsoft.DTO;

import java.util.List;

public class SzemelyServiceResp {

	private SzemelyDTO szemely;
	private List<String> lista;
	public SzemelyDTO getSzemely() {
		return szemely;
	}
	public List<String> getLista() {
		return lista;
	}
	public void setSzemely(SzemelyDTO szemely) {
		this.szemely = szemely;
	}
	public void setLista(List<String> lista) {
		this.lista = lista;
	}
	@Override
	public String toString() {
		return "SzemelyServiceResp [szemely=" + szemely + ", lista=" + lista + "]";
	}
	
	
	
	
}

