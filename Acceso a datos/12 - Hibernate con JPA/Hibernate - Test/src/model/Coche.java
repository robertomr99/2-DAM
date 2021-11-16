package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="COCHE")

public class Coche {

	@Id
	@GeneratedValue(generator="miSecuencia")
	@SequenceGenerator(name="miSecuencia", sequenceName="SEQ_COCHE", allocationSize=1)
	@Column(name="ID_COCHE")
	private Integer idCoche;
	
	@Column(name="MARCA")
	private String sMarca;

	@Column(name="MODELO")
	private String sModelo;

	@Column(name="POTENCIA")
	private Integer iPotencia;
	
	
	public Coche() {
		
	}
	
	public Coche(String sMarca, String sModelo, Integer iPotencia) {
		this.sMarca = sMarca;
		this.sModelo = sModelo;
		this.iPotencia = iPotencia;
	}
	
	public Coche(int idCoche, String sMarca, String sModelo, Integer iPotencia) {
		this.idCoche = idCoche;
		this.sMarca = sMarca;
		this.sModelo = sModelo;
		this.iPotencia = iPotencia;
	}
	public Integer getIdCoche() {
		return idCoche;
	}
	public void setIdCoche(Integer idCoche) {
		this.idCoche = idCoche;
	}
	public String getsMarca() {
		return sMarca;
	}
	public void setsMarca(String sMarca) {
		this.sMarca = sMarca;
	}
	public String getsModelo() {
		return sModelo;
	}
	public void setsModelo(String sModelo) {
		this.sModelo = sModelo;
	}
	public Integer getiPotencia() {
		return iPotencia;
	}
	public void setiPotencia(Integer iPotencia) {
		this.iPotencia = iPotencia;
	}

	@Override
	public String toString() {
		return "Coche [idCoche=" + idCoche + ", sMarca=" + sMarca + ", sModelo=" + sModelo + ", iPotencia=" + iPotencia
				+ "]";
	}
	
	
}
