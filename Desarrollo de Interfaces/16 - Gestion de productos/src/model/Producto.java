package model;

import java.util.ArrayList;

public class Producto {

	public static ArrayList<Producto> aCoches= new ArrayList<Producto>();
	public static ArrayList<Producto> aMoviles= new ArrayList<Producto>();
	public static ArrayList<Producto> aOrdenadores= new ArrayList<Producto>();
	

	private String sNombreProducto, sImagen;
	private float fPrecio;
	private int iStock;
	private boolean boFragil;

	public Producto(String sNombreProducto, String sImagen, float fPrecio, int iStock, boolean boFragil) {
		this.sNombreProducto = sNombreProducto;
		this.sImagen = sImagen;
		this.fPrecio = fPrecio;
		this.iStock = iStock;
		this.boFragil = boFragil;
	}

	public Producto() {
		this.sNombreProducto = "";
		this.sImagen = "";
		this.fPrecio = 0.0f;
		this.iStock = 0;
		this.boFragil = false;
	}

	public String getsNombreProducto() {
		return sNombreProducto;
	}

	public void setsNombreProducto(String sNombreProducto) {
		this.sNombreProducto = sNombreProducto;
	}

	public String getsImagen() {
		return sImagen;
	}

	public void setsImagen(String sImagen) {
		this.sImagen = sImagen;
	}

	public float getfPrecio() {
		return fPrecio;
	}

	public void setfPrecio(float fPrecio) {
		this.fPrecio = fPrecio;
	}

	public int getiStock() {
		return iStock;
	}

	public void setiStock(int iStock) {
		this.iStock = iStock;
	}

	public boolean isBoFragil() {
		return boFragil;
	}

	public void setBoFragil(boolean boFragil) {
		this.boFragil = boFragil;
	}

	@Override
	public String toString() {
		return "Producto [sNombreProducto=" + sNombreProducto + ", sImagen=" + sImagen + ", fPrecio=" + fPrecio
				+ ", iStock=" + iStock + ", boFragil=" + boFragil + "]";
	}
	
	
	public static void cargarProductos () {
		aCoches.add(new Producto("Ferrari","Resources/Images/Productos/ferrari.jpeg",120000.0f,2,false));
		aMoviles.add(new Producto("Xiaomi Mi 9 Lite","Resources/Images/Productos/xiaomi.jpeg",300.0f,10,true));
		aOrdenadores.add(new Producto("Asus 14P","Resources/Images/Productos/asus.jpg",800.0f,5,true));
	}
	
	public void adsa() {
		
		String sNombreArray = aCoches.toString();
		
		System.out.println(sNombreArray);
	}

}
