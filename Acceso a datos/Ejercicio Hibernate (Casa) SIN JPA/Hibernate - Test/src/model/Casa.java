package model;

import java.io.Serializable;

public class Casa implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer iId_Casa;
	private String sCalle;
	private Integer iNumero;
	private Double dSuperficie;
	
	
	public Casa() {
		
	}
	
	
	public Casa(Integer iId_Casa, String sCalle, Integer iNumero, Double dSuperficie) {
		this.iId_Casa = iId_Casa;
		this.sCalle = sCalle;
		this.iNumero = iNumero;
		this.dSuperficie = dSuperficie;
	}
	
	

	public Casa(String sCalle, Integer iNumero, Double dSuperficie) {
		this.sCalle = sCalle;
		this.iNumero = iNumero;
		this.dSuperficie = dSuperficie;
	}

	public Integer getiId_Casa() {
		return iId_Casa;
	}

	public void setiId_Casa(Integer iId_Casa) {
		this.iId_Casa = iId_Casa;
	}

	public String getsCalle() {
		return sCalle;
	}

	public void setsCalle(String sCalle) {
		this.sCalle = sCalle;
	}

	public Integer getiNumero() {
		return iNumero;
	}

	public void setiNumero(Integer iNumero) {
		this.iNumero = iNumero;
	}

	public Double getdSuperficie() {
		return dSuperficie;
	}

	public void setdSuperficie(Double dSuperficie) {
		this.dSuperficie = dSuperficie;
	}


	@Override
	public String toString() {
		return "Casa [iId_Casa=" + iId_Casa + ", sCalle=" + sCalle + ", iNumero=" + iNumero + ", dSuperficie="
				+ dSuperficie + "]";
	}

	
	
}
