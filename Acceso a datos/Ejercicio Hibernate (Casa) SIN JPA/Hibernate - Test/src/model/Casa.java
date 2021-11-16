package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CASA")

public class Casa implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="miSecuencia")
	@SequenceGenerator(name="miSecuencia", sequenceName="SEQ_CASA", allocationSize=1)
	@Column(name="ID_CASA")
	private Integer iId_Casa;
	
	@Column(name="CALLE")
	private String sCalle;
	
	@Column(name="NUMERO")
	private Integer iNumero;
	
	@Column(name="SUPERFICIE")
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
