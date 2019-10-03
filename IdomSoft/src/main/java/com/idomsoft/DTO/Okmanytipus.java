package com.idomsoft.DTO;
//a kodszotar46_okmanytipus.json beolvasáshoz
public class Okmanytipus {

	private String kod;
	private String ertek;
	
	
	
	public String getKod() {
		return kod;
	}
	public String getErtek() {
		return ertek;
	}
	public void setKod(String kod) {
		this.kod = kod;
	}
	public void setErtek(String ertek) {
		this.ertek = ertek;
	}
	@Override
	public String toString() {
		return "Okmanytipus [kod=" + kod + ", ertek=" + ertek + "]";
	}
	
	
	
	
	
}
