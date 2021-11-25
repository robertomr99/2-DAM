package model;

public class Chaleco {
	
	private Integer iId_Chaleco, iColor, iTalla, iStock;
	private String sModelo;
	private Double dPrecio;
	
	public Chaleco(Integer iId_Chaleco, Integer iColor, Integer iTalla, Integer iStock, String sModelo,
			Double dPrecio) {
		this.iId_Chaleco = iId_Chaleco;
		this.iColor = iColor;
		this.iTalla = iTalla;
		this.iStock = iStock;
		this.sModelo = sModelo;
		this.dPrecio = dPrecio;
	}
	
	public Chaleco(Integer iColor, Integer iTalla, Integer iStock, String sModelo, Double dPrecio) {
		this.iColor = iColor;
		this.iTalla = iTalla;
		this.iStock = iStock;
		this.sModelo = sModelo;
		this.dPrecio = dPrecio;
	}

	public Chaleco() {
	}

	public Integer getiId_Chaleco() {
		return iId_Chaleco;
	}
	public void setiId_Chaleco(Integer iId_Chaleco) {
		this.iId_Chaleco = iId_Chaleco;
	}
	public Integer getiColor() {
		return iColor;
	}
	public void setiColor(Integer iColor) {
		this.iColor = iColor;
	}
	public Integer getiTalla() {
		return iTalla;
	}
	public void setiTalla(Integer iTalla) {
		this.iTalla = iTalla;
	}
	public Integer getiStock() {
		return iStock;
	}
	public void setiStock(Integer iStock) {
		this.iStock = iStock;
	}
	public String getsModelo() {
		return sModelo;
	}
	public void setsModelo(String sModelo) {
		this.sModelo = sModelo;
	}
	public Double getdPrecio() {
		return dPrecio;
	}
	public void setdPrecio(Double dPrecio) {
		this.dPrecio = dPrecio;
	}

	@Override
	public String toString() {
		return "Chaleco [iId_Chaleco=" + iId_Chaleco + ", iColor=" + iColor + ", iTalla=" + iTalla + ", iStock="
				+ iStock + ", sModelo=" + sModelo + ", dPrecio=" + dPrecio + "]";
	}
	
	
}
