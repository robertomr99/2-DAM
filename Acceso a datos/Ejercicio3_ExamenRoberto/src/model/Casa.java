package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CASA")

public class Casa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "miSecuencia")
	@SequenceGenerator(name = "miSecuencia", sequenceName = "SEQ_CASA", allocationSize = 1)
	@Column(name = "ID_CASA")
	private Integer iId_Casa;

	@Column(name = "POBLACION")
	private String sPoblacion;

	@Column(name = "ASEOS")
	private Integer iAseos;
	
	@Column(name = "SUPERFICIE")
	private Double dSuperficie;

	public Casa(Integer iId_Casa, String sPoblacion, Integer iAseos, Double dSuperficie) {
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
