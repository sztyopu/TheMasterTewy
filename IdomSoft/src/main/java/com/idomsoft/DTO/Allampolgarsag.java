package com.idomsoft.DTO;

public class Allampolgarsag  {

	private String kod;
	private String allampolgarsag;
	private String orszag;
	private String schengen;
	private String sis1_orsz;
	private String sis1_orsz_hun;
	
	
	
	
	public String getKod() {
		return kod;
	}
	public String getAllampolgarsag() {
		return allampolgarsag;
	}
	public String getOrszag() {
		return orszag;
	}
	public String getSchengen() {
		return schengen;
	}
	public String getSis1_orsz() {
		return sis1_orsz;
	}
	public String getSis1_orsz_hun() {
		return sis1_orsz_hun;
	}
	public void setKod(String kod) {
		this.kod = kod;
	}
	public void setAllampolgarsag(String allampolgarsag) {
		this.allampolgarsag = allampolgarsag;
	}
	public void setOrszag(String orszag) {
		this.orszag = orszag;
	}
	public void setSchengen(String schengen) {
		this.schengen = schengen;
	}
	public void setSis1_orsz(String sis1_orsz) {
		this.sis1_orsz = sis1_orsz;
	}
	public void setSis1_orsz_hun(String sis1_orsz_hun) {
		this.sis1_orsz_hun = sis1_orsz_hun;
	}
	@Override
	public String toString() {
		return "Allampolgarsag [kod=" + kod + ", allampolgarsag=" + allampolgarsag + ", orszag=" + orszag
				+ ", schengen=" + schengen + ", sis1_orsz=" + sis1_orsz + ", sis1_orsz_hun=" + sis1_orsz_hun + "]";
	}

	
	
	
}
