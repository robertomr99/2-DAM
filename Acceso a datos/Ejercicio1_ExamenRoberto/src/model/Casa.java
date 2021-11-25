package model;

import java.io.Serializable;

public class Casa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String sPoblacion;
	private Integer iId_Casa , iAseos;
	private Double dSuperficie;
	

	public Casa(Integer iId_Casa, String sPoblacion , Integer iAseos, Double dSuperficie) {
		this.iId_Casa = iId_Casa;
		this.sPoblacion = sPoblacion;
		this.iAseos = iAseos;
		this.dSuperficie = dSuperficie;
	}
	
	
	
	
	public Casa(String sPoblacion, Integer iAseos, Double dSuperficie) {
		this.sPoblacion = sPoblacion;
		this.iAseos = iAseos;
		this.dSuperficie = dSuperficie;
	}
	
	public Casa() {
	
	}
	
	
	public String getsPoblacion() {
		return sPoblacion;
	}
	public void setsPoblacion(String sPoblacion) {
		this.sPoblacion = sPoblacion;
	}
	public Integer getiId_Casa() {
		return iId_Casa;
	}
	public void setiId_Casa(Integer iId_Casa) {
		this.iId_Casa = iId_Casa;
	}
	public Integer getiAseos() {
		return iAseos;
	}
	public void setiAseos(Integer iAseos) {
		this.iAseos = iAseos;
	}
	public Double getdSuperficie() {
		return dSuperficie;
	}
	public void setdSuperficie(Double dSuperficie) {
		this.dSuperficie = dSuperficie;
	}

	@Override
	public String toString() {
		return "Casa [sPoblacion=" + sPoblacion + ", iId_Casa=" + iId_Casa + ", iAseos=" + iAseos + ", dSuperficie="
				+ dSuperficie + "]";
	}
		
}
